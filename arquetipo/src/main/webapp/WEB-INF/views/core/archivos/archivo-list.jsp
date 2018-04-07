<%@page import="com.dvalpha.core.utils.TransformBytesToTB"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.dvalpha.core.entity.MstArchivo" %>

<style>
.dropdown {
    position: relative;
    display: inline-block;
    vertical-align: middle;
}
.badge {
    display: inline-block;
    min-width: 5px !important;
    padding: 4px 6px !important;
    font-size: 9px !important;
    font-weight: 700 !important;
    line-height: 1 !important;
    color: #505050 !important;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    background-color: #dce3ec !important;
    border-radius: 50px !important;
}
.ui-widget.ui-widget-content{
z-index: 1001;
}

.ui-widget-header {
    border: 1px solid #dddddd;
    background: #3f7196;
    color: #ffffff;
    font-weight: bold;
}

.thumbnail-files {
    display: block;
    padding: 4px;
    margin-bottom: 10px;
    line-height: 1.42857143;
    background-color: #bac7d0;
    border: 1px solid #ddd;
    border-radius: 4px;
    
    }
    
    .gallery
{
    display: inline-block;
    margin-top: 20px;
}
</style>


		<div class="col-sm-10" >
			<div class="col-sm-12" >
				<div class="col-sm-2">
				
				<div class="dropdown" style="margin-top:20px;">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
  <span class="glyphicon glyphicon-cog"></span> 
  Opciones
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="#" onclick="crearDirectorio()">Crear directorio nuevo +</a></li>
   
  </ul>
</div>
				
					<hr>
					<h4>Directorios</h4>
			    </div>
			 
			 <div class="col-sm-10"><h4>Gestión de archivos en mi nube</h4></div>
        
            </div>
        <div id="content-dashboard"></div>
      
       </div>
 
<!-- Ventana modal -->
<div id="dialog"  title="Compartir archivos" class="panel panel-primary" >

  <div id="file-id" style=" max-height:600px; overflow: auto;"></div>
</div>


<script type="text/javascript" class="init">

var id_root_dir=<c:out value="${sessionScope.rootdir.id}"></c:out>;

refreshDashboard();

function cambiarNombreDelDirectorio(id){
	var oldName =$("#name-dir-"+id).text();
	
	$.confirm({
		 title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Renombrar directorio',
		    content:'<p>Introduzca un nombre para el directorio</p><form action="" class="formName"><input type="text" placeholder="Nuevo nombre" value=\"'+oldName+'\" class="nombre form-control" /></form>',
	    buttons: {
	        formSubmit: {
	            text: 'cambiar-nombre-directorio',
	            btnClass: 'btn-blue',
	            action: function () {
	                var nombre = this.$content.find('.nombre').val();
	               
	                var dataString ={"id":id,"nombre":nombre};
		        	$.ajax({
		        	    url: 'cambiar-nombre-directorio',
		        	    type: 'POST',
		        	    data: dataString, 
		        	    success: function (response) {
		        	    	refreshProgressBar();
		        	    	refreshDashboard();
		        	    },
		        	    error: function (response) {
		        	    	$("#msg").text("error");
		        	    }
		        	});	
	            }
	        },
	        cancel: function () {
	            //close
	        },
	    }
	    
	});
}

