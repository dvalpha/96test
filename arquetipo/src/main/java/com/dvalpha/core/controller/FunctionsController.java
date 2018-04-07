package com.dvalpha.core.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstApplicationParams;
import com.dvalpha.core.entity.MstArchivo;
import com.dvalpha.core.entity.MstCategoriaLibro;
import com.dvalpha.core.entity.MstDocumento;
import com.dvalpha.core.entity.MstLibro;
import com.dvalpha.core.entity.MstUsuario;
import com.dvalpha.core.service.FunctionsService;
import com.lowagie.text.Anchor;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;

import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.codec.Base64;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

@Controller
public class FunctionsController extends CoreController {
	private static final Logger logger = Logger.getLogger(com.dvalpha.core.controller.FunctionsController.class);
	@Autowired
	IGenericDAO dao;
	@Autowired
	FunctionsService service;
	
	 private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
	    private static final Font fecha_creacion = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL);
	    private static final Font indice = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL);   
	    private static final Font titulo_indice = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD);   
	    private static final Font categoryFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
	    private static final Font subcategoryFont = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);
	    private static final Font blueFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL);    
	    private static final Font smallBold = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
	     
	    private static final String iTextExampleImage = "http://dv-alpha.com/img/logo_original.png";
	
	
	
	
	    @RequestMapping(value = { "/uploadfiles" })
		public void fileupload(HttpServletResponse response, HttpServletRequest request) throws IOException {
	    	
	    	MstApplicationParams param =getParameter("files", request, response);
	    	HttpSession ses = request.getSession();
	    	MstUsuario user =(MstUsuario)ses.getAttribute("user");
			String path =param.getValor()+File.separator+user.getMstcentro().getId()+File.separator+user.getId();
			service.subirArchivo(request,response,ses,user,path);
			
			//refrescamos el usuario de la sesion
			
			MstUsuario usernew =(MstUsuario)dao.readById(user.getId(), MstUsuario.class);
			ses.setAttribute("user", usernew);
	         
	       }
	    
	    /**
	     * Control que refresca el espacio ocupado en disco que aparece en la barra lateral del
	     * backend (en la parte de abajo)
	     * @param request
	     * @param response
	     */
	    @RequestMapping(value = { "/refrescar-espacio-menubar-left" })
	    public void refrescarEspacioDisponibleDelUsuarioEnMenuLateral(HttpServletRequest request, HttpServletResponse response) {
			//Actualizamos el espacio disponible del usuario que hay en sesion
	    	HttpSession ses = request.getSession();
	    	MstUsuario user =(MstUsuario)ses.getAttribute("user");
			double espacio_ocupadoMB =obtenerEspacioOcupado(user,request,response);
			int espacio_total=user.getMststorage().getMaxMB();
			double total=(espacio_ocupadoMB*100)/espacio_total;
			DecimalFormat mf = new DecimalFormat("#0.0");
			String s = mf.format(total);
			s = s.replace(',', '.');
			double conv = Double.parseDouble(s); 
			user.setEspacioOcupado(conv);
			openSession(response, request).setAttribute("user", user);
			
			String respuesta="";
			if(user.espacioOcupado>=70 && user.espacioOcupado<=79) {
				respuesta="<div class=\"progress\" style=\"background-color: #7e7e7e; position: relative;\">\r\n" + 
						"			  <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" \r\n" + 
						"			  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+user.espacioOcupado+"%\">\r\n" + 
						"			    <span>"+user.espacioOcupado+"%</span>\r\n" + 
						"			  </div>\r\n" + 
						"			</div>";
			}else if(user.espacioOcupado>=80 && user.espacioOcupado<=89) {
				respuesta="<div class=\"progress\" style=\"background-color: #7e7e7e; position: relative;\">\r\n" + 
						"			  <div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" \r\n" + 
						"			  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+user.espacioOcupado+"%\">\r\n" + 
						"			    <span>"+user.espacioOcupado+"%</span>\r\n" + 
						"			  </div>\r\n" + 
						"			</div>";
				
			}else if(user.espacioOcupado>=90 && user.espacioOcupado<=100) {
				respuesta="<div class=\"progress\" style=\"background-color: #7e7e7e; position: relative;\">\r\n" + 
						"			  <div class=\"progress-bar progress-bar-danger\" role=\"progressbar\" \r\n" + 
						"			  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+user.espacioOcupado+"%\">\r\n" + 
						"			    <span>"+user.espacioOcupado+"%</span>\r\n" + 
						"			  </div>\r\n" + 
						"			</div>";
				
			}else {
				respuesta="<div class=\"progress\" style=\"background-color: #7e7e7e; position: relative;\">\r\n" + 
						"			  <div class=\"progress-bar progress-bar-primary\" role=\"progressbar\" \r\n" + 
						"			  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+user.espacioOcupado+"%\">\r\n" + 
						"			    <span>"+user.espacioOcupado+"%</span>\r\n" + 
						"			  </div>\r\n" + 
						"			</div>";
			}
			
			responseAjax(response,respuesta);
		}

	    @RequestMapping(value = { "/minube-form" })
		public void minubeform(HttpServletResponse response, HttpServletRequest request) throws IOException {
	    	HttpSession ses = request.getSession();
	    	MstUsuario user =(MstUsuario)ses.getAttribute("user");
          
	    	
	    	
			String pattern="";
	    	
	    	//ha de obtener los archivos de ese usuario desde base de datos por que si los 
	    	//obtiene desde la sesion del usuario no vera si se ha subido un archivo nuevo
			List<MstArchivo> lista = (List<MstArchivo>) dao.findAllWhere(new MstArchivo(), "usuario", user);
			
			
	    	
	    	for(MstArchivo file:user.archivos) {
	    	String nombreArchivo=transformarElNombreDelArchivo(file);
	    	String tag =obtenerElTagHtml(file, request, response);
	    	
	    	pattern +="<div class=\"col-lg-2 col-sm-3 col-xs-4\" onclick=\"selector('"+file.getUrlPath()+"')\">\r\n" + 
	    			"        <div class=\"panel panel-default\">\r\n" + 
	    			"            <div class=\"panel-body\">\r\n" + 
	    			"                <a href=\"#\">\r\n" + 
	    			"                \r\n" + tag+
	    			
	    			"                </a> \r\n" + 
	    			"            </div>\r\n" + 
	    			"            <div class=\"panel-footer\">  \r\n" +nombreArchivo+ 
	    			"            </div>  \r\n" + 
	    			"        </div> \r\n" + 
	    			"    </div>\r\n" + 
	    			"    <div class=\"clear\"></div> \r\n";
	    	}
	    	
	    	responseAjax(response,pattern);
	          
	       }
	    
	    
    /**
     * En funcion del archivo que le llega x parametro carga un tag img distinto, esto se hace por que en caso 
     * de tener la imagen de una foto cargara esa foto pero si el archivo es un excel o un pdf debe cargar el icono de un
     * excel o pdf definidos por la aplicacion
     * @param file
     * @param request
     * @param response
     * @return
     */
	    
	private String obtenerElTagHtml(MstArchivo file, HttpServletRequest request, HttpServletResponse response) {
		String tag="";
		MstApplicationParams param =getParameter("statics", request, response);
		String path=param.getValor();
		if( file.getExtension().equalsIgnoreCase("png")
		  ||file.getExtension().equalsIgnoreCase("bmp")
		  ||file.getExtension().equalsIgnoreCase("jpg")
		  ||file.getExtension().equalsIgnoreCase("jpeg")) {
			tag="                    <img src=\""+file.getUrlPath()+"\" class=\"img-thumbnail img-responsive size\">\r\n";
		}else if(file.getExtension().equalsIgnoreCase("doc")){
			tag="                    <img src=\""+path+"/images/iconos/word.png\" class=\"img-thumbnail img-responsive size\">\r\n";
		}else if(file.getExtension().equalsIgnoreCase("docx")){
			tag="                    <img src=\""+path+"/images/iconos/word.png\" class=\"img-thumbnail img-responsive size\">\r\n";
		}else if(file.getExtension().equalsIgnoreCase("xls")){
			tag="                    <img src=\""+path+"/images/iconos/excel.png\" class=\"img-thumbnail img-responsive size\">\r\n";
		}else if(file.getExtension().equalsIgnoreCase("xlsx")){
			tag="                    <img src=\""+path+"/images/iconos/excel.png\" class=\"img-thumbnail img-responsive size\">\r\n";
		}else if(file.getExtension().equalsIgnoreCase("pdf")){
			tag="                    <img src=\""+path+"/images/iconos/pdf.png\" class=\"img-thumbnail img-responsive size\">\r\n";
		}else if(file.getExtension().equalsIgnoreCase("txt")){
			tag="                    <img src=\""+path+"/images/iconos/text.png\" class=\"img-thumbnail img-responsive size\">\r\n";
		}					
		
		return tag;
		}

	/**
	 * Metodo que recorta el nombre del archivo por tal de que se ajuste al diseño html en el frontend
	 * @param file
	 * @return
	 */
	private String transformarElNombreDelArchivo(MstArchivo file) {
		
		String fi="";
		if(file.getFileName().length()>10) {
			fi=file.getFileName().substring(0, 10)+"..."+file.getExtension();
		}else {
			fi=file.getFileName();
		}
		
			return fi;
		}

	@RequestMapping(value = { "/reordenar" })
	public void reordenar(HttpServletResponse response, HttpServletRequest request) throws IOException {
	
		service.reordenar(request,response);
		
	}
	
	@RequestMapping(value = { "/toPdf" })
	public void trasnformarAPdf(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		try {
		    Document document = new Document();
		    try {
		        PdfWriter.getInstance(document, new FileOutputStream("C:\\xampp\\htdocs\\arquetipo\\centros\\pdf\\pdf-test.pdf"));
		    } catch (FileNotFoundException fileNotFoundException) {
		        System.out.println("No such file was found to generate the PDF "
		                + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
		    }
		    
		    Long id=Long.parseLong(request.getParameter("id"));
		    
		    MstLibro libro =  (MstLibro)dao.readById(id, MstLibro.class);
		    
		    document.open();
		    document.addTitle(libro.getTitulo());
		    document.addSubject("SUBTITULO");
		    document.addKeywords("palabras,clave");
		    document.addAuthor("Autor Alex");
		    document.addCreator("Creador alex");
		 // First page
		 // Primera página 
		  
		 Chunk chunk = new Chunk(libro.getTitulo(), chapterFont);
		
		 // Let's create de first Chapter (Creemos el primer capítulo)
		 Chapter chapter = new Chapter(new Paragraph(chunk), 1);
		 chapter.setNumberDepth(0);
		 String creacion = new SimpleDateFormat("dd-MM-yyyy").format(libro.getCreacion());
		 chapter.add(new Paragraph("Fecha de creación: "+creacion, fecha_creacion));
		 // We add an image (Añadimos una imagen)
		 Image image;
		 try {
		     image = Image.getInstance(iTextExampleImage);
		     image.scaleAbsolute(350, 200);
		     image.setAbsolutePosition(2, 150);
		     chapter.add(image);
		 } catch (BadElementException ex) {
		     System.out.println("Image BadElementException" +  ex);
		 } catch (IOException ex) {
		     System.out.println("Image IOException " +  ex);
		 }
		 document.add(chapter);
		
		 //Indice
		 int countIndice=1;
		 int countSubIndice=1;
		 Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Indice de contenidos", categoryFont)), countIndice);
		 document.add(chapSecond);
		 for(MstCategoriaLibro categoria:libro.getCategorias()) {   
		
			 Paragraph paragraphX = new Paragraph(new Anchor(countIndice+"."+countSubIndice+" "+categoria.getTitulo(), titulo_indice)); 
			 document.add(paragraphX);
				 for(MstDocumento doc: categoria.getDocumentos()) {   
					 countSubIndice++;
					 Paragraph paragraphE = new Paragraph(new Anchor(countIndice+"."+countSubIndice+"-----"+doc.getTitulo(), indice)); 
					 document.add(paragraphE);
					 
				 }
		 
				 countSubIndice=1;
		 System.out.println("Se añade la categoria "+categoria.getTitulo());
		 countIndice++;
		 }
		 
		 
		 
		 Chapter chap3 = new Chapter(new Paragraph(new Anchor("Indice de contenidos", categoryFont)), countIndice);
		 document.add(chap3);
		 for(MstCategoriaLibro categoria:libro.getCategorias()) {   
		
			 Paragraph paragraphX = new Paragraph(new Anchor(categoria.getTitulo(), titulo_indice)); 
			 document.add(paragraphX);
				 for(MstDocumento doc: categoria.getDocumentos()) {   
					 countSubIndice++;
					 Paragraph titulo = new Paragraph(); 
					 titulo.add(new Phrase(doc.getTitulo()));
					 Paragraph cuerpo = new Paragraph(); 
					 String cuerpofmt=doc.getCuerpo().replaceAll("\\<.*?\\>", "");
					 cuerpo.add(new Phrase(cuerpofmt));
					 document.add(cuerpo);
					 
				 }
		 
				
		 System.out.println("Se añade la categoria "+categoria.getTitulo());
		 countIndice++;
		 }
		 
		 
		 
		 
		String text = "un texto";
		
		com.lowagie.text.List list = new com.lowagie.text.List(com.lowagie.text.List.UNORDERED);
		ListItem item = new ListItem(text);
		item.setAlignment(Element.ALIGN_JUSTIFIED);
		list.add(item);
		text = "otro texto";
		
		item = new ListItem(text);
		item.setAlignment(Element.ALIGN_JUSTIFIED);
		list.add(item);
		
		
		
		    document.close();
		    
		    responseAjax(response, "http://localhost/arquetipo/centros/pdf/pdf-test.pdf");
		} catch (DocumentException documentException) {
		    System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}
	}
	
	
	
	}