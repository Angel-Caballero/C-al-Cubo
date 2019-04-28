<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deezer Info</title>
</head>
<body>

	<h1>Tracks from <c:out value="${param.playlist}"/></h1>
	<c:forEach items="${requestScope.tracks}" var="holiday">
		<span>Holiday Name: <c:out value="${holiday.tittle}"/></span><br/>
	</c:forEach>
	
</body>
</html>