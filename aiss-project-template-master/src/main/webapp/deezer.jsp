<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deezer Info</title>
</head>
<body>

	<h1>Tracks from "<c:out value="${requestScope.playlist}"/>"</h1>
	<c:forEach items="${requestScope.tracks}" var="track">
		<span>Track Name: <c:out value="${track.title}"/></span><br/>
	</c:forEach>
	
</body>
</html>