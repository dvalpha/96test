<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">
			<div class="col-xs-4">
				<h1>Editar albaran</h1>
			</div>
			<div class="col-xs-8">
			<img id="foto-form" class="img img-responsive col-xs-2 pull-right" src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/documentos.gif" class="thumbnail" >
			
			</div>	
			</div>


<form id="frm-update-clialb">
<div class="col-xs-3">
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	
<div class="form-group" >
<label for="seralb">SERIE ALBARAN</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.seralb}"></c:out>" name="seralb" class="form-control" id="seralb" >
</div>
<div class="form-group">
<label for="serfra">SERIE FACTURA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.serfra}"></c:out>" name="serfra" class="form-control" id="serfra">
</div>
<div class="form-group">
<label for="numfra">NUM.FACTURA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.numfra}"></c:out>" name="numfra" class="form-control" id="numfra" disabled>
</div>
	<div class="form-group">
<label for="numalb">NUM.ALBARAN</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.numalb}"></c:out>" name="numalb" class="form-control" id="numalb" disabled>
</div>
	<div class="form-group">
<label for="fechaalb">FECHA ALBARAN</label>
<br>
<input type="text" value="<fmt:formatDate pattern = "yyyy-MM-dd" 
         value = "${requestScope.object.fechaalb}" />" name="fechaalb" class="form-control" id="fechaalb" disabled>
</div>
	
	
<input type="hidden" value="<c:out value="${requestScope.object.codclient}"></c:out>" name="codclient" class="form-control" id="codclient">


</div>
<div class="col-xs-3">
	<div class="form-group">
<label for="nomcli">NOMBRE CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nomcli}"></c:out>" name="nomcli" class="form-control" id="nomcli" disabled>
</div>
	<div class="form-group">
<label for="dircli">DIR.CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.dircli}"></c:out>" name="dircli" class="form-control" id="dircli" disabled>
</div>
	<div class="form-group">
<label for="pobcli">POB.CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.pobcli}"></c:out>" name="pobcli" class="form-control" id="pobcli" disabled>
</div>
	<div class="form-group">
<label for="codpos">CP</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.codpos}"></c:out>" name="codpos" class="form-control" id="codpos" disabled>
</div>
	<div class="form-group">
<label for="coddir">COD.DIRECCION</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.coddir}"></c:out>" name="coddir" class="form-control" id="coddir">
</div>


</div>
<div class="col-xs-3">
	<div class="form-group">
<label for="nomclidir">ENVIO NOM. CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nomclidir}"></c:out>" name="nomclidir" class="form-control" id="nomclidir">
</div>
	<div class="form-group">
<label for="dirclidir">ENVIO DIR. CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.dirclidir}"></c:out>" name="dirclidir" class="form-control" id="dirclidir">
</div>
	<div class="form-group">
<label for="pobclidir">ENVIO POB.CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.pobclidir}"></c:out>" name="pobclidir" class="form-control" id="pobclidir">
</div>
	<div class="form-group">
<label for="codposdir">ENVIO CP CLIENTE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.codposdir}"></c:out>" name="codposdir" class="form-control" id="codposdir">
</div>
	<div class="form-group">
<label for="clicmda">CLICMDA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.clicmda}"></c:out>" name="clicmda" class="form-control" id="clicmda">
</div>

</div>
<div class="col-xs-3">
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
	
	
</div>
<div class="col-xs-3">
<button class="btn btn-warning col-lg-12">Actualizar</button>
</div>			
</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

<!-- FIN BODY -->
		</div>
	<jsp:include page="navbar-control-componente.jsp" />