<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-md-8" id="column-a">
			<div class="col-lg-12">

				<h2>Edición de producto</h2>
			</div>


      <table id="table-MstProducto" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Ref</th>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Stock</th>
							<th>Proveedor</th>
							<th>Creación</th>
							<th>Seleccionar</th>
							<th>Controles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.list}">
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
							<td><c:out value="${bean.ref}"></c:out></td>
							<td><c:out value="${bean.nombre}"></c:out></td>
							<td><c:out value="${bean.precio}"></c:out></td>
							<td><c:out value="${bean.stock}"></c:out></td>
							<td><c:out value="${bean.proveedor.nombre}"></c:out></td>
							<td><fmt:formatDate type = "date" value="${bean.creacion}" /></td>
							<td>
							<button class="btn btn-info btn-xs" onclick="addToCart('<c:out value="${bean.nombre}"></c:out>',<c:out value="${bean.id}"></c:out>)">
							    +Add
							     <form action="add-to-cart" id="frm-add-to-cart<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							 </td>
							<td>
							    <button class="btn btn-success btn-xs" style="width:90px;"onclick="editar(<c:out value="${bean.id}"></c:out>)">
							    <span class="glyphicon glyphicon-edit"></span>
							     Editar
							    </button>
							    
							    <button class="btn btn-danger btn-xs" style="width:90px;" onclick="borrar(<c:out value="${bean.id}"></c:out>)">
							     <span class="glyphicon glyphicon-erase"></span>
							      Eliminar
							    </button>
							    <form action="menu-edit-producto" id="frm-<c:out value="${bean.id}"></c:out>" method="post">
							    <input type="hidden" name="id" value="<c:out value="${bean.id}"></c:out>">
							    </form>
							    <form action="delete-producto" id="frm-del-<c:out value="${bean.id}"></c:out>" method="post">
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
	</div>		
<div class="col-md-2 thumbnail productos" id="column-b">
<h4 onclick="espandir();" style="margin-top:40px; padding:20px;">Productos seleccionados</h4>

 <div class="col-md-12" id="tabla"></div>

</div>			
			

<script type="text/javascript" class="init">
cargarCarrito();	
function espandir(){

	$("#column-a").toggleClass('col-md-8 col-md-6');
	$("#column-b").toggleClass('col-md-2 col-md-4');

}	


function borrarDelCarrito(id){
var dataString ={"id":id};
	
	$.ajax({
	    url: 'delete-to-cart',
	    type: 'POST',
	    data: dataString, 
	    success: function (response) {
	       
	    	$("#tabla").html(response);
	    	
	    	
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	
}

$(document).ready(function() {
$('#table-MstProducto').DataTable({
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

function addToCart(nombre,id){
	
	$.confirm({
	    title: 'Unidades de producto',
	    content: '<h3>'+nombre+'</h3>' +
	    '<form action="" >' +
	    '<div class="form-group">' +
	    '<label>Indique la cantidad de unidades para este producto</label>' +
	    '<input type="text" placeholder="cantidad" class="cantidad form-control"  required />' +
	    '</div>' +
	    '</form>',
	    buttons: {
	        formSubmit: {
	            text: 'seleccionar',
	            btnClass: 'btn-blue',
	            action: function () {
	                var cantidad = this.$content.find('.cantidad').val();
	                if(!cantidad){
	                    $.alert('no es una cantidad valida');
	                    return false;
	                }else{
	                	if(validarSiNumero(cantidad)){
	                	enviarAlCarrito(id,cantidad);
	                	}
	                }
	               
	            }
	        },
	        cancel: function () {
	            //close
	        },
	    },
	    onContentReady: function () {
	        // bind to events
	        var jc = this;
	        this.$content.find('form').on('submit', function (e) {
	            // if the user submits the form by pressing enter in the field.
	            e.preventDefault();
	            jc.$$formSubmit.trigger('click'); // reference the button and click it
	        });
	    }
	});
	
	
}

function enviarAlCarrito(id,cantidad){
	var dataString ={"id":id,"cantidad":cantidad};
	
	$.ajax({
	    url: 'add-to-cart',
	    type: 'POST',
	    data: dataString, 
	    success: function (response) {
	       
	    	$("#tabla").html(response);
	    	
	    	
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	
}


function cargarCarrito(){
	
	
	$.ajax({
	    url: 'get-cart-items',
	    type: 'POST',
	    success: function (response) {
	       
	    	$("#tabla").html(response);
	    	
	    	
	    },
	    error: function (response) {
	    	$("#msg").text("error");
	    }
	});	
	
}


function validarSiNumero(numero){
	var b=false;
    if (!/^([0-9])*$/.test(numero)){
      $.alert("El valor " + numero + " no es un número");
    }else{
    	b=true;
    }
    
    return b;
  }

function borrar(id){
	
var dataString = $("#frm-del-"+id).serialize();
$.ajax({
    url: 'delete-producto',
    type: 'POST',
    data: dataString, 
    success: function (response) {
   
    	$("#tabla").text(response);
    
    },
    error: function (response) {
    	$("#msg").text("error");
    }
});	
}

</script>

<style>
.productos{
background-color: #7d9cb7;
color:#fff;
}
.productos table td{

color:#fff;
}
</style>

</div>
<jsp:include page="navbar-control-producto.jsp" />