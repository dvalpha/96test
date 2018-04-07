<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nueva Categoría</h2>
			</div>

<!-- CODIGO AQUI -->

<form id="frm-add-categorialibro">
	<div class="form-group ">
 <label for="titulo">TITULO</label>
<br>
<input type="text" name="titulo" class="form-control" id="titulo">
</div>
	<div class="form-group" >
    
<label>LIBRO Al QUE QUIERE ASOCIAR LA CATEGORÍA NUEVA</label>
<br>
<select name="libro" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.titulo}</option>
  </c:forEach>
</select>
   
</div>
	

<button class="btn btn-primry">Crear nueva categoría</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

<jsp:include page="navbar-control-documentacion.jsp" />