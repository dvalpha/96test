<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo Componente</h2>
			</div>

<form id="frm-add-componente">
	
	<div class="form-group ">
 <label for="nombre">NOMBRE</label>
<br>
<input type="text" name="nombre" class="form-control" id="nombre">
</div>
	<div class="form-group ">
 <label for="codigo">CODIGO</label>
<br>
<input type="text" name="codigo" class="form-control" id="codigo">
</div>

<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>



<jsp:include page="navbar-control-componente.jsp" />