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
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.MstUsuario;

@Controller
public class MstUrlController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstUrl.class);
	@Autowired
	IGenericDAO dao;

	

	@RequestMapping(value = { "/menu-addUrl" })
	public ModelAndView menuAddUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {
		List<DefModules> modulos = (List<DefModules> )dao.findAllSimple(new DefModules());
		request.setAttribute("modulos", modulos);
		return new ModelAndView("url-add");

	}

	// metodo add (ajax response)
	@RequestMapping(value = { "/addUrl" })
	public void addUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstUrl bean = (MstUrl) populateBean(request, new MstUrl());
		bean.setCreacion(new Date());
		dao.createEntity(bean);
		responseAjax(response, "Creado");
	}

	@RequestMapping(value = { "/list-url" })
	public ModelAndView listMstUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstUrl> lista = (List<MstUrl>) dao.findAll(new MstUrl());
		request.setAttribute("list", lista);
		return new ModelAndView("url-list");

	}

	@RequestMapping(value = { "/menu-edit-url" })
	public ModelAndView menuEditMstUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstUrl msturl = (MstUrl) dao.readById(id, MstUrl.class);
		List<DefModules> modulos = (List<DefModules> )dao.findAllSimple(new DefModules());
		request.setAttribute("modulos", modulos);
		request.setAttribute("object", msturl);
		return new ModelAndView("url-edit");

	}

	@RequestMapping(value = { "/update-url" })
	public void updateMstUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {

		MstUrl bean = (MstUrl) populateBean(request, new MstUrl());
		dao.updateEntity(bean);
		responseAjax(response, "Actualizado");
	}

	@RequestMapping(value = { "/delete-url" })
	public void deleteMstUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		System.out.println("LA ID DEL ROL ES "+id);
		dao.deleteEntity(new MstUrl(id));

		responseAjax(response, "Eliminado");
	}
}
