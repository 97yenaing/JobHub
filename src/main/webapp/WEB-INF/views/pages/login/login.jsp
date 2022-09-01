<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="com-inner">
    <div class="email-container">
      <form action="<c:url value='/login' />" method="POST">
        <font color="red">
          ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>
        <h1 class="h1">login to jobhub</h1>
        <input type="text" name="username" placeholder="Enter user name"
          class="login-input" /><br /> <input type="password"
          name="password" placeholder="Enter password"
          class="login-input" /> <br /> <input type="submit"
          class="login-registerbtn" value="Login" /> <input
          type="hidden" name="${_csrf.parameterName}"
          value="${_csrf.token}" />
        <div class="forgot-pass">
          <a href="<c:url value ="/forgot_password"/>"> Forgot
            Password</a>
        </div>
        <div class="forgot-pass">
          <p>Do you have job hub account?</p>
        </div>
      </form>
      <a href="<c:url value ="/sign-up"/>"><input type="submit"
        class="login-registerbtn" value="Sign Up" /></a>
    </div>
  </div>
</body>
</html>