function loadBody(){
	var dataString ={"iddir":id_root_dir};
	$.ajax({
        url: 'load-dashboard-body',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#cuerpo-dashboard").css("display","none");
        	$("#cuerpo-dashboard").html(response);
        	$("#cuerpo-dashboard").fadeIn(800);
        	
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
}


function refreshDashboard(){

	$.ajax({
        url: 'load-dashboard',
        type: 'POST',
        success: function (response) {
        	$("#content-dashboard").css("display","none");
        	$("#content-dashboard").html(response);
        	
        	$("#img-dir-"+id_root_dir).attr("src","<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/folderopen.ico");
	 	       
            	
        	$("#content-dashboard").fadeIn(1000,function(){
        		loadBody();
        	});
        	
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev,idDir) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    var dataid = ev.dataTransfer.files;
   
    var idfile = data.replace("link-", "");
   
    cambiarDirectorio(idfile,idDir);
    
}


function actualizarIconoDirectorio(){
	
	for (i = 0; i < 500; i++) { 
		
	 $("#img-dir-"+i).attr("src","<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/folder.png");
	 
	}
	
	
}
function getFilesFromFolder(id){
	
	id_root_dir=id; //seteamos el directorio cada vez que hacemos clic en una carpeta
	
	var dataString ={"idDir":id};
	 	$.ajax({
	 	    url: 'obtener-archivos-del-directorio',
	 	    type: 'POST',
	 	    data: dataString, 
	 	    success: function (response) {
	 	    	
	 	    	actualizarIconoDirectorio(id);
	 	    	
	 	    	$("#img-dir-"+id).attr("src","<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/folderopen.ico");
	 	       
	 	    	
	 	    	$("#cuerpo-dashboard").css("display","none");
	        	$("#cuerpo-dashboard").html(response);
	        	$("#cuerpo-dashboard").fadeIn(500);
	 	    },
	 	    error: function (response) {
	 	    	$("#msg").text("error");
	 	    }
	 	});	
}
function cambiarDirectorio(idfile,idDir){
	 var dataString ={"idFile":idfile,"idDir":idDir};
 	$.ajax({
 	    url: 'cambiar-directorio',
 	    type: 'POST',
 	    data: dataString, 
 	    success: function (response) {
 	    	refreshProgressBar();
 	    	loadBody();
 	    	refreshDashboard();
 	    },
 	    error: function (response) {
 	    	$("#msg").text("error");
 	    }
 	});	
}


function crearDirectorio(){
	

	$.confirm({
		 title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Crear un directorio nuevo',
		    content:'<h5>Se creara un directorio nuevo.</h5><p>Introduzca un nombre para el nuevo directorio</p><form action="" class="formName"><input type="text" placeholder="Nuevo nombre" value=\"\" class="nombre form-control" /></form>',
	    buttons: {
	        formSubmit: {
	            text: 'Crear directorio',
	            btnClass: 'btn-blue',
	            action: function () {
	                var nombre = this.$content.find('.nombre').val();
	               
	                var dataString ={"nombre":nombre};
		        	$.ajax({
		        	    url: 'crear-directorio',
		        	    type: 'POST',
		        	    data: dataString, 
		        	    success: function (response) {
		        	    	refreshProgressBar();
		        	    	refreshDashboard();
		        	    },
		        	    error: function (response) {
		        	    	$("#msg").text("error");
		        	    }
		        	});	
	            }
	        },
	        cancel: function () {
	            //close
	        },
	    }
	    
	});
}



// funcion para forzar la descarga del archivo desde la aplicacion
function down(url){
	window.open(url, '_blank');
	
	

}


// Iniciamos los cuadros de dialogo usados a la hora de compartir archivos
$( function() {
    $( "#dialog" ).dialog({
    	 autoOpen: false,
         bgiframe: true,
         minHeight: 85,
        
         width: 550,
         modal: false,
         draggable: true,
         resizable: false,
         position: {
             my: "center top",
             at: "center top",
             of: window
         },
         dialogClass: 'ui-dialog-osx',
         show: {
             effect: "fade",
             duration: 300
         },
         hide: {
             effect: "fade",
             duration: 300
         }
    });   
 
 });
  
  
function verTrazabilidad(id){	
	
	alert(id);
}



function borrarDirectorio(id){
	$.confirm({
		 columnClass: 'col-md-6',
	    title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Confirmación',
	    content: ' <div class="col-md-12"> <h3 class=\" col-md-12 text-center\">Se borrara el archivo</h3></div><div class="col-md-12 alert alert-warning"><h5>Se borrara el directorio y los archivos incluidos en el, en caso de haber archivos compartidos, estos dejaran de compartirse ya que han sido eliminados. Desea continuar?</h5></div> ',
	    buttons: {
	        confirm: function () {
	        	borrarDirectorioAction(id);
	        },
	        cancel: function () {
	            $.alert('Cancelado!');
	        }
	
	    }
});
}

function borrarDirectorioAction(id){
	
	var dataString ={"id":id};
	$.ajax({
	    url: 'delete-directorio',
	    type: 'POST',
	    data: dataString, 
	    success: function (response) {
	    	refreshProgressBar();
	    	refreshDashboard();
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	}
function borrarArchivo(id){
	$.confirm({
			 columnClass: 'col-md-6',
		    title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Confirmación',
		    content: ' <div class="col-md-12"> <h3 class=\" col-md-12 text-center\">Se borrara el archivo</h3></div><div class="col-md-12 alert alert-warning"><h5>El archivo se borrara del disco. Si el archivo está compartido con otros usuarios, los usuarios no podran acceder a este recurso. Desea continuar?</h5></div> ',
		    buttons: {
		        confirm: function () {
		        	borrarArchivoAction(id);
		        },
		        cancel: function () {
		            $.alert('Cancelado!');
		        }
		
		    }
	});
	

}
//Funcion que genera la tabla donde aparecen los usuarios para compartir un archivo
function compartirConUsuarioMenu(id){
	
	
	var dataString = {"id":id};
	$.ajax({
        url: 'compartir-con-usuario',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#file-id").html(response);
        	$(".ui-widget-content").css('background','#fff');
            $( "#dialog" ).dialog( "open" );
            $("#file-id").fadeIn(500);
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
}	




// Funcion llamada al seleccionar un usuarios
//desde la ventana modal donde aparecen los usuarios con los que puedes compartir un archivo
//Este metodo genera la ventana de confirmación
function compartirConUsuarioAction(id){
	var dataString = $("#frm-id-"+id).serialize();
	$.ajax({
        url: 'compartir-con-usuario-action',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#file-id").fadeOut(500,function(){
        		$("#file-id").html(response);
        	$(".ui-widget-content").css('background','#40474a');
        	$(".ui-dialog").css('width','400');
        	
        		
        	});  
        	
        	$("#file-id").fadeIn(500);
        },
        error: function (response) {
        	$("#msg-compartir").text("error");
        }
    });
}	



//Se confirma que se quiere compartir con otro usuario y se genera la confirmacion de que el archivo se ha compartido
function compartirAction(id){
	    //var dataString = $("#frm-id-enviar-"+id).serialize();
		var dataString = $("#frm-compartirAction-"+id).serialize()+"&iddir="+id_root_dir;
		
		$.ajax({
	        url: 'compartir-con-usuario-action-confirm',
	        type: 'POST',
	        data: dataString, 
	        success: function (response) {
	        	
	        		
	        		$('#dialog').dialog('close');
	            	
	        		 
	        		
	        			loadBody();
	        	
	        	
	        },
	        error: function (response) {
	        	$("#msg-compartir").text("error");
	        }
	    });
}

// Como se comparte con todo el departamento no hay tabla de seleccion de usuarios
// Este metodo genera el formulario de confirmacion
function compartirConDepartamento(id){
	var dataString = {"id":id};
	$.ajax({
        url: 'compartir-con-departamento',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	
        	$("#file-id").html(response);
        	$("#dialog").parents(".ui-dialog:first").animate({width: '400px'});
        	$(".ui-widget-content").css('background','#40474a');
        	$( "#dialog" ).dialog( "open" );
        	$("#file-id").fadeIn(500);
          
   		
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
	
	}
		
//Se confirma que se comparte con todo el departamento y se genera la ventana de 'Archivo compartido ok'	
function compartirDepartamento(id)	{
	var dataString = $("#frm-compartirDepartamento-"+id).serialize();
	$.ajax({
        url: 'compartir-con-departamento-confirm',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#file-id").fadeOut(500,function(){
        		//$("#dialog").parents(".ui-dialog:first").animate({width: '400px'});
        		//$("#file-id").html(response);
        		loadBody();
        		//$("#file-id").fadeIn(2500,function(){
        			$('#dialog').dialog('close');
        			
        		//});	
        		
        	});		
        },
        error: function (response) {
        	$("#msg-compartir").text("error");
        }
    });
}
	
// Se solicita hacer publico el archivo y se genera la confirmación	
function hacerPublico(id){
	var dataString = {"id":id};
	$.ajax({
        url: 'hacer-publico',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	
        	$("#file-id").html(response);
        	$("#dialog").parents(".ui-dialog:first").animate({width: '400px'});
        	$(".ui-widget-content").css('background','#40474a');
        	
        	$( "#dialog" ).dialog( "open" );
        	$("#file-id").fadeIn(500);
   		
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
}
function hacerPublicoAction(id){
	var dataString = $("#frm-hacerPublicoAction-"+id).serialize();
	$.ajax({
        url: 'hacer-publico-action',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$('#dialog').dialog('close');
        	loadBody();
        	
        	//$("#file-id").fadeOut(500,function(){
        		//$("#dialog").parents(".ui-dialog:first").animate({width: '400px'});
        		//$("#file-id").html(response);
        		//$("#file-id").fadeIn(1000,function(){
        			
        	//	});
        		
        		
        		
        	//});		
        },
        error: function (response) {
        	$("#msg-compartir").text("error");
        }
    });
}

function dejarDeCompartir(id){
	$.confirm({
		 columnClass: 'col-md-6',
	    title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Confirmación',
	    content: ' <div class="col-md-12"> <h3 class=\" col-md-12 text-center\">Se dejará de compartir el archivo</h3></div><div class="col-md-12 alert alert-warning"><h5>El archivo dejara de compartirse con los usuarios. Desea continuar?</h5></div> ',
	    buttons: {
	        confirm: function () {
	        	var dataString={"id":id};
	        	$.ajax({
	                url: 'dejar-de-compartir',
	                type: 'POST',
	                data: dataString, 
	                success: function (response) {
	                	
	                	loadBody();
	                		
	                },
	                error: function (response) {
	                	$("#msg-compartir").text("error");
	                }
	            });	
	        },
	        cancel: function () {
	            $.alert('Cancelado!');
	        }
	    }
});
	}

function codificarArchivo(id){
	var dataString = {"id":id};
	$.ajax({
        url: 'codificar-archivo',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	
        	loadBody();
   		
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
	
	}
function descodificarArchivo(id){
	
	var dataString = {"id":id};
	$.ajax({
        url: 'descodificar-archivo',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	
        	loadBody();
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
	
	}









$(document).ready(function() {
$('#table-MstArchivo').DataTable({
			order: [[ 0, 'desc' ]],	
		    dom: 'Bfrtip',
		    buttons: [
	            {
	                extend: 'copyHtml5',
	                text:'Copiar al porta papeles',
	                className:'btn-success',
	                exportOptions: {
	                    columns: [ 0, ':visible' ]
	                }
	            },
	            {
	                extend: 'excelHtml5',
	                text:'Exportar a Excel',
	                exportOptions: {
	                    columns: ':visible'
	                }
	            },
	            {
	                extend: 'pdfHtml5',
	                text:'Exportar en PDF',
	                exportOptions: {
	                    columns: [ 0, 1, 2, 3, 4, 5 ]
	                }
	            },
	            {
	                extend: 'colvis',
	                text:'Selector',
	                exportOptions: {
	                    columns: [ 0, 1, 2, 5 ]
	                }
	            }
	            
	        ]
	} );
} );

function editar(id){
	
	var link=$("#link-"+id).attr("title");

	$.confirm({
		 title: '<img style=\"width:60px;height:60px\" src=\"<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/puntos.gif\">Etiquetar archivo',
		    content:'<h5>Al etiquetar el archivo crearemos un identificador válido para este archivo, de forma que pueda identificarlo más facilmente.</h5><p>Introduzca un nombre para la nueva etiqueta</p><form action="" class="formName"><input type="text" placeholder="Nuevo nombre" value=\"'+link+'\" class="etiqueta form-control" /></form>',
	    buttons: {
	        formSubmit: {
	            text: 'Actualizar',
	            btnClass: 'btn-blue',
	            action: function () {
	                var etiqueta = this.$content.find('.etiqueta').val();
	               
	                var dataString ={"id":id,"etiqueta":etiqueta};
		        	$.ajax({
		        	    url: 'update-archivo',
		        	    type: 'POST',
		        	    data: dataString, 
		        	    success: function (response) {
		        	    	refreshProgressBar();
		        	    	loadBody();
		        	    },
		        	    error: function (response) {
		        	    	$("#msg").text("error");
		        	    }
		        	});	
	            }
	        },
	        cancel: function () {
	            //close
	        },
	    }
	    
	});
	
	
	
	
	
}

function borrarArchivoAction(id){
	
var dataString ={"id":id};
$.ajax({
    url: 'delete-archivo',
    type: 'POST',
    data: dataString, 
    success: function (response) {
    	refreshProgressBar();
    	refreshDashboard();
    	loadBody();
    	
    },
    error: function (response) {
    	$("#msg").text("error");
    }
});	
}

</script>







</div>

<jsp:include page="navbar-control-archivo.jsp" />