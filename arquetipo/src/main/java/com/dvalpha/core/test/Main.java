package com.dvalpha.core.test;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.dvalpha.core.utils.PasswordGenerator;

public class Main {

	public static void main(String[] args) {
	
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy-MM-dd");
		ConvertUtils.register(converter, Date.class);
		
		
		//-422016635
	}
	
	public static void borrarDirectorio (File directorio){ 
		 File[] ficheros = directorio.listFiles();
		 
		 for (int x=0;x<ficheros.length;x++){
			 if (ficheros[x].isDirectory()) {
			  borrarDirectorio(ficheros[x]);
		 }
		 ficheros[x].delete();
		 }
		 
	}
}
