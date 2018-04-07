package com.dvalpha.core.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstCentro;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.MstUsuario;
import com.mysql.fabric.jdbc.FabricMySQLDataSource;

@Controller
public class InitController extends CoreController {
	private static final Logger logger = Logger.getLogger(InitController.class);	

	
	@Autowired ServletContext context;
	@Autowired MstUrl url;
	@Autowired MstApplicationParams params;
	@Resource IGenericDAO dao; //al ser un DAO lo invocamos de esta forma
	

	
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
		
		
        return "login";
    }
	
	@RequestMapping(value={"/logout"})
	public ModelAndView logout(HttpServletResponse response,HttpServletRequest request) throws IOException{
		      logger.info("Sesion invalidada");
		      openSession(response, request).invalidate();
			 // return new ModelAndView("/login/login");
		      return new ModelAndView("login");
		
	}
	
	@RequestMapping(value={"/login"})
	public ModelAndView  login(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		boolean validacion=validarLogin(request,response);
		
		ModelAndView model = new ModelAndView();
		
		if(validacion) {
			logger.info("Usuario valido");
			  model.setViewName("home");
			
		}else {
			logger.info("Usuario incorrecto");
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
				for(MstUsuario user:users) {
					if(user.getUser().equalsIgnoreCase(request.getParameter("user"))&&
					   user.getPassword().equalsIgnoreCase(request.getParameter("psw")) 		) {
						b=true;
						
						
						//DEJAMOS TODOS LOS PARAMETROS EN LA SESION
						InicializarParametros(request, response);
						
						//DEJAMOS LAS RESTRICCIONES DE URL EN SESION
						inicializarURLS(request, response);
						
						//INICIALIZAMOS LA URL DE ESTATICOS
						MstApplicationParams path_Statics=getParameter("statics", request, response);
						openSession(response, request).setAttribute("statics", path_Statics.getValor());
						
						//DEJAMOS AL USUARIO EN LA SESION CALCULANDO SU ESPACIO DISPONIBLE EN DISCO
						double espacio_ocupadoMB =obtenerEspacioOcupado(user,request,response);
						int espacio_total=user.getMststorage().getMaxMB();
						double total=(espacio_ocupadoMB*100)/espacio_total;
						DecimalFormat mf = new DecimalFormat("#0.0");
						String s = mf.format(total);
						s = s.replace(',', '.');
						double conv = Double.parseDouble(s); 
						user.setEspacioOcupado(conv);
						openSession(response, request).setAttribute("user", user);
						
						//DEJAMOS EL DAO GENERICO EN SESION
						openSession(response, request).setAttribute("dao", dao);
						
					}
				}
				
			}
			
		}
		
		
		return b;
	}

	
	@RequestMapping(value={"/core/home"})
	public ModelAndView home(HttpServletResponse response,HttpServletRequest request) throws IOException{
		 logger.info("/core/home");
			  logger.info("Inicializando parametros");
			 //Inicializamos los parametros de la aplicacion
			  InicializarParametros(request,response);
		     
			  //Determinamos si la aplicacion se inicia pr primera vez o esta ya inicializadada
			  if(getParameter("mode", request, response).getValor().equalsIgnoreCase("init")) {
				  crearCentro();
				  crearUsuario();
			  }
			  
			  //Inicializamos las URLS
			  inicializarURLS(request,response);
			 // return new ModelAndView("/core/home");
			  return new ModelAndView("home");
		
	}
	
	
	
	
	
	
	
	private void crearUsuario() {
		
		MstUsuario user = new MstUsuario();
		user.setAcepto_condiciones_legales(true);
		user.setActivo(true);
		user.setApellidos("Millan Avalos");
		
		user.setEmail("tic.millan@gmail.com");
		user.setNombre("Alejandro");
		user.setPassword("qwe");
		user.setSessiontimeout("30");
		user.setTelefono("1222");
		user.setUser("qwe");
		user.setMstcentro(new MstCentro(1L));
		
		
		
		dao.createEntity(user);
		
	}
	private void crearCentro() {
		MstCentro centro = new MstCentro();
		centro.setActivo(true);
		centro.setApiKey("qwe");
		centro.setBorrado(false);
		centro.setCodificar_archivos(false);
		centro.setCodigoCentro("6alde");
		centro.setCp("08176");
		centro.setDireccion("xx");
		centro.setFax("sin fax");
		centro.setFilial(false);
		centro.setMail("tic.millan@gmail.com");
		centro.setNifCif("B65670309");
		centro.setNombreComercial("dvalpha");
		centro.setPais("España");
		centro.setPersonaContacto("yo");
		centro.setPoblacion("Barcelona");
		centro.setProvincia("Barcelona");
		centro.setRazonSocial("DvAlpha Solutions TIC S.L.");
		centro.setTelefono("938881181");
		
		dao.createEntity(centro);
		
	}
	private List<MstApplicationParams>InicializarParametros(HttpServletRequest request, HttpServletResponse response) {
		logger.info("INICIALIZANDO PARAMETROS");
		List<MstApplicationParams>params = (List<MstApplicationParams>) dao.findAll(new MstApplicationParams());
		//Lo dejamos en el contexto de sesion de spring
		HttpSession ses= openSession(response, request);
	    ses.setAttribute("parametros", params); 
	    
	   
	    setParametros(params);
	    
	    return params;
	}
	private void inicializarURLS(HttpServletRequest request, HttpServletResponse response) {
		logger.info("INICIALIZANDO URLS");
		List<MstUrl>urls = (List<MstUrl>) dao.findAll(url);
		logger.info("La lista de URL TIENE "+urls.size());
		HttpSession ses= openSession(response, request);
		
	   ses.setAttribute("urls", urls);
	   
	    setListaUrls(urls);
	  
	    
	    
		
	}

	
}
