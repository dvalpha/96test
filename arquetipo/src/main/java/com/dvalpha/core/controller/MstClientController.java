package com.dvalpha.core.controller;

import java.io.IOException;
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
import com.dvalpha.core.entity.MstArticulo;
import com.dvalpha.core.entity.MstClient;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.utils.PasswordGenerator;
@Controller
public class MstClientController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstClient.class);
	@Autowired IGenericDAO dao;



	@RequestMapping(value = { "/main-menu-client" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {

		return new ModelAndView("/la vista main menu");

	}
	@RequestMapping(value={"/menu-addClient"})
	public ModelAndView menuAddClient(HttpServletResponse response,HttpServletRequest request) throws IOException{
	return new ModelAndView("client-add");
		
}
//metodo add (ajax response)
@RequestMapping(value={"/addClient"})
	public void addClient(HttpServletResponse response,HttpServletRequest request) throws IOException{
	MstClient bean=(MstClient)populateBean(request, new MstClient());
	
	bean.setCodclient(PasswordGenerator.getPassword(12));
	dao.createEntity(bean);
    responseAjax(response, "Creado");
}

@RequestMapping(value = { "/list-client" })
public ModelAndView listMstClient(HttpServletResponse response, HttpServletRequest request) throws IOException {

List<MstClient> lista = (List<MstClient>)dao.findAll(new MstClient());
request.setAttribute("list", lista);
	return new ModelAndView("client-list");

}

@RequestMapping(value = { "/menu-edit-client" })
public ModelAndView menuEditMstClient(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
MstClient user = (MstClient)dao.readById(id, MstClient.class);
List<MstArticulo>lista0 = (List<MstArticulo>) dao.findAllWhere(new MstArticulo(), "cliente", user);
request.setAttribute("dependencia00",lista0);
request.setAttribute("object", user);
	return new ModelAndView("client-edit");

}

@RequestMapping(value = { "/update-client" })
public void updateMstClient(HttpServletResponse response, HttpServletRequest request) throws IOException {

MstClient bean=(MstClient)populateBean(request, new MstClient());

//Falta listar la lista de articulos en memoria y pasarsela al cliente via set


dao.updateEntity(bean);
responseAjax(response, "Actualizado");
}


@RequestMapping(value = { "/delete-client" })
public void deleteMstClient(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
dao.deleteEntity(new MstClient(id));

responseAjax(response, "Eliminado");
}	}

