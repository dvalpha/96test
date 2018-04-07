<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-10">





	<div class="col-md-4">
		<h3>Noticias</h3>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b>Noticias</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">
						<ul class="demo1">
							<li class="news-item">
								<table cellpadding="8">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
							<li class="news-item">
								<table cellpadding="4">
									<tr>
										<td>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Nullam in venenatis enim... <a href="#">Read
												more...</a>
										</td>
									</tr>
								</table>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel-footer"></div>
		</div>
	</div>


	<div class="col-md-4">
	<h3>Clientes</h3>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b>Clientes</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">Clientes</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-4">
	<h3>Proveedores</h3>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b>Proveedores</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">Proveedores</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="col-md-4">
	<h3>Productos</h3>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b>Productos</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">Productos</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="col-md-4">
	<h3>Pedidos</h3>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b>Pedidos</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">Pedidos</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="col-md-4">
	<h3>Facturación</h3>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-list-alt"></span><b>Facturación</b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-12">Facturación</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
</div>



<script type="text/javascript">
    $(function () {
        $(".demo1").bootstrapNews({
            newsPerPage: 3,
            autoplay: true,
			pauseOnHover:true,
            direction: 'up',
            newsTickerInterval: 4000,
            onToDo: function () {
                //console.log(this);
            }
        });
		
		$(".demo2").bootstrapNews({
            newsPerPage: 4,
            autoplay: true,
			pauseOnHover: true,
			navigation: false,
            direction: 'down',
            newsTickerInterval: 2500,
            onToDo: function () {
                //console.log(this);
            }
        });

        $("#demo3").bootstrapNews({
            newsPerPage: 3,
            autoplay: false,
            
            onToDo: function () {
                //console.log(this);
            }
        });
    });
</script>




