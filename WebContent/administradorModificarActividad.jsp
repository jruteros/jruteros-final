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
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="encabezado.jsp" flush="false" />
			<jsp:include page="menuAdmin.jsp" flush="false" />
		</header>
		<div id="content">
			<div id="login">

				<h2>
					<span class="fontawesome-lock"></span>Modificar Actividad
				</h2>

				<form id="formu" modelAttribute="perfil" method="post"
					action="administradorAdminActividades.jsp">
					<fieldset>

						<p>
							<label for="nombreUsuario">Nombre de Actividad</label>
						</p>
						<p>
							<input type="text" name="nombre" value="Ciclismo" />
						</p>

						<p>
							<label for="password">Descripcion</label>
						</p>
						<p>
							<input type="text" name="clave" value="Descripcion de Ciclismo" />
						</p>

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