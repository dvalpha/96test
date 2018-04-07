<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Editar Restricción</h2>
			</div>

<!-- CODIGO AQUI -->

<form id="frm-update-url">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	<div class="form-group">
<label for="url">URL</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.url}"></c:out>" name="url" class="form-control" id="url">
</div>
	<div class="form-group">
<label for="modulo">MODULO</label>
<br>
<br>
<select name="modulo" class="form-control" id="modulo">
<option value="${requestScope.object.modulo}">${requestScope.object.modulo} [Actual]</option>
  <c:forEach var="elemento" items="${requestScope.modulos}">
      <option value="${elemento.nombre}">${elemento.nombre}</option>
  </c:forEach>
</select>

</div>
	<div class="form-group">
<label for="grupo">GRUPO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.grupo}"></c:out>" name="grupo" class="form-control" id="grupo">
</div>
	<div class="form-group">
<label for="level">LEVEL</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.level}"></c:out>" name="level" class="form-control" id="level">
</div>
	<div class="form-group">
<label for="comentario">COMENTARIO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.comentario}"></c:out>" name="comentario" class="form-control" id="comentario">
</div>

<button class="btn btn-primry">Actualizar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>
			

<!-- FIN BODY -->
		</div>
	<jsp:include page="navbar-control-roles.jsp" />