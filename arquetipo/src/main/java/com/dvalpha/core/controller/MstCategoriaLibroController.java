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
import com.dvalpha.core.entity.MstLibro;
@Controller
public class MstCategoriaLibroController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstCategoriaLibro.class);
	@Autowired
	IGenericDAO dao;

	@RequestMapping(value = { "/main-menu-categorialibro" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {
		return new ModelAndView("/la vista main menu");
	}

	@RequestMapping(value = { "/menu-addCategoriaLibro" })
	public ModelAndView menuAddCategoriaLibro(HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		List<MstLibro>lista0 = (List<MstLibro>) dao.findAll(new MstLibro());
		request.setAttribute("dependencia00",lista0);
		return new ModelAndView("categoria-add");

	}
	
	@RequestMapping(value = { "/menu-add-categoria-libro" })
	public ModelAndView menuAddDocumentoWhere(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id0 = Long.parseLong(request.getParameter("id"));
		
		MstLibro libro =(MstLibro) dao.readById(id0, MstLibro.class);
		List<MstLibro> lista = new ArrayList();
		lista.add(libro);
		request.setAttribute("dependencia00", lista);
		return new ModelAndView("categoria-add");

	}

	@RequestMapping(value = { "/addCategoriaLibro" })
	public void addCategoriaLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstCategoriaLibro bean = (MstCategoriaLibro) populateBean(request, new MstCategoriaLibro());
		Long id0 = Long.parseLong(request.getParameter("libro"));
		bean.setLibro(new MstLibro(id0));
		bean.setCreacion(new Date());
		dao.createEntity(bean);
		responseAjax(response, "Creado");
	}

	@RequestMapping(value = { "/list-categorialibro" })
	public ModelAndView listMstCategoriaLibro(HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		List<MstCategoriaLibro> lista = (List<MstCategoriaLibro>) dao.findAll(new MstCategoriaLibro());
		request.setAttribute("list", lista);
		return new ModelAndView("categoria-list");

	}

	@RequestMapping(value = { "/menu-edit-categorialibro" })
	public ModelAndView menuEditMstCategoriaLibro(HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstCategoriaLibro user = (MstCategoriaLibro) dao.readById(id, MstCategoriaLibro.class);
		List<MstLibro> lista0 = (List<MstLibro>) dao.findAll(new MstLibro());
		request.setAttribute("dependencia00", lista0);
		request.setAttribute("object", user);
		return new ModelAndView("categoria-edit");

	}

	@RequestMapping(value = { "/update-categorialibro" })
	public void updateMstCategoriaLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {

		MstCategoriaLibro bean = (MstCategoriaLibro) populateBean(request, new MstCategoriaLibro());
		Long id0 = Long.parseLong(request.getParameter("libro"));
		bean.setLibro(new MstLibro(id0));

		dao.updateEntity(bean);
		responseAjax(response, "Actualizado");
	}

	@RequestMapping(value = { "/delete-categorialibro" })
	public void deleteMstCategoriaLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		dao.deleteEntity(new MstCategoriaLibro(id));

		responseAjax(response, "Eliminado");
	}
}
