<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Actualizar módulos</h2>
			</div>


<form id="update-rol-module">
<input type="hidden" name="idrol" value="<c:out value="${requestScope.idrol}"></c:out>"> 
<c:forEach var="bean" items="${requestScope.modules}">
<input type="hidden" name="id_mstmodule<c:out value="${bean.id}"></c:out>" value="<c:out value="${bean.id}"></c:out>">
</c:forEach>  					

       <table id="table-MstRol-Module" class="table table-condensed table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							
							<th>Level</th>
							
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean" items="${requestScope.modules}">
					
						<tr id="tr-<c:out value="${bean.id}"></c:out>">
							<td><c:out value="${bean.id}"></c:out></td>
							<td><c:out value="${bean.nombre}"></c:out></td>
							
							
							<td>
							<select class="btn-primary btn-md" name="<c:out value="${bean.nombre}" ></c:out>">
							<option value="<c:out value="${bean.level}"></c:out>"><c:out value="${bean.level}"></c:out> [Actual]</option>
							<option value="0">0 [Root]</option>
							<option value="1">1 </option>
							<option value="2">2</option>
							<option value="3">3 </option>
							<option value="4">4 </option>
							<option value="5">5</option>
							</select>
							</td>
							<td>
							
							</td>
                       </tr>
                     </c:forEach>  
                    </tbody>
              </table> 
              
</form>
<div class="col-lg-12">
				<p>Status</p>
				<div class="col-lg-12 alert alert-info" id="msg"></div>
			</div>
			
<div class="col-lg-12">
				
				<button class="btn btn-warning btn-md" onclick="estructurarPermisos()"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Actualizar la estructura de permisos en el rol del usuario</button>  

			</div>			

<script type="text/javascript" class="init">
	

$(document).ready(function() {
	$('#table-MstRol-Module').DataTable({
				order: [[ 0, 'desc' ]]
		} );
	} );



function estructurarPermisos(){
	
	var dataString = $("#update-rol-module").serialize();
	$.ajax({
        url: 'update-rol-module',
        type: 'POST',
        data: dataString, 
        success: function (response) {
        	$("#msg").removeClass("alert-info");
			$("#msg").addClass("alert-warning");
			$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
			$("#msg").text(response);
			$("#msg").animate({width: '400px', opacity: '0.8'}, "slow");
			$("#msg").removeClass("alert-warning");
			$("#msg").addClass("alert-info");
        	                	
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
	
	
}


function borrar(id){
	
	var dataString = $("#frm-del-"+id).serialize();
	$.ajax({
	    url: 'xxx',
	    type: 'POST',
	    data: dataString, 
	    success: function (response) {
	    $("#msg").removeClass("alert-info");
	    	$("#msg").addClass("alert-warning");
	    	$("#msg").animate({width: '130px', opacity: '0.8'}, "slow");
	    	$("#msg").text(response);
	    	$("#tr-"+id).animate({"opacity": 0},1500,function(){
	    		$("#tr-"+id).addClass("hide");
	    	});
	    	$("#msg").animate({width: '100px', opacity: '0.8'}, "slow");
	    	$("#msg").removeClass("alert-warning");
	    	$("#msg").addClass("alert-info");    	
	    },
	    error: function (response) {
	    	$("#msg").addClass("alert-danger");
	    	$("#msg").animate({width: '230px', opacity: '0.8'}, "slow");
	    	$("#msg").text(response);
	    }
	});	
	}

</script>

			

<!-- FIN BODY -->
		</div>
	<jsp:include page="navbar-control-roles.jsp" />


</body>
</html>