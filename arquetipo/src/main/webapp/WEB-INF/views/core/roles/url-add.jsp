<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- BODY -->
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Agregar restricción</h2>
			</div>
<div class="container-fluid">
    <section class="container">
		<div class="container-page">				
			<div class="col-md-6">
				
				
				<!-- CODIGO AQUI -->

<form id="frm-add-url">
	<div class="form-group ">
 <label for="url">URL</label>
<br>
<input type="text" name="url" class="form-control" id="url">
</div>
	<div class="form-group">
<label for="modulo">MODULO</label>
<br>
<br>
<select name="modulo" class="form-control" id="modulo">

  <c:forEach var="elemento" items="${requestScope.modulos}">
      <option value="${elemento.nombre}">${elemento.nombre}</option>
  </c:forEach>
</select>

</div>
	<div class="form-group ">
 <label for="grupo">GRUPO</label>
<br>
<input type="text" name="grupo" class="form-control" id="grupo">
</div>
	<div class="form-group ">
 <label for="level">LEVEL</label>
<br>
<input type="text" name="level" class="form-control" id="level">
</div>
	<div class="form-group ">
 <label for="comentario">COMENTARIO</label>
<br>
<input type="text" name="comentario" class="form-control" id="comentario">
</div>

<button class="btn btn-primry">Enviar</button>
			</form>
<div class="col-lg-12"><b>Status</b>
<div class="alert alert-info" id="msg"></div>
</div>


			

<!-- FIN BODY -->				
			
			</div>
		
			<div class="col-md-6">
				<h3 class="dark-grey">Restricciones</h3>
				<p>
					Una restricción representa un nivel de accesibilidad por parte de los usuarios a un recurso.
				</p>
				<p>
					Cuando creamos una restricciòn los usuarios que tengan un nivel de acceso igual o superior al nivel de restricción no podran acceder al recurso que esten solicitando en ese momento, por ejemplo, si un usuario tiene un nivel de acceso de '2' y la url tiene un nivel de acceso de 2, el usuario no podra acceder, si por el contrario la URL tiene un nivel de acceso de 2 y el usuario tiene un nivel de acceso de 1 si podra acceder a la aplicación, es decir:
					<ul>
					<li>Nivel de acceso del usuario a ese módulo = 6, Accesibilidad de la URL :5,  5 > 5 [No accede]</li>
					<li>Nivel de acceso del usuario a ese módulo = 5, Accesibilidad de la URL :5,  5=5   [No accede]</li>
					<li>Nivel de acceso del usuario a ese módulo = 4, Accesibilidad de la URL :5,  4 < 5 [Accede]</li>
					</ul>
					
				</p>
				<p>
					Los niveles de acceso del usuario se configuran al crear un ROL, es decir, primero se crea un ROL y despues se asigna que permisos tendra ese usuario para cada uno de los módulos que tiene la aplicación.
				</p>
				<p>Para realizar esta validacion se interceptan las URL y se envian al controlador de la aplicación para validar si el usuario tiene acceso o no ANTES de realizar la peticion.
				
				</p>
				<p>El el código mostrado a continuación podemos ver un ejemplo de su funcionamiento a nivel interno</p>
				<hr>
		</div>
		<div class="col-lg-12">
		<h4>Ejemplo:</h4>
				<pre class="prettyprint">public class UrlRestrictionFilter extends CoreController implements Filter {
private static final Logger logger = Logger.getLogger(UrlRestrictionFilter.class);	
	//comparamos el nombre de los modulos
	if(moduleUrl.equalsIgnoreCase(moduleRol.getNombre())) {
							
		//Comparamos los niveles del rol para esa url (de ese modulo)
		int rolLevel = moduleRol.getLevel();
		int urlLevel =ur.getLevel();
							
			if(rolLevel>=urlLevel) {
				b = true;
								
			}	
							
	}
						
				</pre>
				
			</div>
		</div>
	</section>
</div>

		</div>
	
<jsp:include page="navbar-control-roles.jsp" />

</body>
</html>