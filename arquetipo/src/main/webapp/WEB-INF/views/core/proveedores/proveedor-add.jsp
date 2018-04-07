<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo proveedor</h2>
			</div>

<form id="frm-add-proveedor">
	<div class="form-group ">
 <label for="ref">REF</label>
<br>
<input type="text" name="ref" class="form-control" id="ref">
</div>
	<div class="form-group ">
 <label for="nombre">NOMBRE</label>
<br>
<input type="text" name="nombre" class="form-control" id="nombre">
</div>
	<div class="form-group ">
 <label for="nif">NIF</label>
<br>
<input type="text" name="nif" class="form-control" id="nif">
</div>
	<div class="form-group ">
 <label for="mail">MAIL</label>
<br>
<input type="text" name="mail" class="form-control" id="mail">
</div>
	<div class="form-group ">
 <label for="avatar">AVATAR</label>
<br>
<input type="text" name="avatar" class="form-control" id="avatar">
</div>
	<div class="form-group" >
    

   
</div>

<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>




<jsp:include page="navbar-control-proveedores.jsp" />