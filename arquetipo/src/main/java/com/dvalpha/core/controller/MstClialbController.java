package com.dvalpha.core.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.beans.AlbaranBean;
import com.dvalpha.core.dao.GenericDao;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstClialb;
import com.dvalpha.core.entity.MstCliente;
import com.dvalpha.core.entity.MstUsuario;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Controller
public class MstClialbController extends CoreController {
	 private static final Logger logger = Logger.getLogger(com.dvalpha.core.entity.MstClialb.class);
 	@Autowired IGenericDAO dao;



	@RequestMapping(value = { "/main-menu-clialb" })
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {

		return new ModelAndView("/la vista main menu");

	}
	@RequestMapping(value={"/menu-addAlbaran"})
		public ModelAndView menuAddClialb(HttpServletResponse response,HttpServletRequest request) throws IOException{			  	
	 	
		Integer in=(Integer)dao.find_By_SQL_Generic("select max(numalb)from mst_clialb").get(0);
		++in;
		request.setAttribute("numalb", in);
		return new ModelAndView("albaran-add");
		
}
	//metodo add (ajax response)
	@RequestMapping(value={"/addClialb"})
		public void addClialb(HttpServletResponse response,HttpServletRequest request) throws IOException{
		MstClialb bean=(MstClialb)populateBean(request, new MstClialb());
		dao.createEntity(bean);
	    responseAjax(response, "Creado");
	}
	
	
	@RequestMapping(value = { "/list-albaran" })
	public ModelAndView listMstClialb(HttpServletResponse response, HttpServletRequest request) throws IOException {
	String sql="select codclient,count(*) as albaranes, nomcli  from mst_clialb group by codclient order by albaranes desc ";	
    //String sql="select count(*) as albaranes,seralb from mst_clialb group by codclient order by albaranes desc limit 1";	
		
	List<Object[]> lista = (List<Object[]>) dao.find_By_SQL_Generic(sql);
	AlbaranBean bean;
	List<AlbaranBean>listaBean = new ArrayList();
	int id=1;
	for (Object[] elementos : lista)
	{ 
		bean = new AlbaranBean();
		bean.setCodclient(String.valueOf(elementos[0]));
		bean.setAlbaranes(String.valueOf(elementos[1]));
		bean.setNomcli(String.valueOf(elementos[2]));
		bean.setId(id);
		
		listaBean.add(bean);
		id++;
	}
	
	request.setAttribute("list", listaBean);
	return new ModelAndView("albaran-list");

	}
	

	
	@RequestMapping(value = { "/list-albaranes-cliente" })
	public ModelAndView listMstClialbCliente(HttpServletResponse response, HttpServletRequest request) throws IOException {

	String codigocliente=request.getParameter("codigocliente");

	String sql1="select * from mst_clialb where codclient='"+codigocliente+"';";
	
	MstClialb albaranCliente = (MstClialb)dao.find_By_SQL_Generic(sql1, MstClialb.class).get(0);
	
	String sql ="select * from mst_clialb where codclient='"+albaranCliente.getCodclient()+"' order by fechaalb desc";
	
	List<MstClialb> lista = (List<MstClialb>)dao.find_By_SQL_Generic(sql, MstClialb.class);
	request.setAttribute("list", lista);
	return new ModelAndView("list-albaranes-cliente");

	}

@RequestMapping(value = { "/menu-edit-clialb" })
	public ModelAndView menuEditMstClialb(HttpServletResponse response, HttpServletRequest request) throws IOException {

		Long id=Long.parseLong(request.getParameter("id"));
		MstClialb user = (MstClialb)dao.readById(id, MstClialb.class);
		request.setAttribute("object", user);
		return new ModelAndView("albaran-edit");

	}

@RequestMapping(value = { "/update-clialb" })
	public void updateMstClialb(HttpServletResponse response, HttpServletRequest request) throws IOException {
    
	MstClialb bean=(MstClialb)populateBeanConFecha(request, new MstClialb(), "fechaalb",request.getParameter("fechaalb"),"yyyy-MM-dd");
	
	System.out.println("albaran  "+bean);
	
	
	dao.updateEntity(bean);

	responseAjax(response, "Actualizado");
}
	

@RequestMapping(value = { "/delete-clialb" })
	public void deleteMstClialb(HttpServletResponse response, HttpServletRequest request) throws IOException {

Long id=Long.parseLong(request.getParameter("id"));
	dao.deleteEntity(new MstClialb(id));
 
responseAjax(response, "Eliminado");
}	}
