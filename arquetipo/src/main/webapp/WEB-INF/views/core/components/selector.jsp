<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<style>

#selector .modal-dialog{
 width:1250px;
 overflow-y: initial !important
}
#selector .modal-body{
  width:1200px;
  height: 450px;
  overflow-y: auto;
}

.size{
width:150px;
  height: 100px;
}
@media (max-width: 767px) {
    .portfolio>.clear:nth-child(6n)::before {
      content: '';
      display: table;
      clear: both;
    }
}
@media (min-width: 768px) and (max-width: 1199px) {
    .portfolio>.clear:nth-child(8n)::before {
      content: '';
      display: table;
      clear: both;
    }
}
@media (min-width: 1200px) {
    .portfolio>.clear:nth-child(12n)::before {  
      content: '';
      display: table;
      clear: both;
    }
}
</style>
<button type="button" onclick="reload();" class="btn btn-primary btn-xs col-lg-12" data-toggle="modal" data-target="#selector"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span> Mi nube</button>

<!-- Modal -->
<div id="selector" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Selector de archivos</h4>
      </div>
      <div id ="body-modal" class="modal-body"  >
       

	  
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>





<script>



//Funcion que lista los archivos del usuario y los inserta en la ventana modal
//controlador ->core/controller/FuctionsController
$.ajax({
    url: 'minube-form',
    type: 'POST',
    success: function (response) {
    	$("#body-modal").html(response);
    },
    error: function (response) {
    	$("#msg").text("error");
    }
});
function selector(path){
	$("#avatar").attr("value", path);
	$("#foto-form").attr("src", path);
	
	$("#selector").modal("hide");
}
function reload(){
	$.ajax({
        url: "minube-form",
        type: 'POST',
        success: function (response) {
        	
        	$("#body-modal").html(response);
        	
        	
        },
        error: function (response) {
        	$("#msg").text("error");
        }
    });
}

</script>