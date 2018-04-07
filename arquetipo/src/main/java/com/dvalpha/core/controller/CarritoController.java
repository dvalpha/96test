package com.dvalpha.core.controller;

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

import com.dvalpha.core.beans.MstCarritoBean;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstCliente;
import com.dvalpha.core.entity.MstPedido;
import com.dvalpha.core.entity.MstProducto;

@Controller
public class CarritoController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.controller.CarritoController.class);
	 	@Autowired IGenericDAO dao;

	List<MstCarritoBean> lista= new ArrayList();
	
	
	@RequestMapping(value={"/get-cart-items"})
	public void getItems(HttpServletResponse response,HttpServletRequest request) throws IOException{

    HttpSession ses =(HttpSession)request.getSession();
	
	String tabla="<table class=\"table table-condensed \">"
			+ "<td>Producto</td><td>Cantidad</td>";
			for(MstCarritoBean cart:lista) {
				tabla+="<tr>";
				tabla+="<td>"+cart.getProducto().getNombre()+"</td>";
				tabla+="<td>"+cart.getCantidad()+"</td>";
				tabla+="<td><button onclick=\"borrarDelCarrito('"+cart.getProducto().getId()+"');\" class=\"btn btn-danger btn-xs\">x</button></td>";
				tabla+="</tr>";
			}
			tabla+="</table>";
	ses.setAttribute("cart", lista);
	responseAjax(response, tabla);
	}


	@RequestMapping(value={"/add-to-cart"})
	public void agregarItem(HttpServletResponse response,HttpServletRequest request) throws IOException{

    HttpSession ses =(HttpSession)request.getSession();
	Long id0=Long.parseLong(request.getParameter("id"));
	Long cantidad=Long.parseLong(request.getParameter("cantidad"));
	MstProducto prod =(MstProducto) dao.readById(id0, MstProducto.class);
	MstCarritoBean bean = new MstCarritoBean();
	bean.setProducto(prod);
	bean.setCantidad(cantidad);
	lista.add(bean);
	String tabla="<table class=\"table table-condensed \">"
			+ "<td>Producto</td><td>Cantidad</td>";
			for(MstCarritoBean cart:lista) {
				tabla+="<tr>";
				tabla+="<td>"+cart.getProducto().getNombre()+"</td>";
				tabla+="<td>"+cart.getCantidad()+"</td>";
				tabla+="<td><button onclick=\"borrarDelCarrito('"+cart.getProducto().getId()+"');\" class=\"btn btn-danger btn-xs\">x</button></td>";
				tabla+="</tr>";
			}
			tabla+="</table>";
	ses.setAttribute("cart", lista);
	responseAjax(response, tabla);
	}
	
	
	@RequestMapping(value={"/delete-to-cart"})
	public void eliminarItem(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
    HttpSession ses =(HttpSession)request.getSession();
	Long id0=Long.parseLong(request.getParameter("id"));
	
	MstProducto prod =(MstProducto) dao.readById(id0, MstProducto.class);
	
	
	List<MstCarritoBean> nuevalista= new ArrayList();
	for(MstCarritoBean item:lista) {
		if(item.getProducto().getId().equals(prod.getId())) {
			
			System.out.println("Mismo");
		}else {
			nuevalista.add(item);
		}
	
	}
	
	lista=nuevalista;
	
	String tabla="<table class=\"table table-condensed \">"
			+ "<td>Producto</td><td>Cantidad</td>";
			for(MstCarritoBean cart:lista) {
				tabla+="<tr>";
				tabla+="<td>"+cart.getProducto().getNombre()+"</td>";
				tabla+="<td>"+cart.getCantidad()+"</td>";
				tabla+="<td><button onclick=\"borrarDelCarrito('"+cart.getProducto().getId()+"');\" class=\"btn btn-danger btn-xs\">x</button></td>";
				tabla+="</tr>";
			}
			tabla+="</table>";
	ses.setAttribute("cart", lista);
	responseAjax(response, tabla);
	}


}
