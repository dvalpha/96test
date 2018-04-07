<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

			<div class="col-lg-7">
<h2>Edición de componentes</h2>
<br>
<h4><button class="btn btn-primary btn-md" data-toggle="modal" data-target="#modal-add-componente">+ Componente</button></h4>
		
	</div>		
			<div class="col-lg-5">

				<span style="font-size:44px; color: #093750; " >${requestScope.cliente.nomclicom}</span>
				<h3 style="font-size:34px; color: #670000; ">Articulo: <c:out value="${requestScope.articulo.articulo}"></c:out> </h3>
	
			</div>
		
	
	</div>
            <table id="table-MstComponente" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							
							
							<th>Componente</th>
							<th>Cant</th>
							<th>Plantilla</th>
							
							<th>Largo</th>
							
							<th>Ancho</th>
							<th>Alto</th>
							<th>División</th>
							<th>Mart</th>
							
							
							
							<th>Fin</th>
							<th>Dup</th>
							<th>Grup</th>
							<th>Dest</th>
							<th>Observ</th>
							<th>Precio</th>
							<th>Btns</th>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.list}">
					
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
						<input type="hidden" name="idcomponente" id="idcomponente<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.id}"></c:out>">
						   
							<td class="thumbnail" style="font-size:9px;" onclick="setearIdMstArticuloMstComponente('<c:out value="${bean.id}"></c:out>')"><c:out value="${bean.componente.descritipo}"></c:out></td>
							
							<td>
							<input type="text" class="form-control" style="width: 60px;" name="cantidad" id="cantidad<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.cantidad}"></c:out>">
							</td>
							
							<td><input type="text" class="form-control" style="width: 80px;" name="plantilla" id="plantilla<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.plantilla}"></c:out>">
							</td>
							<td><input type="text" class="form-control" style="width: 60px;" name="largo" id="largo<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.largo}"></c:out>"></td>
							<td><input type="text" class="form-control" style="width: 60px;" name="ancho" id="ancho<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.ancho}"></c:out>"></td>
								<td><input type="text" class="form-control" style="width: 60px;" name="alto" id="alto<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.alto}"></c:out>"></td>
						<td><input type="text" class="form-control" style="width: 60px;" name="division" id="division<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.division}"></c:out>"></td>
						
							<td>
							<select name="mater" id="mater<c:out value="${bean.id}"></c:out>" style="width:150px; " onchange="actualizarMaterialYPrecio('<c:out value="${bean.id}"></c:out>')"class="form-control">
							<option value="<c:out value="${bean.material.id}"></c:out>"><c:out value="${bean.material.calidad}"></c:out> [Actual]</option>
							<c:forEach var="mat" items="${requestScope.materiales}">
							<option value="<c:out value="${mat.id}"></c:out>">
							<c:out value="${mat.calidad}"></c:out>
							</option>
							</c:forEach>
							
							</select>
							
							
							
							</td>
							
						
							<td>
							<select style="width:40px;" name="fingru" id="fingru<c:out value="${bean.id}"></c:out>">
							<option value="<c:out value="${bean.fingru}"></c:out>"><c:out value="${bean.fingru}"></c:out> [Actual]</option>
							<option value="D">D</option>
							<option value="T">T</option>
							</select>
							</td>
							<td><select name="dupbasico" style="width:40px;"  id="dupbasico<c:out value="${bean.id}"></c:out>">
							
							<option value="<c:out value="${bean.dupbasico}"></c:out>"><c:out value="${bean.dupbasico}"></c:out> [Actual]</option>
							<option value="D">D</option>
							<option value="N">N</option>
							</td>
							<td><select name="grupo" style="width:40px;"  id="grupo<c:out value="${bean.id}"></c:out>">
							<option value="<c:out value="${bean.grupo}"></c:out>"><c:out value="${bean.grupo}"></c:out> [Actual]</option>
							<option value=" ">Sin grupo</option>
							<option value="A">A</option>
							<option value="B">B</option></td>
							<td><select name="destino" style="width:40px;"  id="destino<c:out value="${bean.id}"></c:out>">
							<option value="<c:out value="${bean.destino}"></c:out>"><c:out value="${bean.destino}"></c:out> [Actual]</option>
							<option value=" ">Sin destino</option>
							<option value="A">A</option>
							<option value="B">B</option></td>
							<td><input type="text" class="form-control" style="width: 60px;" name="observac" id="observac<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.observac}"></c:out>">
							<td><c:out value="${bean.precio}"></c:out></td>
							<td>
							
							<div class="dropdown">
							  <button class="btn btn-primary dropdown-toggle btn-xs" type="button" data-toggle="dropdown">Seleccionar
							  <span class="caret"></span></button>
							  <ul class="dropdown-menu">
							    
							    <li><a href="#" onclick="actualizarComponenteDelArticulo(<c:out value="${bean.id}"></c:out>)">Editar</a></li>
							    <li><a href="#"onclick="borrar(<c:out value="${bean.id}"></c:out>)">Eliminar</a></li>
							  </ul>
							</div>
							<form action="menu-edit-componente" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="delete-componente" id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							</td>
                       </tr>
                      
                     </c:forEach>  
                    </tbody>
              </table>   


