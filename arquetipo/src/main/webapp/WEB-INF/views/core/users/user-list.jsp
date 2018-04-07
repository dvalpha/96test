<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

	<style>
.progress span {
    position: absolute;
    display: block;
    width: 100%;
   
 }
.desplegable-izquierda {
  right: 31px;
  top: 22px;
  left: initial;

}
</style>	

		<div class="col-sm-10">
			<div class="col-lg-12">


				<h2>Administración de usuarios</h2>
			</div>
<div class="col-lg-12">
                   <table id="table-MstUsuario" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Avatar</th>
							<th>Nombre</th>
							<th>Departamento</th>
							<th>Email</th>
							<th>Rol</th>
							<th>Centro</th>
							<th>Total archivos</th>
							<th>Espacio contratado</th>
							<th>Espacio ocupado</th>
							<th>Creación</th>
							<th>Editar</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.listb}" varStatus="bcount">
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
						    <td class="text-center">
						    
						    <img class="thumbnail" style="width: 45px; height: 45px;" src="<c:out value="${bean.avatar}"></c:out>">
						    
						    </td>
							<td><c:out value="${bean.nombre}"></c:out></td>
							<td><c:out value="${bean.defdepartamentos.nombre}"></c:out></td>
							<td><c:out value="${bean.email}"></c:out></td>
							<td><c:out value="${bean.mstrol.nombre}"></c:out> </td>
							<td><c:out value="${bean.mstcentro.razonSocial}"></c:out></td>
							<td style="text-align: center;"><c:out value="${fn:length(bean.archivos)}"></c:out></td>
							<td style="text-align: center;"><c:out value="${bean.mststorage.maxMB}"></c:out>MB</td>
							<td>
							
							<c:choose>
							<c:when test="${bean.espacioOcupado>=70 && bean.espacioOcupado<=79}">
							<div class="progress" style="background-color: #7e7e7e; position: relative;">
							  <div class="progress-bar progress-bar-info" role="progressbar" 
							  aria-valuemin="0" aria-valuemax="100" style="width:${bean.espacioOcupado}%">
							    <span>${bean.espacioOcupado}%</span>
							  </div>
							</div>
						
							</c:when>
							<c:when test="${bean.espacioOcupado>=80 && bean.espacioOcupado<=89}">
							<div class="progress" style="background-color: #7e7e7e; position: relative;">
							  <div class="progress-bar progress-bar-warning" role="progressbar" 
							  aria-valuemin="0" aria-valuemax="100" style="width:${bean.espacioOcupado}%">
							    <span>${bean.espacioOcupado}%</span>
							  </div>
							</div>
							
							</c:when>
							
							<c:when test="${bean.espacioOcupado>=90 && bean.espacioOcupado<=100}">
							<div class="progress" style="background-color: #7e7e7e; position: relative;">
							  <div class="progress-bar progress-bar-danger" role="progressbar" 
							  aria-valuemin="0" aria-valuemax="100" style="width:${bean.espacioOcupado}%">
							    <span>${bean.espacioOcupado}%</span>
							  </div>
							</div>
							
							</c:when>
							<c:otherwise>
							<div class="progress" style="background-color: #7e7e7e; position: relative;">
							  <div class="progress-bar progress-bar-primary" role="progressbar" 
							  aria-valuemin="0" aria-valuemax="100" style="width:${bean.espacioOcupado}%">
							    <span>${bean.espacioOcupado}%</span>
							  </div>
							</div>
							
							
							</c:otherwise>
							
							</c:choose>
							
							
							
							</td>
							<td><fmt:formatDate type = "date" value="${bean.creacion}" /></td>
							<td> <button class="btn btn-success btn-xs" type="button" onclick="editar(<c:out value="${bean.id}"></c:out>)"><span class="glyphicon glyphicon-edit"></span> Editar</button>  </td>
							<td >
							    
							    
							 
							    
							    <div class="dropdown">
								  <button class="btn btn-danger dropdown-toggle btn-xs" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-edit"></span> Eliminar
								  <span class="caret"></span></button>
								  <ul class="dropdown-menu desplegable-izquierda" >
								    
									
								    <li><a href="#" onclick="borrar(<c:out value="${bean.id}"></c:out>)"><span class="glyphicon glyphicon-erase"></span> Elimiar usuario</a></li>
								    <li><a href="#"onclick="borrarcomprimir(<c:out value="${bean.id}"></c:out>)"><span class="glyphicon glyphicon-tasks"></span>  Eliminar usuarios y comprimir archivos</a></li>
								    <li><a href="#"onclick="borrartotal(<c:out value="${bean.id}"></c:out>)"><span class="glyphicon glyphicon-flash"></span>  Eliminar usuario y eliminar archivos</a></li>
								    
								  </ul>
								</div>
							    
							    
							    
							    							    <form action="menu-edit-usuario" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="delete-usuario" id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							</td>
                       </tr>
                     </c:forEach>  
                    </tbody>
              </table>   


<div class="col-lg-12">
	<p>Status</p>
	<div class="col-lg-12 alert alert-info" style="width: 0px;" id="msg"></div>
</div>










</div>

<script type="text/javascript" class="init">
	
