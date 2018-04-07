
 <p class="text-center">Dv-Alpha Solutions TIC S.L</p>


 
<script>
session();

function session(){
setTimeout(function () { 
   refrescarSession();
   session();
   }, 1 * 1000);
}
function refrescarSession(){
             $.ajax({
               url:   'validate-session',
               type: 'POST', 
               success: function (response) {
               	
	               	if(response<0){
	               	 	console.log("sesion finalizada");
	               	 	window.location="logout";
	               	}else{
	               		$("#result-session").text(response);
	               	}
	               	
               },
               error: function (response) {
               	$("#result-session").text("Error al refrescar la sesion del usuario");
               	window.location="session-finish";
               }
           }); 
       }
       
       

</script>





    
