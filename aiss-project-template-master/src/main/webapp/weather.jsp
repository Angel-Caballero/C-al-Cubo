<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Weather Info</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>C al Cubo</h1>
	<h2>Weather from <c:out value="${param.city}"/>, <c:out value="${param.country}"/></h2>
	<h2><c:out value="${requestScope.weather}"/></h2>
</body>
</html>