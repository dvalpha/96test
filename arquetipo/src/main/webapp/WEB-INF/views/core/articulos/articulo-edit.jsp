<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">
<div class="col-lg-4">			
<p>Menus</p>			
<p><a href="list-client"><span class="thumbnail col-xs-6" style="font-size:16px; background-color: #4890ce;color:#fff;" >Lista de clientes</span></a>
<a href="#" onclick="listarArticulos()"><span class="thumbnail col-xs-6"style="font-size:16px;  background-color: #ffa591;color:#fff;">Lista de articulos</span></a>

</p>
<h2>Edición de articulos</h2>
<form action="list-articulo" method="post" id="navigation">
<input type="hidden" name="id" value="${requestScope.object.cliente.id}">
</form>
 </div> 
 <div class="col-lg-8 text-center">	
				<h2><span class="thumbnail" style=" color:#337ab7;">${requestScope.object.cliente.nomclifiscal}</span></h2>
			</div>
</div> 


<form id="frm-update-articulo">



<div class="col-md-12">



<div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-body text-center" >
            
            <c:choose>
            <c:when test="${empty requestScope.object.imagen}">
             <img id="foto-form" class="img img-responsive" src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/design_800p.gif" class="thumbnail" >
         
            </c:when>
            <c:otherwise>
            <img id="foto-form" class="img img-responsive" src="<c:out value="${requestScope.object.imagen}" escapeXml="false"></c:out>" class="thumbnail" >
         
            </c:otherwise>
            </c:choose>
                      </div>
            <div class="panel-primary"> 
            </div> 
        </div> 
        <jsp:include page="../components/selector.jsp" /> 
</div>




<div class="col-md-4">

<!-- ID del articulo -->
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">
<!-- Imagen para setear -->
<input type="hidden" name="imagen" class="form-control" id="avatar" value="${requestScope.object.imagen}">	
<!-- ID del cliente al que pertenece el articulo -->
<input type="hidden" name="mstcliente" class="form-control" id="mstcliente" value="${requestScope.object.cliente.id}">
<!-- Codigo del cliente (tambien necesario) -->
<input type="hidden" name="codigoCliente" class="form-control" id="codigoCliente" value="<c:out value="${requestScope.object.codigoCliente}"></c:out>" >		
<!-- Código de articulo (el que se le asigno cuando se creo, no modificable) -->
<input type="hidden" name="codigo" class="form-control" id="codigo" value="<c:out value="${requestScope.object.codigo}"></c:out>" >		






<div class="form-group ">
 	<label for="articulo">ARTICULO</label>
	<br>
	<input type="text" name="articulo" class="form-control" id="articulo" value="<c:out value="${requestScope.object.articulo}"></c:out>">
</div>

<div class="form-group ">
 <label for="modelo">MODELO</label>
 <br>
 <input type="text" name="modelo" class="form-control" id="modelo" value="<c:out value="${requestScope.object.modelo}"></c:out>">
</div>

<div class="form-group ">
 <label for="artignifugo">Ignifugo</label>
 <br>
<select name="artignifugo" class="form-control" id="artignifugo">
<option value="<c:out value="${requestScope.object.artignifugo}"></c:out>">${requestScope.object.artignifugo} [Actual]</option>
<option value="N">No</option>
<option value="S">Si</option>
</select>

</div>
	<div class="form-group ">
 <label for="ordenmod">ORDEN</label>
<br>
<input type="text" name="ordenmod" class="form-control" id="ordenmod" value="<c:out value="${requestScope.object.ordenmod}"></c:out>">
</div>
<div class="form-group ">
 <label for="conlin">CONLIN</label>
<br>
<input type="text" name="conlin" class="form-control" id="conlin" value="<c:out value="${requestScope.object.conlin}"></c:out>">
</div>

	


</div>
<div class="col-md-4">

	<div class="form-group ">
 <label for="artnormesp">Norma Especial</label>
