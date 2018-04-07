package com.dvalpha.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstArchivo;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.filter.UrlRestrictionFilter;
import com.dvalpha.core.service.FunctionsService;
import com.dvalpha.core.service.MstUserService;

import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry; 

@Configuration
@ComponentScan(basePackages="com.dvalpha")
@EnableWebMvc
@EnableTransactionManagement
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	
   /* @Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	*/
	
	@Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
 
    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
    
    
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	@Bean
	public ApplicationContextProvider getApplicationContextProvider() {
		return new ApplicationContextProvider();
	}

	@Bean 
    public HibernateExceptionTranslator hibernateExceptionTranslator(){ 
      return new HibernateExceptionTranslator(); 
    }
	
	
	@Bean
	public MstArchivo getMstArchivo() {
		return new MstArchivo();
	}
	
	
	
	@Bean 
	public MstApplicationParams getMstApplicationParams() {
		return new MstApplicationParams();
	}
	
	@Bean 
	public MstUrl getMstUrl() {
		return new MstUrl();
	}
	
	
	
	
}
