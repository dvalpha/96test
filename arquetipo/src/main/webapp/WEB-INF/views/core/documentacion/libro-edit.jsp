<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Editar Libro</h2>
			</div>

<!-- CODIGO AQUI -->

<form id="frm-update-libro">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	<div class="form-group">
<label for="titulo">TITULO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.titulo}"></c:out>" name="titulo" class="form-control" id="titulo">
</div>
	

<button class="btn btn-primry">Actualizar</button>
</form>
<div class="form-group" >
    
<label>CATEGORIAS ASOCIADAS A ESTE LIBRO</label>
<br>
<select name="categorias" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.titulo}</option>
  </c:forEach>
</select>
   
</div>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>


<!-- FIN BODY -->
		</div>
<jsp:include page="navbar-control-documentacion.jsp" />	