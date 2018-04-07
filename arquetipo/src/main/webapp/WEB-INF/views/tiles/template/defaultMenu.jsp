<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<style>
p,h1,h2,h3,h4,h5{
font-family: 'Quicksand', sans-serif;
}

a{
color:#2e2e2e;
}

.panel-title {
    margin-top: 0;
    margin-bottom: 0;
    font-size: 12px;
    color: inherit;
}
</style>
<div class="col-sm-2 " style="background-color: #093750; color:#fff; height: 140%;">
  
  <a href="home"><h4 style="margin-top:20px; color:#fff;  ">Dv-Alpha Solutions TIC.</h4></a>
  <br>
 
 <hr>

        <div class="col-sm-12 col-md-12">
        <h5><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Menu Aplicación</h5>
            <div class="panel-group" id="accordion">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-1"><span class="glyphicon glyphicon-folder-close">
                            </span>  Centros</a>
                        </h4>
                    </div>
                    <div id="bar-1" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                             <td>
                                      <a href="main-menu-usuario"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Menú principal</a>

                                    </td>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-home"></span><a href=""> Crear centro nuevo</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-refresh"></span><a href="http://www.jquery2dotnet.com"> Edición de centros</a>
                                    </td>
                                </tr>
                                
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-2"><span class="glyphicon glyphicon-user">
                            </span>  Usuarios</a>
                        </h4>
                    </div>
                    <div id="bar-2" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                            <tr>
                                    <td>
                                      <a href="main-menu-usuario"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Menú principal</a>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      <a href="menu-addUsuario"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Nuevo usuario</a>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      <a href="list-usuario"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Edición de usuarios</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <a href="usuarios-conectados"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Usuarios conectados</a>
                                    </td>
                                </tr>
                                
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-3"><span class="glyphicon glyphicon-th">
                            </span>  Roles</a>
                        </h4>
                    </div>
                    <div id="bar-3" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                
                                <tr>
                                    <td>
                                      <a href="main-menu-rol"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Menú principal</a>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      <a href="menu-addRol"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Nuevo rol</a>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      <a href="list-rol"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Edición de roles</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      <a href="menu-addUrl"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Nueva Restricción</a>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                      <a href="list-url"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Administrar restricciones</a>
                                    </td>
                                </tr>
                                
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-4"><span class="glyphicon glyphicon-stats">
                            </span>  Reports</a>
                        </h4>
                    </div>
                    <div id="bar-4" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd"></span><a href="http://www.jquery2dotnet.com"> Sales</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-user"></span><a href="http://www.jquery2dotnet.com"> Customers</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-tasks"></span><a href="http://www.jquery2dotnet.com"> Products</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-shopping-cart"></span><a href="http://www.jquery2dotnet.com"> Shopping Cart</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-5"><span class="glyphicon glyphicon-book">
                            </span>  Documentación</a>
                        </h4>
                    </div>
                    <div id="bar-5" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addLibro"> Nuevo libro</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-libro"> Edición de libros</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addCategoriaLibro"> Nueva categoría</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-categorialibro"> Edición de categorías</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-file"></span><a href="menu-addDocumento"> Nuevo documento</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-duplicate"></span><a href="list-documento"> Edición de documentos</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-9"><span class="glyphicon glyphicon-book">
                            </span>  Facturación</a>
                        </h4>
                    </div>
                    <div id="bar-9" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addAlbaran"> Nuevo Albaran</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-albaran"> Edición de Albaranes</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addFactura"> Nueva Factura</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-factura"> Edición de Facturas</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-file"></span><a href="menu-addDocumento"> Nuevo documento</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-duplicate"></span><a href="list-documento"> Edición de documentos</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-6"><span class="glyphicon glyphicon-file">
                            </span>  Archivos</a>
                        </h4>
                    </div>
                    <div id="bar-6" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                            <tr>
                                    <td>
                                      <a href="list-archivo-user"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Dashboard</a>

                                    </td>
                                </tr>
                                
                                
                              
                                    <td>
                                    <a href="usuarios-conectados"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Crear host-plan</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <a href="usuarios-conectados"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Administrar host-plan</a>
                                    </td>
                                </tr>
                                
                                
                            </table>
                        </div>
                    </div>
                    
                    
                    
                    
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-7"><span class="glyphicon glyphicon-book">
                            </span>  Administración</a>
                        </h4>
                    </div>
                    <div id="bar-7" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addClient"> Nuevo cliente</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-client"> Edición de clientes</a>
                                    </td>
                                </tr>
                                
                            </table>
                        </div>
                    </div>
                </div>
                <!--  
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#bar-7"><span class="glyphicon glyphicon-book">
                            </span>  Administración de pedidos II</a>
                        </h4>
                    </div>
                    <div id="bar-7" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addCliente"> Nuevo cliente</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-cliente"> Edición de clientes</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-book"></span><a href="menu-addProveedor"> Nuevo proveedor</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-proveedor"> Edición de proveedores</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-file"></span><a href="menu-addProducto"> Nuevo producto</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-duplicate"></span><a href="list-producto-proveedor">Productos por proveedor</a>
                                    </td>
                                </tr>
                                
                                 <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="list-pedido"> Edición de pedidos</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                
                -->
                
                
                
            </div>
            
           </div>   
            
            
             <div class="col-lg-12" >
             <h5><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span> Mi nube</h5>
             <form id="dropzone" method="post" action="uploadfiles" class="dropzone" style="background: #093750;height: 250px; overflow: auto;">
			  <div class="fallback">
			    <input name="file" type="file" />
			  </div>
			</form>
             
           <div class="col-lg-12">
            <h6 >Espacio ocupado en disco</h6>
            <div id="espacio-ocupado"  style="margin-top:5px;">
            </div>
           
           
           
           
           </div>
           
             </div>   
     
            </div>
  
        </div>
        
        <style>
        .panel-warning>.panel-heading {
    color: #fff;
    background-color: #6b8e6a;
    border-color: #fff;
}
        </style>
   