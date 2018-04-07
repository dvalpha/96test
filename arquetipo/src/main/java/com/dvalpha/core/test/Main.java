package com.dvalpha.core.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.dvalpha.core.utils.PasswordGenerator;

public class Main {

	public static void main(String[] args) {
	
		String a=PasswordGenerator.getPassword(12);
		System.out.println(a);
		
		
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
