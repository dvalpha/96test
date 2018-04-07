<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo Libro</h2>
			</div>

<!-- CODIGO AQUI -->

<form id="frm-add-libro">
	<div class="form-group ">
 <label for="titulo">TITULO</label>
<br>
<input type="text" name="titulo" class="form-control" id="titulo">
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