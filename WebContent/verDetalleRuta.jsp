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
<link rel="stylesheet" type="text/css" href="estilos.css" />
<script src="leaflet/leaflet.js"></script>
<link rel="stylesheet" type="text/css" href="leaflet/leaflet.css" />
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
					<h2>Camino de los siete lagos</h2>

					<p>Descripción: Esta ruta transitá el camino de los siete
						lagos. Etc</p>

					<div id="map"></div>
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

					<p>Formato: Sólo ida</p>

					<p>Distancia: 24km</p>

					<p>Tiempo estimado: 2hs</p>

					<p>Fecha realización: 12/12/2015</p>

					<p>Dificultad Moderado:</p>

					<p>Actividad: Cicloturismo</p>

					<p>Fotos:</p>
					<div>
						<img src="fotos/7lagos.jpg" />
					</div>

					<p>Puntaje: 4,8</p>
					Valorar: <select><option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
					<p>Usuarios que hicieron esta ruta: 1523</p>
					<button>Hice está ruta</button>
				</div>
			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>
</body>
</html>