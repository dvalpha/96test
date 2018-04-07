package com.dvalpha.core.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstCategoriaLibro;
import com.dvalpha.core.entity.MstLibro;
import com.dvalpha.core.entity.MstProveedor;
import com.dvalpha.core.entity.MstCliente;


@Controller
public class MstLibroController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstLibro.class);
	
	@Autowired
	IGenericDAO dao;
	
	@RequestMapping(value = { "/menu-addLibro" })
	public ModelAndView menuAddLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
	
		MstProveedor p = new MstProveedor();
		p.setAvatar("av");
		p.setMail("mail");
		p.setNif("nif");
		p.setRef("prov");
	    dao.createEntity(p);
		
	    List<MstCategoriaLibro> lista0 = (List<MstCategoriaLibro>) dao.findAll(new MstCategoriaLibro());
		request.setAttribute("dependencia00", lista0);
		return new ModelAndView("libro-add");
	}
	@RequestMapping(value = { "/addLibro" })
	public void addLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstLibro bean = (MstLibro) populateBean(request, new MstLibro());
		bean.setCreacion(new Date());
		dao.createEntity(bean);
		responseAjax(response, "Creado");
	}
	
	@RequestMapping(value = { "/list-libro" })
	public ModelAndView listMstLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstLibro> lista = (List<MstLibro>) dao.findAll(new MstLibro());
		request.setAttribute("list", lista);
		return new ModelAndView("libro-list");

	}

	@RequestMapping(value = { "/menu-edit-libro" })
	public ModelAndView menuEditMstLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		MstLibro user = (MstLibro) dao.readById(id, MstLibro.class);
		List<MstCategoriaLibro> lista0 = (List<MstCategoriaLibro>) dao.findAll(new MstCategoriaLibro());
		request.setAttribute("dependencia00", lista0);
		request.setAttribute("object", user);
		return new ModelAndView("libro-edit");

	}

	@RequestMapping(value = { "/update-libro" })
	public void updateMstLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstLibro bean = (MstLibro) populateBean(request, new MstLibro());
		responseAjax(response, "Actualizado");
	}

	@RequestMapping(value = { "/delete-libro" })
	public void deleteMstLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		dao.deleteEntity(new MstLibro(id));
		responseAjax(response, "Eliminado");
	}
	
	
}


