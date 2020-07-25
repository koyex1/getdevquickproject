<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/imagess"/>


<c:set var="Root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>

<!-- BOOTSTRAP CSS -->
<link href= "${css}/bootstrap.min.css" rel= "stylesheet">
<!-- CUSTOM CSS -->
<c:set var="Root" value="${pageContext.request.contextPath}"/>
<link href= "${css}/myapp.css" rel= "stylesheet">

</head> 

<body> 
<div>
<h3>${storename}</h3>

<!-- navabar -->
<nav class="navbar navbar-dark bg-dark">
  <a href="${Root}/home"> <span class="navbar-brand mb-0 h1">Home</span></a>
</nav>

<!-- login form -->
<!-- stuck with default login. since i have 3hours left -->
<form name='f' action='/getdevquickproject/login' method='POST'>
<table>
	<tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
	<tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
	<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
	<tr><td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td></tr>
</table>
</form>



</div>




<!-- BOOTSTRAP JS -->
<script src= "${js}/bootstrap.min.js"></script>

<!-- CUSTOM JS -->
<script src= "${js}/jquery.js"></script>

</body> 

</html>

