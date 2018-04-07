<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de albaranes</h2>
			</div>


<form id="frm-update-clialb">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	<div class="form-group">
<label for="seralb">SERALB</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.seralb}"></c:out>" name="seralb" class="form-control" id="seralb">
</div>
	<div class="form-group">
<label for="numalb">NUMALB</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.numalb}"></c:out>" name="numalb" class="form-control" id="numalb">
</div>
	<div class="form-group">
<label for="fechaalb">FECHAALB</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.fechaalb}"></c:out>" name="fechaalb" class="form-control" id="fechaalb">
</div>
	<div class="form-group">
<label for="codclient">CODCLIENT</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.codclient}"></c:out>" name="codclient" class="form-control" id="codclient">
</div>
	<div class="form-group">
<label for="nomcli">NOMCLI</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nomcli}"></c:out>" name="nomcli" class="form-control" id="nomcli">
</div>
	<div class="form-group">
<label for="dircli">DIRCLI</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.dircli}"></c:out>" name="dircli" class="form-control" id="dircli">
</div>
	<div class="form-group">
<label for="pobcli">POBCLI</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.pobcli}"></c:out>" name="pobcli" class="form-control" id="pobcli">
</div>
	<div class="form-group">
<label for="codpos">CODPOS</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.codpos}"></c:out>" name="codpos" class="form-control" id="codpos">
</div>
	<div class="form-group">
<label for="coddir">CODDIR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.coddir}"></c:out>" name="coddir" class="form-control" id="coddir">
</div>
	<div class="form-group">
<label for="nomclidir">NOMCLIDIR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nomclidir}"></c:out>" name="nomclidir" class="form-control" id="nomclidir">
</div>
	<div class="form-group">
<label for="dirclidir">DIRCLIDIR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.dirclidir}"></c:out>" name="dirclidir" class="form-control" id="dirclidir">
</div>
	<div class="form-group">
<label for="pobclidir">POBCLIDIR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.pobclidir}"></c:out>" name="pobclidir" class="form-control" id="pobclidir">
</div>
	<div class="form-group">
<label for="codposdir">CODPOSDIR</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.codposdir}"></c:out>" name="codposdir" class="form-control" id="codposdir">
</div>
	<div class="form-group">
<label for="clicmda">CLICMDA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.clicmda}"></c:out>" name="clicmda" class="form-control" id="clicmda">
</div>
	<div class="form-group">
<label for="contalinies">CONTALINIES</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.contalinies}"></c:out>" name="contalinies" class="form-control" id="contalinies">
</div>
	<div class="form-group">
<label for="semana1">SEMANA1</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.semana1}"></c:out>" name="semana1" class="form-control" id="semana1">
</div>
	<div class="form-group">
<label for="semana2">SEMANA2</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.semana2}"></c:out>" name="semana2" class="form-control" id="semana2">
</div>
	<div class="form-group">
<label for="semana3">SEMANA3</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.semana3}"></c:out>" name="semana3" class="form-control" id="semana3">
</div>
	<div class="form-group">
<label for="serfra">SERFRA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.serfra}"></c:out>" name="serfra" class="form-control" id="serfra">
</div>
	<div class="form-group">
<label for="numfra">NUMFRA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.numfra}"></c:out>" name="numfra" class="form-control" id="numfra">
</div>

<button class="btn btn-primry">Actualizar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

<!-- FIN BODY -->
		</div>
	<jsp:include page="navbar-control-componente.jsp" />