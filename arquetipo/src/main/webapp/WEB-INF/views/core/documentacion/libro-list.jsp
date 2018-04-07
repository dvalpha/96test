<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Lista de libros</h2>
			</div>

<!-- CODIGO AQUI -->

	<table id="table-MstLibro" class="table table-condensed table-hover"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Categorias</th>
				<th>Creación</th>
				<th>Controles</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bean" items="${requestScope.list}">
				<tr id="tr-<c:out value="${bean.id}"></c:out>">
					<td><c:out value="${bean.id}"></c:out></td>
					<td><c:out value="${bean.titulo}"></c:out></td>
					<td>
						<div class="dropdown  col-lg-10">
							<button class="btn btn-primary btn-md dropdown-toggle col-lg-12" type="button" data-toggle="dropdown">
								Categorías asociadas 
								
								<span class="badge pull-right"> 
								<c:out value="${fn:length(bean.categorias)}"></c:out>
								</span>
							</button>
							<table class="dropdown-menu table-hover col-lg-12"  >
								<thead>
									<tr>
										<th>Categoria</th>
										
										<th>Controles</th>
										<th>Documentos</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="categoria" items="${bean.categorias}">
										<form action="menu-edit-categorialibro" method="post">
										<tr>
											<td>
											<c:out value="${categoria.titulo}"></c:out> 
											<input type="hidden" name="id" value="<c:out value="${categoria.id}"></c:out>">
	
											</td>
											
											<td>
												<button class="btn btn-success btn-xs pull-right">Editar</button>


											</td>
											<td class="text-center">
											<span class="alert-warning badge "><c:out value="${fn:length(categoria.documentos)}"></c:out> </span>
											
	
											</td>
										</tr>
										</form>


									</c:forEach>
								</tbody>
							</table>
						</div>

					</td>
					<td><fmt:formatDate type="date" value="${bean.creacion}" /></td>
					<td>
						<button class="btn btn-primary btn-xs"
							onclick="editar(<c:out value="${bean.id}"></c:out>)">
							<span class="glyphicon glyphicon-edit"></span> Editar
						</button>
						
						<button class="btn btn-success btn-xs"
							onclick="crearDocumento(<c:out value="${bean.id}"></c:out>)">
							<span class="glyphicon glyphicon-edit"></span> Nuevo documento
						</button>
						<button class="btn btn-success btn-xs"
							onclick="crearCategoria(<c:out value="${bean.id}"></c:out>)">
							<span class="glyphicon glyphicon-edit"></span> Nueva categoría
						</button>
						<button class="btn btn-warning btn-xs"
							onclick="toPdf(<c:out value="${bean.id}"></c:out>)">
							<span class="glyphicon glyphicon-edit"></span> Crear PDF
						</button>
						<button class="btn btn-danger btn-xs"
							onclick="borrar(<c:out value="${bean.id}"></c:out>)">
							<span class="glyphicon glyphicon-erase"></span> Eliminar
						</button>
						<form action="menu-add-documento-libro"
							id="frm-doc-<c:out value="${bean.id}"></c:out>" method="post">
							<input type="hidden" name="id"
								value="<c:out value="${bean.id}"></c:out>">
						</form>
						<form action="menu-add-categoria-libro"
							id="frm-cat-<c:out value="${bean.id}"></c:out>" method="post">
							<input type="hidden" name="id"
								value="<c:out value="${bean.id}"></c:out>">
						</form>
						<form action="menu-edit-libro"
							id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							<input type="hidden" name="id"
								value="<c:out value="${bean.id}"></c:out>">
						</form>
						<form action="delete-libro"
							id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
							<input type="hidden" name="id"
								value="<c:out value="${bean.id}"></c:out>">
						</form>
						
						<form 
							id="frm-to-pdf-<c:out value="${bean.id}"></c:out>" method="post">
							<input type="hidden" name="id"
								value="<c:out value="${bean.id}"></c:out>">
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

<jsp:include page="../includes/list-reorder.jsp" />




	<script type="text/javascript" class="init">
function crearDocumento(id){
	var idform="#frm-doc-"+id;
	$(idform).submit();
}

function crearCategoria(id){
	var idform="#frm-cat-"+id;
	$(idform).submit();
}

$(document).ready(function() {
$('#table-MstLibro').DataTable({
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

function toPdf(id){
	var dataString = $("#frm-to-pdf-"+id).serialize();
	$.ajax({
	    url: 'toPdf',
	    type: 'POST',
	    data: dataString, 
	    success: function (response) {
	    $("#msg").removeClass("alert-info");
	    	$("#msg").addClass("alert-warning");
	    	$("#msg").animate({width: '830px', opacity: '0.8'}, "slow");
	    	
	    	
	    	
	    	$("#msg").text("Documento generado");
	    	
	    	$("#msg").animate({width: '700px', opacity: '0.8'}, "slow");
	    	$("#msg").removeClass("alert-warning");
	    	$("#msg").addClass("alert-info");   
	    	
	    	window.open(response, '_blank');
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	}

function borrar(id){
	
var dataString = $("#frm-del-"+id).serialize();
$.ajax({
    url: 'delete-libro',
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




	<!-- FIN BODY -->
		</div>
	<jsp:include page="navbar-control-documentacion.jsp" />


</body>
</html>