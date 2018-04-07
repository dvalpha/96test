<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Nuevo usuario</h2>
				<p>Para agregrar un usuario nuevo rellene los siguientes campos de formulario y pulse el botón agregar usuario</p>
				<hr>
			</div>

<div class="col-lg-2 col-sm-2 col-xs-2">
        <div class="panel panel-default">
            <div class="panel-body text-center" >
             
                    <img id="foto-form" class="img img-responsive" src="<c:out value="${sessionScope.statics}" escapeXml="false"></c:out>/images/iconos/user.png" class="thumbnail" >
             
            </div>
            
            
            <div class="panel-primary">
                
            </div> 
            
        </div> 
        <jsp:include page="../components/selector.jsp" /> 
    </div>
    <div class="clear"></div> 



			<form id="frm-add-usuario">
			<input type="hidden" name="avatar" class="form-control" id="avatar" >
<div class="col-lg-3">		
	<div class="form-group ">
 <label for="user">USER</label>
<br>
<input type="text" name="user" class="form-control" id="user" >
</div>
	
	<div class="form-group ">
 <label for="password">PASSWORD</label>
<br>
<input type="text" name="password" class="form-control" id="password">
</div>
<div class="form-group ">
 <label for="telefono">TELEFONO</label>
<br>
<input type="text" name="telefono" class="form-control" id="telefono">
</div>
<div class="form-group ">
 <label for="email">EMAIL</label>
<br>
<input type="text" name="email" class="form-control" id="email">
</div>


</div>



<div class="col-lg-3">	


<div class="form-group">
<label for="sessiontimeout">SESSIONTIMEOUT</label>
<br>
<select name="sessiontimeout"  class="form-control " id="sessiontimeout">
<option value="3600">1 Hora</option>
<option value="28800">8 Horas</option>
<option value="86400">24 Horas</option>
</select>


</div>

	
	<div class="form-group">
 <label for="activo">ACTIVO</label>
<br>
 <select name="activo"  class="form-control " id="activo">
      <option value="true">Si</option>
      <option value="false">No</option>
 </select>
  
</div>
	


	<div class="form-group ">
 <label for="nombre">NOMBRE</label>
<br>
<input type="text" name="nombre" class="form-control" id="nombre" >
</div>
	<div class="form-group ">
 <label for="apellidos">APELLIDOS</label>
<br>
<input type="text" name="apellidos" class="form-control" id="apellidos">
</div>


</div>




<div class="col-lg-3">	
	
	
<div class="form-group" >
    
<label>Rol</label>
<br>
<select name="mstrol" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia01}">
      <option value="${elemento.id}">${elemento.nombre}</option>
  </c:forEach>
</select>
   
</div>	
	<div class="form-group" >
    
<label>Centro</label>
<br>
<select name="mstcentro" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.razonSocial}</option>
  </c:forEach>
</select>
   
</div>
<div class="form-group" >
    
<label>Storage</label>
<br>
<select name="mststorage" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia02}">
      <option value="${elemento.id}">${elemento.nombre} [${elemento.maxMB} MB]</option>
  </c:forEach>
</select>
   
</div>		
<div class="form-group" >
    
<label>Departamento</label>
<br>
<select name="defdepartamentos" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia03}">
      <option value="${elemento.id}">${elemento.nombre}</option>
  </c:forEach>
</select>
   
</div>




</div>


<div class="col-lg-12 " >
<hr>
<br>
<div id="btn-agregar">
<button class="btn btn-warning col-lg-2 ">Agregar usuario</button>
</div>

</div>
			</form>

<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" style="width: 0px;" id="msg"></div>
</div>

</div>




<jsp:include page="navbar-control-users.jsp" />
