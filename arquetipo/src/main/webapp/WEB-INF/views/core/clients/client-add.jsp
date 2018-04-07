<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Agregar Cliente</h2>
			
			
<form id="frm-add-client">

<div class="col-md-3">
	
	<div class="form-group ">
 <label for="nomclifiscal">NOM.FISCAL</label>
<br>
<input type="text" name="nomclifiscal" class="form-control" id="nomclifiscal">
</div>
	<div class="form-group ">
 <label for="nomclicom">NOM.CLIENT</label>
<br>
<input type="text" name="nomclicom" class="form-control" id="nomclicom">
</div>
	<div class="form-group ">
 <label for="carrercli">CALLE</label>
<br>
<input type="text" name="carrercli" class="form-control" id="carrercli">
</div>
	<div class="form-group ">
 <label for="codposcli">CP</label>
<br>
<input type="text" name="codposcli" class="form-control" id="codposcli">
</div>
	<div class="form-group ">
 <label for="poblecli">POBLACIÓN</label>
<br>
<input type="text" name="poblecli" class="form-control" id="poblecli">
</div>
	<div class="form-group ">
 <label for="paiscli">PAIS</label>
<br>
<input type="text" name="paiscli" class="form-control" id="paiscli">
</div>
<div class="form-group ">
 <label for="abm">ABM</label>
<br>
<input type="text" name="abm" class="form-control" id="abm">
</div>

</div>

<div class="col-md-3">



	<div class="form-group ">
 <label for="provincli">PROVINCIA</label>
<br>
<input type="text" name="provincli" class="form-control" id="provincli">
</div>
	<div class="form-group ">
 <label for="nifcli">NIF</label>
<br>
<input type="text" name="nifcli" class="form-control" id="nifcli">
</div>
	<div class="form-group ">
 <label for="telefcli1">TELEFONO1</label>
<br>
<input type="text" name="telefcli1" class="form-control" id="telefcli1">
</div>
	<div class="form-group ">
 <label for="telefcli2">TELEFONO2</label>
<br>
<input type="text" name="telefcli2" class="form-control" id="telefcli2">
</div>
	<div class="form-group ">
 <label for="mobilcli">MOBIL</label>
<br>
<input type="text" name="mobilcli" class="form-control" id="mobilcli">
</div>
	<div class="form-group ">
 <label for="faxcli">FAX</label>
<br>
<input type="text" name="faxcli" class="form-control" id="faxcli">
</div>
	<div class="form-group ">
 <label for="emailcli">EMAIL</label>
<br>
<input type="text" name="emailcli" class="form-control" id="emailcli">
</div>

</div>

<div class="col-md-3">
	<div class="form-group ">
 <label for="webcli">WEB</label>
<br>
<input type="text" name="webcli" class="form-control" id="webcli">
</div>
	<div class="form-group ">
 <label for="forpagcli">FORMA DE PAGO</label>
<br>
<input type="text" name="forpagcli" class="form-control" id="forpagcli">
</div>
	<div class="form-group ">
 <label for="nombanccli">BANCO</label>
<br>
<input type="text" name="nombanccli" class="form-control" id="nombanccli">
</div>
	<div class="form-group ">
 <label for="ctebanccli">N.CUENTA</label>
<br>
<input type="text" name="ctebanccli" class="form-control" id="ctebanccli">
</div>
	<div class="form-group ">
 <label for="diapag1cli">DIAS DE PAGO 1</label>
<br>
<input type="text" name="diapag1cli" class="form-control" id="diapag1cli">
</div>
	<div class="form-group ">
 <label for="diapag2cli">DIAS DE PAGO 2</label>
<br>
<input type="text" name="diapag2cli" class="form-control" id="diapag2cli">
</div>
	<div class="form-group ">
 <label for="pordteppcli">PORTES</label>
<br>
<input type="text" name="pordteppcli" class="form-control" id="pordteppcli">
</div>
</div>

<div class="col-md-3">
	<div class="form-group ">
 <label for="porfinancli">PORTES FINACIADO</label>
<br>
<input type="text" name="porfinancli" class="form-control" id="porfinancli">
</div>
	<div class="form-group ">
 <label for="porivacli">PORTES IVA</label>
<br>
<input type="text" name="porivacli" class="form-control" id="porivacli">
</div>
	<div class="form-group ">
 <label for="observacionscli">OBSERVACIONES</label>
<br>
<input type="text" name="observacionscli" class="form-control" id="observacionscli">
</div>
	<div class="form-group ">
 <label for="contaadress">OFICINA</label>
<br>
<input type="text" name="contaadress" class="form-control" id="contaadress">
</div>
	<div class="form-group ">
 <label for="contacontact">OFICINA CONTACTO</label>
<br>
<input type="text" name="contacontact" class="form-control" id="contacontact">
</div>
	
	
     
</div>

<div class="col-md-12">
   <button class="btn btn-primary">Agregar un cliente nuevo</button>
</div>


			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

</div>	

<jsp:include page="navbar-control-clientes.jsp" />
</body>
</html>			