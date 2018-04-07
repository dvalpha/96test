package com.dvalpha.core.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.beans.MstUserBean;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.DefDepartamentos;
import com.dvalpha.core.entity.DefModules;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstArchivo;
import com.dvalpha.core.entity.MstCentro;
import com.dvalpha.core.entity.MstRol;
import com.dvalpha.core.entity.MstStorage;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.service.MstUserService;
import com.dvalpha.core.utils.TransformBytesToTB;

@Controller
public class MstUsuarioController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstUsuario.class);
	@Autowired
	IGenericDAO dao;
    @Autowired MstUserService service;
	
	
	@RequestMapping(value = { "/menu-addUsuario" })
	public ModelAndView menuAddUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstCentro> lista0 = (List<MstCentro>) dao.findAll(new MstCentro());
		request.setAttribute("dependencia00", lista0);
		
		List<MstRol> lista1 = (List<MstRol>) dao.findAll(new MstRol());
		request.setAttribute("dependencia01", lista1);
		
		List<MstStorage> espacio = (List<MstStorage>) dao.findAllSimple(new MstStorage());
		request.setAttribute("dependencia02", espacio);
		
		List<DefDepartamentos> modules = (List<DefDepartamentos>) dao.findAllSimple(new DefDepartamentos());
		request.setAttribute("dependencia03", modules);
		
		return new ModelAndView("user-add");

	}
	
	// metodo add (ajax response)
	@RequestMapping(value = { "/addUsuario" })
	public void  addUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		
		MstUsuario bean = (MstUsuario) populateBean(request, new MstUsuario());
		bean.setCreacion(new Date());
		Long id0 = Long.parseLong(request.getParameter("mstcentro"));
		bean.setMstcentro(new MstCentro(id0));
		Long id1 = Long.parseLong(request.getParameter("mstrol"));
		bean.setMstrol(new MstRol(id1));
		Long id2 = Long.parseLong(request.getParameter("mststorage"));
		bean.setMststorage(new MstStorage(id2));
		Long id3 = Long.parseLong(request.getParameter("defdepartamentos"));
		bean.setDefdepartamentos(new DefDepartamentos(id3));
		
		dao.createEntity(bean);
		
		service.adduser(bean,request,response);
		
		 responseAjax(response, "Creado");
		
		
	}

	@RequestMapping(value = { "/list-usuario" })
	public ModelAndView listMstUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstUsuario> lista = (List<MstUsuario>) dao.findAll(new MstUsuario());
		List<MstUsuario> listab= new ArrayList();
		
		for(MstUsuario user:lista) {
			
			double espacio_ocupadoMB =obtenerEspacioOcupado(user,request,response);
			int espacio_total=user.getMststorage().getMaxMB();
			
			double total=(espacio_ocupadoMB*100)/espacio_total;
			
			DecimalFormat mf = new DecimalFormat("#0.0");
			
			String s = mf.format(total);
			s = s.replace(',', '.');
			double conv = Double.parseDouble(s); 
			user.setEspacioOcupado(conv);
			listab.add(user);
			
			System.out.println(user);
		}
		
		request.setAttribute("listb", listab);
		return new ModelAndView("user-list");

	}
	
	public boolean validarSiHayEspacioDisponible(MstUsuario user,Long archivoSubido, HttpServletRequest request, HttpServletResponse response) {
       
		boolean b = false;
		
		for(MstArchivo archivo:user.getArchivos()) {
			archivoSubido+=archivo.getTamano();
			
		}
		TransformBytesToTB transform = new TransformBytesToTB(archivoSubido);
		double espacio_ocupadoMB=transform.getMB();
		int espacio_total=user.getMststorage().getMaxMB();
		
		double total=(espacio_ocupadoMB*100)/espacio_total;
		if(total>100) {
			b=true;
		}
		return b;
	}
	
	
	

	

	
	@RequestMapping(value = { "/menu-edit-usuario" })
	public ModelAndView menuEditMstUsuario(HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstUsuario user = (MstUsuario) dao.readById(id, MstUsuario.class);
		List<MstCentro> lista0 = (List<MstCentro>) dao.findAll(new MstCentro());
		request.setAttribute("dependencia00", lista0);
		List<MstRol> lista1 = (List<MstRol>) dao.findAll(new MstRol());
		request.setAttribute("dependencia01", lista1);
		List<MstStorage> espacio = (List<MstStorage>) dao.findAllSimple(new MstStorage());
		request.setAttribute("dependencia02", espacio);
		List<DefDepartamentos> modules = (List<DefDepartamentos>) dao.findAllSimple(new DefDepartamentos());
		request.setAttribute("dependencia03", modules);
		request.setAttribute("object", user);
		return new ModelAndView("user-edit");

	}

	@RequestMapping(value = { "/update-usuario" })
	public void updateMstUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {

		MstUsuario bean = (MstUsuario) populateBean(request, new MstUsuario());
		Long id0 = Long.parseLong(request.getParameter("mstcentro"));
		bean.setMstcentro(new MstCentro(id0));
		Long id1 = Long.parseLong(request.getParameter("mstrol"));
		bean.setMstrol(new MstRol(id1));
		Long id2 = Long.parseLong(request.getParameter("mststorage"));
		bean.setMststorage(new MstStorage(id2));
		Long id3 = Long.parseLong(request.getParameter("defdepartamentos"));
		bean.setDefdepartamentos(new DefDepartamentos(id3));
		dao.updateEntity(bean);
		responseAjax(response, "Actualizado");
	}

	@RequestMapping(value = { "/delete-usuario" })
	public void deleteMstUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		dao.deleteEntity(new MstUsuario(id));

		responseAjax(response, "Eliminado");
	}
	
	@RequestMapping(value = { "/delete-usuario-comprimir" })
	public void deleteMstUsuarioComprime(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		
		MstUsuario user =(MstUsuario)dao.readById(id, MstUsuario.class);
		service.comprimirArchivos(user,request,response);
		service.eliminarArchivos(user, request, response);
		
		dao.deleteEntity(new MstUsuario(id));

		responseAjax(response, "Usuario eliminado y archivos comprimidos");
	}
	
	@RequestMapping(value = { "/delete-usuario-total" })
	public void deleteMstUsuarioTotalmente(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		MstUsuario user =(MstUsuario)dao.readById(id, MstUsuario.class);
		service.eliminarArchivos(user, request, response);
		dao.deleteEntity(new MstUsuario(id));
		responseAjax(response, "Usuario eliminado totalmente");
	}
	
}
