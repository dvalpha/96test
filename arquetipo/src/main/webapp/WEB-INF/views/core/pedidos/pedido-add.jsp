<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo pedido</h2>
				<p>Verifique el conjunto de elementos y el cliente seleccionado antes de realizar el pedido.</p>
			</div>


	
<div class="form-group" >
<label>CLIENTE</label>
<br>
<form id="frm-add-pedido" action="addPedido" method="post">
<input type="text" name="cliente-name" class="form-control" value="<c:out value="${requestScope.cliente.nombre}"></c:out>" disabled>
<input type="hidden" name="cliente-id" class="form-control" value="<c:out value="${requestScope.cliente.id}"></c:out>">   
</form>
</div>

<div class="form-group ">
 <label for="producto">PRODUCTOS</label>
<div class="col-md-12" id="tabla"></div>

</div>
<div id="boton">
<button class="btn btn-primry btn-xs" onclick="realizarPedido();">Realizar pedido</button>
</div>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>


</div>
<jsp:include page="navbar-control-pedidos.jsp" />
<script>

function realizarPedido(){
	
	
	  var dataString = $("#frm-add-pedido").serialize();
   	$.ajax({
      url: 'addPedido',
      type: 'POST',
      data: dataString, 
      success: function (response) {
      	$("#msg").removeClass("alert-info");
			$("#msg").addClass("alert-warning");
			$("#msg").animate({width: '330px', opacity: '0.8'}, "slow");
			$("#msg").text(response);
			$("#msg").animate({width: '200px', opacity: '0.8'}, "slow");
			$("#msg").removeClass("alert-warning");
			$("#msg").addClass("alert-info");
			$("#boton").html('<a href="list-pedido"><button class="btn btn-primry btn-xs" >Lista de pedidos</button></a>')         	
      },
      error: function (response) {
      	$("#msg").text("error");
      }
  });
	
	
	
	
	
	
}
cargarCarrito();
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