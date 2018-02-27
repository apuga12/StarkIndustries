<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Spring forms :: Users</title>
	
	<!-- Mejorar el estilo con Bootstrap -->	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value="./../../resources/css/style.css" />" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Users app</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="<s:url value="/assignments" />"
						title="Asignaciones">Asignaciones</a></li>
						
					<li class="active"><a href="<s:url value="/users" />"
						title="Vista de Usuarios">Vista de Usuarios</a></li>
								
					<li><a href="<s:url value="/users/new" />"
						title="Nuevo Usuario">Nuevo Usuario</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h2>Lista de Usuarios >>> </h2>
			<p>A continuación se presentan los usuarios actuales del sistema: </p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Login</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.login}</td>
						<td>${user.description}</td>
						<td><a class="btn btn-sm btn-primary"
							href="<s:url value="/user/${user.id}" />" title="Info detalle">
								Vista detalle</a></td>
					</tr>
				</c:forEach>
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
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>