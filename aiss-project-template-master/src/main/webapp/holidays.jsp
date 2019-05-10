<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Holidays Info</title>
</head>
<body>

	<h1>Holidays from <c:out value="${param.country}"/></h1>
	<h2>Closest holiday is <c:out value="${requestScope.closestHoliday}"/></h2>
	<c:forEach items="${requestScope.holidays}" var="holiday">
		<span>Holiday Name: <c:out value="${holiday.name}"/></span><br/>
	</c:forEach>
	
	<h1>Tracks from "<c:out value="${requestScope.playlist}"/>"</h1>
	<c:forEach items="${requestScope.tracks}" var="track">
		<span>Track Name: <c:out value="${track.title}"/></span><br/>
	</c:forEach>

</body>
</html>