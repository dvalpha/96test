package com.dvalpha.core.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.beans.MstCarritoBean;
import com.dvalpha.core.beans.MstPedidoGroup;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstCliente;
import com.dvalpha.core.entity.MstPedido;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.utils.PasswordGenerator;
@Controller
public class MstPedidoController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstPedido.class);
 	@Autowired IGenericDAO dao;



	@RequestMapping(value = { "/main-menu-pedido" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("/la vista main menu");
    }
	@RequestMapping(value={"/menu-addPedido"})
	public ModelAndView menuAddPedido(HttpServletResponse response,HttpServletRequest request) throws IOException{		  	
	System.out.println("Llega al controlador");
	//obtenemos el id del formulario que nos indeca para que cliente es el pedido	
	Long id0=Long.parseLong(request.getParameter("id"));
	MstCliente cliente = (MstCliente)dao.readById(id0, MstCliente.class);
	request.setAttribute("cliente",cliente);
	
	
	return new ModelAndView("pedido-add");
		
}
//metodo add (ajax response)
@RequestMapping(value={"/addPedido"})
	public  void addPedido(HttpServletResponse response,HttpServletRequest request) throws IOException{
	//Obtenemos la lista de items de ese pedido 
	HttpSession ses = request.getSession();
	List<MstCarritoBean> cart=(List<MstCarritoBean>) ses.getAttribute("cart");
	//Creamos la referencia a ese pedido y la seteamos
	String ref="PED-"+PasswordGenerator.getPassword(4);	
	//Obtenemos la id del cliente de la request y la seteamos al pedido
	Long id0=Long.parseLong(request.getParameter("cliente-id"));
	Date creacion = new Date();
	
	Double importe=0.0;
	Double total=0.0;
	for(MstCarritoBean productos:cart) {
		total+=productos.getProducto().getPrecio()*productos.getCantidad();
	}
	
	for(MstCarritoBean productos:cart) {
	//Creamos una instancia del pedido
	MstPedido pedido=new MstPedido();
	pedido.setCliente(new MstCliente(id0));
	pedido.setRef(ref);
	pedido.setCreacion(creacion);
	//Creamos un pedido para cada producto pero con la misma referencia de pedido y diferente id
	
	pedido.setProducto(productos.getProducto().getId());
	pedido.setCantidad(productos.getCantidad());
	pedido.setItems(cart.size());
	//Calculamos el importe
	importe+=productos.getProducto().getPrecio()*productos.getCantidad();
	pedido.setImporte(importe);
	pedido.setTotalPedido(total);
	dao.createEntity(pedido);
	}
	
	//listamos los pedidos para ir a la vista con la lista de pedidos y visualizar el pedido creado
	String sql="SELECT * FROM mst_pedido GROUP BY ref";
	List <MstPedido>listap=(List<MstPedido>) dao.find_By_SQL_Generic(sql,MstPedido.class);

	request.setAttribute("listap", listap);
	 responseAjax(response, "Pedido Realizado");
}

@RequestMapping(value={"/list-pedido"})
public  ModelAndView listPedido(HttpServletResponse response,HttpServletRequest request) throws IOException{

//listamos los pedidos para ir a la vista con la lista de pedidos y visualizar el pedido creado
String sql="SELECT * FROM mst_pedido GROUP BY ref";
List <MstPedido>listap=(List<MstPedido>) dao.find_By_SQL_Generic(sql,MstPedido.class);

request.setAttribute("listap", listap);
return new ModelAndView("pedido-list");
}




 }
 