<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		<div class="col-sm-10">
			<div class="col-lg-12">
			<div class="col-lg-8">
                <a href="list-client"><span style="font-size:16px;">Volver a lista de clientes</span></a>
				<h3>Edición de artículos por cliente </h3>
			</div>
			<div class="col-lg-4">

				<span style="font-size:44px; color: #093750; " >${requestScope.list[0].cliente.nomclicom}</span>
			</div>
			</div>

				
 <table id="table-MstArticulo" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
						     
							<th>Código articulo</th>
							<th>Articulo</th>
							<th>Orden</th>
							<th>Modelo</th>
							<th>Cliente</th>
							
							<th>Opciones</th>
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.list}">
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
							
							<td><c:out value="${bean.codigo}"></c:out></td>
							<td><c:out value="${bean.articulo}"></c:out></td>
							<td><c:out value="${bean.ordenmod}"></c:out></td>
							<td><c:out value="${bean.modelo}"></c:out></td>
							<td><c:out value="${bean.cliente.nomclicom}"></c:out></td>
							
							<td>  
							<button class="btn btn-success btn-xs" onclick="listarComponentes(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-edit"></span>
							     Listar Componentes
							</button>
							<form action="list-componente" id="frm-listar-componentes-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							</td>
							<td>
							    <button class="btn btn-success btn-xs" onclick="editar(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-edit"></span>
							     Editar
							    </button>
							    <button class="btn btn-danger btn-xs" onclick="borrar(<c:out value="${bean.id}"></c:out>)">
							     <span class="glyphicon glyphicon-erase"></span>
							      Eliminar
							    </button>							    <form action="menu-edit-articulo" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="delete-articulo" id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
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
function listarComponentes(id){

	$("#frm-listar-componentes-"+id).submit();
	
	
	
}
	

$(document).ready(function() {
$('#table-MstArticulo').DataTable({
			order: [[ 2, 'asc' ]],	
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
    url: 'delete-articulo',
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
<jsp:include page="navbar-control-articulo.jsp" />