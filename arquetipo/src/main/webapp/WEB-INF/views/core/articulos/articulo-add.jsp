<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">
			
			
			<div class="col-lg-4">
			<p>Menus</p>			
<p><a href="list-client"><span class="thumbnail col-xs-6" style="font-size:16px; background-color: #4890ce;color:#fff;" >Lista de clientes</span></a>
<a href="#" onclick="listarArticulos()"><span class="thumbnail col-xs-6"style="font-size:16px;  background-color: #ffa591;color:#fff;">Lista de articulos</span></a>

</p>
				<h2>Agregar artículo</h2>
			</div>
			<div class="col-lg-8 text-center">	
				<h2><span class="thumbnail" style=" color:#337ab7;">${requestScope.cliente.nomclifiscal}</span></h2>
			</div>
    </div>
<div class="col-md-12">


<form id="frm-add-articulo">
<div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-body text-center" >
                    <img id="foto-form" class="img img-responsive" src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/design_800p.gif" class="thumbnail" >
            </div>
            <div class="panel-primary"> 
            </div> 
        </div> 
        <jsp:include page="../components/selector.jsp" /> 
</div>
<div class="col-md-4">
	<input type="hidden" name="imagen" class="form-control" id="avatar" value="">	
	<input type="hidden" name="idcliente" class="form-control" id="idcliente" value="${requestScope.idcliente}">	
<div class="form-group ">
 	<label for="articulo">ARTICULO</label>
	<br>
	<input type="text" name="articulo" class="form-control" id="articulo">
</div>

<div class="form-group ">
 <label for="modelo">MODELO</label>
 <br>
 <input type="text" name="modelo" class="form-control" id="modelo">
</div>

<div class="form-group ">
 <label for="artignifugo">Ignifugo</label>
 <br>
<select name="artignifugo" class="form-control" id="artignifugo">
<option value="N">No</option>
<option value="S">Si</option>
</select>

</div>
	<div class="form-group ">
 <label for="ordenmod">ORDEN</label>
<br>
<input type="text" name="ordenmod" class="form-control" id="ordenmod">
</div>
<div class="form-group ">
 <label for="conlin">CONLIN</label>
<br>
<input type="text" name="conlin" class="form-control" id="conlin">
</div>

	


</div>
<div class="col-md-4">

	<div class="form-group ">
 <label for="artnormesp">Norma Especial</label>
<br>
<select name="artnormesp" class="form-control" id="artnormesp">
<option value="N">Normal</option>
<option value="E">Especial</option>
</select>

</div>
	<div class="form-group ">
 <label for="artbasico">Básico</label>
<br>
<select name="artbasico" class="form-control" id="artbasico">
<option value="N">Normal</option>
<option value="B">Básico</option>
</select>

</div>
	<div class="form-group ">
 <label for="artlargo">ARTLARGO</label>
<br>
<input type="text" name="artlargo" class="form-control" id="artlargo">
</div>
	<div class="form-group ">
 <label for="artprvdef">ARTPRVDEF</label>
<br>
<select name="artprvdef" class="form-control" id="artprvdef">
<option value="D">D</option>
<option value="P">P</option>
</select>

</div>

<div class="form-group ">
 <label for="contmovstck">CONTMOVSTCK</label>
<br>
<input type="text" name="contmovstck" class="form-control" id="contmovstck">
</div>

</div>
</div>

<div class="col-md-1">
<div class="form-group ">
 <label for="cantdto1">CANTDTO1</label>
<br>
<input type="text" name="cantdto1" class="form-control" id="cantdto1">
</div>
	<div class="form-group ">
 <label for="porcdto1">PORCDTO1</label>
<br>
<input type="text" name="porcdto1" class="form-control" id="porcdto1">
</div>

</div>
<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto2">CANTDTO2</label>
<br>
<input type="text" name="cantdto2" class="form-control" id="cantdto2">
</div>
	<div class="form-group ">
 <label for="porcdto2">PORCDTO2</label>
<br>
<input type="text" name="porcdto2" class="form-control" id="porcdto2">
</div>

</div>
<div class="col-md-1">



	<div class="form-group ">
 <label for="pantdto3">PANTDTO3</label>
<br>
<input type="text" name="pantdto3" class="form-control" id="pantdto3">
</div>
	<div class="form-group ">
 <label for="porcdto3">PORCDTO3</label>
<br>
<input type="text" name="porcdto3" class="form-control" id="porcdto3">
</div>
</div>
<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto4">CANTDTO4</label>
<br>
<input type="text" name="cantdto4" class="form-control" id="cantdto4">
</div>
	<div class="form-group ">
 <label for="porcdto4">PORCDTO4</label>
<br>
<input type="text" name="porcdto4" class="form-control" id="porcdto4">
</div>

</div>
<div class="col-md-1">


	<div class="form-group ">
 <label for="cantdto5">CANTDTO5</label>
<br>
<input type="text" name="cantdto5" class="form-control" id="cantdto5">
</div>
	<div class="form-group ">
 <label for="porcdto5">PORCDTO5</label>
<br>
<input type="text" name="porcdto5" class="form-control" id="porcdto5">
</div>

</div>
<div class="col-md-1">



	<div class="form-group ">
 <label for="pantdto6">PANTDTO6</label>
<br>
<input type="text" name="pantdto6" class="form-control" id="pantdto6">
</div>
	<div class="form-group ">
 <label for="porcdto6">PORCDTO6</label>
<br>
<input type="text" name="porcdto6" class="form-control" id="porcdto6">
</div>


</div>
<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto7">CANTDTO7</label>
<br>
<input type="text" name="cantdto7" class="form-control" id="cantdto7">
</div>
	<div class="form-group ">
 <label for="porcdto7">PORCDTO7</label>
<br>
<input type="text" name="porcdto7" class="form-control" id="porcdto7">
</div>
</div>
<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto8">CANTDTO8</label>
<br>
<input type="text" name="cantdto8" class="form-control" id="cantdto8">
</div>
	<div class="form-group ">
 <label for="porcdto8">PORCDTO8</label>
<br>
<input type="text" name="porcdto8" class="form-control" id="porcdto8">
</div>

</div>
<div class="col-md-1">


	<div class="form-group ">
 <label for="cantdto9">CANTDTO9</label>
<br>
<input type="text" name="cantdto9" class="form-control" id="cantdto9">
</div>
	<div class="form-group ">
 <label for="porcdto9">PORCDTO9</label>
<br>
<input type="text" name="porcdto9" class="form-control" id="porcdto9">
</div>

</div>
<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto10">CANTDTO10</label>
<br>
<input type="text" name="cantdto10" class="form-control" id="cantdto10">
</div>
	<div class="form-group ">
 <label for="porcdto10">PORCDTO10</label>
<br>
<input type="text" name="porcdto10" class="form-control" id="porcdto10">
</div>

</div>
<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto11">CANTDTO11</label>
<br>
<input type="text" name="cantdto11" class="form-control" id="cantdto11">
</div>
	<div class="form-group ">
 <label for="porcdto11">PORCDTO11</label>
<br>
<input type="text" name="porcdto11" class="form-control" id="porcdto11">
</div>

</div>

	

<div class="col-md-12">
<button class="btn btn-primary">Crear artículo nuevo</button>
</div>	
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>
<script>

function listarArticulos(){
	$("#navigation").submit();
	
}
</script>
<jsp:include page="navbar-control-articulo.jsp" />