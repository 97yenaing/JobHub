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
					<li><a href=#>Home</a></li>
					<li><a href=#>Find Jobs</a></li>
					<li><a href=#>About Us</a></li>
					<li class="pc"><a href="#" >Log In</a></li>
					<li class="pc"><a href="#">Sign Up</a></li>
				</ul>
                
			</nav>
			<button class="btn-gnavi">
        <span id="one"></span>
        <span id="two"></span>
        <span id="three"></span>
      </button>			
			<a href="#" class="mobile login-out" >Log in</a> 
				<a href="#" class="mobile login-out">sign up</a>

		</div>
		
	</header>
	
	</body>
</html>