<%@page import="co.com.mallweb.dao.Detalle_DAO"%>
<%@page import="co.com.aprocom.daohandler2.models.Field_cond"%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	import="java.sql.*, java.util.*" errorPage=""%>
<%@page import="co.com.mallweb.dao.Producto_DAO" %>
<%@page import="co.com.mallweb.dao.Detalle_DAO" %>
<%
String message=request.getParameter("msg");
int total=0;
Producto_DAO rdarRegDAO= new Producto_DAO();
Detalle_DAO detalle= new Detalle_DAO();

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
		String id = (String) datos_usuario.get("cedula");
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
					<li class="active"><a href="expositorio.jsp">Inicio</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="clear">
	<div class="wrapper row4">
		<footer id="footer" class="hoc clear">
			<!-- ################################################################################################ -->
			<div class="one_half">
				<h6>Productos Disponibles</h6>
				<ul>
				<%	for(int i = 0; i< ls.size()-1;i++){
							Map<String, Object> row= ls.get(i);
							%><li><%= (String) row.get("nombre") %></li><%
						} %>
				</ul>

			</div>
			<div>
				<h6 class="heading">Carrito de compras</h6>
				<p class="nospace btmspace-10">Copia el nombre del producto que quieres de nuestra lista.</p>
				<form action="CompraP">
					<fieldset>
						<input type="text" id="V_nombre" name ="V_nombre" class="btmspace-15" placeholder="Nombre del Producto" /> 
						<input type="text" id="V_cantidad" name ="V_cantidad" class="btmspace-15" placeholder="Cantidad" />
						<input type="text" id="V_id" name ="V_id" class="btmspace-15" value="<%=id %>" style="opacity: 0px;" /> 
						<input type="submit" value="Aceptar" id="buttomN"/>
						<a href="pago.jsp" style="background-color:#333333;padding-top:15px; display: block;text-align: center;color: white;">Pagar</a>
					</fieldset>
				</form>
			</div>
			<!-- ################################################################################################ -->
		</footer>
	</div>
	</div>
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