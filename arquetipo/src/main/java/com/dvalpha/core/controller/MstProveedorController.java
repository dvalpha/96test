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
import com.dvalpha.core.entity.MstProveedor;
import com.dvalpha.core.entity.MstUsuario;
@Controller
public class MstProveedorController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstProveedor.class);
 	@Autowired IGenericDAO dao;

	@RequestMapping(value = { "/main-menu-proveedor" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {
	return new ModelAndView("/la vista main menu");
	}
	@RequestMapping(value={"/menu-addProveedor"})
	public ModelAndView menuAddProveedor(HttpServletResponse response,HttpServletRequest request) throws IOException{
	return new ModelAndView("proveedor-add");
		
}
	//metodo add (ajax response)
	@RequestMapping(value={"/addProveedor"})
	public void addProveedor(HttpServletResponse response,HttpServletRequest request) throws IOException{
	MstProveedor bean=(MstProveedor)populateBean(request, new MstProveedor());
	bean.setCreacion(new Date());
	dao.createEntity(bean);
responseAjax(response, "Creado");
}
	@RequestMapping(value = { "/list-proveedor" })
	public ModelAndView listMstProveedor(HttpServletResponse response, HttpServletRequest request) throws IOException {

List<MstProveedor> lista = (List<MstProveedor>)dao.findAll(new MstProveedor());
 request.setAttribute("list", lista);
		return new ModelAndView("proveedor-list");

	}

@RequestMapping(value = { "/menu-edit-proveedor" })
public ModelAndView menuEditMstProveedor(HttpServletResponse response, HttpServletRequest request) throws IOException {
Long id=Long.parseLong(request.getParameter("id"));
MstProveedor user = (MstProveedor)dao.readById(id, MstProveedor.class);	
request.setAttribute("object", user);
return new ModelAndView("proveedor-edit");
}

@RequestMapping(value = { "/update-proveedor" })
	public void updateMstProveedor(HttpServletResponse response, HttpServletRequest request) throws IOException {
	MstProveedor bean=(MstProveedor)populateBean(request, new MstProveedor());
	dao.updateEntity(bean);
    responseAjax(response, "Actualizado");
}
	

@RequestMapping(value = { "/delete-proveedor" })
	public void deleteMstProveedor(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
	dao.deleteEntity(new MstProveedor(id));
 
responseAjax(response, "Eliminado");
}	}