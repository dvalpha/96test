package com.dvalpha.core.filter;
import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dvalpha.core.config.MvcConfiguration;
import com.dvalpha.core.dao.GenericDao;
 
public class SpringInicializador extends
AbstractAnnotationConfigDispatcherServletInitializer {

//...

@Override
protected Filter[] getServletFilters() {
return new Filter[]{new ErrorHandleFilter(),new UrlRestrictionFilter(),new CharacterEncodingFilter()};
}

@Override
protected Class<?>[] getRootConfigClasses() {
	
	// TODO Auto-generated method stub
	//return new Class[] { GenericDao.class };
	
	return null;
}

@Override
protected Class<?>[] getServletConfigClasses() {
	System.out.println("SE ACCEDE AL INICIALIZADOR --> getServletConfigClasses() ");
	return new Class[] { MvcConfiguration.class};
}

@Override
protected String[] getServletMappings() {
	// TODO Auto-generated method stub
	return null;
}
	
}
