<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error page</title>
<link rel="icon" href="../images/icono.png">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-brown w3-center">
<div class="contenido">
  <div class="cabecera w3-display-middle">
    <img src="../images/C3 Logo.png" alt="Logo C3" id="logo" style="transform: rotate(180deg); margin-right:15px;"/>
    <h3><c:out value="${requestScope.mensajeError}"/><br/><a href="../index.html">Please try again</a></h3>
  </div>
</div>
<div id="footer">
  <p>&copy 2019 C<sup>3</sup>.Inc. All rights Reserved. Powered by <img src="images/dz_logo.png" / style="height: 20px;"><a href="#" style="margin-left:5px;">Documentación</a></p>
</div>
</body>
</html>
