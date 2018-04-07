<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de producto</h2>
			</div>
<form id="frm-update-producto">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	<div class="form-group">
<label for="ref">REF</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.ref}"></c:out>" name="ref" class="form-control" id="ref">
</div>
	<div class="form-group">
<label for="nombre">NOMBRE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nombre}"></c:out>" name="nombre" class="form-control" id="nombre">
</div>
	<div class="form-group">
<label for="precio">PRECIO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.precio}"></c:out>" name="precio" class="form-control" id="precio">
</div>
	<div class="form-group">
<label for="stock">STOCK</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.stock}"></c:out>" name="stock" class="form-control" id="stock">
</div>
	<div class="form-group" >
    
<label>PROVEEDOR</label>
<br>
<select name="proveedor" class="form-control " >
<option value="${requestScope.object.id}">${requestScope.object.proveedor.nombre} [Actual]</option>
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.nombre}</option>
  </c:forEach>
</select>
   
</div>

<button class="btn btn-primry">Actualizar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>
		</div>
<jsp:include page="navbar-control-producto.jsp" />