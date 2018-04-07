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

import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstCliente;
import com.dvalpha.core.entity.MstPedido;

@Controller
public class MstClienteController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstCliente.class);
 	@Autowired IGenericDAO dao;



	@RequestMapping(value = { "/main-menu-cliente" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {

		return new ModelAndView("/la vista main menu");

	}
		@RequestMapping(value={"/menu-addCliente"})
	public ModelAndView menuAddCliente(HttpServletResponse response,HttpServletRequest request) throws IOException{

	
	return new ModelAndView("cliente-add");
		
}
//metodo add (ajax response)
@RequestMapping(value={"/addCliente"})
	public void addCliente(HttpServletResponse response,HttpServletRequest request) throws IOException{
	MstCliente bean=(MstCliente)populateBean(request, new MstCliente());
	bean.setCreacion(new Date());
	dao.createEntity(bean);
responseAjax(response, "Creado");
}
@RequestMapping(value = { "/list-cliente" })
public ModelAndView listMstCliente(HttpServletResponse response, HttpServletRequest request) throws IOException {

List<MstCliente> lista = (List<MstCliente>)dao.findAll(new MstCliente());
request.setAttribute("list", lista);
	return new ModelAndView("cliente-list");

}

@RequestMapping(value = { "/menu-edit-cliente" })
public ModelAndView menuEditMstCliente(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
MstCliente user = (MstCliente)dao.readById(id, MstCliente.class);
//List<MstPedido>lista0 = (List<MstPedido>) dao.findAll(new MstPedido());
//request.setAttribute("dependencia00",lista0);
request.setAttribute("object", user);
	return new ModelAndView("cliente-edit");

}

@RequestMapping(value = { "/update-cliente" })
public void updateMstCliente(HttpServletResponse response, HttpServletRequest request) throws IOException {

MstCliente bean=(MstCliente)populateBean(request, new MstCliente());

dao.updateEntity(bean);
System.out.println("Llega al controlador");
responseAjax(response, "Actualizado");
}


@RequestMapping(value = { "/delete-cliente" })
public void deleteMstCliente(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
dao.deleteEntity(new MstCliente(id));

responseAjax(response, "Eliminado");
}	}