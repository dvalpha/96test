<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de clientes</h2>
			</div>
			
			
		<form id="frm-update-cliente">
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
<label for="nif">NIF</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nif}"></c:out>" name="nif" class="form-control" id="nif">
</div>
	<div class="form-group">
<label for="mail">MAIL</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.mail}"></c:out>" name="mail" class="form-control" id="mail">
</div>
	<div class="form-group">
<label for="avatar">AVATAR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.avatar}"></c:out>" name="avatar" class="form-control" id="avatar">
</div>
	
<button class="btn btn-primry">Actualizar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>	
			
			
			
</div>
<jsp:include page="navbar-control-clientes.jsp" />				