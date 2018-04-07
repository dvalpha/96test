<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo Albaran</h2>
			</div>

<form id="frm-add-clialb">
<div class="col-xs-3">
<div class="form-group ">
 <label for="seralb">SERALB</label>
<br>
<select name="seralb" class="form-control" id="seralb">
<option value="A">A</option>
<option value="O">O</option>
</select>

</div>
	<div class="form-group ">
 <label for="numalb">NUMALB</label>
<br>
<input type="text" name="numalb" class="form-control" id="numalb" value='<c:out value="${requestScope.numalb}"></c:out>' disabled>
</div>
	<div class="form-group ">
 <label for="fechaalb">FECHAALB</label>
<br>
<input type="text" name="fechaalb" class="form-control" id="fechaalb">
</div>
	<div class="form-group ">
 <label for="codclient">CODCLIENT</label>
<br>
<input type="text" name="codclient" class="form-control" id="codclient">
</div>
	<div class="form-group ">
 <label for="nomcli">NOMCLI</label>
<br>
<input type="text" name="nomcli" class="form-control" id="nomcli">
</div>
</div>


<div class="col-xs-3">
<div class="form-group ">
 <label for="dircli">DIRCLI</label>
<br>
<input type="text" name="dircli" class="form-control" id="dircli">
</div>
	<div class="form-group ">
 <label for="pobcli">POBCLI</label>
<br>
<input type="text" name="pobcli" class="form-control" id="pobcli">
</div>
	<div class="form-group ">
 <label for="codpos">CODPOS</label>
<br>
<input type="text" name="codpos" class="form-control" id="codpos">
</div>
	<div class="form-group ">
 <label for="coddir">CODDIR</label>
<br>
<input type="text" name="coddir" class="form-control" id="coddir">
</div>
	<div class="form-group ">
 <label for="nomclidir">NOMCLIDIR</label>
<br>
<input type="text" name="nomclidir" class="form-control" id="nomclidir">
</div>
</div>


<div class="col-xs-3">
<div class="form-group ">
 <label for="dirclidir">DIRCLIDIR</label>
<br>
<input type="text" name="dirclidir" class="form-control" id="dirclidir">
</div>
	<div class="form-group ">
 <label for="pobclidir">POBCLIDIR</label>
<br>
<input type="text" name="pobclidir" class="form-control" id="pobclidir">
</div>
	<div class="form-group ">
 <label for="codposdir">CODPOSDIR</label>
<br>
<input type="text" name="codposdir" class="form-control" id="codposdir">
</div>
	<div class="form-group ">
 <label for="clicmda">CLICMDA</label>
<br>
<input type="text" name="clicmda" class="form-control" id="clicmda">
</div>
	<div class="form-group ">
 <label for="contalinies">CONTALINIES</label>
<br>
<input type="text" name="contalinies" class="form-control" id="contalinies">
</div>
</div>



	
	<div class="col-xs-3">
	<div class="form-group ">
 <label for="semana1">SEMANA1</label>
<br>
<input type="text" name="semana1" class="form-control" id="semana1">
</div>
	<div class="form-group ">
 <label for="semana2">SEMANA2</label>
<br>
<input type="text" name="semana2" class="form-control" id="semana2">
</div>
	<div class="form-group ">
 <label for="semana3">SEMANA3</label>
<br>
<input type="text" name="semana3" class="form-control" id="semana3">
</div>
	<div class="form-group ">
 <label for="serfra">SERFRA</label>
<br>
<input type="text" name="serfra" class="form-control" id="serfra">
</div>
	<div class="form-group ">
 <label for="numfra">NUMFRA</label>
<br>
<input type="text" name="numfra" class="form-control" id="numfra">
</div>
</div>
<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>




<jsp:include page="navbar-control-componente.jsp" />