package com.dvalpha.core.filter;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.dvalpha.core.config.ApplicationContextProvider;
import com.dvalpha.core.controller.CoreController;
import com.dvalpha.core.controller.InitController;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstModule;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.MstUsuario;


public class UrlRestrictionFilter extends CoreController implements Filter {
	private static final Logger logger = Logger.getLogger(UrlRestrictionFilter.class);	
	
	
	
	
	/**
     * Default constructor. 
     */
    public UrlRestrictionFilter() {
    	
    }

	
    
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession ses = req.getSession();
		
		MstUsuario user= (MstUsuario)ses.getAttribute("user");
		List<MstUrl> lista =(List<MstUrl>)ses.getAttribute("urls");
		
	
		
	
		String url =obtenerUrl(request,response);
		boolean b = validarUrl(url,request,response,user,lista);
		
		if(b) {
			
			responseAjax(res, "Acceso denegado");
			
		}else {
		
		
		chain.doFilter(request, response);
		}
	}

	private boolean validarUrl(String url,ServletRequest request, ServletResponse response,MstUsuario user,List<MstUrl> lista) {
		boolean b=false;
		  
		try {
			
			for (MstUrl ur : lista) {
				if (ur.getUrl().equalsIgnoreCase(url)) {
					for(MstModule moduleRol:user.getMstrol().getModulos()) {
						String moduleUrl =ur.getModulo();
						
						//comparamos el nombre de los modulos
						if(moduleUrl.equalsIgnoreCase(moduleRol.getNombre())) {
							
							//Comparamos los niveles del rol para esa url (de ese modulo)
							int rolLevel = moduleRol.getLevel();
							int urlLevel =ur.getLevel();
							
							if(rolLevel>=urlLevel) {
								b = true;
								logger.info("Nivel de rol "+rolLevel+" nivel de url "+urlLevel+" acceso denegado por permisos.");
							}	
							
						}
						
					}
						
				}
			}
		} catch (java.lang.NullPointerException e) {
			logger.info(e.getCause()+" "+e.getMessage());
		}

		return b;
	}

	private String obtenerUrl(ServletRequest request, ServletResponse response) {
		String u = ((HttpServletRequest)request).getRequestURL().toString();
		String us [] =u.split("/");
		String url = us[us.length-1];
		return url;
	}



	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
