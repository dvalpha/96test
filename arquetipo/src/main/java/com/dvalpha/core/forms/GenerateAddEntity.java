package com.dvalpha.core.forms;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

public class GenerateAddEntity {
	private static final Logger logger = Logger.getLogger(GenerateForms.class);

	private String comboCss = "class=\"form-control \"";
	private String imputCss = "class=\"form-control\"";
	String bootstrapGrid = "";
	String urlAdd = "la url esta en el controlador metodo add";

	private void crearFormulario_y_ControladorADDEntity(String string, String string2) {
		String controller = create_Controller(string, string2);
		String html = create_EntityTest(string);

		System.out.println(controller);
		System.out.println(html);
	}

	public String create_EntityTest(String nombreEntity) {
		int count = 0;
		String form = "";
		String[] fm1 = nombreEntity.replace("Mst", "").toLowerCase().split("\\.");
		String id_form = "frm-add-" + fm1[fm1.length - 1];

		generateJQueryValidatorFormAdd(id_form);

		String tag_form = "<form id=\"" + id_form + "\">\r\n";
		String tag_finalForm = "\r\n<button class=\"btn btn-primry\">Enviar</button>\r\n			</form>\r\n"
				+ "<div class=\"col-lg-12\"><b>Status</b>\r\n" + "<div class=\"alert alert-info\" id=\"msg\"></div>\r\n"
				+ "</div>";
		try {
			Object objeto = Class.forName(nombreEntity).newInstance();
			Field[] campos = objeto.getClass().getDeclaredFields();
			// No sale ni serial ni id

			for (int x = 2; x < campos.length; x++) {

				String nombreDelCampo = campos[x].getName();
				Type tipo = campos[x].getGenericType();

				if (tipo.toString().equalsIgnoreCase("class java.lang.Boolean")) {
					form += create_generarInputOption(nombreDelCampo);
				} else {

					if (tipo.getTypeName().contains("com.dvalpha")) {
						form += obtenerDependencia(count, nombreDelCampo);
						count++;
					} else {
						form += create_generarInputText(nombreDelCampo);
					}
				}
			}

		} catch (ClassNotFoundException ex) {
			logger.warn(ex.getMessage());

		} catch (InstantiationException ex) {
			logger.warn(ex.getMessage());

		} catch (IllegalAccessException ex) {
			logger.warn(ex.getMessage());
		}

		return tag_form + form + tag_finalForm;

	}

	/**
	 * Metodo que recibe por parametros el nombre del campo option type y los
	 * atributos css class js y retorna un combobox html
	 * 
	 * @param name
	 * @param metaData
	 * @return
	 */
	public String create_generarInputOption(String name) {
		String data = "\t<div class=\"form-group\">\n" + " <label for=\"" + name + "\">" + name.toUpperCase()
				+ "</label>\n<br>\n" + " <select name=\"" + name + "\"  " + getComboCss() + " id=\"" + name + "\">\n"
				+ "      <option value=\"true\">Si</option>\n" + 
				  "      <option value=\"false\">No</option>\n"
				+ " </select>\n" 
				+ "  \n" + "</div>\n";

		return data;
	}

	private String obtenerDependencia(int count, String nombre) {
		String a, b, c, d, e, f, g, h, i, j;
		a = "\t<div class=\"form-group\" >\r\n";
		b = "    \r\n";
		c = "<label>" + nombre.toUpperCase() + "</label>\r\n<br>\n";
		d = "<select name=\"" + nombre + "\" " + getComboCss() + " >\r\n";
		e = "  <c:forEach var=\"elemento\" items=\"${requestScope.dependencia0" + count + "}\">\r\n";
		f = "      <option value=\"${elemento.id}\">${elemento.id}</option>\r\n";
		g = "  </c:forEach>\r\n";
		h = "</select>\r\n";
		i = "   \r\n";
		j = "</div>\r\n";
		return a + b + c + d + e + f + g + h + i + j;
	}

	/**
	 * Metodo que recibe por parametros el nombre del campo y los atributos css
	 * class js y retorna un input type html
	 * 
	 * @param name
	 * @param metaData
	 * @return
	 */
	public String create_generarInputText(String name) {
		String data = 
				  "\t<div class=\"form-group \">\n" + " <label for=\"" + name + "\">" + name.toUpperCase()
				+ "</label>\n<br>\n" 
				+ "<input type=\"text\" name=\"" + name + "\" " + getImputCss() + " id=\"" + name + "\">\n" 
				+ "</div>\n";

		return data;
	}

