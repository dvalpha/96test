package com.dvalpha.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clases de utilidad para copiar el contenido de los archivos y una estructura 
 * de archivos y directorios
 * @author Alex
 */
public class FileCopyUtils {
     
    /**
     * Metodo que copia el contenido de un archivo en otro archivo
     * @param origen
     * @param destino 
     */
     public void copiarContenido(File origen,File destino){
        try {
            FileWriter fw = new FileWriter(destino);
            BufferedReader buff = new BufferedReader(new FileReader(origen));
            String linea = "";
            while((linea=buff.readLine())!=null){
            fw.append(linea+"\r\n");
              }
            
            fw.flush();
            
            buff.close();
            fw.close();  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileCopyUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileCopyUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
      * Metodo que copia archivos y carpetas en otro lugar
      * @param origen
      * @param destino
      * @throws IOException 
      */
    public void copiarArchivosYCarpetas(File origen , File destino)
    throws IOException {

        if (origen.isDirectory()) {
            if (!destino.exists()) {
                 //Asignamos permisos de lectura sobre el directorio
                 destino.setReadable(true);
                 destino.mkdir();
            }
            String[] children = origen.list();
            for (int i=0; i<children.length; i++) {
                copiarArchivosYCarpetas(new File(origen, children[i]),
                        new File(destino, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
            // Se realiza la copia del archivo
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
}
