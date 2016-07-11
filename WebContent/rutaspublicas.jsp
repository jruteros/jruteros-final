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
<script src="leaflet/leaflet.js"></script>
<link rel="stylesheet" type="text/css" href="leaflet/leaflet.css" />
<link rel="stylesheet" type="text/css" href="estilos.css" />
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="encabezado.jsp" flush="false" />
			<jsp:include page="menuUsuario.jsp" flush="false" />
		</header>
		<div id="content">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<h2>Buscar</h2>
					<form action="#buscar">
						<div>
							Formato: <label for="formato_ida">Solo ida</label> <input
								id="formato_ida" type="radio" name="formato" value="ida" /> <label
								for="formato_circular">Circular</label> <input
								id="formato_circular" type="radio" name="formato"
								value="circular" />
						</div>

						<div>
							Dificultad: <select>
								<option value="facil">Fácil</option>
								<option value="moderado">Moderado</option>
								<option value="dificil">Difícil</option>
								<option value="muydificil">Muy Difícil</option>
								<option value="soloexpertos">Sólo expertos</option>
							</select>
						</div>

						<div>
							Actividad: <select>
								<option value="mountainbike">Mountain bike</option>
								<option value="ciclismo">Ciclismo</option>
								<option value="cicloturismo">Cicloturismo</option>
								<option value="senderismo">Senderismo</option>
								<option value="carrerapormotaña">Carrera por montaña</option>
								<option value="alpinismo">Alpinismo</option>
								<option value="motociclismo">Motociclismo</option>
								<option value="cuatriciclo">Cuatriciclo</option>
								<option value="esqui">Esquí</option>
								<option value="kayac">Kayac</option>
								<option value="vela">Vela</option>
								<option value="acaballo">A Caballo</option>
							</select>
						</div>

						<div>Seleccione un punto en el mapa para buscar por cercanía
							a ese sitio</div>
						<div id="map"></div>

						<div>
							Distancia maxíma al punto: <input id="radio" type="text"
								name="radio" />
						</div>
						<script>
            var mymap = L.map('map').setView([-40.50404, -66.26953], 4);
            var osmUrl='http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
            var osmAttrib='Map data © <a href="http://openstreetmap.org">OpenStreetMap</a> contributors';
            L.tileLayer(osmUrl, {
                    maxZoom: 18,
                    attribution: osmAttrib
            }).addTo(mymap);

            var popup = L.popup();

            function onMapClick(e) {
                popup
                    .setLatLng(e.latlng)
                    .setContent("You clicked the map at " + e.latlng.toString())
                    .openOn(mymap);
            }

            mymap.on('click', onMapClick);

    </script>
						<input type="submit" value="buscar" />
					</form>
				</div>
			</div>
			<div class="row" style="width: 70%; margin: auto">
				<table class="table">
					<thead>
						<tr>
							<th data-column-id="nombreRuta" data-order="asc">Nombre de
								la Ruta</th>
							<th data-column-id="descripcion" data-type="string">Descripcion</th>
							<th data-column-id="actividad" data-type="string">Actividad</th>
							<th data-column-id="fecha" data-type="date">Distancia</th>
							<th data-column-id="dificultad" data-type="string">Dificultad</th>
							<th data-column-id="puntuacion" data-type="string">Puntuacion</th>
							<th data-column-id="cantidad" data-type="string">Veces
								realizadas</th>
							<th data-column-id="ver+" data-formatter="ver+">Ver +</th>
							<th>Imagen?</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Camino de los siete lagos</td>
							<td>Esta ruta transitá el camino de los siete lagos a...</td>
							<td>Cicloturismo</td>
							<td>24km</td>
							<td>Moderado</td>
							<td>4,9</td>
							<td>1354</td>
							<td><a href="verDetalleRuta.jsp">Ver en detalle</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td>En kayac por el río salado</td>
							<td>Con mi kayac recorri el río salado desde su inicio....</td>
							<td>Kayac</td>
							<td>150km</td>
							<td>Difícil</td>
							<td>4,2</td>
							<td>3</td>
							<td><a href="verDetalleRuta.jsp">Ver en detalle</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td>A caballo en la estancia Los Haroldos</td>
							<td>A caballo recorrer los montes de la estancia...</td>
							<td>A Caballo</td>
							<td>5km</td>
							<td>fácil</td>
							<td>4,9</td>
							<td>5321</td>
							<td><a href="verDetalleRuta.jsp">Ver en detalle</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>
</body>
</html>