<div class="col-lg-12">
				<p>Status</p>
				<div class="col-lg-12 alert alert-info" id="msg"></div>
</div>




<!-- Modal -->
<div id="modal-add-componente" class="modal fade" role="dialog" >
  <div class="modal-dialog" style="width:1400px;">

    <!-- Modal content-->
    <div class="modal-content" style="width:1400px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h3>Agregar Componentes </h3> 
        <h4>Articulo:<c:out value="${requestScope.articulo.articulo}"></c:out> </h4>   
        
	    
      </div>
      <div class="modal-body">
        <table id="table-nuevo-material" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
						   
							<th>Componente</th>
							<th>Largo</th>
							<th>Ancho</th>
							<th>Alto</th>
							
							<th>Cantidad</th>
							<th>Material</th>
							<th>División</th>
							<th>Precio</th>
							<th>Plantilla</th>
							<th>F</th>
							<th>D</th>
							<th>G</th>
							<th>Dst</th>
							<th>Descripcion</th>	
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.componentes}">
					
						<tr id="tr-<c:out value="${bean.id}"></c:out>"> 
						<form action="agregar-componente-a-articulo" id="form-add-componente<c:out value="${bean.id}"></c:out>" method="post">
						    <input type="hidden"  name="cliente" id="cliente" value="<c:out value="${requestScope.cliente.codclient}"></c:out>">
						    <input type="hidden"  name="codigoart" id="codigoart" value="<c:out value="${requestScope.articulo.codigo}"></c:out>">
						    <input type="hidden"  name="material" id="material<c:out value="${bean.id}"></c:out>" >
						    <input type="hidden"  name="componenteCod" id="componenteCod<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.codigo}"></c:out>" >
						    
							<td><c:out value="${bean.descritipo}"></c:out></td>
							<td><input type="text" style="width: 50px;" class="form-control" name="largo" id="largo<c:out value="${bean.id}"></c:out>"></td>
							<td><input type="text" style="width: 50px;" class="form-control" name="ancho" id="ancho<c:out value="${bean.id}"></c:out>"></td>
							<td><input type="text" style="width: 50px;" class="form-control" name="alto" id="alto<c:out value="${bean.id}"></c:out>"></td>
							
							<td><input type="text" style="width: 50px;" class="form-control" name="cantidad" id="cantidad<c:out value="${bean.id}"></c:out>"></td>
							<td>
							<select name="materiales" id="materiales<c:out value="${bean.id}"></c:out>" style="width:150px; " onchange="calcularPrecio('<c:out value="${bean.id}"></c:out>')"class="form-control">
							
							<c:forEach var="mat" items="${requestScope.materiales}">
							<option value="<c:out value="${mat.calidad}"></c:out>">
							<c:out value="${mat.material}"></c:out> - <c:out value="${mat.calidad}"></c:out>
							</option>
							</c:forEach>
							
							</select>
							</td>
							<td><input type="text" class="form-control" name="division" id="division<c:out value="${bean.id}"></c:out>"></td>
							
							<td><input type="text" class="form-control" name="precio" id="precio<c:out value="${bean.id}"></c:out>"></td>
							<td><input type="text" class="form-control" name="plantilla" id="plantilla<c:out value="${bean.id}"></c:out>"></td>
							<td>
							<select name="fingru" id="fingru<c:out value="${bean.id}"></c:out>">
							<option value="D">D</option>
							<option value="T">T</option>
							</select>
							</td>
							<td><select name="dupbasico" id="dupbasico<c:out value="${bean.id}"></c:out>">
							<option value="D">D</option>
							<option value="N">N</option>
							</td>
							<td><select name="grupo" id="grupo<c:out value="${bean.id}"></c:out>">
							<option value=" ">Sin grupo</option>
							<option value="A">A</option>
							<option value="B">B</option></td>
							<td><select name="destino" id="destino<c:out value="${bean.id}"></c:out>">
							<option value=" ">Sin destino</option>
							<option value="A">A</option>
							<option value="B">B</option></td>
							<td><input type="text" class="form-control" name="observaciones" id="observaciones<c:out value="${bean.id}"></c:out>"></td>
							
							<td>
							<button type="button" class="btn btn-info btn-xs" onclick="agregarComponente('<c:out value="${bean.id}"></c:out>')" >+ Agregar</button> 
							</td>
						 </form> 	
                       </tr>
                     
                     </c:forEach>  
                    </tbody>
              </table>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>


