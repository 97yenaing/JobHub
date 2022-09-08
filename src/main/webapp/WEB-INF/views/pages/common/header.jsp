<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
      <h1>
        <img class="logo"
          src="<c:url value="/assets/img/header/logo-large.png" />"
          alt="JobHub_Log">
      </h1>
      <nav id="global-navi" class="clearfix">
        <ul class="clearfix">
          <li><a href="<%=request.getContextPath()%>/">Home</a></li>
          <li><a
            href="<%=request.getContextPath()%>/post/applicant/list">Find
              Jobs</a></li>
          <security:authorize
            access="hasAnyRole('COMPANY','APPLICANT','ADMIN')"
            var="isLoggedin" />
          <c:choose>
            <c:when test="${isLoggedin}">
              <li class="user-about"><a
                href="<%=request.getContextPath()%>/register">About
                  us</a></li>

              <c:if test="${Login != null}">

                <c:forEach items="${Login.authorities}" var="authority"
                  varStatus="loop">

                  <c:if test="${authority.id == 1}">
                    <li class="tab"><div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">Dashboard</button>
                        <div id="myDropdown" class="dropdown-content">
                          <a
                            href="<%=request.getContextPath()%>/company/List">Company
                            List</a> <a
                            href="<%=request.getContextPath()%>/applicant/list">ApplicantInfo
                            List</a> <a
                            href="<%=request.getContextPath()%>/userInfo">User
                            List</a> <a
                            href="<%=request.getContextPath()%>/post/list">Job
                            Category List</a>

                        </div>
                      </div></li>
                    <li class="pc image"><a
                      href="<%=request.getContextPath()%>/log-out"><img
                        src="<c:url value="/assets/img/header/log-out.png" />"
                        alt="logout"></a></li>
                    <li class="pc sing-up"><a
                      href="<%=request.getContextPath()%>/register">Sign
                        up</a></li>
                    <%--  </c:if>
                </c:forEach> --%>
                  </c:if>

                  <c:if test="${authority.id == 2}">
                    <li class="tab"><div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">Dashboard</button>
                        <div id="myDropdown" class="dropdown-content">
                          <a
                            href="<%=request.getContextPath()%>/applicant/list">ApplicantInfo
                            List</a> <a
                            href="<%=request.getContextPath()%>/post/list">Job
                            Category List</a>

                        </div>
                      </div></li>
                    <li class="pc image"><a
                      href="<%=request.getContextPath()%>/company/Profile?company_id=${Login.company.company_id}"><img
                        src="<c:url value="/assets/img/header/profile.png" />"
                        alt="Profile"></a></li>
                         <li class="pc image"><a
                      href="<%=request.getContextPath()%>/log-out"><img
                        src="<c:url value="/assets/img/header/log-out.png" />"
                        alt="logout"></a></li>
                  </c:if>

                  <c:if test="${authority.id == 3}">
                    <li class="tab"><div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">Dashboard</button>
                        <div id="myDropdown" class="dropdown-content">
                          <a
                            href="<%=request.getContextPath()%>/applicant/list">ApplicantInfo
                            List</a> <a
                            href="<%=request.getContextPath()%>/post/list">Job
                            Category List</a>

                        </div>
                      </div></li>
                    <li class="pc image"><a
                      href="<%=request.getContextPath()%>/applicant/profile?id=${Login.applicantInfo.id}"><img
                        src="<c:url value="/assets/img/header/profile.png" />"
                        alt="Profile"></a></li>
                         <li class="pc image"><a
                      href="<%=request.getContextPath()%>/log-out"><img
                        src="<c:url value="/assets/img/header/log-out.png" />"
                        alt="logout"></a></li>
                  </c:if>

                </c:forEach>
              </c:if>
            </c:when>
            <c:otherwise>
              <li class="about-us"><a
                href="<%=request.getContextPath()%>/register">About
                  us</a></li>
              <li class="pc login-header"><a
                href="<%=request.getContextPath()%>/login">Log in</a></li>
              <li class="pc sign-up"><a
                href="<%=request.getContextPath()%>/register">Sign
                  up</a></li>
            </c:otherwise>
          </c:choose>
        </ul>
      </nav>
      <button class="btn-gnavi">
        <span id="one"></span> <span id="two"></span> <span id="three"></span>
      </button>
      <a href="<%=request.getContextPath()%>/login"
        class="mobile login-out">Log in</a> <a
        href="<%=request.getContextPath()%>/register"
        class="mobile login-out">sign up</a>
    </div>

  </header>
  <script>
			function myFunction() {
				document.getElementById("myDropdown").classList.toggle("show");
			}

			window.onclick = function(event) {
				if (!event.target.matches('.dropbtn')) {
					var dropdowns = document
							.getElementsByClassName("dropdown-content");
					var i;
					for (i = 0; i < dropdowns.length; i++) {
						var openDropdown = dropdowns[i];
						if (openDropdown.classList.contains('show')) {
							openDropdown.classList.remove('show');
						}
					}
				}
			}
		</script>

</body>
</html>