<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  
  <head>
    <!-- BASE CSS -->
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="http://localhost/arquetipo/statics/baselib/bootstrap/css/bootstrap.css" rel="stylesheet" >
    <link href="http://localhost/arquetipo/statics/css/style.css" rel="stylesheet">
    
    
    <!-- BASE JS -->
    <script src="http://localhost/arquetipo/statics/baselib/jquery/js/jquery-3.2.1.min.js"></script>
    <script src="http://localhost/arquetipo/statics/baselib/bootstrap/js/bootstrap.min.js"></script>
    <style>
		body{
		background-color: #2e2e2e;
		
		}
	</style>
    </head>
  <body>


<div class="col-lg-4"></div>
<div class="col-lg-4" style="margin-top:10%;border:solid 1px; padding:20px; background-color: #fefefe;">

   
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <h3 class="text-center">Spumas 96 S.L.</h3>
            <p>Para acceder a la aplicación indique sus credenciales y pulse el botón acceder</p>
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" method="post" id="login" action="login">
                
                <input type="text" id="centro" name="centro" class="form-control" placeholder="Centro/Empresa" value="dvalpha" required autofocus>
                <input type="text" id="user" name="user"     class="form-control" placeholder="Usuario" value="qwe" required>
                <input type="password" id="psw" name="psw"   class="form-control" placeholder="Password" value="qwe" required>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Acceder</button>
            </form><!-- /form -->
            <div id="result-login"class="alert alert-info"></div>
            <a href="#" class="forgot-password">
                No recuerdo mis credenciales
            </a>
        </div><!-- /card-container -->
    
 </div>
<div class="col-lg-4"></div>
<div class="col-lg-12"style="margin-top:10%;">
    <footer class="container-fluid">
	  <p class="text-center" style="color:#fff;">Dv-Alpha Solutionles TIC S.L</p>
	</footer>
  </div> 
  <!-- TAGS DE CIERRES -->
  <script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script
	src="resources/js/login-validation.js"></script>
</body>
</html>