<div id="modal-select-componente" class="modal fade" role="dialog" >
  <div class="modal-dialog" style="width:500px;">

    <!-- Modal content-->
    <div class="modal-content" style="width:500px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h5>Actualizar componente al articulo <c:out value="${requestScope.articulo.articulo}"></c:out> </h5>   
        
	    
      </div>
      <div class="modal-body">
        <table id="actualizar-componente" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Código</th>
							<th>Descripción</th>
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.componentes}">
						<tr id="tr-<c:out value="${bean.id}"></c:out>"> 
							<td><c:out value="${bean.codigo}"></c:out></td>
							<td><c:out value="${bean.descritipo}"></c:out></td>
							<td>
							<button type="button" class="btn btn-info btn-xs" onclick="seleccionarComponente('<c:out value="${bean.id}"></c:out>')" >Seleccionar</button> 
							</td>
						
                       </tr>
                     
                     </c:forEach>  
                    </tbody>
              </table>
       
    
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>












<style>
#table-nuevo-material table.dataTable.cell-border tbody td {
    border-top: 0px solid #ddd;
    border-right: 0px solid #ddd;
}
.modal {
  
   
   right: 100px;
   left: 100px;
  
}
</style>


</div>
</div>
<script type="text/javascript" >
var id_mst_articulo_mst_componente;

function actualizarMaterialYPrecio(idComponente){
	var materialid=$("#mater"+idComponente).val();
	$.confirm({
	    title: 'Material',
	    content: 'Desea actualizar el tipo de material en este articulo?',
	    buttons: {
	        confirm: function () {
	        	var dataString = {"idmsta":materialid,"idcomp":idComponente};
	        	$.ajax({
	                url: 'actualizarEntidadMaterialDelArticulo',
	                type: 'POST',
	                data: dataString, 
	                success: function (response) {
	                	$("#msg").addClass("alert-warning");
	                	$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
	                	$("#msg").text(response);
	                	location.reload();

	                },
	                error: function (response) {
	                	$("#msg").text(response);
	                }
	            });
	        },
	        cancel: function () {
	           // $.alert('Cancelado!');
	        }
	        
	    }
	});
	

}


