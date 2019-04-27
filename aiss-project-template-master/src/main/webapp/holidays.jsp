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

	<legend>Holidays from <c:out value="${param.country}"/></legend>
	<c:forEach items="${requestScope.holidays}" var="holiday">
		<span>Holiday Name: <c:out value="${holiday.name}"/></span><br/>
	</c:forEach>

</body>
</html>