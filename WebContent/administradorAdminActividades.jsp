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
							<th data-column-id="nombreActividad" data-order="asc">Nombre
								de Actividad</th>
							<th data-column-id="descripcion" data-type="string">Descripcion</th>
							<th data-column-id="modificar" data-type="string">Modificar
								Actividad</th>
							<th data-column-id="habilitar">Habilitar</th>
							<th data-column-id="deshabilitar">Deshabilitar</th>
							<th data-column-id="eliminar">Eliminar Actividad</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>Ciclismo</td>
							<td>Descripcion del ciclismo</td>
							<td><a href="administradorModificarActividad.jsp">Modificar
									Actividad</a></td>
							<td>-</td>
							<td><a href="#" onclick="alert('Actividad Deshabilitada!')">Deshabilitar</a>
							</td>
							<td><a href="#">Eliminar Actividad</a></td>
						</tr>

						<tr>
							<td>Canotaje</td>
							<td>Descripcion del canotaje</td>
							<td><a href="#">Modificar Actividad</a></td>
							<td>-</td>
							<td><a href="#" onclick="alert('Actividad Deshabilitada!')">Deshabilitar</a>
							</td>
							<td><a href="#">Eliminar Actividad</a></td>
						</tr>


						<tr>
							<td>Senderismo</td>
							<td>Descripcion del senderismo</td>
							<td><a href="#">Modificar Actividad</a></td>
							<td><a href="#" onclick="alert('Actividad Habilitada!')">Habilitar</a>
							</td>
							<td>-</td>
							<td><a href="#">Eliminar Actividad</a></td>
						</tr>

						<tr>
							<td>Cuatriciclo</td>
							<td>Descripcion del cuatriciclo</td>
							<td><a href="#">Modificar Actividad</a></td>
							<td><a href="#" onclick="alert('Actividad Habilitada!')">Habilitar</a>
							</td>
							<td>-</td>
							<td><a href="#">Eliminar Actividad</a></td>
						</tr>



					</tbody>

				</table>

				<a href="administradorAltaActividad.jsp" class="btn btn-default">Crear
					actividad nueva</a>
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