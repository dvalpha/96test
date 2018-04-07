<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de clientes</h2>
			</div>
   
   
      <table id="table-MstClient" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Codigo de cliente</th>
							<th>NIF</th>
							<th>Razón social</th>
							<th>Teléfono</th>
							<th>Num.Artículos</th>
							<th>Artículos</th>
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.list}">
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
							<td><c:out value="${bean.codclient}"></c:out></td>
							<td><c:out value="${bean.nifcli}"></c:out></td>
							<td><c:out value="${bean.nomclifiscal}"></c:out></td>
							<td><c:out value="${bean.telefcli1}"></c:out></td>
							<td><c:out value="${fn:length(bean.articulos)}"></c:out></td>
							<td>  
							<button class="btn btn-success btn-xs" onclick="listarArticulos(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-download"></span>
							     Listar
							</button>
							<button class="btn btn-primary btn-xs" onclick="addArticulos(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-plus"></span>
							     Agregar
							</button>
							<form action="list-articulo" id="frm-listar-articulos-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							</td>
							<td>
							    <button class="btn btn-success btn-xs" onclick="editar(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-edit"></span>
							     Editar
							    </button>
							    <button class="btn btn-info btn-xs" onclick="javascript:alert('se llamara a la función ocultar cliente');">
							     <span class="glyphicon glyphicon-erase"></span>
							      Ocultar
							    </button>
							   <!-- <button class="btn btn-danger btn-xs" onclick="borrar(<c:out value="${bean.id}"></c:out>)">
							     <span class="glyphicon glyphicon-erase"></span>
							      Eliminar
							    </button>
							   --> 
							    <form action="menu-addArticulo" id="frm-add-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="menu-edit-client" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="delete-client" id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
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

<script type="text/javascript" class="init">
	

function listarArticulos(id){

	$("#frm-listar-articulos-"+id).submit();
	
	
	
}

function addArticulos(id){

	$("#frm-add-"+id).submit();
	
	
	
}


$(document).ready(function() {
$('#table-MstClient').DataTable({
			order: [[ 4, 'desc' ]],	
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
	
var dataString = $("#frm-del-"+id).serialize();
$.ajax({
    url: 'delete-client',
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

<jsp:include page="navbar-control-clientes.jsp" />