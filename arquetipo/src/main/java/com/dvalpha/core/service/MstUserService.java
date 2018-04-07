package com.dvalpha.core.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

import com.dvalpha.core.controller.CoreController;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstUsuario;

@Service
public class MstUserService extends CoreController{

	
	
	public void adduser(MstUsuario user, HttpServletRequest request, HttpServletResponse response) {
		MstApplicationParams param =getParameter("files", request, response);
		String url =param.getValor()+File.separator+user.getMstcentro().getId()+File.separator+user.getId();
		File dir =new File(url);{
			dir.mkdirs();
		}	
	}
	
	public void eliminarArchivos(MstUsuario user, HttpServletRequest request, HttpServletResponse response) {
		MstApplicationParams param =getParameter("files", request, response);
		String url =param.getValor()+File.separator+user.getMstcentro().getId()+File.separator+user.getId();
		File f = new File(url);
		borrarDirectorio(f);
		if(f.exists()) {
			f.delete();
		}
	}

	public void comprimirArchivos(MstUsuario user, HttpServletRequest request, HttpServletResponse response) {
		MstApplicationParams param =getParameter("files", request, response);
		String url =param.getValor()+File.separator+user.getMstcentro().getId()+File.separator+user.getId();
		ZipUtil.pack(new File(url), new File(url+".zip"));
	}
	
	
	public void borrarDirectorio (File directorio){ 
		 File[] ficheros = directorio.listFiles();
		 
		 for (int x=0;x<ficheros.length;x++){
			 if (ficheros[x].isDirectory()) {
			  borrarDirectorio(ficheros[x]);
		 }
		 ficheros[x].delete();
		 }
		 
	}
	
}
