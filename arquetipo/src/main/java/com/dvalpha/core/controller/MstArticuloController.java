package com.dvalpha.core.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstArticulo;
import com.dvalpha.core.entity.MstClient;
import com.dvalpha.core.entity.MstComponente;
import com.dvalpha.core.entity.MstUsuario;
@Controller
public class MstArticuloController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstArticulo.class);
	@Autowired IGenericDAO dao;
	
	@RequestMapping(value = { "/main-menu-articulo" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {
	return new ModelAndView("/la vista main menu");
	}
	
	@RequestMapping(value={"/menu-addArticulo"})
	public ModelAndView menuAddArticulo(HttpServletResponse response,HttpServletRequest request) throws IOException{
	request.setAttribute("idcliente",request.getParameter("id"));
	MstClient cliente = (MstClient)dao.readById(Long.parseLong(request.getParameter("id")),MstClient.class);	
	request.setAttribute("cliente",cliente);
	
	return new ModelAndView("articulo-add");		
	}
	//metodo add (ajax response)
	@RequestMapping(value={"/addArticulo"})
	public void addArticulo(HttpServletResponse response,HttpServletRequest request) throws IOException{
	
   MstArticulo bean=(MstArticulo)populateBean(request, new MstArticulo());
	  //Obtenemos el articulo con el codigo de articulo mas alto
	String sql="select * from mst_articulo order by codigo desc limit 0,1";
	List<MstArticulo> lista = (List<MstArticulo>)dao.find_By_SQL_Generic(sql, MstArticulo.class);
	
	//Le sumamos 1 para hacer el codigo auto incrementable
	int max_codigoArticulo=lista.get(0).getCodigo()+1;
	bean.setCodigo(max_codigoArticulo);
	
	//Seteamos el cliente al que pertenece el articulo
	MstClient cliente = (MstClient)dao.readById(Long.parseLong(request.getParameter("idcliente")),MstClient.class);
	bean.setCliente(cliente);
	bean.setCodigoCliente(cliente.getCodclient());
	bean.setOrden(0);
	//Creamos el articulo en base de datos
	dao.createEntity(bean);
	responseAjax(response, "Creado");
	}
	@RequestMapping(value = { "/list-articulo" })
	public ModelAndView listMstArticulo(HttpServletResponse response, HttpServletRequest request) throws IOException {
	Long idcliente=Long.parseLong(request.getParameter("id"));
	//List<MstArticulo> lista = (List<MstArticulo>)dao.findAllWhere(new MstArticulo(), "cliente", new MstClient(id));
	String sql = "select * from mst_articulo where cliente="+idcliente;
	List<MstArticulo> lista = (List<MstArticulo>)dao.find_By_SQL_Generic(sql, MstArticulo.class);
	
	request.setAttribute("list", lista);
	return new ModelAndView("articulo-list");
	}
	
	@RequestMapping(value = { "/menu-edit-articulo" })
	public ModelAndView menuEditMstArticulo(HttpServletResponse response, HttpServletRequest request) throws IOException {
	Long id=Long.parseLong(request.getParameter("id"));
	MstArticulo user = (MstArticulo)dao.readById(id, MstArticulo.class);
	request.setAttribute("object", user);
	return new ModelAndView("articulo-edit");
	}
	
	@RequestMapping(value = { "/update-articulo" })
	public void updateMstArticulo(HttpServletResponse response, HttpServletRequest request) throws IOException {
	
	
    MstArticulo bean=(MstArticulo)populateBean(request, new MstArticulo());
   
    bean.setCodigoCliente(request.getParameter("codigoCliente"));
    
    MstClient cliente = (MstClient)dao.readById(Long.parseLong(request.getParameter("mstcliente")),MstClient.class);
    
    System.out.println(cliente);
    
    bean.setCliente(cliente);
	dao.updateEntity(bean);
	responseAjax(response, "Actualizado");
	}


@RequestMapping(value = { "/delete-articulo" })
public void deleteMstArticulo(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
dao.deleteEntity(new MstArticulo(id));

responseAjax(response, "Eliminado");
}	}
 
