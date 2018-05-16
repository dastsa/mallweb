<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	import="java.sql.*, java.util.*" errorPage=""%>
<%@page import="co.com.mallweb.dao.Registro_DAO" %>
<!DOCTYPE html>
<!--
Template Name: Wetwest
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html lang="">
<!-- To declare your language - read more here: https://www.w3.org/International/questions/qa-html-language-declarations -->
<head>
<title>Compra y venta Medellin</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<body id="top">

	<div class="wrapper row1">
		<header id="header" class="hoc clear">

			<div id="logo" class="fl_left">
				<h1>
					<a href="index.html">Compra y venta Medellin</a>
				</h1>
			</div>
			<div id="quickinfo" class="fl_right">
				<ul class="nospace inline">
					<img src="images/logo.png" width="120" height="129" />
				</ul>
			</div>

		</header>
	</div>
	<div class="wrapper row2">
		<nav id="mainav" class="hoc clear">
			<div>
				<ul>
					<li class="active"><a href="index.jsp">Inicio</a></li>
					<li><a href="carrito.jsp">iniciar sesi&oacute;n</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body -->
		<article class="group" id="quienesomos">
			<div class="group btmspace-80">
				<h6 class="heading">Registrarme</h6>
				<div class="divR">
					<form method="post" action="Registro">
						<div class="divR2">
							<input type="text" 
								name="in_nombre" id="in_nombre" class="inputR"
								placeholder="Nombre de Usuario">
						</div>
						<div class="field ">
							<input type="text"
								name="in_apellido" class="inputR" id="in_apellido" placeholder="Apellidos"
								onBlur="getValidarLength($('#nomUser').val())"
								onKeyPress="return acceptAlphabetNumbers(event)" />
						</div>
						<div class="field">
							<input type="password"
								name="in_contrasenna" class="inputR" id="in_contrasenna"
								placeholder="Contraseña"
								onBlur="getValidarLength($('#contrasenna').val())"
								onKeyPress="return acceptAlphabetNumber(event)" />
						</div>
						<div class="field">
							<input type="text"
								name="in_cedula" class="inputR" id="in_cedula" required
								placeholder="Cedula"
								onBlur="getValidarLength($('#numcel').val())"
								onKeyPress="return acceptCelDigits(event)" />
						</div>
						<div class="field ">
							<input type="text"
								name="in_ciudad" class="inputR" id="in_ciudad" placeholder="Ciudad" required
								onBlur="getValidarLength($('#nomUser').val())"
								onKeyPress="return acceptAlphabetNumbers(event)">
						</div>
						<div class="field ">
							<input type="text"
								name="in_postal" class="inputR" id="in_postal" placeholder="Codigo postal" required
								onBlur="getValidarLength($('#numcel').val())"
								onKeyPress="return acceptCelDigits(event)">
						</div>
						<div class="field ">
							<input type="text" 
								name="in_direccion" class="inputR" id="in_direccion" placeholder="Direccion" required>
						</div>
						<div class="field">
							<input type="email" 
								name="in_email" class="inputR" id="in_email" placeholder="ejemplo@example.com"
								required onBlur="getValidarLength($('#email').val())"
								onKeyPress="return acceptAlphabetNumberEmail(event)">
						</div>
						<div class="field">
							 <input type="text" class="inputR"
								name="in_monedero" id="in_monedero" placeholder="Monedero BTC"
								required onBlur="getValidarLength($('#email').val())"
								onKeyPress="return acceptAlphabetNumberEmail(event)">
						</div>
						<div class="field ">
							<input type="text" class="inputR"
								name="in_numcel" id="in_numcel" placeholder="+570000000000" required
								onBlur="getValidarLength($('#numcel').val())"
								onKeyPress="return acceptCelDigits(event)">
						</div>
						<div>
							<input type="submit" value="Aceptar" id="buttomR"/>
						</div>
					</form>
				</div>
		</article>
	</div>
	<!-- ################################################################################################ -->
	<!-- / main body -->
	<div class="clear"></div>
	</main>
	</div>
	<div class="wrapper row4">
		<footer id="footer" class="hoc clear">
			<!-- ################################################################################################ -->
			<div class="one_half">
				<h6 class="heading">Contactenos</h6>
				<ul class="nospace btmspace-30 linklist contact">
					<li><i class="fa fa-map-marker"></i>
						<address>Calle 12 a sur # 52 a 33 - Medellin Antioquia</address></li>
					<li><i class="fa fa-phone"></i> +57 (311) 656 9152</li>
					<li><i class="fa fa-envelope-o"></i>
						appcomprayventam@gmail.com</li>
				</ul>
				<ul class="faico clear">
					<li><a class="faicon-facebook"
						href="https://www.facebook.com/compra.venta.medellin2015/"><i
							class="fa fa-facebook"></i></a></li>
					<li><a class="faicon-instagram"
						href="https://www.instagram.com/comprayventa.medellin/"><i
							class="fa fa-instagram"></i></a></li>
				</ul>
			</div>
			<div>
				<h6 class="heading">Contactanos</h6>
				<p class="nospace btmspace-10">Envianos tu opinion sobre nuestro
					trabajo, nos interesa escucharte</p>
				<form method="post" action="#">
					<fieldset>
						<legend>Newsletter:</legend>
						<input class="btmspace-15" type="text" value=""
							placeholder="Nombre"> <input class="btmspace-15"
							type="text" value="" placeholder="Email">
						<button type="submit" value="submit">Enviar</button>
					</fieldset>
				</form>
			</div>
			<!-- ################################################################################################ -->
		</footer>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row5">
		<div id="copyright" class="hoc clear">
			<!-- ################################################################################################ -->
			<p class="fl_left">Copyright &copy; 2018 - All Rights Reserved</p>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<script src="layout/scripts/jquery.min.js"></script>
	<script src="layout/scripts/jquery.backtotop.js"></script>
	<script src="layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>