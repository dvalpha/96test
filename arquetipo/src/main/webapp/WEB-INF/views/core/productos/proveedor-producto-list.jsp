<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de productos por proveedor</h2>
				
				<p>Seleccione el proveedor para obtener la lista de sus productos</p>
			</div>


      <table id="table-MstProducto" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Ref</th>
							<th>Nombre</th>
							<th>Productos</th>
							<th>Creación</th>
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.list}">
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
							<td><c:out value="${bean.ref}"></c:out></td>
							<td><c:out value="${bean.nombre}"></c:out></td>
							<td>${fn:length(bean.productos)}</td>
							
							<td><fmt:formatDate type = "date" value="${bean.creacion}" /></td>
							<td>
							    <button class="btn btn-success btn-xs" onclick="listarProductosPorProveedor(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-edit"></span>
							     Listar productos
							    </button>
							     <form action="list-producto" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
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
	

$(document).ready(function() {
$('#table-MstProducto').DataTable({
			order: [[ 2, 'desc' ]],	
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

function listarProductosPorProveedor(id){
	
	var idform="#frm-"+id;
	$(idform).submit();
	
}



</script>



</div>
<jsp:include page="navbar-control-producto.jsp" />