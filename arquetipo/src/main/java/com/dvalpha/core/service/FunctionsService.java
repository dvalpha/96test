package com.dvalpha.core.service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvalpha.core.controller.CoreController;
import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstArchivo;
import com.dvalpha.core.entity.MstDirectorio;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.utils.TransformBytesToTB;

@Service
public class FunctionsService extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.service.FunctionsService.class);
	@Autowired
	IGenericDAO dao;
	
	//devuelve true si  hay espacio suficiente
	public boolean validarSiHayEspacioDisponible(MstUsuario user,Long archivoSubido, HttpServletRequest request, HttpServletResponse response) {
	       
		boolean b = false;
		for(MstArchivo archivo:user.getArchivos()) {
			archivoSubido+=archivo.getTamano();
			
		}
		TransformBytesToTB transform = new TransformBytesToTB(archivoSubido);
		double espacio_ocupadoMB=transform.getMB();
		int espacio_total=user.getMststorage().getMaxMB();
		
		double total=(espacio_ocupadoMB*100)/espacio_total;
		if(total<100) {
			b=true;
		}
		return b;
	}
	public void subirArchivo(HttpServletRequest request, HttpServletResponse response, HttpSession ses, MstUsuario user,String path) {
		MstApplicationParams urlbase = getParameter("url-base", request, response);
		String urlpathbase = urlbase.getValor() + "/" + user.getMstcentro().getId() + "/"
				+ user.getId() + "/";
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			java.util.List items = upload.parseRequest(request);
			for (Object item : items) {	
				FileItem uploaded = (FileItem) item;
				
				//Se crea el archivo en memoria
				File fichero = new File(path, uploaded.getName());
				uploaded.write(fichero);
				
				boolean espacio =validarSiHayEspacioDisponible(user, fichero.length(), request, response);
				
				if(!espacio) {
					
					responseAjax(response, "101");
				}else {
				
					//Obtenemos la extension
					String extension = FilenameUtils.getExtension(fichero.getAbsolutePath());
					//Validamos si hay que codificar el archivo al subirlo
					boolean codificar = user.getMstcentro().getCodificar_archivos();
					//Instanciamos un MstArchivo para introducir la informacion en BBDD
					MstArchivo archivo = new MstArchivo();
				if (codificar) {
					//Codificamos su nombre renombrandolo
					String strSHA = codificacionSHA1(fichero.getName());
					File nuevoArchivoSHA = new File(fichero.getParent() + File.separator + strSHA);
					fichero.renameTo(nuevoArchivoSHA);
					//Actualizamos el path que apunta a ese archivo en disco (no es la url) (path llega a este método con la ruta al directorio pero sin el nombre del archivo)
					path += File.separator + nuevoArchivoSHA.getName();
					archivo.setFilePath(path);
					//Actualizamos la URL que apunta a ese archivo
					archivo.setUrlPath(urlpathbase + nuevoArchivoSHA.getName());
					archivo.setFileNameEncode(nuevoArchivoSHA.getName());
					archivo.setCodificado(true);
					
				} else {
					//Escribimos el archivo en disco
					
					//Creamos el path completo incluyendo el nombre del archivo
					path += File.separator + fichero.getName();
					archivo.setFilePath(path);
					
					//Actualizamos la URL que apunta a ese archivo
					archivo.setUrlPath(urlpathbase + fichero.getName());
					archivo.setFileNameEncode(fichero.getName());
					archivo.setCodificado(false);
				}
				
				    //Completamos el resto de campos
				    
					archivo.setPublico(false);
					archivo.setActivo(true);
					archivo.setBorrado(false);
					archivo.setCompartido(false);
					archivo.setExtension(extension);
					archivo.setFileName(fichero.getName());
					archivo.setTamano(fichero.length());
					archivo.setUsuario(user);
					archivo.setHashCode(fichero.hashCode()+"");
					archivo.setStatus("ROOT");
					archivo.setEtiqueta(fichero.getName());
					
					
					
					List<MstDirectorio> dirs =(List<MstDirectorio>)dao.findAllWhere(new MstDirectorio(), "root", true);
					MstDirectorio dir = dirs.get(0);
					dir.setUsuario(user);
					archivo.setDirectorio(dir);
					
					//buscamos el archivo por hash y por ROOT
					borrarSiExisteEnBBDD(archivo);
					dao.createEntity(archivo);
					
					
					
					
				}
			}
		} catch (FileUploadException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Si el archivo ya se subio y se vuelve a subir se actualiza automaticamente en el disco duro pero tambien
	// debemos actuaizarlo en base de datos ya que si no lo hacemos nos mostrara dos archivos iguales subidos
	// pero realmente solo tendremos uno, por lo tanto antes de registrar el archivo que subimos en bbdd debemos buscar si ya existe y borrarlo
	//para no duplicarlo al subirlo de nuevo.
	
	// Cuando el archivo se sube, el archivo fisico se actualiza inmediatamente.
	private void borrarSiExisteEnBBDD(MstArchivo archivo) {
		List<MstArchivo> file =(List<MstArchivo>) dao.findAllWhereAnd(new MstArchivo(), "hashCode", archivo.getHashCode(), "status", "ROOT");
		if(file.size()>0) {
		dao.deleteEntity(file.get(0));
		}
		
		
	}

	public String codificacionSHA1(String path) {

		return org.apache.commons.codec.digest.DigestUtils.shaHex(path);
	}

	
	
	
	public void reordenar(HttpServletRequest request, HttpServletResponse response) {
		try {
			String clase = request.getParameter("clase");
			String orden = request.getParameter("orden");
			String fmt1 = orden.substring(0, orden.length() - 1);// quitamos ultima coma
			
			String fmt2[] = fmt1.split(",");

			Object entity = Class.forName(clase).newInstance();
			Map<String, String> valores = new HashMap();
			for (int i = 0; i < fmt2.length; i += 2) {
				valores.put(fmt2[i], fmt2[i + 1]);
				dao.updateWhere(entity, "orden", Integer.parseInt(fmt2[i + 1]), "id", Long.parseLong(fmt2[i]));
			}

			logger.info(valores);
			responseAjax(response, "Items Reordenados");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
