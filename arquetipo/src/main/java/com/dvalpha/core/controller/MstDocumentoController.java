package com.dvalpha.core.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.dvalpha.core.entity.MstCategoriaLibro;
import com.dvalpha.core.entity.MstDocumento;
import com.dvalpha.core.entity.MstLibro;

@Controller
public class MstDocumentoController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstDocumento.class);
	@Autowired
	IGenericDAO dao;

	@RequestMapping(value = { "/main-menu-documento" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {

		return new ModelAndView("documento-main");

	}
	
	@RequestMapping(value = { "/menu-add-documento-libro" })
	public ModelAndView menuAddDocumentoWhere(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id0 = Long.parseLong(request.getParameter("id"));
		
		MstLibro libro =(MstLibro) dao.readById(id0, MstLibro.class);
		
		request.setAttribute("dependencia00", libro.getCategorias());
		return new ModelAndView("documento-add");

	}
	
	@RequestMapping(value = { "/menu-addDocumento" })
	public ModelAndView menuAddDocumento(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstCategoriaLibro> lista0 = (List<MstCategoriaLibro>) dao.findAll(new MstCategoriaLibro());
		request.setAttribute("dependencia00", lista0);
		return new ModelAndView("documento-add");

	}

	
	@RequestMapping(value = { "/addDocumento" })
	public void addDocumento(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstDocumento bean = (MstDocumento) populateBean(request, new MstDocumento());
		Long id0 = Long.parseLong(request.getParameter("categoria"));
		bean.setCategoria(new MstCategoriaLibro(id0));
		bean.setCreacion(new Date());
		dao.createEntity(bean);
		responseAjax(response, "Creado");
	}

	@RequestMapping(value = { "/list-documento" })
	public ModelAndView listMstDocumento(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstDocumento> lista = (List<MstDocumento>) dao.findAll(new MstDocumento());
		request.setAttribute("list", lista);
		return new ModelAndView("documento-list");

	}

	@RequestMapping(value = { "/menu-edit-documento" })
	public ModelAndView menuEditMstDocumento(HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstDocumento user = (MstDocumento) dao.readById(id, MstDocumento.class);
		List<MstCategoriaLibro> lista0 = (List<MstCategoriaLibro>) dao.findAll(new MstCategoriaLibro());
		request.setAttribute("dependencia00", lista0);
		request.setAttribute("object", user);
		return new ModelAndView("documento-edit");

	}

	@RequestMapping(value = { "/update-documento" })
	public void updateMstDocumento(HttpServletResponse response, HttpServletRequest request) throws IOException {

		MstDocumento bean = (MstDocumento) populateBean(request, new MstDocumento());
		Long id0 = Long.parseLong(request.getParameter("categoria"));
		bean.setCategoria(new MstCategoriaLibro(id0));
		dao.updateEntity(bean);
		responseAjax(response, "Actualizado");
	}

   @RequestMapping(value = { "/delete-documento" })
	public void deleteMstDocumento(HttpServletResponse response, HttpServletRequest request) throws IOException {

    Long id=Long.parseLong(request.getParameter("id"));
	dao.deleteEntity(new MstDocumento(id));
     responseAjax(response, "Eliminado");
}	

}


