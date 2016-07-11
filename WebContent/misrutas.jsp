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
			<jsp:include page="menuUsuario.jsp" flush="false" />
		</header>
		<div id="content">
			<div class="container">
				<table id="grid-data-api" class="table table-striped"
					data-toggle="bootgrid">
					<thead>
						<tr>
							<th data-column-id="nombreRuta" data-order="asc">Nombre de
								la Ruta</th>
							<th data-column-id="descripcion" data-type="string">Descripcion</th>
							<th data-column-id="actividad" data-type="string">Actividad</th>
							<th data-column-id="fecha" data-type="date">Fecha</th>
							<th data-column-id="ver+" data-formatter="ver+">Ver +</th>
							<th data-column-id="editar">Editar Ruta</th>
							<th data-column-id="eliminar">Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Camino de los siete lagos</td>
							<td>Esta ruta transitá el camino de los siete lagos a...</td>
							<td>Cicloturismo</td>
							<td>12/12/2015</td>
							<td><a href="verDetalleRuta.jsp">Ver en detalle</a></td>
							<td><a href="editarRuta.jsp">Editar</a></td>
							<td><a href="#" onclick="confirm('¿Eliminar ruta?')">Eliminar</a></td>
						</tr>
						<tr>
							<td>En kayac por el río salado</td>
							<td>Con mi kayac recorri el río salado desde su inicio....</td>
							<td>Kayac</td>
							<td>25/10/2014</td>
							<td><a href="verDetalleRuta.jsp">Ver en detalle</a></td>
							<td><a href="editarRuta.jsp">Editar</a></td>
							<td><a href="#" onclick="confirm('¿Eliminar ruta?')">Eliminar</a></td>
						</tr>
						<tr>
							<td>A caballo en la estancia Los Haroldos</td>
							<td>A caballo recorrer los montes de la estancia...</td>
							<td>A Caballo</td>
							<td>12/12/2015</td>
							<td><a href="verDetalleRuta.jsp">Ver en detalle</a></td>
							<td><a href="editarRuta.jsp">Editar</a></td>
							<td><a href="#" onclick="confirm('¿Eliminar ruta?')">Eliminar</a></td>
						</tr>
					</tbody>
				</table>
				<a href="nuevaRuta.jsp" class="btn btn-default">Crear nueva ruta</a>
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