$(document).ready(function() {
	$('#table-MstUsuario').DataTable( {
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
	
	var idform="#frm-"+id;
	$(idform).submit();
	
}

function borrar(id){
	$.confirm({
		columnClass: 'small',
		icon: 'fa fa-circle-o-notch fa-spin',
		theme: 'dark',//theme: 'light'  theme: 'supervan'  
		title: 'Eliminación de un usuario',
	    content: 'Se eliminara el usuario de la base de datos, pero sus archivos permaneceran en el servidor desea continuar?',
	    animationBounce: 1.5,
	    bootstrapClasses: {
	        btn: 'btn',
	        btnxs: 'btn-xs',
	        
	    },		
	    buttons: {
	        cancel: function () {
	            // here the button key 'hey' will be used as the text.
	            $.alert('Operación cancelada');
	        },
	        eliminar: {
	            text: 'Eliminar', // With spaces and symbols
	            action: function () {
	            	borrarUsuario(id);  
	                
	            }
	        }
	    }
	});
}

function borrarcomprimir(id){
	$.confirm({
		columnClass: 'small',
		theme: 'dark',//theme: 'light'  theme: 'supervan'  
		title: 'Eliminación de un usuario',
	    content: 'Se eliminara el usuario de la base de datos, pero sus archivos quedaran comprimidos  en el servidor desea continuar?',
	    animationBounce: 1.5,
	    bootstrapClasses: {
	        btn: 'btn',
	        btnxs: 'btn-xs',
	        
	    },		
	    buttons: {
	        cancel: function () {
	            // here the button key 'hey' will be used as the text.
	            $.alert('Operación cancelada');
	        },
	        eliminar: {
	            text: 'Eliminar', // With spaces and symbols
	            action: function () {
	            	borrarComprimir(id);  
	                
	            }
	        }
	    }
	});
}

function borrartotal(id){
	$.confirm({
		columnClass: 'small',
		theme: 'supervan',//theme: 'light'  theme: 'supervan'  
		title: 'Eliminación de un usuario',
	    content: 'Se eliminara el usuario totalmente, no quedaran guardados sus archivos en el servidor, desea continuar?',
	    animationBounce: 1.5,
	    bootstrapClasses: {
	        btn: 'btn',
	        btnxs: 'btn-xs',
	        
	    },		
	    buttons: {
	        cancel: function () {
	            // here the button key 'hey' will be used as the text.
	            $.alert('Operación cancelada');
	        },
	        eliminar: {
	            text: 'Eliminar', // With spaces and symbols
	            action: function () {
	            	borrarpermanentemente(id);  
	                
	            }
	        }
	    }
	});
}


function borrarUsuario(id){
	
var dataString = $("#frm-del-"+id).serialize();
$.ajax({
    url: 'delete-usuario',
    type: 'POST',
    data: dataString,   
    success: function (response) {
    	$("#msg").removeClass("alert-info");
    	$("#msg").addClass("alert-warning");
    	$("#msg").animate({width: '830px', opacity: '0.8'}, "slow");
    	$("#msg").text(response);
    	$("#tr-"+id).animate({"opacity": 0},1500,function(){
    		$("#tr-"+id).addClass("hide");
    	});
    	$("#msg").animate({width: '600px', opacity: '0.8'}, "slow");
    	$("#msg").removeClass("alert-warning");
    	$("#msg").addClass("alert-info");
    	
    },
    error: function (response) {
    	$("#msg").text("error");
    }
});	
}

function borrarComprimir(id){
	
	var dataString = $("#frm-del-"+id).serialize();
	$.ajax({
	    url: 'delete-usuario-comprimir',
	    type: 'POST',
	    data: dataString,   
	    success: function (response) {
	    	$("#msg").removeClass("alert-info");
	    	$("#msg").addClass("alert-warning");
	    	$("#msg").animate({width: '830px', opacity: '0.8'}, "slow");
	    	$("#msg").text(response);
	    	$("#tr-"+id).animate({"opacity": 0},1500,function(){
	    		$("#tr-"+id).addClass("hide");
	    	});
	    	$("#msg").animate({width: '600px', opacity: '0.8'}, "slow");
	    	$("#msg").removeClass("alert-warning");
	    	$("#msg").addClass("alert-info");
	    	
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	}
	
	
function borrarpermanentemente(id){
	
	var dataString = $("#frm-del-"+id).serialize();
	$.ajax({
	    url: 'delete-usuario-total',
	    type: 'POST',
	    data: dataString,   
	    success: function (response) {
	    	$("#msg").removeClass("alert-info");
	    	$("#msg").addClass("alert-warning");
	    	$("#msg").animate({width: '830px', opacity: '0.8'}, "slow");
	    	$("#msg").text(response);
	    	$("#tr-"+id).animate({"opacity": 0},1500,function(){
	    		$("#tr-"+id).addClass("hide");
	    	});
	    	$("#msg").animate({width: '600px', opacity: '0.8'}, "slow");
	    	$("#msg").removeClass("alert-warning");
	    	$("#msg").addClass("alert-info");
	    	
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	}

$("#btnExport").click(function (e) {
	
	 e.preventDefault();

	    //getting data from our table
	    var data_type = 'data:application/vnd.ms-excel';
	    var table_div = document.getElementById('table-MstUsuario');
	    
	    var test = table_div.row.find('td:not(:eq(2))');
	    alert(test);
	    var table_html = table_div.outerHTML.replace(/ /g, '%20');

	    
	    
	    
	    var a = document.createElement('a');
	    a.href = data_type + ', ' + table_html;
	    a.download = 'exported_table_' + Math.floor((Math.random() * 9999999) + 1000000) + '.xls';
	    a.click();
	  });
    

</script>
		</div>
<jsp:include page="navbar-control-users.jsp" />