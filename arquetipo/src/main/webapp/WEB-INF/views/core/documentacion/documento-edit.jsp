<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de documentos</h2>
			</div>

<!-- CODIGO AQUI -->

<form id="frm-update-documento">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	<div class="form-group">
<label for="titulo">TITULO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.titulo}"></c:out>" name="titulo" class="form-control" id="titulo">
</div>
	<div class="form-group">
<label for="cuerpo">CUERPO</label>
<br>
<textarea name="cuerpo" class="mce" id="cuerpo"><c:out value="${requestScope.object.cuerpo}"></c:out></textarea>
</div>
	<div class="form-group">
<label for="autor">AUTOR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.autor}"></c:out>" name="autor" class="form-control" id="autor">
</div>
	<div class="form-group" >
    
<label>CATEGORIA</label>
<br>
<select name="categoria" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.titulo}</option>
  </c:forEach>
</select>
   
</div>

<button class="btn btn-primry">Actualizar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>


<!-- FIN BODY -->
		</div>
<jsp:include page="navbar-control-documentacion.jsp" />	