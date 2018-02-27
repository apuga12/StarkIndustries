<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Configurador de canales forms :: Admin</title>
	
	<!-- Mejorar el estilo con Bootstrap -->	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
</head>

<body>
<!-- 	<nav class="navbar navbar-inverse navbar-fixed-top"> -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Configurador de canales</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="<s:url value="/catChannels" />"
						title="Catálogo de canales">Todos los Canales</a></li>
						
					<li class="active"><a href="<s:url value="/channelRpt" />"
						title="Canales por RPT">Canales / RPT</a></li>
								
					<li><a href="<s:url value="/channelPack" />"
						title="Canales por paquete y RPT">Canales / Pack</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<section class="jumbotron jumbotron-chema">	
	<br><br>
		<div class="container">
			<h2 class="text-center color-primary mb-2 wow fadeInDown" style="visibility: visible; animation-name: fadeInDown;">
				Guía de canales
			</h2>
			<p class="lead text-center aco wow fadeInDown animation-delay-5 mw-800 center-block mb-4" style="visibility: visible; animation-name: fadeInDown;">
				Administración de Canales, RPT (Ciudades) y Paquetes.
			</p>
		</div>
	</section>
	<div class="container">
		
<!-- 		<table class="table"> -->
		<table class="table table-no-border table-striped" >
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>				
				<tr>	
					<td>
						<a class="btn btn-sm btn-primary" href="<s:url value="/newPackage" />" title="Nuevo Paquete comercial">
							Nuevo Paquete comercial
						</a>
					</td>
					<td>
						<a class="btn btn-sm btn-primary" href="<s:url value="/newRpt" />" title="Nuevo RPT">
							Nuevo RPT (Ciudad izzi)
						</a>
					</td>									
					<td>
						<a class="btn btn-sm btn-primary" href="<s:url value="/newChannel" />" title="Nuevo Canal">
							Nuevo canal
						</a>
					</td>
				</tr>
				<tr>	
					<td></td><td></td><td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2017 Andrés Puga</p>
		</div>
	</footer>
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>