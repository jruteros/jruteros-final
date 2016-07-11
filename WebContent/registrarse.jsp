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
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="encabezado.jsp" flush="false" />
			<jsp:include page="menuPublic.jsp" flush="false" />
		</header>
		<div id="content">
			<div id="login">

				<h2>
					<span class="fontawesome-lock"></span>Registrarse
				</h2>

				<form id="formu" method="post" action="registroExitoso.jsp">
					<fieldset>

						<label for="nombreUsuario">Nombre de usuario:</label>
						<p>
							<input type="text" id="nombreUsuario" name="nombreUsuario" />
						</p>

						<label for="email">Email:</label>
						<p>
							<input type="text" id="email" name="email" />
						</p>

						<label for="nombre">Nombre:</label>
						<p>
							<input type="text" id="nombre" name="nombre" />
						</p>

						<label for="apellido">Apellido:</label>
						<p>
							<input type="text" id="apellido" name="apellido" />
						</p>

						<label for="dni">DNI:</label>
						<p>
							<input type="text" id="dni" name="dni" />
						</p>

						<label for="domicilio">Domicilio:</label>
						<p>
							<input type="text" id="domicilio" name="domicilio" />
						</p>

						<label for="fechaNacimiento">Fecha de Nacimiento</label> <input
							type="date" id="fechaNacimiento" name="fechaNacimiento" />

						<p>Sexo:</p>
						<label for="hombre">Hombre</label> <input type="radio" id="hombre"
							name="sexo" value="hombre" checked="checked" /> <label
							for="mujer">Mujer</label> <input type="radio" id="mujer"
							name="sexo" value="mujer" />
						<p>
							<input type="submit" value="Guardar">
						</p>
					</fieldset>
				</form>
			</div>
			<!-- end login -->
		</div>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>
</body>
</html>