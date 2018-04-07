<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Agregar Rol</h2>
			</div>

<!-- CODIGO AQUI -->

<form id="frm-add-rol">
	<div class="form-group ">
 <label for="nombre">NOMBRE</label>
<br>
<input type="text" name="nombre" class="form-control" id="nombre">
</div>
	
    


	<div class="form-group ">
 <label for="descripcion">DESCRIPCION</label>
<br>
<input type="text" name="descripcion" class="form-control" id="descripcion">
</div>
	

<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

			

<!-- FIN BODY -->
		</div>
	

<jsp:include page="navbar-control-roles.jsp" />
</body>
</html>