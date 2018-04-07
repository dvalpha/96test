<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-10">
<nav class="navbar navbar-primary">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Mi Perfil</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Mensajes <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Noticias</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dashboard <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Mi nube</a></li>
            <li><a href="#">Mensajes</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Reportar</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Crear un reporte nuevo</a></li>
            <li><a href="#">Seguimiento de reportes</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Buscar archivos">
        </div>
        <button type="submit" class="btn btn-default">Buscar</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li> <button type="button" class="btn btn-primary btn-xs " style="margin-top:16px; width:100px;" data-toggle="modal" data-target="#myModal">SESIÓN</button>
	      </li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</div>










 
<div class="col-sm-10" style="background-color: #6e6e6e;color:#fff !important; padding:5px; display:inline !important;">
	      <h1 class="text-left" style="color:#fff !important; float:left">Bienvenido</h1>
	    
</div>	     
	      
<div id="myModal" class="modal fade" role="dialog" style="color:#000 !important;">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Perfil de usuario</h4>
      </div>
      <div class="modal-body">
         <p><small >User:<c:out value="${sessionScope.user.nombre}"></c:out></small></p>
	     <p> <small >Centro:<c:out value="${sessionScope.user.mstcentro.razonSocial}"></c:out></small></p>
	      <p><small >Session timeout: <span id="result-session"></span>/s</small></p>
	      
      </div>
      <div class="modal-footer">
        <a href="session-finish"><button type="button" class="btn btn-danger btn-xs pull-right" >Finalizar sesión</button></a>
        <button type="button" class="btn btn-success btn-xs pull-left" data-dismiss="modal">Cerrar ventana</button>
      </div>
    </div>

  </div>
  </div>
	      
	    
	      
	      

	    
	    
	