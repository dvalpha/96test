<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Editar usuario</h2>
			</div>
<div class="col-lg-2 col-sm-2 col-xs-2">
        <div class="panel panel-default">
            <div class="panel-body text-center" >
             
                    <img id="foto-form" class="img img-responsive" src="<c:out value="${requestScope.object.avatar}"></c:out>" class="thumbnail" >
             
            </div>
            
            
            <div class="panel-primary">
                
            </div> 
            
        </div> 
        <jsp:include page="../components/selector.jsp" /> 
    </div>
    <div class="clear"></div> 
    
<form id="frm-update-usuario">
<input type="hidden" value="<c:out value="${requestScope.object.avatar}"></c:out>" name="avatar" class="form-control" id="avatar">

<div class="col-lg-3">	
<input type="hidden" name="id" id="id" value="<c:out value="${requestScope.object.id}"></c:out>">	

<div class="form-group">
<label for="user">USER</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.user}"></c:out>" name="user" class="form-control" id="user">
</div>
	
	<div class="form-group">
<label for="password">PASSWORD</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.password}"></c:out>" name="password" class="form-control" id="password">
</div>

<div class="form-group">
<label for="email">EMAIL</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.email}"></c:out>" name="email" class="form-control" id="email">
</div>

<div class="form-group">
<label for="telefono">TELEFONO</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.telefono}"></c:out>" name="telefono" class="form-control" id="telefono">
</div>
	                                
</div>	



<div class="col-lg-3">	

<div class="form-group">
<label for="sessiontimeout">SESSIONTIMEOUT</label>
<br>
<select name="sessiontimeout"  class="form-control " id="sessiontimeout">

<c:choose>
<c:when test="${requestScope.object.sessiontimeout==3600}">
<option value="<c:out value="${requestScope.object.sessiontimeout}"></c:out>" selected>1 Hora [Actual]</option>
</c:when>
<c:when test="${requestScope.object.sessiontimeout==28800}">
<option value="<c:out value="${requestScope.object.sessiontimeout}"></c:out>" selected>8 Horas [Actual]</option>
</c:when>
<c:when test="${requestScope.object.sessiontimeout==86400}">
<option value="<c:out value="${requestScope.object.sessiontimeout}"></c:out>" selected>24 Horas [Actual]</option>
</c:when>
</c:choose>

<option value="3600">1 Hora</option>
<option value="28800">8 Horas</option>
<option value="86400">24 Horas</option>
</select>


</div>


	<div class="form-group">
<label for="nombre">NOMBRE</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.nombre}"></c:out>" name="nombre" class="form-control" id="nombre">
</div>
	<div class="form-group">
<label for="apellidos">APELLIDOS</label>
<br>
<input type="text" value="<c:out value="${requestScope.object.apellidos}"></c:out>" name="apellidos" class="form-control" id="apellidos">
</div>
	



<div class="form-group">
<label for="activo">ACTIVO</label>
<br>
<select name="activo"  class="form-control " id="activo">
<option value="<c:out value="${requestScope.object.activo}"></c:out>" selected>
 <c:choose>
 <c:when test="${requestScope.object.activo}">
       Si [Actual]
 </c:when>
 <c:otherwise>
       No [Actual]
 </c:otherwise>    
 </c:choose>

</option>
<option value="true">Si</option>
<option value="false">No</option>

</select>
   </div> 

</div>	




<div class="col-lg-4">	
	
	<div class="form-group" >
    
<label>CENTRO</label>
<br>
<select name="mstcentro" class="form-control " >
  <c:forEach var="elemento" items="${requestScope.dependencia00}">
      <option value="${elemento.id}">${elemento.razonSocial}</option>
  </c:forEach>
</select>
   
</div>
	<div class="form-group" >
    
<label>ROL</label>
<br>
<select name="mstrol" class="form-control " >
<option value="${requestScope.object.mstrol.id}">${requestScope.object.mstrol.nombre} [Actual]</option>
  <c:forEach var="elemento" items="${requestScope.dependencia01}">
      <option value="${elemento.id}">${elemento.nombre}</option>
  </c:forEach>
</select>
   
</div>
<div class="form-group" >
    
<label>STORAGE</label>
<br>
<select name="mststorage" class="form-control " >
<option value="${requestScope.object.mststorage.id}">${requestScope.object.mststorage.nombre} [${requestScope.object.mststorage.maxMB} MB Actual]</option>
  <c:forEach var="elemento" items="${requestScope.dependencia02}">
      <option value="${elemento.id}">${elemento.nombre} [${elemento.maxMB} MB]</option>
  </c:forEach>
</select>
   
</div>

<div class="form-group" >
    
<label>Departamento</label>
<br>
<select name="defdepartamentos" class="form-control " >
<option value="${requestScope.object.mststorage.id}">${requestScope.object.defdepartamentos.nombre} [Actual]</option>
  <c:forEach var="elemento" items="${requestScope.dependencia03}">
      <option value="${elemento.id}">${elemento.nombre}</option>
  </c:forEach>
</select>
   
</div>




</div>	
<div class="col-lg-12 " >
<hr>
<br>
<button class="btn btn-warning col-lg-2 ">Actualizar usuario</button>
</div>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" style="width: 0px;" id="msg"></div>
</div>










		</div>
<jsp:include page="navbar-control-users.jsp" />