<br>
<select name="artnormesp" class="form-control" id="artnormesp">
<option value="<c:out value="${requestScope.object.artnormesp}"></c:out>">${requestScope.object.artnormesp} [Actual]</option>

<option value="N">Normal</option>
<option value="E">Especial</option>
</select>

</div>
	<div class="form-group ">
 <label for="artbasico">Básico</label>
<br>
<select name="artbasico" class="form-control" id="artbasico">
<option value="<c:out value="${requestScope.object.artbasico}"></c:out>">${requestScope.object.artbasico} [Actual]</option>

<option value="N">Normal</option>
<option value="B">Básico</option>
</select>

</div>
	<div class="form-group ">
 <label for="artlargo">ARTLARGO</label>
<br>
<input type="text" name="artlargo" class="form-control" id="artlargo" value="<c:out value="${requestScope.object.artlargo}"></c:out>">
</div>
	<div class="form-group ">
 <label for="artprvdef">ARTPRVDEF</label>
<br>
<select name="artprvdef" class="form-control" id="artprvdef">
<option value="<c:out value="${requestScope.object.artprvdef}"></c:out>">${requestScope.object.artprvdef} [Actual]</option>

<option value="D">D</option>
<option value="P">P</option>
</select>

</div>

<div class="form-group ">
 <label for="contmovstck">CONTMOVSTCK</label>
<br>
<input type="text" name="contmovstck" class="form-control" id="contmovstck" value="<c:out value="${requestScope.object.contmovstck}"></c:out>">
</div>

</div>

</div>
<div class="col-md-12">

<div class="col-md-1">
<div class="form-group ">
 <label for="cantdto1">CANTDTO1</label>
<br>
<input type="text" name="cantdto1" class="form-control" id="cantdto1" value="<c:out value="${requestScope.object.cantdto1}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto1">PORCDTO1</label>
<br>
<input type="text" name="porcdto1" class="form-control" id="porcdto1" value="<c:out value="${requestScope.object.porcdto1}"></c:out>">
</div>
</div>



<div class="col-md-1">
<div class="form-group ">
<label for="cantdto2">CANTDTO2</label>
<br>
<input type="text" name="cantdto2" class="form-control" id="cantdto2" value="<c:out value="${requestScope.object.cantdto2}"></c:out>">
</div>
<div class="form-group ">
 <label for="porcdto2">PORCDTO2</label>
<br>
<input type="text" name="porcdto2" class="form-control" id="porcdto2" value="<c:out value="${requestScope.object.porcdto2}"></c:out>">
</div>
</div>


<div class="col-md-1">
<div class="form-group ">
 <label for="pantdto3">PANTDTO3</label>
<br>
<input type="text" name="pantdto3" class="form-control" id="pantdto3" value="<c:out value="${requestScope.object.pantdto3}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto3">PORCDTO3</label>
<br>
<input type="text" name="porcdto3" class="form-control" id="porcdto3" value="<c:out value="${requestScope.object.porcdto3}"></c:out>">
</div>
</div>


<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto4">CANTDTO4</label>
<br>
<input type="text" name="cantdto4" class="form-control" id="cantdto4" value="<c:out value="${requestScope.object.cantdto4}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto4">PORCDTO4</label>
<br>
<input type="text" name="porcdto4" class="form-control" id="porcdto4" value="<c:out value="${requestScope.object.porcdto4}"></c:out>">
</div>
</div>


<div class="col-md-1">
<div class="form-group ">
 <label for="cantdto5">CANTDTO5</label>
<br>
<input type="text" name="cantdto5" class="form-control" id="cantdto5" value="<c:out value="${requestScope.object.cantdto5}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto5">PORCDTO5</label>
<br>
<input type="text" name="porcdto5" class="form-control" id="porcdto5" value="<c:out value="${requestScope.object.porcdto5}"></c:out>">
</div>
</div>