function seleccionarComponente(componenteid){
	
	
	
	$.confirm({
	    title: 'Confirmación',
	    content: 'Desea actualizar el tipo de componente en este articulo?',
	    buttons: {
	        confirm: function () {
	        	var dataString = {"idmsta":id_mst_articulo_mst_componente,"idcomp":componenteid};
	        	$.ajax({
	                url: 'actualizarEntidadComponenteDelArticulo',
	                type: 'POST',
	                data: dataString, 
	                success: function (response) {
	                	$("#msg").addClass("alert-warning");
	                	$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
	                	$("#msg").text(response);
	                	location.reload();

	                },
	                error: function (response) {
	                	$("#msg").text(response);
	                }
	            });
	        },
	        cancel: function () {
	            $.alert('Cancelado!');
	        }
	        
	    }
	});
	

	
	
	
}
function actualizarComponenteDelArticulo(id){
	var largo=$("#largo"+id).val();
	var alto=$("#alto"+id).val();
	var ancho=$("#ancho"+id).val();
	var id=$("#idcomponente"+id).val();
	var cant=$("#cantidad"+id).val();
	var pl=$("#plantilla"+id).val();
	var ob=$("#observac"+id).val();
	var fingru=$("#fingru"+id).val();
    var dupbasico=$("#dupbasico"+id).val();
    var grupo=$("#grupo"+id).val();
    var destino=$("#destino"+id).val();
    var mater=$("#mater"+id).val();
	
	
	var dataString = {"largo":largo,"alto":alto,"ancho":ancho,"idcomponente":id,"cantidad":cant,"plantilla":pl,"observaciones":ob,"fingru":fingru,"destino":destino,"grupo":grupo,"dupbasico":dupbasico,"mater":mater};
	//MstComponenteController
	$.ajax({
        url: 'actualizarComponenteDelArticulo',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#msg").addClass("alert-warning");
        	$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
        	$("#msg").text(response);
        	location.reload();

        },
        error: function (response) {
        	$("#msg").addClass("alert-warning");
        	$("#msg").text("Error en la actualizacion, los datos insertados no parecen correctos");
        }
    });
	
	
	
}

function calcularPrecio(id){
var dataString = $("#form-add-componente"+id).serialize();
	$.ajax({
        url: 'calcularPrecioComponente',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#precio"+id).val(response);

        },
        error: function (response) {
        	$.alert("El formato de las medidas no es correcto,o no se indicó la cantidad");
        }
    });
	
	
	
}
	function agregarComponente(id){
		var dataString = $("#form-add-componente"+id).serialize();
		$.ajax({
	        url: 'agregar-componente-a-articulo',
	        type: 'POST',
	        data: dataString, 
	        success: function (response) {
	        	$("#msg").addClass("alert-warning");
	        	$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
	        	$("#msg").text(response);
	        	location.reload();

	        },
	        error: function (response) {
	        	$.alert("El formato de las medidas no es correcto, no se pudo calcular el precio.");
	        }
	    });
		
		
		
	
	}

$(document).ready(function() {
	var table = $('#table-MstComponente').DataTable({
		order: [[ 13, 'desc' ]],
		"columnDefs": [
			 { "targets": [1,2,3,4,5,6,7,8,9], "searchable": false }
	    ],
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
	
	
	
	
$('#table-nuevo-material').DataTable({
	order: [[ 1, 'desc' ]],
	"pageLength": 5,
	"columnDefs": [
        { "targets": [1,2,3,4,5,6,7,8,9,10,11,12,13,14], "searchable": false }
    ]
   
} );
	
$('#actualizar-componente').DataTable({
	order: [[ 1, 'desc' ]],
	"columnDefs": [
        { "targets": [2], "searchable": false }
    ]
   
} );
	
} );

function setearIdMstArticuloMstComponente(data){
	id_mst_articulo_mst_componente=data;
	 $('#modal-select-componente').modal('show');
}


function editar(id){
	
	var idform="#frm-"+id;
	$(idform).submit();
	
}

function borrar(id){
	
var dataString = $("#frm-del-"+id).serialize();
$.ajax({
    url: 'delete-componente',
    type: 'POST',
    data: dataString, 
    success: function (response) {
    $("#msg").removeClass("alert-info");
    	$("#msg").addClass("alert-warning");
    	$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
    	$("#msg").text(response);
    	$("#tr-"+id).animate({"opacity": 0},1500,function(){
    		$("#tr-"+id).addClass("hide");
    	});
    	$("#msg").animate({width: '100px', opacity: '0.8'}, "slow");
    	$("#msg").removeClass("alert-warning");
    	$("#msg").addClass("alert-info");    	
    },
    error: function (response) {
    	$("#msg").text("error");
    }
});	
}

</script>			


</div>
</div>
<jsp:include page="navbar-control-componente.jsp" />