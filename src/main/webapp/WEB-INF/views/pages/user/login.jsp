<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <c:url value="/login" var="send">
  </c:url>
  <div class="com-inner">
    <div class="login-container">
      <form:form action="${send }" modelAttribute="userForm"
        method="post" >

        <h1 class="h1">login to jobhub</h1>
        <c:if test="${errorMsg != null}">
          <div>
            <span class="text-danger">${errorMsg }</span>
          </div>
        </c:if>
        <p>
          <form:input path="username" type="username" name="username"
            class="input" placeholder="Enter your username" />
        <div>
          <form:errors path="username" />
        </div>
        <form:password path="password" name="password" class="input"
          placeholder="Enter your password" />
        <div>
          <form:errors  class="pass-error" path="password" />
        </div>
        <div>
          <button type="submit" class="registerbtn">Send</button>
          <input type="hidden"
      name="${_csrf.parameterName}" value="${_csrf.token}" />
        </div>
        <div class = "forgot-pass">
          <a href="forgot-password">Forgot Password</a>
        </div>
       
        <div class="forgot-pass">
          <p>Do you have job hub account?</p>
        </div>
        <div>
          <button type="submit" class="registerbtn">Sign Up</button>
        </div>
      </form:form>
    </div>
  </div>
</body>
</html>