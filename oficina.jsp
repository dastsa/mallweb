<%@page import="co.com.aprocom.daohandler2.models.Field_cond"%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	import="java.sql.*, java.util.*" errorPage=""%>
<%@page import="co.com.mallweb.dao.Producto_DAO" %>
<%
String message=request.getParameter("msg");

Producto_DAO rdarRegDAO= new Producto_DAO();

	String nombre = request.getParameter("in_nombreA");
	List<String> fields_select= new ArrayList<String>();
	fields_select.add("id_producto");
	fields_select.add("nombre");

	List<Field_cond> fields_cond= new java.util.LinkedList<Field_cond>();
 	fields_cond.add(new Field_cond("nombre","like","%%"));
 	
 	List<String> fields_order_by= new java.util.LinkedList<String>();
 	fields_order_by.add("id_producto");
 	
 	List<Map<String, Object>> ls= rdarRegDAO.get(fields_select, fields_cond, 0, 999999999, fields_order_by);

	if (session.getAttribute("datos_usuario") == null) {
		response.sendRedirect("index.jsp");
	} else {
		Map<String, Object> datos_usuario = (Map<String, Object>) session.getAttribute("datos_usuario");
		String nombre_usuario = (String) datos_usuario.get("nombre");
		String apellido = (String) datos_usuario.get("apellidos");
		int celular = (Integer) datos_usuario.get("celular");

		/*if(habilitado == 0){
			response.sendRedirect("index.jsp?msg=Su Cuenta esta Deshabilitada, se le ah enviado un correo con el respectivo link de activaciòn");
		}*/
%>
<script>

alert("<%=message%>);
</script>
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
<script>
	function uploadFile(){
		//$("#file").click();
		//$("#file").button().click(function( event ) {
			
		//})
		//alert("---");
	}
	fuction selectedFile(){
		//alert($("#file").val());
		$("#file").change(
				function() {
					alert("---");
				}
		);
	}
	if(!message.equals("")){
		%>alert("<%=message%>");<
	}
	
</script>
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
					<li class="active"><a href="oficina.jsp">Inicio</a></li>
					<li class="active"><a href="expositorio.jsp">Entrar como cliente</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="wrapper bgded overlay"
		style="background-color: rgba(50, 50, 50)">
		<div id="pageintro" class="hoc clear">
							<h2 class="heading">Tus productos</h2>
					<p>Administrar tus productos.</p>
			<article>
				<div >
					
					<p>Nuevo Producto</p>
					<form action="Rproducto">
						<input type="text" id="P_id" name ="P_id" class="inputS" placeholder="identificacion producto" />
						<input type="text" id="P_nombre" name ="P_nombre" class="inputS" placeholder="Nombre del Producto" /> 
						<input type="text" id="P_precio" name ="P_precio" class="inputS" placeholder="Precio" /> 
						<input type="text" id="P_cantidad" name ="P_cantidad" class="inputS" placeholder="Cantidad" /> 
						<input type="file" id="P_imagen" name ="P_imagen" placeholder="Subir IMG" name="file" id="file" class="inputfile" style="opacity: 0;" onchange="selectedFile();" value="to" /> 
						<input type="submit" value="Aceptar" id="buttomN"/>
						<!--<input type="button" class="buttomS" value="Subir Imagen" onClick="uploadFile()" class="rm-button" /> -->
					</form>
				</div>
				<div>
					
					<p>Actualizar Precio</p>
					<form action="actualizarP">
							<input type="text" id="in_nombreA" name="in_nombreA" class="inputS" placeholder="Nombre Producto" />
							<input type="text" id="newprecio" name="newprecio" class="inputS" placeholder="Precio" /> 
							<input type="text" id="newcantidad" name="newcantidad" class="inputS" placeholder="Cantidad" /> 
							<input type="submit" value="Aceptar" id="buttomA"/>
					</form>
				</div>
				<div>
					
					<p>Actualizar Cantidad</p>
					<form action="actualizarC">
							<input type="text" id="in_nombreA" name="in_nombreA" class="inputS" placeholder="Nombre Producto" />
							<input type="text" id="newcantidad" name="newcantidad" class="inputS" placeholder="Cantidad" /> 
							<input type="submit" value="Aceptar" id="buttomA"/>
					</form>
				</div>
				<div>
					
					<p>Eliminar Producto</p>
					<form action="">
							<input type="text" id="in_nombreE" name="in_nombreE" class="inputS" placeholder="Nombre del Producto" />
							<input type="submit" value="Aceptar" id="buttomE"/>
					</form>
				</div>
			</article>
		</div>
	</div>
	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body -->
		<article class="group" id="quienesomos">
			<div class="group btmspace-80">
				<div class="one_quarter first">

					<h6 class="heading">Aqui tus productos</h6>
				</div>
				<div class="three_quarter">
					<ul>
						<%		 	    		
						for(int i = 0; i< ls.size()-1;i++){
							Map<String, Object> row= ls.get(i);
							%><li><%= (String) row.get("nombre") %></li><%
						} %>
						
					</ul>
					
				</div>
		</article>
	</div>
	<!-- ################################################################################################ -->
	<!-- / main body -->
	<div class="clear"></div>
	</main>
	</div>
	<div class="wrapper row4">
		<footer id="footer" class="hoc clear"> </footer>
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
<%
	}
%>