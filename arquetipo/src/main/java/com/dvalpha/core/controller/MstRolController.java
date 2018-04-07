package com.dvalpha.core.controller;
import java.io.IOException;
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
import com.dvalpha.core.entity.DefModules;
import com.dvalpha.core.entity.MstModule;
import com.dvalpha.core.entity.MstRol;
import com.dvalpha.core.entity.MstUsuario;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
@Controller
public class MstRolController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstRol.class);
 	@Autowired IGenericDAO dao;



	
		@RequestMapping(value={"/menu-addRol"})
	public ModelAndView menuAddRol(HttpServletResponse response,HttpServletRequest request) throws IOException{

	
	return new ModelAndView("roles-add");
		
}
   //metodo add (ajax response)
   @RequestMapping(value={"/addRol"})
	public void addRol(HttpServletResponse response,HttpServletRequest request) throws IOException{
	MstRol rol=(MstRol)populateBean(request, new MstRol());
	rol.setCreacion(new Date());
	dao.createEntity(rol);
	
	System.out.println("El rol que se ha creado tiene una id : "+rol.getId());
	
	
	MstRol newRol = (MstRol) dao.findAllWhere(new MstRol(), "nombre", rol.getNombre()).get(0);
	List<DefModules> lista =(List<DefModules>) dao.findAllSimple(new DefModules());
	
	
	for(DefModules mod:lista) {
		
		MstModule m = new MstModule();
		m.setLevel(1);
		m.setNombre(mod.getNombre());
		m.setRol_id(newRol.getId());
		dao.createEntity(m);
		
	}
	
	
	
	 
     responseAjax(response, "Creado");
}


@RequestMapping(value = { "/list-rol" })
public ModelAndView listMstRol(HttpServletResponse response, HttpServletRequest request) throws IOException {

List<MstRol> lista = (List<MstRol>)dao.findAll(new MstRol());
request.setAttribute("list", lista);
	return new ModelAndView("roles-list");

}

@RequestMapping(value = { "/menu-edit-rol" })
public ModelAndView menuEditMstRol(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
MstRol user = (MstRol)dao.readById(id, MstRol.class);
	
request.setAttribute("object", user);

	return new ModelAndView("roles-edit");

}

@RequestMapping(value = { "/update-rol" })
public void updateMstRol(HttpServletResponse response, HttpServletRequest request) throws IOException {

MstRol bean=(MstRol)populateBean(request, new MstRol());
dao.updateEntity(bean);
responseAjax(response, "Actualizado");
}


@RequestMapping(value = { "/delete-rol" })
public void deleteMstRol(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		String msg = "Item eliminado";
		try {
			dao.deleteEntity(new MstRol(id));
		} catch (Exception e) {
			msg = "Error: " + e.getMessage();
		}
		
		responseAjax(response, msg);
	}

@RequestMapping(value = { "/definir-modulos" })
public ModelAndView definirModulos(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		
		List<MstModule> lista =(List<MstModule>) dao.findAllWhere(new MstModule(), "rol_id", id);
		
		request.setAttribute("modules", lista);
		request.setAttribute("idrol", id);
		return new ModelAndView("roles-update-module");
	}

@RequestMapping(value = { "/add-rol-module" })
public void addRolModule(HttpServletResponse response, HttpServletRequest request) throws IOException {

		
		List<DefModules> lista =(List<DefModules>) dao.findAll(new DefModules());
		Long idRol =(long) Integer.parseInt(request.getParameter("idrol"));
		
		for(DefModules mod:lista) {
			String valor = request.getParameter(mod.getNombre());
			MstModule m = new MstModule();
			m.setLevel(Integer.parseInt(valor));
			m.setNombre(mod.getNombre());
			m.setRol_id(idRol);
			m.setCreacion(new Date());
			dao.createEntity(m);
			
		}
		
		
		
	}


@RequestMapping(value = { "/update-rol-module" })
public void updateMstModule(HttpServletResponse response, HttpServletRequest request) throws IOException {

	String msg="Items modificados";
		Long idRol =(long) Integer.parseInt(request.getParameter("idrol"));		
		List<MstModule> lista =(List<MstModule>) dao.findAllWhere(new MstModule(), "rol_id",idRol);
		
		
		for(MstModule mst_module:lista) {
			String valor = request.getParameter(mst_module.getNombre()); //nombre del select (core (nombre) value=2)
			
			String param="id_mstmodule"+mst_module.getId();
			String idmstmodule = request.getParameter(param);

			MstModule m = new MstModule(Long.parseLong(idmstmodule));
			m.setLevel(Integer.parseInt(valor));
			m.setNombre(mst_module.getNombre());
			m.setRol_id(idRol);
			try {
				dao.updateEntity(m);
			} catch (Exception e) {
				msg = "Error: " + e.getMessage();
			}
			
			responseAjax(response, msg);
		}
		
		
		
	}


}