<div class="col-md-1">
<div class="form-group ">
 <label for="pantdto6">PANTDTO6</label>
<br>
<input type="text" name="pantdto6" class="form-control" id="pantdto6" value="<c:out value="${requestScope.object.pantdto6}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto6">PORCDTO6</label>
<br>
<input type="text" name="porcdto6" class="form-control" id="porcdto6" value="<c:out value="${requestScope.object.porcdto6}"></c:out>">
</div>
</div>



<div class="col-md-1">
<div class="form-group ">
 <label for="cantdto7">CANTDTO7</label>
<br>
<input type="text" name="cantdto7" class="form-control" id="cantdto7" value="<c:out value="${requestScope.object.cantdto7}"></c:out>">
</div>
<div class="form-group ">
 <label for="porcdto7">PORCDTO7</label>
<br>
<input type="text" name="porcdto7" class="form-control" id="porcdto7" value="<c:out value="${requestScope.object.porcdto7}"></c:out>">
</div>
</div>


<div class="col-md-1">
<div class="form-group ">
 <label for="cantdto8">CANTDTO8</label>
<br>
<input type="text" name="cantdto8" class="form-control" id="cantdto8" value="<c:out value="${requestScope.object.cantdto8}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto8">PORCDTO8</label>
<br>
<input type="text" name="porcdto8" class="form-control" id="porcdto8" value="<c:out value="${requestScope.object.porcdto8}"></c:out>">
</div>
</div>

<div class="col-md-1">
<div class="form-group ">
 <label for="cantdto9">CANTDTO9</label>
<br>
<input type="text" name="cantdto9" class="form-control" id="cantdto9" value="<c:out value="${requestScope.object.cantdto9}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto9">PORCDTO9</label>
<br>
<input type="text" name="porcdto9" class="form-control" id="porcdto9" value="<c:out value="${requestScope.object.porcdto9}"></c:out>">
</div>

</div>



<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto10">CANTDTO10</label>
<br>
<input type="text" name="cantdto10" class="form-control" id="cantdto10" value="<c:out value="${requestScope.object.cantdto10}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto10">PORCDTO10</label>
<br>
<input type="text" name="porcdto10" class="form-control" id="porcdto10" value="<c:out value="${requestScope.object.porcdto10}"></c:out>">
</div>

</div>



<div class="col-md-1">
	<div class="form-group ">
 <label for="cantdto11">CANTDTO11</label>
<br>
<input type="text" name="cantdto11" class="form-control" id="cantdto11" value="<c:out value="${requestScope.object.cantdto11}"></c:out>">
</div>
	<div class="form-group ">
 <label for="porcdto11">PORCDTO11</label>
<br>
<input type="text" name="porcdto11" class="form-control" id="porcdto11" value="<c:out value="${requestScope.object.porcdto11}"></c:out>">
</div>
</div>






<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>

</div>


</form>	

<div class="col-md-12">
<button class="btn btn-primary" onclick="update();">Actualizar articulos</button>
</div>	



<!-- CODIGO Actualizar AQUI -->


<script>
function listarArticulos(){
	$("#navigation").submit();
	
}
function update(){
	


	        //PARA FRM NO AJAX $("#frm-update-articulo").submit();
	var dataString = $("#frm-update-articulo").serialize();
	        	$.ajax({
	                url: 'update-articulo',
	                type: 'POST',
	                data: dataString, 
	                success: function (response) {
	                	$("#msg").removeClass("alert-info");
						$("#msg").addClass("alert-warning");
						$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
						$("#msg").text(response);
						$("#msg").animate({width: '100px', opacity: '0.8'}, "slow");
						$("#msg").removeClass("alert-warning");
						$("#msg").addClass("alert-info");
	                	                	
	                },
	                error: function (response) {
	                	$("#msg").text("error");
	                }
	            });
	        	

	
}


</script>



<!-- FIN BODY -->
	
	<jsp:include page="navbar-control-articulo.jsp" />