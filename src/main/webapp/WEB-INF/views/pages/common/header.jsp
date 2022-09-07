<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title></title>
</head>
<body>
	<header>
		<div class="head-inner clearfix">
			<h1 ><img class="logo" src="<c:url value="/assets/img/logo-large.png" />" alt="JobHub_Log"></h1>	
			<nav id="global-navi" class="clearfix" >
				<ul class="clearfix">
					<li><a href="<%=request.getContextPath()%>/">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/post/applicant/list">Find Jobs</a></li>
					<li><a href="<%=request.getContextPath()%>/register">About us</a></li>
					<li class="pc"><a href="<%=request.getContextPath()%>/login" >Log in</a>
					</li>
					<li class="pc"><a href="<%=request.getContextPath()%>/register">sign up</a></li>
				</ul>
			</nav>
			<button class="btn-gnavi">
        <span id="one"></span>
        <span id="two"></span>
        <span id="three"></span>
      </button>			
			<a href="<%=request.getContextPath()%>/login" class="mobile login-out" >Log in</a> 
				<a href="<%=request.getContextPath()%>/register" class="mobile login-out">sign up</a>
		</div>
		
	</header>
	
	</body>
</html>