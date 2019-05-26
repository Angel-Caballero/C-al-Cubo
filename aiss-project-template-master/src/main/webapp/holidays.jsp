<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Holidays Info</title>
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
			<b>Holidays from <c:out value="${param.country}" /></b>
		</h2>
		<h3>
			<b>Closest holiday is <c:out
					value="${requestScope.closestHoliday}" /></b>
		</h3>
		<table class="w3-table w3-striped w3-light-green w3-card-4"
			style="width: 50%; margin-left: 25%;">
			<tbody>
				<c:forEach items="${requestScope.holidays}" var="holiday">
					<tr>
						<td><form action="/CalendarController" style="display:inline">
						<input type="text" name="country" value="<c:out value='${param.country}' />" style="display:none"/>
						<input type="text" name="closestHoliday" value="<c:out value='${requestScope.closestHoliday}' />" style="display:none"/>
							<input type="text" name="holidayName" value="<c:out value='${holiday.name}' />" style="display:none"/>
							<input type="text" name="holidayDescription" value="<c:out value='${holiday.description}' />" style="display:none"/>
							<input type="text" name="holidayIso" value="<c:out value='${holiday.date.iso}' />" style="display:none"/>
							<input type="image" value="submit" src="images/like.png" alt="submit Button" onMouseOver="this.src='images/like.png'" style="height:20px; margin-right:5px"/>
						</form>Holiday Name: <c:out value="${holiday.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
						<td>Track Name: <c:out value="${track.title}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="footer">
		<p>&copy 2019 C<sup>3</sup>.Inc. All rights Reserved. Powered by <img src="images/dz_logo.png" style="height: 20px;"><a href="#" style="margin-left:5px;">Documentación</a></p>
	</div>
</body>
</html>
