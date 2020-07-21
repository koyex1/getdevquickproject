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
<link href= "${css}/myapp.css" rel= "stylesheet">

</head> 

<body> 
<div>
<h3>${storename}</h3>
<!-- PERMENTLY MOUNTED VIEWS -->
<!-- Navigation bar -->
<%@include file="./shared/navbar.jsp" %>
<!-- Genre Bar content-->
<%@include file="./shared/genrebar.jsp" %>

<!-- OPTIONAL VIEWS -->
<!-- Home bar -->
<c:if test="${userClickHome == true }">
<%@include file="./shared/home.jsp" %>
</c:if>
<!-- book bar -->
<c:if test="${userClickBook == true }">
<%@include file="./shared/book.jsp" %>
</c:if>

</div>




<!-- BOOTSTRAP JS -->
<script src= "${js}/bootstrap.min.js"></script>

<!-- CUSTOM JS -->
<script src= "${js}/jquery.js"></script>

</body> 

</html>

