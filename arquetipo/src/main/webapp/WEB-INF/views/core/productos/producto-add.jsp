<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo producto</h2>
			</div>

<form id="frm-add-producto">
	<div class="form-group ">
 <label for="ref">REF</label>
<br>
<input type="text" name="ref" class="form-control" id="ref">
</div>
	<div class="form-group ">
 <label for="nombre">NOMBRE</label>
<br>
<input type="text" name="nombre" class="form-control" id="nombre">
</div>
	<div class="form-group ">
 <label for="precio">PRECIO</label>
<br>
<input type="text" name="precio" class="form-control" id="precio">
</div>
	<div class="form-group ">
 <label for="stock">STOCK</label>
<br>
<input type="text" name="stock" class="form-control" id="stock">
</div>
	<div class="form-group" >
    
<label>PROVEEDOR</label>
<br>
<select name="proveedor" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.nombre}</option>
  </c:forEach>
</select>
   
</div>

<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>



</div>
<jsp:include page="navbar-control-producto.jsp" />