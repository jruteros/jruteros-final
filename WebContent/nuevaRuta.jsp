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

			<!--
		Nombre 
		Descripción 
		Privacidad: Privada/pública 
		Recorrido: Se indica mediante un dibujo en el mapa o subiendo un archivo KML (Keyhole Markup Language) 
		Formato: Sólo ida / Circular 
		Distancia: Extensión en kilómetros de la ruta 
		Dificultad: Fácil / Moderado / Dificil / Muy Dificil / Sólo Expertos 
		Actividad (selección simple) : Mountain bike / Ciclismo / Cicloturismo / 
		Senderismo / Carrera por montaña / Alpinismo / Motociclismo / Cuatriciclo / 
		Esquí / Kayac / Vela / A caballo . 
		Tiempo estimado 
		Fecha de realización 
		Fotos 
		-->

			<form id="login">
				<h2>
					<span class="fontawesome-lock"></span>Nueva Ruta
				</h2>
				<fieldset>

					<p>
						<label for="nombreRuta">Nombre de la ruta:</label>
					</p>
					<p>
						<input type="text" name="nombreRuta" />
					</p>

					<p>
						<label for="descripcion">Descripción:</label>
					</p>
					<p>
						<input type="text" name="descripcion" />
					</p>

					<p>Privacidad:</p>
					<label for="privacidad_publica">Publica</label> <input
						id="privacidad_publica" type="radio" name="privacidad"
						value="publica" /> <label for="privacidad_privada">Privada</label>
					<input id="privacidad_privada" type="radio" name="privacidad"
						value="privada" />

					<p>Recorrido:</p>
					<div>Subir archivo KML</div>
					<p>
						<input type="file" name="archivo_kml" />
					</p>

					<p>Seleccionar recorrido en el Mapa</p>
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

					<p>Formato:</p>
					<label for="formato_ida">Solo ida</label> <input id="formato_ida"
						type="radio" name="formato" value="ida" /> <label
						for="formato_circular">Circular</label> <input
						id="formato_circular" type="radio" name="formato" value="circular" />

					<p>
						<label for="distancia">Distancia:</label>
					</p>
					<p>
						<input type="text" name="distancia" />
					</p>

					<p>
						<label for="tiempo">Tiempo estimado:</label>
					</p>
					<p>
						<input type="text" name="tiempo" />
					</p>

					<p>
						<label for="fecha">Fecha realización:</label>
					</p>
					<p>
						<input type="date" name="fecha" placeholder="dd/mm/AAAA" />
					</p>

					<p>Dificultad:</p>
					<div>
						<select>
							<option value="facil">Fácil</option>
							<option value="moderado">Moderado</option>
							<option value="dificil">Difícil</option>
							<option value="muydificil">Muy Difícil</option>
							<option value="soloexpertos">Sólo expertos</option>
						</select>
					</div>

					<p>Actividad:</p>
					<div>
						<select>
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

					<p>Fotos:</p>
					<p>
						<input type="file" name="fotos" />
					</p>


					<p>
						<input type="submit" value="Guardar">
					</p>

				</fieldset>

			</form>
		</div>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>
</body>
</html>