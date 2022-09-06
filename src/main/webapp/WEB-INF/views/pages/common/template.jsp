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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lexend&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/assets/css/reset.css" />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/assets/css/app.css" />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/assets/css/signup1.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/slick.css" />"
  type="text/css" />

<!-- // start for datatable responsive -->
<link rel="stylesheet" href="<c:url value="/assets/css/form.css" />"
  type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- // end -->

<script
  src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/resources/js/adminlte.min.js"/>"></script>
<script src="<c:url value="/resources/js/common.js"/>"></script>
<script src="<c:url value="/resources/js/demo.js"/>"></script>
<script type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet"
  href='<c:url value="/resources/plugins/fontawesome-free/css/all.min.css"/>'>
<link rel="stylesheet"
  href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="<c:url value="/assets/css/findJob.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/form1.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/confirm_form.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/list.css" />"
  type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/emailSendForm.css" />"
    type="text/css" />
  <link rel="stylesheet" href="<c:url value="/assets/css/login.css" />"
    type="text/css" />
    
  <link rel="stylesheet" href="<c:url value="/assets/css/passwordReset.css" />"
    type="text/css" />
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container main-content">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
<%-- 	<script src="<c:url value="/assets/js/jquery-3.6.0.min.js" />"></script> --%>
    <script src="<c:url value="/assets/js/jquery.heightLine.js" />"></script>
	<script src="<c:url value="/assets/js/app.js" />"></script>
</body>
</html>