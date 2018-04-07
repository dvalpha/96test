package com.dvalpha.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstArchivo;
import com.dvalpha.core.entity.MstCentro;
import com.dvalpha.core.entity.MstRol;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.utils.TransformBytesToTB;


/**
 * Controlador generico
 * @author alex
 *
 */

public class CoreController {
	private static final Logger logger = Logger.getLogger(CoreController.class);	
	public  List<MstApplicationParams>parametros;
	public  List<MstUrl>listaUrls;
	

	public List<MstApplicationParams> getParametros() {
		return parametros;
	}

	public void setParametros(List<MstApplicationParams> parametros) {
		this.parametros = parametros;
	}

	public List<MstUrl> getListaUrls() {
		return listaUrls;
	}

	public void setListaUrls(List<MstUrl> listaUrls) {
		this.listaUrls = listaUrls;
	}

	/**
	 * Metodo diseñado para las respuestas a peticiones AJAX desde las vistas
	 * @param response
	 * @param respuesta
	 */
	
	public void responseAjax(HttpServletResponse response,String respuesta) {
		response.setContentType("text/html;charset=UTF-8");	
		try {
			PrintWriter out=response.getWriter();
			out.println(respuesta);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public double obtenerEspacioOcupado(MstUsuario user, HttpServletRequest request, HttpServletResponse response) {
        int bytes=0;
		
		for(MstArchivo archivo:user.getArchivos()) {
			bytes+=archivo.getTamano();
			
		}
		TransformBytesToTB transform = new TransformBytesToTB(bytes);
		double mb=transform.getMB();
		
		return mb;
	}
	
	
	/**
	 * Acceso a la sesion eliminando lineas de codigo adicionales
	 * @param response
	 * @param request
	 * @return
	 */
	public HttpSession openSession(HttpServletResponse response,HttpServletRequest request) {
		HttpSession ses = request.getSession();
		return ses;
		
	}
	
	public MstUsuario getUserSession(HttpServletResponse response,HttpServletRequest request) {
		return (MstUsuario)openSession(response, request).getAttribute("user");
	}

    /**
     * Método que retorna nulo si el parametro de la request es null, evitando un null pointer exception
     * @param request
     * @param parameter
     * @return
     */
	public String getParameterNotNull(HttpServletRequest request,String parameter) {
		String nombre=parameter;
		try {
		parameter=(request.getParameter(parameter)).equalsIgnoreCase("")?"nulo":request.getParameter(parameter);
		}catch(java.lang.NullPointerException e) {
	    logger.info("Parametro: null "+e.getCause());
		}
		logger.info("Parametro enviado al controlador: [nombre:"+nombre+" valor:"+parameter+"]");
		
		return parameter;
	}
	
	/**
	 * Metodo que recoge los parametros de la request y los settea a un bean
	 * @param request
	 * @param obj
	 * @return
	 */
	public Object populateBean(HttpServletRequest request,Object obj){
		
		Map<String, String> parameters = request.getParameterMap();
		try {
			BeanUtils.populate(obj, parameters);
		} catch (IllegalAccessException e) {
			logger.error(e.getCause());
		} catch (InvocationTargetException e) {
			logger.error(e.getCause());
		} catch(org.apache.commons.beanutils.ConversionException e) {
			logger.error(e.getCause());
		}
		return obj;
	}
	
	
	
	
	public MstApplicationParams getParameter(String key,HttpServletRequest request,HttpServletResponse response) {
		
		List<MstApplicationParams>params = (List<MstApplicationParams>) openSession(response, request).getAttribute("parametros");
		MstApplicationParams param=null;
		
		for(MstApplicationParams p:params) {
			if(p.getKey().equalsIgnoreCase(key)) {
				param=p;
			}
		}
		
		return param;
	}
	
	
	
}
