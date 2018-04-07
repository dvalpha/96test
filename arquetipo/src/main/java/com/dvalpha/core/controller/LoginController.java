package com.dvalpha.core.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstCentro;
import com.dvalpha.core.entity.MstUsuario;
@Controller

public class LoginController  extends CoreController {
	private static final Logger logger = Logger.getLogger(InitController.class);	

	@Autowired IGenericDAO dao;
	
	@RequestMapping(value={"/validation"})
	public ModelAndView  login(HttpServletResponse response,HttpServletRequest request) throws IOException{
		logger.info("Llega al login controller, viva!");
		boolean validacion=validarLogin(request,response);
		
		ModelAndView model = new ModelAndView();
		
		if(validacion) {
			logger.info("Usuario valido");
			//responseAjax(response, "core/home");
			model.setViewName("/core/home");
			
		}else {
			logger.info("Usuario incorrecto");
			//model.setViewName("arquetipo/login/login");
			model.setViewName("login");
		}
		return model;
	}
	private boolean validarLogin(HttpServletRequest request, HttpServletResponse response) {
		List<MstCentro> centros = (List<MstCentro>)dao.findAll(new MstCentro());
		boolean b=false;
		for(MstCentro c:centros) {
			if(c.getNombreComercial().equalsIgnoreCase(request.getParameter("centro"))) {
				
				List<MstUsuario>users =c.getUsuarios();
				for(MstUsuario u:users) {
					if(u.getUser().equalsIgnoreCase(request.getParameter("user"))&&
					   u.getPassword().equalsIgnoreCase(request.getParameter("psw")) 		) {
						openSession(response, request).setAttribute("user", u);
						logger.info("El psw es: "+request.getParameter("psw"));
						b=true;
					}
				}
				
			}
			
		}
		
		
		return b;
	}

		
}
