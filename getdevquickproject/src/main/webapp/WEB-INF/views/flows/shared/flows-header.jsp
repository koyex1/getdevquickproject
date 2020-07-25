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

<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="${flowExecutionUrl}&_eventId_home">Home</a>
  </li>
</ul>