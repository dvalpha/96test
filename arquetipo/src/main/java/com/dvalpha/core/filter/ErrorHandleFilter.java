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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.MstUsuario;

public class ErrorHandleFilter implements Filter {

	WebApplicationContext springContext;
	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext springContext = 
				WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		this.springContext=springContext;
	}

	@Override
	public void doFilter(ServletRequest request,
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		try {
			
	        
			
			
			
			chain.doFilter(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
                               .forward(request, response);
		}

	}


}
