package com.dvalpha.core.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstArchivo;
import com.dvalpha.core.entity.MstDirectorio;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.utils.TransformBytesToTB;

@Controller
public class MstArchivoController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstArchivo.class);
	@Autowired
	IGenericDAO dao;

	@RequestMapping(value = { "/main-menu-archivo" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {

		return new ModelAndView("archivo-main");

	}

	/**
	 * Lista todos los archivos de todos los usuarios
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = { "/list-archivo" })
	public ModelAndView listMstArchivo(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<MstArchivo> lista = (List<MstArchivo>) dao.findAll(new MstArchivo());
		request.setAttribute("list", lista);
		return new ModelAndView("archivo-list");

	}
	
	
	/**
	 * Metodo que carga todos los archivos que estan dentro del directorio seleccionado
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/obtener-archivos-del-directorio" })
	public void loadDashboardFolder(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstApplicationParams param =getParameter("statics", request, response); 
		String statics_dir=param.getValor();
		MstUsuario user =getUserSession(response, request);
		Long id = Long.parseLong(request.getParameter("idDir"));
		List<MstArchivo> lista = (List<MstArchivo>) dao.findAllWhereAnd(new MstArchivo(), "usuario", user,"directorio", new MstDirectorio(id));
		String cuerpo="";
		
		for(MstArchivo bean:lista) {
			String codificadoIcon ="";
			
			// Si el archivo esta codificado mostramos el icono que nos lo indica en la vista
			if(bean.getCodificado()) {
				
				codificadoIcon="<span  alt=\"Archivo codificado\" class=\"glyphicon glyphicon-flash pull-left\" style=\"color:#fff; background-color: #408abb; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n";			
			}
			
			
		cuerpo+="	<div class=\"col-md-2 col-sm-2 text-center\" id=\"elemento-"+bean.getId()+"\" style=\"height: 240px; width:180px;\"> \r\n" + 
		"	\r\n" + 
		"    		<span class=\"thumbnail-files text-center\" style=\"background-color: #467594;\">\r\n" + 
		"    		\r\n" + 
		"    		<span onclick=\"editar("+bean.getId()+")\" class=\"glyphicon glyphicon-pencil pull-left\" style=\"color:#fff; background-color: #408abb; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n" + 
		"    		<span onclick=\"borrarArchivo("+bean.getId()+")\" class=\"glyphicon glyphicon-erase pull-left\" style=\"color:#fff; background-color: #408abb; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n" + 
		
		//introducimos el icono si esta codificado
		codificadoIcon+"    		\r\n" + 
		"    		\r\n" + 
		"    		<div class=\"dropdown \" style=\"float: right!important;\" >\r\n" + 
		"								  <button class=\"btn btn-default dropdown-toggle  btn-xs\" type=\"button\" data-toggle=\"dropdown\"><span class=\"glyphicon glyphicon-edit\"></span>\r\n" + 
		"								  <span class=\"caret\"></span></button>\r\n" + 
		"								  <ul class=\"dropdown-menu \" style=\"background-color: rgba(255, 255, 255, 0.92) !important;\" >\r\n" + 
		"								    \r\n" + 
		"									\r\n" + 
		"								    <li><a  onclick=\"compartirConUsuarioMenu("+bean.getId()+")\"><span class=\"glyphicon glyphicon-user\"></span> Compartir con un usuario</a></li>\r\n" + 
		"								    <li><a  onclick=\"compartirConDepartamento("+bean.getId()+")\"><span class=\"glyphicon glyphicon-share\"></span>  Compartir con mi departamento</a></li>\r\n" + 
		"								    <li><a  onclick=\"hacerPublico("+bean.getId()+")\"><span class=\"glyphicon glyphicon-home\"></span>  Hacer publico el archivo</a></li>\r\n" + 
		"								    <li><a  onclick=\"dejarDeCompartir("+bean.getId()+")\"><span class=\"glyphicon glyphicon-stop\"></span>  Dejar de compartir</a></li>\r\n" + 
			"								   	<li class=\"divider\"></li>\r\n" + 
		"								    <li><a  onclick=\"codificarArchivo("+bean.getId()+")\"><span class=\"glyphicon glyphicon-eye-close\"></span> Codificar archivo</a></li>\r\n" + 
		"								    <li><a  onclick=\"descodificarArchivo("+bean.getId()+")\"><span class=\"glyphicon glyphicon-eye-open\"></span> Descodificar archivo</a></li>\r\n" + 
		"								  </ul>\r\n" + 
		"					</div>\r\n" + 
		
		
		                    // Generamos el html del archivo dependiendo de su tipo
		"      		" + generarHtmlApartirDeExtensionDeArchivo(bean,statics_dir)+ 
		"      			\r\n" + 
		"      		    \r\n" + 
		"      			\r\n" + 
		"      		    \r\n" + 
		
						   //Generamos el titulo del archivo y dependiendo de su tamaño, lo editamos
		"      			<span style=\"color:#fff; font-size:12px; padding:25px; margin-bottom: 10px;\">\r\n" + 
		"      		" + generarHtmlEnFuncionDelTamanoDelTituloDelArchivo(bean,statics_dir)+
		
		"      			\r\n" + 
		"      			</span>\r\n" + 
		"      			\r\n" + 
							//Generamos el mensaje que sale cuando compartimos un archivo
		"      		" + generarMensajeDeArchivoCompartido(bean,statics_dir)+
		""+
		
		"    		</span>\r\n" + 
		"  		</div>\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"\r\n"; 
		}// fin del bucle for
		responseAjax(response, cuerpo);
		
	}
	private String generarListaDeUsuariosCompartidos(MstArchivo bean) {
		String html="";
		List<MstArchivo> lista = (List<MstArchivo>)dao.findAllWhere(new MstArchivo(), "hashCode", bean.getHashCode());
		for(MstArchivo ar:lista) {
			html+="<hr> <p style=\"color:#fff;\"><img style=\"width:30px; height:30px;\" class=\"img img-circle pull-left\" src=\""+ar.getUsuario().getAvatar()+"\">\r\n"+ar.getUsuario().getNombre()+" "+ar.getUsuario().getApellidos()+"</p>";
			 
		}
		return html;
	}

	/**
	 * Metodo que refresca la parte de los archivos pero no la de los directorios
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/load-dashboard-body" })
	public void loadDashboardBody(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstApplicationParams param =getParameter("statics", request, response); 
		Long iddir = Long.parseLong(request.getParameter("iddir"));
		MstDirectorio dir = (MstDirectorio)dao.readById(iddir, MstDirectorio.class);
		String statics_dir=param.getValor();
		MstUsuario user =(MstUsuario)openSession(response, request).getAttribute("user");
		List<MstArchivo> lista = (List<MstArchivo>) dao.findAllWhereAnd(new MstArchivo(), "usuario", user,"directorio", dir);
		String cuerpo="";
		
		for(MstArchivo bean:lista) {
			
		String codificadoIcon ="";
		
		if(bean.getCodificado()) {
			codificadoIcon="<span  class=\"glyphicon glyphicon-flash pull-left\" style=\"color:#fff; background-color: #408abb; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n";
					
		}
			
		cuerpo+="	<div class=\"col-md-2 col-sm-2 text-center\" id=\"elemento-"+bean.getId()+"\" style=\"height: 240px; width:180px;\"> \r\n" + 
		"	\r\n" + 
		"    		<span class=\"thumbnail-files text-center\" style=\"background-color: #467594;\">\r\n" + 
		"    		\r\n" + 
		"    		<span onclick=\"editar("+bean.getId()+")\" class=\"glyphicon glyphicon-pencil pull-left\" style=\"color:#fff; background-color: #408abb; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n" + 
		"    		<span onclick=\"borrarArchivo("+bean.getId()+")\" class=\"glyphicon glyphicon-erase pull-left\" style=\"color:#fff; background-color: #408abb; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n" + 
		
                    codificadoIcon+
		
		"    		\r\n" + 
		"    		\r\n" + 
		"    		<div class=\"dropdown \" style=\"float: right!important;\" >\r\n" + 
		"								  <button class=\"btn btn-default dropdown-toggle  btn-xs\" type=\"button\" data-toggle=\"dropdown\"><span class=\"glyphicon glyphicon-edit\"></span>\r\n" + 
		"								  <span class=\"caret\"></span></button>\r\n" + 
		"								  <ul class=\"dropdown-menu \" style=\"background-color: rgba(255, 255, 255, 0.92) !important;\" >\r\n" + 
		"								    \r\n" + 
		"									\r\n" + 
		"								    <li><a  onclick=\"compartirConUsuarioMenu("+bean.getId()+")\"><span class=\"glyphicon glyphicon-user\"></span> Compartir con un usuario</a></li>\r\n" + 
		"								    <li><a  onclick=\"compartirConDepartamento("+bean.getId()+")\"><span class=\"glyphicon glyphicon-share\"></span>  Compartir con mi departamento</a></li>\r\n" + 
		"								    <li><a  onclick=\"hacerPublico("+bean.getId()+")\"><span class=\"glyphicon glyphicon-home\"></span>  Hacer publico el archivo</a></li>\r\n" + 
		"								    <li><a  onclick=\"dejarDeCompartir("+bean.getId()+")\"><span class=\"glyphicon glyphicon-stop\"></span>  Dejar de compartir</a></li>\r\n" + 
		"								    <li class=\"divider\"></li>\r\n" + 
		"								    <li><a  onclick=\"codificarArchivo("+bean.getId()+")\"><span class=\"glyphicon glyphicon-eye-close\"></span> Codificar archivo</a></li>\r\n" + 
		"								    <li><a  onclick=\"descodificarArchivo("+bean.getId()+")\"><span class=\"glyphicon glyphicon-eye-open\"></span> Descodificar archivo</a></li>\r\n" + 
		"								  </ul>\r\n" + 
		"					</div>\r\n" + 
		"      		\r\n" + generarHtmlApartirDeExtensionDeArchivo(bean,statics_dir)+
		""
		+
		"      			 \r\n" + 
		"      			\r\n" + 
		"      		\r\n" + 
		"      			<span style=\"color:#fff; font-size:12px; padding:25px; margin-bottom: 10px;\">\r\n" + 
		"      			\r\n" + generarHtmlEnFuncionDelTamanoDelTituloDelArchivo(bean,statics_dir)+
		
		"      			\r\n" + 
		"      			</span>\r\n" + 
		"      			\r\n" + 
		"      			\r\n" + generarMensajeDeArchivoCompartido(bean,statics_dir)+
	
		"      			\r\n" + 
		"    		</span>\r\n" + 
		"  		</div>\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"\r\n"; 
		}// fin del bucle for
		responseAjax(response, cuerpo);
	}
	
	/**
	 * Metodo que refresca la parte de los directorios pero no la parte de los archivos
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/load-dashboard" })
	public void loadDashboard(HttpServletResponse response, HttpServletRequest request) throws IOException {
		MstApplicationParams param =getParameter("statics", request, response); 
		String statics_dir=param.getValor();
		
		MstUsuario user =(MstUsuario)openSession(response, request).getAttribute("user");
		
		List<MstArchivo> lista = (List<MstArchivo>) dao.findAllWhere(new MstArchivo(), "usuario", user);
		List<MstDirectorio> rootdir = (List<MstDirectorio>)dao.findAllWhereAnd(new MstDirectorio(), "root", true,"usuario",user);
		logger.warn("EL valor de rootdir ES "+rootdir);
		//Dejamos el directorio root en sesion para que cuando cargue la pagina principal sepa que directorio es el root
		openSession(response, request).setAttribute("rootdir", rootdir.get(0));
		
		String dashboard="<div class=\"col-sm-2\" style=\" height:800px; overflow: auto; \">\r\n" + 
				"		\r\n";
		List<MstDirectorio> dirs =(List<MstDirectorio>)dao.findAllWhere(new MstDirectorio(),"usuario", user);
		String btnBorrar="";
		
				 
		for(MstDirectorio dir:dirs) {
			
			String borrarAction="<span  class=\"glyphicon glyphicon-remove\" onclick=\"borrarDirectorio("+dir.getId()+")\" style=\"color:#fff; font-size:9px; background-color: #a9a9a9; border:solid 1px; padding:3px; margin-bottom: 8px;\"></span>\r\n";	
			//Si es el directorio root quitamos la opcion de ser eliminado por el usuario
			if(!dir.getRoot()) {
				dashboard+=borrarAction;
			}
			
			
			dashboard+=	 "<div id=\"divx\" onclick=\"getFilesFromFolder("+dir.getId()+")\" ondrop=\"drop(event,"+dir.getId()+")\" ondragover=\"allowDrop(event)\">\r\n" + 
					 "				<img style=\"width:50px; height:50px;\" id=\"img-dir-"+dir.getId()+"\" src=\""+statics_dir+"/images/iconos/folder.png\">\r\n" + 
				
				"				</div>\r\n" + 
				"				<p id=\"name-dir-"+dir.getId()+"\" onclick=\"cambiarNombreDelDirectorio("+dir.getId()+")\" >"
				                +dir.getNombre()+
				                " <span class=\"badge\">"+dir.getArchivosByUser(user).size()+"</span></p>\r\n" + 
				"		\r\n";
		}
		dashboard+=	"</div><div class=\"col-sm-10\" style=\" height:800px; overflow: auto; \">\r\n" + 
				"		\r\n" + 
				
				"\r\n"+
		
			"<div id=\"cuerpo-dashboard\"> \r\n" + 
				"				\r\n";
		
				
				String finaltxt="</div> <!-- fin cuerpo dashboard-->\r\n" + 
				"               \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" <!--<div id=\"dialog\"  title=\"Compartir archivos\" class=\"panel panel-primary\" >\r\n" + 
				"\r\n" + 
				"  <div id=\"file-id\" style=\" max-height:600px; overflow: auto;\"></div>\r\n" + 
				"</div>-->\r\n" + 
				"";
				
				responseAjax(response, dashboard+finaltxt);

	}
	
	/**
	 * Cambia el directorio al que pertenece un archivo
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/cambiar-directorio" })
	public void cambiarDirectorio(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long idFile=Long.parseLong(request.getParameter("idFile"));
		Long idDir=Long.parseLong(request.getParameter("idDir"));
		
		MstArchivo file = (MstArchivo)dao.readById(idFile, MstArchivo.class);
		MstDirectorio dir =(MstDirectorio)dao.readById(idDir,MstDirectorio.class);
		
		file.setDirectorio(dir);
		dao.updateEntity(file);

	}
	
	
	/**
	 * Crea un directorio nuevo
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/crear-directorio" })
	public void crearDirectorio(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String nombre=request.getParameter("nombre");
		MstUsuario user =getUserSession(response, request);
		MstDirectorio dir =new MstDirectorio();
		dir.setNombre(nombre);
		dir.setRoot(false);
		dir.setOrden(1);
		dir.setUsuario(user);
		
	
		dao.createEntity(dir);

	}
	
	/**
	 * Renombra un directorio
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/cambiar-nombre-directorio" })
	public void cambiarNombreDelDirectorio(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String nombre=request.getParameter("nombre");
		Long idDir=Long.parseLong(request.getParameter("id"));
		
		MstDirectorio dir =(MstDirectorio)dao.readById(idDir, MstDirectorio.class);
		dir.setNombre(nombre);
		
		
	
		dao.updateEntity(dir);

	}
	
	/**
	 * Metodo que añade un mensaje si el archivo esta siendo compartido, si el archivo es publico, o si esta siendo compartido conmigo
	 * @param bean
	 * @param statics_dir
	 * @return
	 */
	private String generarMensajeDeArchivoCompartido(MstArchivo bean, String statics_dir) {
		String str="";
		
		if(bean.getCompartido() && !bean.getPublico()) {
			
			     if(bean.getStatus().equalsIgnoreCase("ROOT")) {
			    	 str="<p class=\"alert alert-info alert-xs\" style=\"height: 25px; padding:3px !important;margin-top: 10px;\">Compartido </p>\r\n" ;
			     }else if(bean.getStatus().equalsIgnoreCase("Compartido conmigo")) {
			    	 str="<p class=\"alert alert-info alert-xs\" style=\"height: 25px; padding:3px !important;margin-top: 10px;\">Compartido conmigo</p>\r\n" ;
			     }else if(bean.getStatus().equalsIgnoreCase("Distribuido")) {
			    	 str="<p class=\"alert alert-info alert-xs\" style=\"height: 25px; padding:3px !important;margin-top: 10px;\">Distribuido</p>\r\n" ;
			     }
		}else if(bean.getCompartido() && bean.getPublico()) {
				if(bean.getStatus().equalsIgnoreCase("ROOT")) {
			    	 str="<p class=\"alert alert-info alert-xs\" style=\"height: 25px; padding:3px !important;margin-top: 10px;\">Público</p>\r\n" ;
			    }else if(bean.getStatus().equalsIgnoreCase("Compartido conmigo")) {
			    	 str="<p class=\"alert alert-info alert-xs\" style=\"height: 25px; padding:3px !important;margin-top: 10px;\">Compartido conmigo</p>\r\n" ;
			    }else if(bean.getStatus().equalsIgnoreCase("Distribuido")) {
			    	 str="<p class=\"alert alert-info alert-xs\" style=\"height: 25px; padding:3px !important;margin-top: 10px;\">Distribuido</p>\r\n" ;
			    }
			
		}
		
		
		
		return str;
	}

	/**
	 * Metodo que edita el titulo de un archivo para que no sea demasiado largo
	 * @param bean
	 * @param statics_dir
	 * @return
	 */
	private String generarHtmlEnFuncionDelTamanoDelTituloDelArchivo(MstArchivo bean, String statics_dir) {
		String str="";
		if(bean.getEtiqueta().length()>=20) {
			str=bean.getEtiqueta().substring(0, 17);
		}else {
			str=bean.getEtiqueta();
		}
		
		return str;
	}

	
	/**
	 * Metodo que genera el html que envuelve al archivo
	 * Este HTML sera distinto en funcion del archivo que sea, es decir no sera igual para una imagen que para un PDF 
	 
	 * @param bean
	 * @param statics
	 * @return
	 */
	private String generarHtmlApartirDeExtensionDeArchivo(MstArchivo bean, String statics) {
		
		String str="";
		if(bean.getExtension().contains("txt")) {
			str="<a id=\"link-"+bean.getId()+"\" draggable=\"true\" ondragstart=\"drag(event)\" onclick=\"down('"+bean.getUrlPath()+"')\">\r\n" + 
					"      		<img src=\""+statics+"/images/iconos/text.png\" class=\"thumbnail-files\" style=\"width:138px; height:100px;\"alt=\"...\">\r\n" + 
					"      		\r\n" + 
					"      		</a>\r\n" + 
					"    		\r\n";
		}else if(bean.getExtension().contains("pdf")) {
			str="<a id=\"link-"+bean.getId()+"\" draggable=\"true\" ondragstart=\"drag(event)\" onclick=\"down('"+bean.getUrlPath()+"')\">\r\n" + 
					"      		<img src=\""+statics+"/images/iconos/pdf.png\" class=\"thumbnail-files\" style=\"width:138px; height:100px;\"alt=\"...\">\r\n" + 
					"      		\r\n" + 
					"      		</a>\r\n" + 
					"    		\r\n";
		}else if(bean.getExtension().contains("doc")) {
			str="<a id=\"link-"+bean.getId()+"\" draggable=\"true\" ondragstart=\"drag(event)\" onclick=\"down('"+bean.getUrlPath()+"')\">\r\n" + 
					"      		<img src=\""+statics+"/images/iconos/word.png\" class=\"thumbnail-files\" style=\"width:138px; height:100px;\"alt=\"...\">\r\n" + 
					"      		\r\n" + 
					"      		</a>\r\n" + 
					"    		\r\n";
		}else if(bean.getExtension().contains("xls")) {
			str="<a id=\"link-"+bean.getId()+"\" draggable=\"true\" ondragstart=\"drag(event)\"  onclick=\"down('"+bean.getUrlPath()+"')\">\r\n" + 
					"      		<img src=\""+statics+"/images/iconos/excel.png\" class=\"thumbnail-files\" style=\"width:138px; height:100px;\"alt=\"...\">\r\n" + 
					"      		\r\n" + 
					"      		</a>\r\n" + 
					"    		\r\n";
		}else{
			str=" <a draggable=\"true\" ondragstart=\"drag(event)\" class=\"fancybox\" id=\"link-"+bean.getId()+"\"  href=\""+bean.getUrlPath()+"\" title=\""+bean.getEtiqueta()+"\">\r\n" + 
					"      		<img  src=\""+bean.getUrlPath()+"\" class=\"thumbnail-files\" style=\"width:138px; height:100px;\" alt=\"...\">\r\n" + 
					"      		</a>	\r\n";
		}
		return str;
	}

	/**
	 * Lista los archivos de un usuario concreto (generalmente el que hay en sesion)
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = { "/list-archivo-user" })
	public ModelAndView listMstArchivoUser(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		MstUsuario user =(MstUsuario)openSession(response, request).getAttribute("user");
		List<MstArchivo> lista = (List<MstArchivo>) dao.findAllWhere(new MstArchivo(), "usuario", user);
		List<MstDirectorio> rootdir = (List<MstDirectorio>)dao.findAllWhere(new MstDirectorio(), "root", true);
		logger.warn("EL valor de rootdir ES "+rootdir);
		//Dejamos el directorio root en sesion para que cuando cargue la pagina principal sepa que directorio es el root
		openSession(response, request).setAttribute("rootdir", rootdir.get(0));
		request.setAttribute("list", lista);
		return new ModelAndView("archivo-list");

	}

	@RequestMapping(value = { "/menu-edit-archivo" })
	public ModelAndView menuEditMstArchivo(HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstArchivo user = (MstArchivo) dao.readById(id, MstArchivo.class);
		List<MstUsuario> lista0 = (List<MstUsuario>) dao.findAll(new MstUsuario());
		request.setAttribute("dependencia00", lista0);
		request.setAttribute("object", user);
		return new ModelAndView("archivo-edit");

	}

	@RequestMapping(value = { "/update-archivo" })
	public void updateMstArchivo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		MstArchivo bean = (MstArchivo) dao.readById(id, MstArchivo.class);
		bean.setEtiqueta(request.getParameter("etiqueta"));
		
		dao.updateEntity(bean);
		
		responseAjax(response, "Actualizado");
	}
	
	
	
	/**
	 * Metodo que borra un directorio y los archivos que ese directorio contiene
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = { "/delete-directorio" })
	public void deleteMstDirectorio(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstDirectorio dir = (MstDirectorio) dao.readById(id,MstDirectorio.class);
		if(dir.getArchivos().size()==0) {
			dao.deleteEntity(dir);
			logger.warn("No hay archivos asociados");
		
		}else {
			
			List<String> hashList= new ArrayList();
			for(MstArchivo file:dir.getArchivos()) {
				hashList.add(file.getHashCode());
				File f = new File(file.getFilePath());
				if(f.exists()) {
					f.delete();
				}
			}
		
		
		//Borramos el directorio
		dao.deleteEntity(dir);
	
			for(String hash:hashList) {
			//borramos los archivos del directorio por hash (por si estan compartidos)
			List<MstArchivo> lista = (List<MstArchivo>)dao.findAllWhere(new MstArchivo(), "hashCode",hash);
				for(MstArchivo ar:lista) {
					dao.deleteEntity(ar);
				}
			}	
		}// fin else
		
		
		
		//refrescamos el usuario en sesion
		refrescarUsuarioEnSesion(request, response);

		responseAjax(response, "Eliminado");
	}

	@RequestMapping(value = { "/delete-archivo" })
	public void deleteMstArchivo(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		MstArchivo root = (MstArchivo) dao.readById(id, MstArchivo.class);
		List<MstArchivo> lista = (List<MstArchivo>)dao.findAllWhere(new MstArchivo(), "hashCode",root.getHashCode());
		for(MstArchivo ar:lista) {
			dao.deleteEntity(ar);
		}
		
		//refrescamos el usuario en sesion
		refrescarUsuarioEnSesion(request, response);

		responseAjax(response, "Eliminado");
	}
	
	public void refrescarUsuarioEnSesion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ses = request.getSession();
		MstUsuario user = (MstUsuario)ses.getAttribute("user");
		
		MstUsuario userRefresh =(MstUsuario)dao.readById(user.getId(), MstUsuario.class);
		ses.setAttribute("user", userRefresh);
	}
	
	//FUNCIONES PARTICULARES DE LA ENTIDAD MSTARCHIVO
   private String generarTabla(Long id, List<MstUsuario> lista, HttpServletRequest request, HttpServletResponse response) {
	   MstApplicationParams param =getParameter("statics", request, response); 
	   String header =" "
        		
				
        		+ "<h4><img src=\""+param.getValor()+"/images/iconos/compartido.gif\" style=\"width:120px; display: inline\" class=\"img img-responsive\" >\r\n"+ 
        		"				 Seleccione el usuario.</h4>"
        		+ "<table id=\"table-Modal-MstArchivo\" class=\"table table-condensed table-hover\" cellspacing=\"0\" width=\"100%\">\r\n" + 
		"					<thead>\r\n" + 
		"						<tr>\r\n" + 
		"						    <th>Usuario</th>\r\n" + 
		"						    <th>Nombre</th>\r\n" + 
		"							<th>Departamento</th>\r\n" + 
		"							<th>Controles</th>\r\n" + 
		"						</tr>\r\n" + 
		"					</thead>\r\n" + 
		"					<tbody>";
		String cuerpo="";
        for(MstUsuario user:lista) {
        	cuerpo+="<tr>\r\n" +
        	        "<td><img src=\""+user.getAvatar()+"\" style=\"width:50px;height:50px;\"></td>\r\n"+
        	        "<td>"+user.getNombre() + " " + user.getApellidos()+"</td>\r\n"+
        	        "<td>"+user.getDefdepartamentos().getNombre()+ "</td>\r\n"+
        	        "<td><button class=\"btn btn-success btn-xs\" onclick=\"compartirConUsuarioAction("+user.getId() +")\">Seleccionar</button>"
        	        + "<form id=\"frm-id-"+user.getId() +"\">"
        	        + "<input type=\"hidden\" name=\"user\" value=\""+user.getId() +"\">\r\n	"
        	        + "<input type=\"hidden\" name=\"file\" value=\""+id +"\">\r\n	"
        	        + "</form>\r\n"
        	        + "</td>\r\n"+
        	        "</tr>\r\n";
        }
       String end="</tbody></table>"; 
		return header+cuerpo+end;
	}
   
   private String generarFormularioDeConfirmacionGeneric(Long id, String file, String metodoJs,HttpServletRequest request,
			HttpServletResponse response) {
		   MstApplicationParams param =getParameter("statics", request, response);
			String confirm =""
					+ "\r\n"+ "<div class=\"col-md-12 col-lg-12 col-sm-12\">\r\n" 
					+ "\r\n"+ "<div class=\"col-md-2 col-lg-2 col-sm-2\"></div>\r\n" 
					+ "<div class=\"col-md-8 col-lg-8 col-sm-8\">\r\n" 
					+ "" + 
					"    		<span class=\" text-center\">\r\n" + 
					"      			<img src=\""+param.getValor()+"/images/iconos/validate.gif\" style=\"width:250px;\" class=\"img img-responsive text-center thumbnail\" alt=\"...\">\r\n" + 
					"      			<h4 style=\"color:#fff;\">Se requiere confirmación</h4>\r\n" + 
					"      			<div class=\"ratings\">\r\n" + 
					"                   <hr>\r\n" + 
					"                </div>\r\n" + 
					  ""
					  + ""
					  + ""
					  + "<form id=\"frm-"+metodoJs+"-"+id +"\">"
	    	        + "<input type=\"hidden\" name=\"user\" value=\""+id +"\">\r\n	"
	    	        + "<input type=\"hidden\" name=\"file\" value=\""+file +"\">\r\n	"  
	    	        + "</form>\r\n"
	    	        + "<button class=\"btn btn-danger col-lg-12\" onclick=\""+metodoJs+"("+ id +");\">Confirmar</button>\r\n	"
	    	        + "\r\n"+
					"\r\n" + 
					"\r\n" + 
					"      			<hr class=\"line\">\r\n" + 
					
					"    		</span>\r\n" + 
					"  		</div>"
					+ "\r\n"
					+ ""
					+ ""
					+ ""
					+ ""
					+"            </div>"
					+ "\r\n"+ "<div class=\"col-md-2 col-lg-2 col-sm-2\"></div>\r\n" 
					+ "\r\n</div>";
					
			return confirm;
		}
   
  
   
   public boolean validarSiHayEspacioDisponible(MstUsuario user,Long archivoSubido, HttpServletRequest request, HttpServletResponse response) {
       
		boolean b = false;
		
		for(MstArchivo archivo:user.getArchivos()) {
			archivoSubido+=archivo.getTamano();
			
		}
		TransformBytesToTB transform = new TransformBytesToTB(archivoSubido);
		double espacio_ocupadoMB=transform.getMB();
		int espacio_total=user.getMststorage().getMaxMB();
		
		double total=(espacio_ocupadoMB*100)/espacio_total;
		if(total<100) {
			b=true;
		}
		return b;
	}
   
   private String generarFormularioDeConfirmado(Long id, String file, HttpServletRequest request,
			HttpServletResponse response) {
	   MstApplicationParams param =getParameter("statics", request, response);
		String confirm =""
				+ "\r\n"+ "<div class=\"col-md-12 col-lg-12 col-sm-12\">\r\n" 
				+ "\r\n"+ "<div class=\"col-md-2 col-lg-2 col-sm-2\"></div>\r\n" 
				+ "<div class=\"col-md-8 col-lg-8 col-sm-8\">\r\n" + 
				"    		<span class=\" text-center\"><h3 style=\"color:#fff;\">Realizado!</h3>\r\n" + 
				"      			<img src=\""+param.getValor()+"/images/iconos/valido.gif\" style=\"width:400px;\" class=\"img img-responsive\" alt=\"...\">\r\n" + 
				"      			<h4 style=\"color:#fff;\">ARCHIVO COMPARTIDO</h4>\r\n" + 
				"      			<div class=\"ratings\">\r\n" + 
				"                   <hr>\r\n" + 
				"                </div>\r\n" + 
				  ""
				  + "<h4 style=\"color:#fff;\">Acción confirmada</h4>"
				  + ""
				  
   	        + "<div class=\"alert alert-success\"><h4>Archivo compartido!</h4></div>\r\n	"
   	        + "\r\n"+
				"\r\n" + 
				"\r\n" + 
				"      			<hr class=\"line\">\r\n" + 
				
				"    		</span>\r\n" + 
				"  		</div>"
				+ ""
				
				+"            </div>"
				+ "\r\n"+ "<div class=\"col-md-2 col-lg-2 col-sm-2\"></div>\r\n" 
				+ "\r\n</div>";
		return confirm;
	}
	
	@RequestMapping(value = { "/compartir-con-usuario" })
	public void compartirConUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		List<MstUsuario> lista = (List<MstUsuario>)dao.findAllSimple(new MstUsuario());
		String tabla=generarTabla(id,lista,request,response);
		String status="<div class=\"col-lg-12\"><p style=\"color:#fff;\">Status</p><div class=\"col-lg-12 alert alert-info\" id=\"msg-compartir\"></div></div>";
		responseAjax(response, tabla+status);
	}
	
	@RequestMapping(value = { "/compartir-con-usuario-action" })
	public void compartirConUsuarioAction(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("user"));
		String file =request.getParameter("file");
		// validamos si hay espacio disponible en ese usuario para compartir el archivo
		Long filex =Long.parseLong(request.getParameter("file"));
		MstUsuario user =(MstUsuario)dao.readById(id, MstUsuario.class);
		MstArchivo efile =(MstArchivo)dao.readById(filex, MstArchivo.class);
		
		//Validamos si se compartir el archivo con el usuario 
		boolean espacio=validarSiHayEspacioDisponible(user, efile.getTamano(), request, response);
		logger.info("el espacio es "+espacio);
		String confirmacion="";
		String status="";
		
			if(espacio) {
				confirmacion= generarFormularioDeConfirmacionGeneric(id, file, "compartirAction", request, response);
				status="<div class=\"col-lg-12\"><p style=\"color:#fff;\">Status</p><div class=\"col-lg-12 alert alert-info\" id=\"msg-compartir\"></div></div>";
			}else {
				confirmacion= generarFormularioDeNegacion(id, file, user.getNombre()+" "+user.getApellidos(), request, response);
				status="<div class=\"col-lg-12\"><p style=\"color:#fff;\">Status</p><div class=\"col-lg-12 alert alert-info\" id=\"msg-compartir\"></div></div>";
				
			}
		responseAjax(response, confirmacion+status);
	}
	private String generarFormularioDeNegacion(Long id, String file, String nombreUser, HttpServletRequest request,
			HttpServletResponse response) {
		MstApplicationParams param =getParameter("statics", request, response);
		String confirm =""
				+ "\r\n"+ "<div class=\"col-md-12 col-lg-12 col-sm-12\">\r\n" 
				+ "\r\n"+ "<div class=\"col-md-2 col-lg-2 col-sm-2\"></div>\r\n" 
				+ "<div class=\"col-md-8 col-lg-8 col-sm-8\">\r\n" 
				+ "" + 
				"    		<span class=\" text-center\">\r\n" + 
				"      			<img src=\""+param.getValor()+"/images/iconos/validate.gif\" style=\"width:250px;\" class=\"img img-responsive text-center thumbnail\" alt=\"...\">\r\n" + 
				"      			<h4 style=\"color:#fff;\">Espacio Insuficiente</h4>\r\n" + 
				"      			<div class=\"ratings\">\r\n" + 
				"                   <hr>\r\n"
				+ "<p style=\"color:#fff;\">El usuario "+nombreUser+" no tiene espacio suficiente para completar esta acción</p>" + 
				
				"                </div>\r\n" + 
				  ""
				  + ""
				  + ""+ 
				"\r\n" + 
				"      			<hr class=\"line\">\r\n" + 
				
				"    		</span>\r\n" + 
				"  		</div>"
				+ "\r\n"
				+ ""
				+ ""
				+ ""
				+ ""
				+"            </div>"
				+ "\r\n"+ "<div class=\"col-md-2 col-lg-2 col-sm-2\"></div>\r\n" 
				+ "\r\n</div>";
				
		return confirm;
	}

	@RequestMapping(value = { "/compartir-con-usuario-action-confirm" })
	public void compartirConUsuarioActionConfirm(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("user"));
		Long file =Long.parseLong(request.getParameter("file"));
		//Long iddir =Long.parseLong(request.getParameter("iddir"));
		
		
		MstUsuario user =(MstUsuario)dao.readById(id, MstUsuario.class);
		MstArchivo efile =(MstArchivo)dao.readById(file, MstArchivo.class);
		efile.setCompartido(true);
		dao.updateEntity(efile);
		
		boolean compartir=validarSiElArchivoYaEstaCompartido(response, request,user, efile);
		if(!compartir) {
		efile.setId(null);
		efile.setUsuario(user);
		efile=validarEstatus(efile);
		efile.setCompartido(true);
		efile.setDirectorio(new MstDirectorio(1L));
		
		dao.createEntity(efile);
		}
		
		
		
		
		logger.info(user);
		logger.info(efile);
		
		
		
		
		String confirmacion= generarFormularioDeConfirmado(id,request.getParameter("file"),request,response);
		responseAjax(response, confirmacion);
	}
	

	

	@RequestMapping(value = { "/compartir-con-departamento" })
	public void compartirConDepartamento(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		String file =request.getParameter("id");
		String confirmacion= generarFormularioDeConfirmacionGeneric(1L,file,"compartirDepartamento",request,response);
		String status="<div class=\"col-lg-12\"><p style=\"color:#fff;\">Status</p><div class=\"col-lg-12 alert alert-info\" id=\"msg-compartir\"></div></div>";
		responseAjax(response, confirmacion+status);
	}
	
	@RequestMapping(value = { "/compartir-con-departamento-confirm" })
	public void compartirConDepartamentoConfirm(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		
		Long file =Long.parseLong(request.getParameter("file"));
		
		MstUsuario user =(MstUsuario)openSession(response, request).getAttribute("user");
		MstArchivo efile =(MstArchivo)dao.readById(file, MstArchivo.class);
		
		efile.setCompartido(true);
		dao.updateEntity(efile);
		
		List<MstUsuario> lista = (List<MstUsuario>)dao.findAllWhere(new MstUsuario(),"defdepartamentos", user.getDefdepartamentos());
		logger.info(lista);
		
		
		for(MstUsuario ux:lista) {
		
			//Creamos el registro en cada usuario del departamento menos en el que comparte el archivo
			boolean compartir=validarSiElArchivoYaEstaCompartido(response, request, ux, efile);
			
		if(!compartir) {	
			if(!user.getId().equals(ux.getId())) {	
				efile.setId(null);
				efile.setUsuario(ux);
				efile.setCompartido(true);
				efile=validarEstatus(efile);
				efile.setDirectorio(new MstDirectorio(1L));
				dao.createEntity(efile);
			  }
			}
		}
		String confirmacion= generarFormularioDeConfirmado(1L,request.getParameter("file"),request,response);
		responseAjax(response, confirmacion);
	}
	
	@RequestMapping(value = { "/hacer-publico" })
	public void hacerPublico(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		String file =request.getParameter("id");
		String confirmacion= generarFormularioDeConfirmacionGeneric(1L,file,"hacerPublicoAction",request,response);
		String status="<div class=\"col-lg-12\"><p style=\"color:#fff;\">Status</p><div class=\"col-lg-12 alert alert-info\" id=\"msg-compartir\"></div></div>";
		responseAjax(response, confirmacion+status);
	}
	
	@RequestMapping(value = { "/hacer-publico-action" })
	public void hacerPublicoAction(HttpServletResponse response, HttpServletRequest request) throws IOException {
       Long file =Long.parseLong(request.getParameter("file"));
		
		MstUsuario user =(MstUsuario)openSession(response, request).getAttribute("user");
		MstArchivo efile =(MstArchivo)dao.readById(file, MstArchivo.class);
		efile.setCompartido(true);
		efile.setPublico(true);
		dao.updateEntity(efile);
		
		List<MstUsuario> lista = (List<MstUsuario>)dao.findAllWhere(new MstUsuario(),"mstcentro", user.getMstcentro());
		logger.info(lista);
		
		
		for(MstUsuario ux:lista) {
			boolean compartir=validarSiElArchivoYaEstaCompartido(response, request, ux, efile);
			//Creamos el registro en cada usuario del departamento menos en el que comparte el archivo
			
			
			if(!compartir) {
			if(!user.getId().equals(ux.getId())) {	
				efile.setId(null);
				efile.setUsuario(ux);
				efile.setCompartido(true);
				efile.setPublico(true);
				efile=validarEstatus(efile);
				efile.setDirectorio(new MstDirectorio(1L));
				dao.createEntity(efile);
			  }
			}
		}
		String confirmacion= generarFormularioDeConfirmado(1L,request.getParameter("file"),request,response);
		responseAjax(response, confirmacion);
	}
	
	private MstArchivo validarEstatus(MstArchivo efile) {
		if(efile.getStatus().equalsIgnoreCase("ROOT")) {
			efile.setStatus("Compartido conmigo");
		}else if(efile.getStatus().equalsIgnoreCase("Compartido conmigo")){
			efile.setStatus("Distribuido");
		}
		return efile;
	}

	
	
	@RequestMapping(value = { "/dejar-de-compartir" })
	public void dejarDeCompartir(HttpServletResponse response, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		
		//Recuperamos el usuario de la sesion para saber quien dejara de compartir
		MstUsuario user = (MstUsuario)openSession(response, request).getAttribute("user");
		MstArchivo root = (MstArchivo) dao.readById(id, MstArchivo.class);
		List<MstArchivo> lista = (List<MstArchivo>)dao.findAllWhere(new MstArchivo(), "hashCode",root.getHashCode());
		for(MstArchivo ar:lista) {
			
			if(ar.getStatus().equalsIgnoreCase("ROOT")) {
				ar.setCompartido(false);
				ar.setPublico(false);
				dao.updateEntity(ar);
				refrescarUsuarioEnSesion(request, response);
			}else {
			    dao.deleteEntity(ar);
			}
		}
		responseAjax(response, "Eliminado");
	}
	
	public String codificacionSHA1(String path) {

		return org.apache.commons.codec.digest.DigestUtils.shaHex(path);
	}
	
	@RequestMapping(value = { "/codificar-archivo" })
	public void codificarArchivo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		//Recogemos el id del archivo a codificar
		Long id = Long.parseLong(request.getParameter("id"));
		MstArchivo archivoEntity =(MstArchivo)dao.readById(id, MstArchivo.class);
		
		//localizamos el archivo en disco antes de codificarlo
		File fichero_old = new File(archivoEntity.getFilePath());
		
		//ciframos el nombre del archivo
		String strSHA = codificacionSHA1(fichero_old.getName());
		
		//Renombramos
		File nuevoArchivoSHA = new File(fichero_old.getParent() + File.separator + strSHA);
		fichero_old.renameTo(nuevoArchivoSHA);
		
		//Actualizamos los datos del fichero en base de datos
		archivoEntity.setFilePath(nuevoArchivoSHA.getAbsolutePath());
		
		//Obtenemos la url que apunta al archivo
		MstApplicationParams urlbase = getParameter("url-base", request, response);
		String urlpathbase = urlbase.getValor() + "/" + getUserSession(response, request).getMstcentro().getId() + "/"
				+ getUserSession(response, request).getId() + "/";
		archivoEntity.setUrlPath(urlpathbase + nuevoArchivoSHA.getName());
		archivoEntity.setCodificado(Boolean.TRUE);
		//Actualizamos
		dao.updateEntity(archivoEntity);
		
		responseAjax(response, "Eliminado");
	}
	
	@RequestMapping(value = { "/descodificar-archivo" })
	public void desCodificarArchivo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		//Recogemos el id del archivo a codificar
				Long id = Long.parseLong(request.getParameter("id"));
				MstArchivo archivoEntity =(MstArchivo)dao.readById(id, MstArchivo.class);
				
				//localizamos el archivo en disco antes de codificarlo
				File fichero_old = new File(archivoEntity.getFilePath());
				
				
				//Renombramos
				File nuevoArchivoSHA = new File(fichero_old.getParent() + File.separator + archivoEntity.getFileName());
				fichero_old.renameTo(nuevoArchivoSHA);
				
				//Actualizamos los datos del fichero en base de datos
				archivoEntity.setFilePath(nuevoArchivoSHA.getAbsolutePath());
				
				//Obtenemos la url que apunta al archivo
				MstApplicationParams urlbase = getParameter("url-base", request, response);
				String urlpathbase = urlbase.getValor() + "/" + getUserSession(response, request).getMstcentro().getId() + "/"
						+ getUserSession(response, request).getId() + "/";
				archivoEntity.setUrlPath(urlpathbase + nuevoArchivoSHA.getName());
				archivoEntity.setCodificado(Boolean.FALSE);
				//Actualizamos
				dao.updateEntity(archivoEntity);
				
				responseAjax(response, "Eliminado");
		
		responseAjax(response, "Eliminado");
	}
	
	
	public boolean validarSiElArchivoYaEstaCompartido(HttpServletResponse response, HttpServletRequest request,MstUsuario user,MstArchivo filex) {
		
		boolean existe=false;
		for(MstArchivo file: user.getArchivos()) {
			if(file.getHashCode().equals(filex.getHashCode())) {
				existe=true;
			}
		}
		
		return existe;
		
	}
	
	
}
 	
 	
 	

