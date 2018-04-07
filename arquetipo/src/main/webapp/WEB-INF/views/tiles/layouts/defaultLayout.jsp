<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
  
  <head>
  <meta charset="utf-8">
    <!-- BASE CSS -->
     <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
     <link href="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/css/style.css" rel="stylesheet">
    
    
    <!-- BASE JS -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/baselib/jquery/js/jquery-3.2.1.min.js"></script>
   
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/baselib/jquery/plugins/dist/jquery.validate.min.js"></script>
    
    
    <!-- CREACION DE TABLAS DINAMICAS -->
	<link rel="stylesheet" type="text/css" href="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/baselib/DataTables/datatables.min.css"/>
	<script type="text/javascript" src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/baselib/DataTables/datatables.min.js"></script>
	    
    <!-- CODIGO EN HTML -->
    <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    
    
    <!-- VALIDACIÓN Y ENVIO DE FORMULARIOS -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/js/form.js"></script>
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/js/form-validation.js"></script>
    
    
    <!-- REORDENACION DE ELEMENTOS CON DRAG N DROP -->
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <!-- NOTICIAS DE LA HOME -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/components/noticias/scripts/jquery.bootstrap.newsbox.min.js" type="text/javascript"></script>
     <link rel="stylesheet" type="text/css" href="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/components/noticias/css/site.css"/>
    
    
    
    
    
    <!-- DROPZONE -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/components/fileupload/dropzone.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/dropzone/5.1.1/dropzone.css"/>
    <script>
    refreshProgressBar();

    Dropzone.options.dropzone = {
    		  paramName: 'file',
    		  maxFilesize: 20, // MB
    		  maxFiles: 10,
    		  addRemoveLinks: true,
    		  dictDefaultMessage: 'Arrastre aqui sus archivos para subirlos a su escritorio',
    		  acceptedFiles: ".gif,.png,.jpg,.gif,.bmp,.jpeg,.pdf,.doc,.docx,.xls,.xlsx",
    		  init: function() {
    			  
    			this.on("sending", function (file) {
    				this.options.renameFilename = function(file){
    	                //keeping the file extension.
    	                var ext = file.split('.').pop();
    	               
    	                
    	                return file.name = filename + '.' + ext;
    	                
    	            };
    	        });
 
    		    this.on('success', function( file, resp ){
    		      console.log( file );
    		      console.log( resp );
    		      
    		      var respuesta = resp.includes("101");
    		      if(respuesta){
    		    	  $.alert({
             			 columnClass: 'col-md-6',
             		    title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Espacio insuficiente en disco',
             		    content: ' <div class="col-md-12 thumbnail"> <h4 class=\" col-md-12 \">Acción denegada</h4> <hr><div class="col-md-12 alert alert-warning"><h5>El espacio disponible en el disco es insuficiente para almacenar el archivo, borre archivos de su nube o amplie el espacio contratado.</h5></div></div> '
             		});
    		      }
    		    });
    		    
    		    this.on("queuecomplete", function (file) {
    		    	refreshProgressBar();
    		    	refreshDashboard(); 
    		    	reload(); //llamamos a la funcion reload [selector.jsp] que refresca los datos de mi nube una vez que ha finalizado la subida
    		      });
    		    
    		    
    		  },
    		  
    		};

    
    function refreshProgressBar(){
    	$.ajax({
            url: 'refrescar-espacio-menubar-left',
            type: 'POST',
           
            success: function (response) {
            	$("#espacio-ocupado").html(response);
            },
            error: function (response) {
            	$("#msg").text("error");
            }
        });
    	
    }
    </script>
   
    <!-- CREACION DE ALERTAS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
    <!-- JQUERY UI MODALES -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script>
    $(document).ready(function() {
        $(document).on("click", "a", function(event) {
           event.preventDefault();
            var dataUrl = $(this).attr("href");
           
           try{
            if(!dataUrl.includes("#")){
	            if (dataUrl != "") {
	            	
	                $.ajax({
	                    url: dataUrl,
	                    type: 'POST', 
	                    success: function (response) {
	                    	var resp=response.trim();
	                    	if(resp.startsWith("Acceso denegado")){
	                    		
	                    		$.alert({
	                    			 columnClass: 'col-md-6',
	                    		    title: '',
	                    		    content: ' <div class="col-md-12"> <h3 class=\"alert alert-warning col-md-12 text-center\">Lo sentimos pero...</h3></div><div class="col-md-12 alert alert-info"><h4> No tiene acceso. No puede acceder a esta sección con su actual nivel de permisos</h4></div> '
	                    		});
	                    		
	                    		
	                    		}else{
	                        window.location=dataUrl;
	                    	}
	                    	
	    	                
	                    }
	                });
	                
	            }
            }
            
        }
        catch(err) {
        	console.log(err);
        }

        });
    });
    </script>

    <!-- TINYMCE 4.6.6 -->
    <script src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/components/tinymce/js/tinymce/tinymce.min.js"></script>
    <script>
  
  tinymce.init({
	  mode : "specific_textareas",
      editor_selector : "mce",
	  height: 200,
	  plugins: [
	    "advlist autolink autosave link image lists charmap print preview hr anchor pagebreak",
	    "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
	    "table contextmenu directionality emoticons template textcolor paste fullpage textcolor colorpicker textpattern"
	  ],

	  toolbar1: "newdocument fullpage | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | styleselect formatselect fontselect fontsizeselect | table | hr removeformat | subscript superscript | charmap emoticons | print fullscreen | ltr rtl | ",
	  toolbar2: "cut copy paste | searchreplace | bullist numlist | outdent indent blockquote | undo redo | link unlink anchor image media code | insertdatetime preview | forecolor backcolor | visualchars visualblocks nonbreaking template pagebreak restoredraft",
	  toolbar3: "",
	  content_css: [
	    '//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
	    '//www.tinymce.com/css/codepen.min.css'],

	  menubar: false,
	  toolbar_items_size: 'small',

	  style_formats: [{
	    title: 'Bold text',
	    inline: 'b'
	  }, {
	    title: 'Red text',
	    inline: 'span',
	    styles: {
	      color: '#ff0000'
	    }
	  }, {
	    title: 'Red header',
	    block: 'h1',
	    styles: {
	      color: '#ff0000'
	    }
	  }, {
	    title: 'Example 1',
	    inline: 'span',
	    classes: 'example1'
	  }, {
	    title: 'Example 2',
	    inline: 'span',
	    classes: 'example2'
	  }, {
	    title: 'Table styles'
	  }, {
	    title: 'Table row 1',
	    selector: 'tr',
	    classes: 'tablerow1'
	  }],

	  templates: [{
	    title: 'Test template 1',
	    content: 'Test 1'
	  }, {
	    title: 'Test template 2',
	    content: 'Test 2'
	  }]
	});
  
  </script>	
  
  
  <!-- PREVISUALIZAR IMAGENES DE LA GALERIA DE ARCHIVOS -->
    <!-- References: https://github.com/fancyapps/fancyBox -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
<script src="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
<script>
$(document).ready(function(){
    
	
			    $(".fancybox").fancybox({
			    	helpers : {
			    		title : {
			    			type : 'over'
			    		}
			    	}
			    });
			    
			    
			    
});
   
</script>

    </head>
  <body>

        <section id="sidemenu">
            <tiles:insertAttribute name="menu" />
        </section>
       
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
     
        
             
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>