	private void generateJQueryValidatorFormAdd(String id_form) {

		System.out.println(
				"---------------JAVASCRIPT DE VALIDACION PARA EL FORMULARIO HTML (jquery validator)-----------------");
		System.out.println();
		String validator = "$(function() {\r\n" + "	 \r\n" 
		+ "    $(\"#" + id_form + "\").validate({ \r\n"
				+ "        rules: {\r\n" + "            campos_XXX: {\r\n" 
		+ "                required: true,\r\n"
				+ "                minlength: 3\r\n" 
		+ "            }\r\n" 
				+ "        },\r\n"
				+ "        messages: {\r\n" 
				+ "            required: \"msg-required\",\r\n"
				+ "            minlength: \"msg-min\"\r\n" 
				+ "        },\r\n"
				+ "        submitHandler: function(form) {\r\n" 
				+ "        	"
				+ "        		 //PARA FRM NO AJAX $(\"#" + id_form + "\").submit();\r\n" + ""
				+ "                var dataString = $(\"#" + id_form + "\").serialize();\r\n" 
				+ "             	$.ajax({\r\n"
				+ "                url: 'add" + urlAdd + "',\r\n" + "                type: 'POST',\r\n"
				+ "                data: dataString, \r\n" + "                success: function (response) {\r\n"
				+ "                	$(\"#msg\").removeClass(\"alert-info\");\r\n" + 
				"					$(\"#msg\").addClass(\"alert-warning\");\r\n" + 
				"					$(\"#msg\").animate({width: '130px', opacity: '0.8'}, \"slow\");\r\n" + 
				"					$(\"#msg\").text(response);\r\n" + 
				"					$(\"#msg\").animate({width: '100px', opacity: '0.8'}, \"slow\");\r\n" + 
				"					$(\"#msg\").removeClass(\"alert-warning\");\r\n" + 
				"					$(\"#msg\").addClass(\"alert-info\");\r\n" + 
				"                	" + "                	\r\n"
				+ "                },\r\n" + "                error: function (response) {\r\n"
				+ "                	$(\"#msg\").text(\"error\");\r\n" + "                }\r\n" + "            });\r\n"
				+ "        	\r\n" + "        }\r\n" + "        \r\n" + "        \r\n" + "    \r\n" + "  })\r\n"
				+ "    });";

		System.out.println(validator);
		System.out.println();
		System.out.println("\r\n");

	}

