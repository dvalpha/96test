package com.dvalpha.core.controller;


import java.io.IOException;
import java.text.DecimalFormat;
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
import com.dvalpha.core.entity.MstArticuloMstComponente;
import com.dvalpha.core.entity.MstClient;
import com.dvalpha.core.entity.MstComponente;
import com.dvalpha.core.entity.MstMateriales;
import com.dvalpha.core.entity.MstUsuario;
@Controller
public class MstComponenteController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstComponente.class);
	@Autowired IGenericDAO dao;

	@RequestMapping(value = { "/main-menu-componente" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("/la vista main menu");
	}
	
	@RequestMapping(value={"/menu-addComponente"})
	public ModelAndView menuAddComponente(HttpServletResponse response,HttpServletRequest request) throws IOException{
	return new ModelAndView("componente-add");	
    }

	//metodo add (ajax response)
    @RequestMapping(value={"/addComponente"})
	public void addComponente(HttpServletResponse response,HttpServletRequest request) throws IOException{
	MstComponente bean=(MstComponente)populateBean(request, new MstComponente());
	dao.createEntity(bean);
    responseAjax(response, "Creado");
}//metodo add (ajax response)
    
    
    @RequestMapping(value={"/agregar-componente-a-articulo"})
	public void agregarComponenteAArticulo(HttpServletResponse response,HttpServletRequest request) throws IOException{
   //Obtenemos el cliente
   String client=request.getParameter("cliente");
   String sql_get_cliente= "select * from mst_client where codclient="+client+";";
   List<MstClient> listaCliente = (List<MstClient>) dao.find_By_SQL_Generic(sql_get_cliente, MstClient.class);
   MstClient cliente=listaCliente.get(0);
   System.out.println(sql_get_cliente);
   
   //Obtenemos el componente
   String codComponente=request.getParameter("componenteCod");
   String sqlCompo="select * from mst_componente where codigo="+codComponente;
   List<MstComponente> listaCompo = (List<MstComponente>) dao.find_By_SQL_Generic(sqlCompo, MstComponente.class);
   MstComponente compo=listaCompo.get(0);
   
   //Obtenemos el articulo
   String articul=request.getParameter("codigoart");
   String sql_get_articulo= "select * from mst_articulo where codigo="+articul;
   System.out.println(sql_get_articulo);
  
   List<MstArticulo> listaArticulo = (List<MstArticulo>) dao.find_By_SQL_Generic(sql_get_articulo, MstArticulo.class);
   MstArticulo articulo=listaArticulo.get(0);
   
   String calidad = request.getParameter("materiales");
   String sqlMat="select * from mst_materiales where calidad='"+calidad+"';";
   
   //Obtenemos los materiales
   List< MstMateriales > listaMat = (List< MstMateriales >) dao.find_By_SQL_Generic(sqlMat,  MstMateriales.class);
   MstMateriales  material=listaMat.get(0);
   
   MstArticuloMstComponente art =(MstArticuloMstComponente) populateBean(request, new MstArticuloMstComponente());
   double precio =Double.valueOf(request.getParameter("precio").replace(",", "."));
   art.setAlto(Integer.parseInt(request.getParameter("alto")));
   art.setAncho(Integer.parseInt(request.getParameter("ancho")));
   art.setLargo(Integer.parseInt(request.getParameter("largo")));
   art.setCliente(cliente.getCodclient());
   art.setCodigo(articulo.getCodigo());
   
   art.setMaterial(material);
   art.setPrecio(precio);
   art.setComponente(compo);
   art.setDestino(request.getParameter("destino"));
   art.setDivision(Integer.parseInt(request.getParameter("division")));
   art.setDupbasico(request.getParameter("dupbasico"));
   art.setFingru(request.getParameter("fingru"));
   art.setGrupo(request.getParameter("grupo"));
   art.setIgual("");
   art.setObservac(request.getParameter("observaciones"));
   art.setPlantilla(request.getParameter("plantilla"));
   art.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
   
   dao.createEntity(art);
   
   //Devolvemos la lista a la vista con el item actualizado
   //Obtenemos los componentes de ese articulo
    	String sql ="select * from mst_articulo_mst_componente where cliente="+cliente.getCodclient()+" and codigo="+articulo.getCodigo();
    	
    	List<MstArticuloMstComponente> lista = (List<MstArticuloMstComponente>) dao.find_By_SQL_Generic(sql, MstArticuloMstComponente.class);
    	
    	//Ahora preparamos la lista que aparecera en la modal con los componentes para aregar uno nuevo a ese articulo
    	List<MstComponente> lista_componentes = (List<MstComponente>) dao.findAllSimple(new MstComponente());
    	System.out.println(lista_componentes);
    	
    	//Ahora preparamos la lista que aparecera en la modal con los componentes para aregar uno nuevo a ese articulo
    	List<MstMateriales> listaMateriales=(List<MstMateriales>) dao.findAllSimple(new MstMateriales());
    	
    	System.out.println(listaMateriales);
    	
    	request.setAttribute("articulo", articulo);
    	request.setAttribute("cliente", cliente);
    	request.setAttribute("list",lista);
    	request.setAttribute("componentes",lista_componentes);
    	request.setAttribute("materiales",listaMateriales);
    	
    	 responseAjax(response, "Nuevo componente agregado");
}
    
    
    @RequestMapping(value={"/actualizarComponenteDelArticulo"})
	public void actualizarComponenteDelArticulo(HttpServletResponse response,HttpServletRequest request) throws IOException{
	
   
    	MstArticuloMstComponente art =(MstArticuloMstComponente)dao.readById(Long.parseLong(request.getParameter("idcomponente")), MstArticuloMstComponente.class);
    	art.setAlto(Integer.parseInt(request.getParameter("alto")));
    	art.setLargo(Integer.parseInt(request.getParameter("largo")));
    	art.setAncho(Integer.parseInt(request.getParameter("ancho")));
    	art.setCantidad(Double.valueOf(request.getParameter("cantidad")));
    	art.setPlantilla(request.getParameter("plantilla"));
    	art.setObservac(request.getParameter("observaciones"));
    	Long mater=Long.parseLong(request.getParameter("mater"));
    	MstMateriales mat = (MstMateriales)dao.readById(mater, MstMateriales.class);
    	art.setMaterial(mat);
    	
    	//Una vez seteado el material calculamos el precio
    	double largo=Double.valueOf(request.getParameter("largo"));
    	double ancho=Double.valueOf(request.getParameter("ancho"));
    	double alto=Double.valueOf(request.getParameter("alto"));
    	double preciox =largo*ancho*alto*art.getMaterial().getPrecio();
    	
    	DecimalFormat df = new DecimalFormat("0.00");
    	Double precio = Double.valueOf(df.format(preciox).replace(",", "."));
    	
    	
    	
    	art.setFingru(request.getParameter("fingru"));
    	art.setDupbasico(request.getParameter("dupbasico"));
    	art.setGrupo(request.getParameter("grupo"));
    	art.setDestino(request.getParameter("destino"));
    	
    	
    	
    	art.setPrecio(precio);
    	
    	dao.updateEntity(art);
    	
    responseAjax(response, "Actualizado");
}
    
    
    
    
    
    @RequestMapping(value={"/calcularPrecioComponente"})
	public void calcularPrecioComponente(HttpServletResponse response,HttpServletRequest request) throws IOException{
	
    	double largo=Double.valueOf(request.getParameter("largo"));
    	String calidad=request.getParameter("materiales");
    	double ancho=Double.valueOf(request.getParameter("ancho"));
    	double alto=Double.valueOf(request.getParameter("alto"));
    	String sql = "SELECT * FROM mst_materiales WHERE calidad='"+calidad+"'";
    	List<MstMateriales> listaMateriales=(List<MstMateriales>) dao.find_By_SQL_Generic(sql, MstMateriales.class);
    	MstMateriales material=listaMateriales.get(0);
    	
    	double preciox =largo*ancho*alto*material.getPrecio();
    	DecimalFormat df = new DecimalFormat("0.00");
    	
    	
    	
    responseAjax(response, df.format(preciox));
}
    
    @RequestMapping(value = { "/list-componente" })
	public ModelAndView listMstComponente(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	
    	//obtenemos el articulo
    	Long id=Long.parseLong(request.getParameter("id"));
    	MstArticulo articulo = (MstArticulo)dao.readById(id, MstArticulo.class);
    	
    	//obtenemos el cliente
    	String sql_get_cliente= "select * from mst_client where codclient="+articulo.getCodigoCliente()+";";
    	List<MstClient> listaCliente = (List<MstClient>) dao.find_By_SQL_Generic(sql_get_cliente, MstClient.class);
    	MstClient cliente=listaCliente.get(0);
    	
    	//Obtenemos los componentes de ese articulo
    	String sql ="select * from mst_articulo_mst_componente where cliente="+articulo.getCodigoCliente()+" and codigo="+articulo.getCodigo();

    	
    	List<MstArticuloMstComponente> lista = (List<MstArticuloMstComponente>) dao.find_By_SQL_Generic(sql, MstArticuloMstComponente.class);
    	
    	
    	//Ahora preparamos la lista que aparecera en la modal con los componentes para aregar uno nuevo a ese articulo
    	List<MstComponente> lista_componentes = (List<MstComponente>) dao.findAllSimple(new MstComponente());
    	System.out.println(lista_componentes);
    	
    	//Ahora preparamos la lista que aparecera en la modal con los componentes para aregar uno nuevo a ese articulo
    	List<MstMateriales> listaMateriales=(List<MstMateriales>) dao.findAllSimple(new MstMateriales());
    	
    	System.out.println(listaMateriales);
    	
    	request.setAttribute("articulo", articulo);
    	request.setAttribute("cliente", cliente);
    	request.setAttribute("list",lista);
    	request.setAttribute("componentes",lista_componentes);
    	request.setAttribute("materiales",listaMateriales);
    	
    	return new ModelAndView("componente-list");

	}
    @RequestMapping(value = { "/actualizarEntidadMaterialDelArticulo" })
	public void actualizarEntidadMaterialDelArticulo(HttpServletResponse response, HttpServletRequest request) throws IOException {
	Long id_mst_mat=Long.parseLong(request.getParameter("idmsta"));
	Long id_comp=Long.parseLong(request.getParameter("idcomp"));
	
	MstArticuloMstComponente art =(MstArticuloMstComponente)dao.readById(id_comp, MstArticuloMstComponente.class);
	MstMateriales mat =(MstMateriales)dao.readById(id_mst_mat, MstMateriales.class);
	
	art.setMaterial(mat);
	
	double preciox =art.getLargo()*art.getAncho()*art.getAlto()*art.getMaterial().getPrecio();
	DecimalFormat df = new DecimalFormat("0.00");
	Double precio = Double.valueOf(df.format(preciox).replace(",", "."));
	art.setPrecio(precio);
	
	dao.updateEntity(art);
	
	
	 responseAjax(response, "Actualizado");

	}
    @RequestMapping(value = { "/actualizarEntidadComponenteDelArticulo" })
	public void actualizarEntidadComponenteDelArticulo(HttpServletResponse response, HttpServletRequest request) throws IOException {
	Long id_mst_mst=Long.parseLong(request.getParameter("idmsta"));
	Long id_comp=Long.parseLong(request.getParameter("idcomp"));
	
	MstArticuloMstComponente art =(MstArticuloMstComponente)dao.readById(id_mst_mst, MstArticuloMstComponente.class);
	MstComponente comp =(MstComponente)dao.readById(id_comp, MstComponente.class);
	
	art.setComponente(comp);
	
	dao.updateEntity(art);
	
	 responseAjax(response, "Actualizado");

	}
@RequestMapping(value = { "/menu-edit-componente" })
	public ModelAndView menuEditMstComponente(HttpServletResponse response, HttpServletRequest request) throws IOException {
	Long id=Long.parseLong(request.getParameter("id"));
	MstComponente user = (MstComponente)dao.readById(id, MstComponente.class);
	request.setAttribute("object", user);
	return new ModelAndView("componente-edit");

	}

@RequestMapping(value = { "/update-componente" })
	public void updateMstComponente(HttpServletResponse response, HttpServletRequest request) throws IOException {
	MstComponente bean=(MstComponente)populateBean(request, new MstComponente());
	dao.updateEntity(bean);
    responseAjax(response, "Actualizado");
}
	

@RequestMapping(value = { "/delete-componente" })
	public void deleteMstComponente(HttpServletResponse response, HttpServletRequest request) throws IOException {
	Long id=Long.parseLong(request.getParameter("id"));
	dao.deleteEntity(new MstArticuloMstComponente(id));
	responseAjax(response, "Eliminado");
	}	
}