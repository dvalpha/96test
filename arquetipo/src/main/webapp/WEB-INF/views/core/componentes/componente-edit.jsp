<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de archivo</h2>
			</div>

<form id="frm-update-componente">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	

	<div class="form-group">
<label for="nombre">NOMBRE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nombre}"></c:out>" name="nombre" class="form-control" id="nombre">
</div>
	<div class="form-group">
<label for="codigo">CODIGO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.codigo}"></c:out>" name="codigo" class="form-control" id="codigo">
</div>

<button class="btn btn-primry">Actualizar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>


<!-- FIN BODY -->
		</div>
	<jsp:include page="navbar-control-componente.jsp" />