<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<!-- Bootstrap CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap JS -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<link href="jqueryBootgrid/jquery.bootgrid.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="estilos.css" />
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="encabezado.jsp" flush="false" />
			<jsp:include page="menuAdmin.jsp" flush="false" />
		</header>

		<div id="content">
			<div class="container" style="padding-top: 60px">

				<table id="grid-data-api" class="table table-striped"
					data-toggle="bootgrid">
					<thead>
						<tr>
							<th data-column-id="nombreUsuario" data-order="asc">Nombre
								de Usuario</th>
							<th data-column-id="nombre" data-type="string">Nombre</th>
							<th data-column-id="apellido" data-type="string">Apellido</th>
							<th data-column-id="ver+">DNI</th>
							<th data-column-id="habilitar">Domicilio</th>
							<th data-column-id="deshabilitar">Fecha de Nacimiento</th>
							<th data-column-id="sexo">Sexo</th>
							<th data-column-id="email">Email</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>UserAlex</td>
							<td>Alex</td>
							<td>Rojas</td>
							<td>35609879</td>
							<td>60 y 25 Nº85</td>
							<td>30/09/1990</td>
							<td>Masculino</td>
							<td>alexrl_lp@hotmail.com</td>
						</tr>



					</tbody>
				</table>
				<a href="administradorAdminUsuarios.jsp" class="btn btn-default">Volver</a>
			</div>

		</div>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>

</body>
</html>