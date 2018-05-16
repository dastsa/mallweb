<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	import="java.sql.*, java.util.*" errorPage=""%>
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
<title>Carrito</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="index.jsp">Carrito de compras</a></h1>
    </div>
    <div id="quickinfo" class="fl_right">
      <ul class="nospace inline">
        <img src="images/logo.png" width="120" height="129"/>
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </header>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <nav id="mainav" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div>
      <ul>
        <li class="active"><a href="index.jsp">Inicio</a></li>
        <li><a href="productos.jsp">Tienda</a></li>
        <li><a href="carrito.jsp">Carrito De Compras</a></li>
        
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </nav>
</div>
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="hoc container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <img class="imgl borderedbox inspace-5" src="../images/demo/imgl.gif" alt="">
      <h1>Productos en el carrito</h1>
      <div class="scrollable">
        <table>
          <thead>
            <tr>
              <th>Producto </th>
              <th>Cantidad</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>producto 1</td>
              <td>catidad 1</td>
              <td>valor  1</td>
            </tr>
            <tr>
              <td>producto 2</td>
              <td>catidad 2</td>
              <td>valor  2</td>
            </tr>
            <tr>
              <td>producto 3</td>
              <td>catidad 3</td>
              <td>valor  3</td>
            </tr>
            <tr>
              <td>Total a pagar</td>
              <td></td>
              <td>valor total</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="comments">
        <h2>Datos Cliente</h2>
        <form action="#" method="post">
          <div class="one_third first">
            <label for="name">Direccion <span>*</span></label>
            <input type="text" name="name" id="name" value="" size="22" required>
          </div>
          <div class="one_third">
            <label for="email">Celular <span>*</span></label>
            <input type="email" name="email" id="email" value="" size="22" required>
          </div>
          <div class="one_third">
            <label for="url">Hora de entrega</label>
            <input type="url" name="url" id="url" value="" size="22">
          </div>
          <div class="block clear">
            <label for="comment">Especificasiones del lugar de envio</label>
            <textarea name="comment" id="comment" cols="25" rows="10"></textarea>
          </div>
          <div>
            <input type="submit" name="submit" value="Submit Form">
            &nbsp;
            <input type="reset" name="reset" value="Reset Form">
          </div>
        </form>
      </div>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row4">
  <footer id="footer" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div class="one_half">
      <h6 class="heading">Contactenos</h6>
      <ul class="nospace btmspace-30 linklist contact">
        <li><i class="fa fa-map-marker"></i>
          <address>
          Calle 12 a sur # 52 a 33 - Medellin Antioquia
          </address>
        </li>
        <li><i class="fa fa-phone"></i> +57 (311) 656 9152</li>
        <li><i class="fa fa-envelope-o"></i> appcomprayventam@gmail.com</li>
      </ul>
      <ul class="faico clear">
        <li><a class="faicon-facebook" href="https://www.facebook.com/compra.venta.medellin2015/"><i class="fa fa-facebook"></i></a></li>
        <li><a class="faicon-instagram" href="https://www.instagram.com/comprayventa.medellin/"><i class="fa fa-instagram"></i></a></li>
      </ul>
    </div>
    <div>
      <h6 class="heading">Contactanos</h6>
      <p class="nospace btmspace-10">Envianos tu opinion sobre nuestro trabajo, nos interesa escucharte</p>
      <form method="post" action="#">
        <fieldset>
          <legend>Newsletter:</legend>
          <input class="btmspace-15" type="text" value="" placeholder="Nombre">
          <input class="btmspace-15" type="text" value="" placeholder="Email">
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
    <p class="fl_left">Copyright &copy; 2017 - All Rights Reserved</p>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS --> 
<script src="../layout/scripts/jquery.min.js"></script> 
<script src="../layout/scripts/jquery.backtotop.js"></script> 
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>