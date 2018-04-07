<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de categorías</h2>
			</div>

          <table id="table-MstCategoriaLibro" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Titulo de la categoría</th>
							<th>Documentos</th>
							<th>Libro</th>
							<th>Creación</th>
							<th>Orden</th>
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.list}">
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
							<td><c:out value="${bean.id}"></c:out></td>
							<td><c:out value="${bean.titulo}"></c:out></td>
							
							<td>
							<select class="form-control">
							<c:forEach var="doc" items="${bean.documentos}">
							
							<option><c:out value="${doc.titulo}"></c:out></option>
							</c:forEach>
							</select>
							</td>
							
							<td><c:out value="${bean.libro.titulo}"></c:out></td>
							
							<td><fmt:formatDate type = "date" value="${bean.creacion}" /></td>
							<td><c:out value="${bean.orden}"></c:out></td>
							<td>
							    <button class="btn btn-success btn-xs" onclick="editar(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-edit"></span>
							     Editar
							    </button>
							    <button class="btn btn-danger btn-xs" onclick="borrar(<c:out value="${bean.id}"></c:out>)">
							     <span class="glyphicon glyphicon-erase"></span>
							      Eliminar
							    </button>							    <form action="menu-edit-categorialibro" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="delete-categorialibro" id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
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


<jsp:include page="../includes/list-reorder.jsp" />
      </div>
   


<script type="text/javascript" class="init">
	

$(document).ready(function() {
$('#table-MstCategoriaLibro').DataTable({
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
	
var dataString = $("#frm-del-"+id).serialize();
$.ajax({
    url: 'delete-categorialibro',
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

<jsp:include page="navbar-control-documentacion.jsp" />