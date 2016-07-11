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
			<div class="container">

				<table id="grid-data-api" class="table table-striped"
					data-toggle="bootgrid">
					<thead>
						<tr>
							<th data-column-id="nombreUsuario" data-order="asc">Nombre
								de Usuario</th>
							<th data-column-id="nombre" data-type="string">Nombre</th>
							<th data-column-id="apellido" data-type="string">Apellido</th>
							<th data-column-id="ver+" data-formatter="ver+">Ver +</th>
							<th data-column-id="habilitar">Habilitar</th>
							<th data-column-id="deshabilitar">Deshabilitar</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>UserAlex</td>
							<td>Alex</td>
							<td>Rojas</td>
							<td><a href="administradorVer+Usuario.jsp?id=1">Ver+</a></td>
							<td>-</td>
							<td><a href="#" onclick="alert('Usuario Deshabilitado!')">Deshabilitar</a>
							</td>
						</tr>

						<tr>
							<td>UserIgnacio</td>
							<td>Ignacio</td>
							<td>Vacca</td>
							<td><a href="#">Ver+</a></td>
							<td><a href="#" onclick="alert('Usuario habilitado!')">Habilitar</a>
							</td>
							<td>-</td>
						</tr>

						<tr>
							<td>UserJuan</td>
							<td>Juan</td>
							<td>Altamirano</td>
							<td><a href="#">Ver+</a></td>
							<td>-</td>
							<td><a href="#" onclick="alert('Usuario Deshabilitado!')">Deshabilitar</a>
							</td>
						</tr>


					</tbody>
				</table>
			</div>

		</div>
		<script src="jqueryBootgrid/jquery.bootgrid.js"></script>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>

</body>
</html>