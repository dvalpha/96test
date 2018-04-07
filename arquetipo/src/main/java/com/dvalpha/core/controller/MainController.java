package com.dvalpha.core.controller;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstArticulo;
import com.dvalpha.core.entity.MstClient;
import com.dvalpha.core.entity.MstComponente;
import com.dvalpha.core.entity.MstMateriales;
import com.dvalpha.core.entity.MstModelo;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.Testxx;


@Controller
public class MainController extends CoreController {
	private static final Logger logger = Logger.getLogger(MainController.class);
	@Autowired
	IGenericDAO dao;
	
	@RequestMapping(value = { "/home" })
	public ModelAndView home(HttpServletResponse response, HttpServletRequest request) throws IOException {
	return new ModelAndView("home");
	}
	
	@RequestMapping(value = { "/test-f" })
	public void test(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		
		List<MstComponente> lista1 = (List<MstComponente>)dao.findAll(new MstComponente());
		System.out.println("Listamos componentes "+lista1.size());
		List<MstComponente> lista2 =new ArrayList();
		List<MstMateriales> listaMateriales =new ArrayList();
		int cs=0;
		for(MstComponente m:lista1) {
			
			
			String sql="SELECT * from temp where componente_id="+m.getCodigo()+" group by material_id";
			List<Testxx> lista = (List<Testxx>)dao.find_By_SQL_Generic(sql, Testxx.class);
			
			System.out.println("La lista de test tiene "+lista.size());
			System.out.println("Obtenemos los materiales de cada uni de los codigos de la lista");
			listaMateriales =new ArrayList();
			for(Testxx t:lista) {
				System.out.println("El codigo del material que se ñadaira a las lista es "+t.getIdmaterial());
				String sql2="select * from mst_materiales where codigo='"+t.getIdmaterial()+"'";
				
				List<MstMateriales> co =(List<MstMateriales>)dao.find_By_SQL_Generic(sql2,MstMateriales.class);
				if(co.size()>0) {
				listaMateriales.add(co.get(0));
				System.out.println("Lista añadida "+listaMateriales.size());
				
				}
			}
			
			/*m.setMateriales(listaMateriales);
			System.out.println("La lista de materiales seteada al componente es de "+m.getMateriales().size());
			dao.updateEntity(m);
			//lista2.add(m);
			*/
			cs++;
			
			
		
			}
		
		/*int c=0;
		for(MstComponente componente:lista2) {
			System.out.println("Componente "+componente.getId()+" materiales "+componente.getMateriales().size());
			try {
			dao.updateEntity(componente);
			c++;
			}catch(org.springframework.dao.DataIntegrityViolationException e) {
				System.out.println("Error en el componente "+componente.getId()+" "+e.getMessage());
			}
			
			/*if(c>10) {
				break;
			}
		}
		
		*/
		
		
		
		/*List<MstArticulo> articulos = (List<MstArticulo>) dao.findAll(new MstArticulo());
		List<MstArticulo> articulos2 =new ArrayList();
		for(MstArticulo art:articulos) {
			
			List<MstClient> cli =(List<MstClient>) dao.findAllWhere(new MstClient(), "codCliente", art.getCodigoCliente());
			art.setCliente(cli.get(0));
			articulos2.add(art);
		}
		
		for(MstArticulo art:articulos2) {
			dao.updateEntity(art);
		}
		
		/*
		BufferedReader buff = new BufferedReader(new FileReader(new File ("C:\\Spumas\\articulos.txt")));
		BufferedReader buff2 = new BufferedReader(new FileReader(new File ("C:\\Spumas\\articulo-codigo.txt")));
		BufferedReader buff3 = new BufferedReader(new FileReader(new File ("C:\\Spumas\\articulo-modelo.txt")));
		List<MstArticulo>lista = new ArrayList();
		List<MstArticulo>lista2 = new ArrayList();
		List<MstArticulo>lista3 = new ArrayList();
		String linea="";
		String linea2="";
		String linea3="";
		MstArticulo comp=null;
		int count=0;
		while((linea=buff.readLine())!=null) {
			comp = new MstArticulo();
			comp.setNombre(linea);
			lista.add(comp);
		}
		
		while((linea2=buff2.readLine())!=null) {
			
			MstArticulo comp2 = lista.get(count);
			comp2.setCodigo(linea2);
			lista2.add(comp2);
			count++;
		}
		
		count=0;
       while((linea3=buff3.readLine())!=null) {
			
			MstArticulo comp3 = lista2.get(count);
			comp3.setModeloNombre(linea3);
			lista3.add(comp3);
			count++;
		}
		
		for(MstArticulo c:lista3) {
			dao.createEntity(c);
		}
		*/
		
	}
	@RequestMapping(value = { "/main-menu-usuario" })
	public ModelAndView mainUsers(HttpServletResponse response, HttpServletRequest request) throws IOException {
	
	
		
		
	/*MstArticulo arti1 = new MstArticulo();
	arti1.setNombre("articulo 2");
	dao.createEntity(arti1);
	
	//arti1= (MstArticulo) dao.readById(arti1.getId(), MstArticulo.class);
	
	MstComponente compo1 =  (MstComponente) dao.readById(8L, MstComponente.class);
	MstComponente compo2 =  (MstComponente) dao.readById(9L, MstComponente.class);
	Set<MstComponente> componentes = new HashSet<MstComponente>();
	componentes.add(compo1);
	componentes.add(compo2);
	arti1.setComponentes(componentes);
	
	dao.updateEntity(arti1);
	
	System.out.println("Los objetos creados son :"+arti1);
	
	
	/*MstArticulo art = (MstArticulo) dao.readById(1L, MstArticulo.class);
	MstComponente comp =  (MstComponente) dao.readById(1L, MstComponente.class);
	Set<MstComponente> componentes = new HashSet<MstComponente>();
	componentes.add(comp);
    art.setComponentes(componentes);
    Set<MstArticulo> articulos = new HashSet<MstArticulo>();
	articulos.add(art);
	comp.setArticulos(articulos);
	
     dao.updateEntity(art);
	
	dao.updateEntity(comp);
	*/
    return new ModelAndView("user-main");
	}
	
	
	@RequestMapping(value = { "/main-menu-rol" })
	public ModelAndView mainRoles(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("roles-main");
	}
	
	@RequestMapping(value = { "/main-menu-url" })
	public ModelAndView mainUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {
	return new ModelAndView("/url-main");
	}
	
	@RequestMapping(value = { "/main-menu-libro" })
	public ModelAndView mainLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("/libro-main");
	}
}
