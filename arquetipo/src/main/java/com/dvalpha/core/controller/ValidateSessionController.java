package com.dvalpha.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.MstUsuario;

/**
 * Clase que recibe datos de la sesion y los valida
 * @author alex
 *
 */
@Controller
public class ValidateSessionController extends CoreController {
	private static final Logger logger = Logger.getLogger(ValidateSessionController.class);	
	@Autowired MstUrl url;
	
	
	
	@RequestMapping(value={"/validate-session"})
	public void validateSession(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		try {
			MstUsuario user = (MstUsuario) openSession(response, request).getAttribute("user");
			int timeout = Integer.parseInt(user.getSessiontimeout());
			timeout--;
			user.setSessiontimeout("" + timeout);
			openSession(response, request).setAttribute("user", user);
			responseAjax(response, user.getSessiontimeout());
			
		} catch (java.lang.NullPointerException e) {
			logger.warn("Se intenta transformar el timeout del usuario en integer pero el timeout es null:"
					+ e.getMessage());
			responseAjax(response, "-1");
		}
		
	}
	
	@RequestMapping(value={"/session-finish"})
	public ModelAndView sessionFinish(HttpServletResponse response,HttpServletRequest request) throws IOException{
    
		logger.info("Session finish");
		openSession(response, request).setAttribute("user", null);
		openSession(response, request).invalidate();

		return new ModelAndView("login");
		
		
	}
	
}
