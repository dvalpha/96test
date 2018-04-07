<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Edición de clientes</h2>
			</div>
			
			
		
<form id="frm-update-client">
<div class="col-md-3">
		<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	
		<input type="hidden" name="codclient" id="codclient" value="<c:out value="${requestScope.object.codclient}"></c:out>">	
			<div class="form-group">
		<label for="nomclifiscal">NOM.FISCAL</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.nomclifiscal}"></c:out>" name="nomclifiscal" class="form-control" id="nomclifiscal">
		</div>
			<div class="form-group">
		<label for="nomclicom">NOM.CLIENT</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.nomclicom}"></c:out>" name="nomclicom" class="form-control" id="nomclicom">
		</div>
			<div class="form-group">
		<label for="carrercli">CALLE</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.carrercli}"></c:out>" name="carrercli" class="form-control" id="carrercli">
		</div>
			<div class="form-group">
		<label for="codposcli">CP</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.codposcli}"></c:out>" name="codposcli" class="form-control" id="codposcli">
		</div>
			<div class="form-group">
		<label for="poblecli">POBLACIÓN</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.poblecli}"></c:out>" name="poblecli" class="form-control" id="poblecli">
		</div>
			<div class="form-group">
		<label for="paiscli">PAIS</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.paiscli}"></c:out>" name="paiscli" class="form-control" id="paiscli">
		</div>
		<div class="form-group">
		<label for="abm">ABM</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.abm}"></c:out>" name="abm" class="form-control" id="abm">
		</div>

</div>

<div class="col-md-3">

			<div class="form-group">
		<label for="provincli">PROVINCIA</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.provincli}"></c:out>" name="provincli" class="form-control" id="provincli">
		</div>
			<div class="form-group">
		<label for="nifcli">NIF</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.nifcli}"></c:out>" name="nifcli" class="form-control" id="nifcli">
		</div>
			<div class="form-group">
		<label for="telefcli1">TELEFONO1</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.telefcli1}"></c:out>" name="telefcli1" class="form-control" id="telefcli1">
		</div>
			<div class="form-group">
		<label for="telefcli2">TELEFONO2</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.telefcli2}"></c:out>" name="telefcli2" class="form-control" id="telefcli2">
		</div>
			<div class="form-group">
		<label for="mobilcli">MOBIL</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.mobilcli}"></c:out>" name="mobilcli" class="form-control" id="mobilcli">
		</div>
			<div class="form-group">
		<label for="faxcli">FAX</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.faxcli}"></c:out>" name="faxcli" class="form-control" id="faxcli">
		</div>
			<div class="form-group">
		<label for="emailcli">EMAIL</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.emailcli}"></c:out>" name="emailcli" class="form-control" id="emailcli">
		</div>
		
	
	
	</div>

<div class="col-md-3">
	
	
		<div class="form-group">	
		<label for="webcli">WEB</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.webcli}"></c:out>" name="webcli" class="form-control" id="webcli">
		</div>
			<div class="form-group">
		<label for="forpagcli">FORMA DE PAGO</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.forpagcli}"></c:out>" name="forpagcli" class="form-control" id="forpagcli">
		</div>
			<div class="form-group">
		<label for="nombanccli">BANCO</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.nombanccli}"></c:out>" name="nombanccli" class="form-control" id="nombanccli">
		</div>
			<div class="form-group">
		<label for="ctebanccli">N.CUENTA</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.ctebanccli}"></c:out>" name="ctebanccli" class="form-control" id="ctebanccli">
		</div>
			<div class="form-group">
		<label for="diapag1cli">DIAS DE PAGO 1</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.diapag1cli}"></c:out>" name="diapag1cli" class="form-control" id="diapag1cli">
		</div>
			<div class="form-group">
		<label for="diapag2cli">DIAS DE PAGO 2</label>
		<br>
		<input type="text" value="<c:out value="${requestScope.object.diapag2cli}"></c:out>" name="diapag2cli" class="form-control" id="diapag2cli">
		</div>
		<div class="form-group">
<label for="pordteppcli">PORTES</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.pordteppcli}"></c:out>" name="pordteppcli" class="form-control" id="pordteppcli">
</div>
		
	</div>

<div class="col-md-3">
		
		
	
	<div class="form-group">
<label for="porfinancli">PORTES FINACIADO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.porfinancli}"></c:out>" name="porfinancli" class="form-control" id="porfinancli">
</div>
	<div class="form-group">
<label for="porivacli">PORTES IVA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.porivacli}"></c:out>" name="porivacli" class="form-control" id="porivacli">
</div>
	<div class="form-group">
<label for="observacionscli">OBSERVACIONES</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.observacionscli}"></c:out>" name="observacionscli" class="form-control" id="observacionscli">
</div>
	<div class="form-group">
<label for="contaadress">OFICINA</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.contaadress}"></c:out>" name="contaadress" class="form-control" id="contaadress">
</div>
	<div class="form-group">
<label for="contacontact">OFICINA CONTACTO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.contacontact}"></c:out>" name="contacontact" class="form-control" id="contacontact">
</div>
	
</div>


<div class="col-md-12">
	
<button class="btn btn-primary">Actualizar datos del cliente</button>
</div>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>
			
</div>
<jsp:include page="navbar-control-clientes.jsp" />				