	public String create_Controller(String nombreEntity, String simpleName) {
		int count = 0;
		int count2 = 0;
		String dependencias = "";
		String form = "";
		String cabecera = "";
		String finalControlador = "";
		String depx = "";
		String fin = "";

		logger.info("Creando el controlador para el formulario");

		System.out.println(
				"Se crea el control que setea las dependencias de la entidad y despues se procede a la creacion del formulario");
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println();
		System.out.println();
		try {

			String[] fm1 = nombreEntity.replace("Mst", "").toLowerCase().split("\\.");
			String url_main = fm1[fm1.length - 1];

			cabecera = "\r\n \r\n ----------CONTROLADOR QUE ATIENDE A LA ENTIDAD--------------\r\n \r\n"
					+ "import java.io.IOException;\r\n" + "import java.util.List;\r\n" + "\r\n"
					+ "import javax.servlet.http.HttpServletRequest;\r\n"
					+ "import javax.servlet.http.HttpServletResponse;\r\n" + "\r\n"
					+ "import org.apache.log4j.Logger;\r\n"
					+ "import org.springframework.beans.factory.annotation.Autowired;\r\n"
					+ "import org.springframework.stereotype.Controller;\r\n"
					+ "import org.springframework.web.bind.annotation.RequestMapping;\r\n"
					+ "import org.springframework.web.servlet.ModelAndView;\r\n"
					+ "import com.dvalpha.core.dao.GenericDao;\r\n" + "import com.dvalpha.core.entity.MstUsuario;\r\n" +

					"@Controller\r\n" + "public class " + simpleName + "Controller extends CoreController {\r\n"
					+ "\t private static final Logger logger = Logger.getLogger("+nombreEntity+".class);\r\n " + ""
					+ "\t@Autowired IGenericDAO dao;\r\n" + "\r\n" + "\r\n" +

					"\r\n" + "	@RequestMapping(value = { \"/main-menu-" + url_main + "\" })\r\n"
					+ "	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws IOException {\r\n"
					+ "\r\n" + "		return new ModelAndView(\"/la vista main menu\");\r\n" + "\r\n" + "	}\r\n"
					+ "	" +

					"\t@RequestMapping(value={\"/menu-add" + simpleName.replace("Mst", "") + "\"})\r\n"
					+ "	public ModelAndView menuAdd" + simpleName.replace("Mst", "")
					+ "(HttpServletResponse response,HttpServletRequest request) throws IOException{\r\n" + "\r\n"
					+ "			  " +

					"" + "	\r\n ";

			urlAdd = simpleName.replace("Mst", "");

			finalControlador = "" + "\treturn new ModelAndView(\"/la_vista\");\r\n" + "		\r\n}"

					+ "\r\n//metodo add (ajax response)\r\n" +

					"@RequestMapping(value={\"/add" + urlAdd + "\"})\r\n" + "	public void add" + urlAdd
					+ "(HttpServletResponse response,HttpServletRequest request) throws IOException{\r\n" 
					
					+ "\t"
					+ simpleName + " bean=(" + simpleName + ")populateBean(request, new " + simpleName + "());\r\n";

			Object objeto1 = Class.forName(nombreEntity).newInstance();
			Field[] campos1 = objeto1.getClass().getDeclaredFields();
			// No sale ni serial ni id

			for (int x = 2; x < campos1.length; x++) {

				String nombreDelCampo1 = campos1[x].getName();
				Type tipo1 = campos1[x].getGenericType();

				if (tipo1.getTypeName().contains("com.dvalpha")) {
					depx += "Long id" + count2 + "=Long.parseLong(request.getParameter(\"" + nombreDelCampo1
							+ "\"));\r\n";

					String[] parts = tipo1.getTypeName().split("\\.");
					String entidad = parts[parts.length - 1];
					String campoPrimeraMayusculas = nombreDelCampo1.substring(0, 1).toUpperCase()
							+ nombreDelCampo1.substring(1);
					depx += "bean.set" + campoPrimeraMayusculas + "(new " + entidad + "(id" + count2 + "));\r\n";
					count2++;
				}

			}

			fin = "\tdao.createEntity(bean);"

					+ "\r\n" + "responseAjax(response, \"Creado\");\r\n"
					+ "}\r\n }\r\n \r\n \r\n --------------------------------------------"
					+ "	\r\n \r\n HTML En la página JSP\r\n \r\n ";

			// Dependencias para el metodo menu-addxxxx (primero de los dos)
			Object objeto = Class.forName(nombreEntity).newInstance();
			Field[] campos = objeto.getClass().getDeclaredFields();
			// No sale ni serial ni id

			for (int x = 2; x < campos.length; x++) {

				String nombreDelCampo = campos[x].getName();
				Type tipo = campos[x].getGenericType();

				if (tipo.getTypeName().contains("com.dvalpha")) {
					String[] parts = tipo.getTypeName().split("\\.");
					String entidad = parts[parts.length - 1];
					dependencias += "\tList<" + entidad + ">lista"+count+" = (List<" + entidad + ">) dao.findAll(new " + entidad
							+ "());\r\n" + "\trequest.setAttribute(\"dependencia0" + count + "\",lista"+count+");\r\n";

					count++;
				}

			}

		} catch (ClassNotFoundException ex) {
			logger.warn(ex.getMessage());

		} catch (InstantiationException ex) {
			logger.warn(ex.getMessage());

		} catch (IllegalAccessException ex) {
			logger.warn(ex.getMessage());
		}

		form = cabecera + dependencias + finalControlador + depx + fin;
		return form;

	}

	public String getComboCss() {
		return comboCss;
	}

	public void setComboCss(String comboCss) {
		this.comboCss = comboCss;
	}

	public String getImputCss() {
		return imputCss;
	}

	public void setImputCss(String imputCss) {
		this.imputCss = imputCss;
	}
}
