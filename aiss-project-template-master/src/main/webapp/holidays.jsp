<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Holidays Info</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<h1>C al Cubo</h1>
	
	<h2>Holidays from <c:out value="${param.country}"/></h2>
	<h3>Closest holiday is <c:out value="${requestScope.closestHoliday}"/></h3>
	<c:forEach items="${requestScope.holidays}" var="holiday">
		<span>Holiday Name: <c:out value="${holiday.name}"/></span><br/>
	</c:forEach>
	
	<h2>Tracks from "<c:out value="${requestScope.playlist}"/>"</h2>
	<c:forEach items="${requestScope.tracks}" var="track">
		<span>Track Name: <c:out value="${track.title}"/></span><br/>
	</c:forEach>

</body>
</html>