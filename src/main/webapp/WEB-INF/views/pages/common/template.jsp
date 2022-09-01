<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN">
<html>
<head>

<meta charset='UTF-8'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="${pageContext.request.contextPath}">

<title><tiles:insertAttribute name="title" /></title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lexend&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/assets/css/reset.css" />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/assets/css/app.css" />"
	type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/findJob.css" />"
  type="text/css" />
  
  <link rel="stylesheet" href="<c:url value="/assets/css/form1.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/confirm_form.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/list.css" />"
  type="text/css" />
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container main-content">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
	<script src="<c:url value="/assets/js/jquery-3.6.0.min.js" />"></script>
    <script src="<c:url value="/assets/js/jquery.heightLine.js" />"></script>
	<script src="<c:url value="/assets/js/app.js" />"></script>
</body>
</html>