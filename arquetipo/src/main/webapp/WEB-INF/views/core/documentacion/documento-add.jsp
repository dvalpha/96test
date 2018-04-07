<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo Documento</h2>
			</div>

<!-- CODIGO AQUI -->
 
<form id="frm-add-documento">
	<div class="form-group ">
 <label for="titulo">TITULO</label>
<br>
<input type="text" name="titulo" class="form-control" id="titulo">
</div>
	<div class="form-group ">
 <label for="cuerpo">CUERPO</label>
<br>
<textarea class="mce" name="cuerpo" id="cuerpo"></textarea>
</div>
	<div class="form-group ">
 <label for="autor">AUTOR</label>
<br>
<input type="text" name="autor" class="form-control" id="autor" value="<c:out value="${sessionScope.user.nombre}"></c:out> <c:out value="${sessionScope.user.apellidos}"></c:out>">
</div>
	<div class="form-group" >
    
<label>CATEGORIA</label>
<br>
<select name="categoria" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.titulo} [${elemento.libro.titulo}]</option>
  </c:forEach>
</select>
   
</div>

<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

<!-- FIN BODY -->
		</div>
	
<jsp:include page="navbar-control-documentacion.jsp" />

</body>
</html>