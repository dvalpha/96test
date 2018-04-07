<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<button class="btn btn-primary btn-xs"  onclick="mostrarOrden()">Reordenar elementos de la tabla</button>
<div class="col-lg-12 " style="display:none;overflow-y: auto;height: 300px; border-bottom-color: #000;" id="orden" >

<h4>Elementos</h4>
<p>La lista de elementos tiene el siguiente criterio de ordenación, para modificarlo, arrastre y suelte los elementos:</p>
<br>
<div class="col-lg-4">
<form id="reorder">

<ul id="sortable">              
	
	<c:forEach var="bean" items="${requestScope.list}">
		<li class="alert alert-primary col-lg-12" style="padding:10px; border-color: #2e2e2e; background-color:#e5eaec;" id="${bean.id}">${bean.titulo} 
		<span class="pull-right  badge">${bean.orden}</span></li>
	</c:forEach>  

</ul>  
</form>
</div>
 <script>
 function mostrarOrden(){
	 $('#orden').fadeToggle(3000);
 }
 var orden="";
  $( function() {
	 
	  $('#sortable').sortable({
	        stop: function(e, ui) {
	        $.map($(this).find('li'), function(el) {
	        	orden+=el.id + ',' + $(el).index()+',';
	                return el.id + ' = ' + $(el).index()+',';
	            });
	        reordenar(orden);
	        orden="";
	        }
	  
	  
	    });
    $( "#sortable" ).disableSelection();
    
  
  } );
  
  
  function reordenar(orden){
	 var clase="${requestScope.list[0].getClass().name}";
	
	 
	 $.ajax({
         url: 'reordenar',
         type: 'POST',
         data: {'orden' : orden,'clase' : clase }, 
         success: function (response) {
         	$("#msg").removeClass("alert-info");
				$("#msg").addClass("alert-warning");
				$("#msg").animate({width: '530px', opacity: '0.8'}, "slow");
				$("#msg").text(response);
				$("#msg").animate({width: '500px', opacity: '0.8'}, "slow");
				$("#msg").removeClass("alert-warning");
				$("#msg").addClass("alert-info");
         	                	
         },
         error: function (response) {
         	$("#msg").text("error");
         }
     });
  }
 </script>

</div>
      