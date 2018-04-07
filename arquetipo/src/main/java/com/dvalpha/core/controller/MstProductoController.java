package com.dvalpha.core.controller;


import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstCliente;
import com.dvalpha.core.entity.MstProducto;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.utils.PasswordGenerator;
import com.dvalpha.core.entity.MstProveedor;
@Controller
public class MstProductoController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstProducto.class);
	@Autowired IGenericDAO dao;



	@RequestMapping(value = { "/main-menu-producto" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("/la vista main menu");
	}
	
	@RequestMapping(value={"/menu-addProducto"})
	public ModelAndView menuAddProducto(HttpServletResponse response,HttpServletRequest request) throws IOException{
    //crearBaseDeDatos();			
			  	
	List<MstProveedor>lista0 = (List<MstProveedor>) dao.findAll(new MstProveedor());
	request.setAttribute("dependencia00",lista0);
	return new ModelAndView("producto-add");
		
}
private void crearBaseDeDatos() {
			
	try {
		FileReader fr = new FileReader(new File("C:\\Spumas\\articulos.txt"));
		BufferedReader buff = new BufferedReader(fr);
		
		String linea="",total="";
		int count=0;
		while((linea=buff.readLine())!=null) {
			
			MstProducto cli = new MstProducto();
			cli.setNombre(linea);
			
			cli.setPrecio(22.50);
			cli.setOrden(1);
			cli.setRef("PROD-"+count);
			Long l1 = ((long)(Math.random() *13) + 1);
			cli.setProveedor(new MstProveedor(l1));
			count++;
			
			cli.setCreacion(new Date());
			
			
			dao.createEntity(cli);
		}
		
		
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
			
		}
//metodo add (ajax response)
@RequestMapping(value={"/addProducto"})
	public void addProducto(HttpServletResponse response,HttpServletRequest request) throws IOException{
	MstProducto bean=(MstProducto)populateBean(request, new MstProducto());
	Long id0=Long.parseLong(request.getParameter("proveedor"));
	bean.setProveedor(new MstProveedor(id0));
	bean.setCreacion(new Date());
	dao.createEntity(bean);
responseAjax(response, "Creado");
}


/**
 * Método que lista los proveedores y el numero de productos que el proveedor tiene
 * @param response
 * @param request
 * @return
 * @throws IOException
 */
@RequestMapping(value = { "/list-producto-proveedor" })
public ModelAndView listMstProductoCliente(HttpServletResponse response, HttpServletRequest request) throws IOException {

List<MstProveedor> lista = (List<MstProveedor>)dao.findAll(new MstProveedor());
request.setAttribute("list", lista);
	return new ModelAndView("proveedor-producto-list");

}


@RequestMapping(value = { "/list-producto" })
public ModelAndView listMstProducto(HttpServletResponse response, HttpServletRequest request) throws IOException {
Long id=Long.parseLong(request.getParameter("id"));
List<MstProducto> lista = (List<MstProducto>)dao.findAllWhere(new MstProducto(), "proveedor",new MstProveedor(id));
request.setAttribute("list", lista);
	return new ModelAndView("producto-list");

}

@RequestMapping(value = { "/menu-edit-producto" })
public ModelAndView menuEditMstProducto(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
MstProducto user = (MstProducto)dao.readById(id, MstProducto.class);
List<MstProveedor>lista0 = (List<MstProveedor>) dao.findAll(new MstProveedor());
request.setAttribute("dependencia00",lista0);
request.setAttribute("object", user);
return new ModelAndView("producto-edit");

}

@RequestMapping(value = { "/update-producto" })
public void updateMstProducto(HttpServletResponse response, HttpServletRequest request) throws IOException {

MstProducto bean=(MstProducto)populateBean(request, new MstProducto());
Long id0=Long.parseLong(request.getParameter("proveedor"));
bean.setProveedor(new MstProveedor(id0));
dao.updateEntity(bean);
responseAjax(response, "Actualizado");
}


@RequestMapping(value = { "/delete-producto" })
public void deleteMstProducto(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
dao.deleteEntity(new MstProducto(id));

responseAjax(response, "Eliminado");
}	}
