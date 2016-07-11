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



			<h1>Registro exitoso</h1>
			<div>Usuario: admin</div>
			<div>Contraseña: p4ssW00rD</div>
			<div>
				<p>La contraseña ha sido generada por el sistema, por favor, le
					solicitamos que la cambie lo antes posible. Gracias.</p>

			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<footer>
		<p>Sistema para Socialización de Rutas - Copyright (c) 2016</p>
	</footer>
</body>
</html>