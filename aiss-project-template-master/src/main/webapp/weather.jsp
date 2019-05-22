<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Weather Info</title>
<link rel="icon" href="images/icono.png">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-brown w3-center">
	<div class="contenido">
		<div class="w3-container cabecera w3-padding-16">
    <a href="http://c-al-cubo.appspot.com"><img src="images/C3 Logo.png" alt="Logo C3" id="logo"/></a>
			<h1>
				<b>C al Cubo</b>
			</h1>
		</div>
		<h2>
			<b>Weather from <c:out value="${param.city}" />, <c:out
					value="${param.country}" /></b>
		</h2>
		<h2>
			<b><c:out value="${requestScope.weather}" /></b>
		</h2>

		<h2>
			<b><c:out value="${requestScope.error}" /></b>
		</h2>
		<h2>
			<b>Tracks from "<c:out value="${requestScope.playlist}" />"
			</b>
		</h2>
		<table class="w3-table w3-striped w3-light-green w3-card-4"
			style="width: 50%; margin-left: 25%;">
			<tbody>
				<c:forEach items="${requestScope.tracks}" var="track">
					<tr>
						<td><a href="#"><img src="images/like.png" style="height:20px; margin-right:5px"/></a>Track Name: <c:out value="${track.title}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="footer">
		<p>&copy 2019 C<sup>3</sup>.Inc. All rights Reserved. Powered by <img src="images/dz_logo.png" / style="height: 20px;"><a href="#" style="margin-left:5px;">Documentación</a></p>
	</div>
</body>
</html>
