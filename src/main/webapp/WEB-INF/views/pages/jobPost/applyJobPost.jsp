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
  <div class="form-card">
    <h1 class="form-header">Applied Job Post</h1>
    <c:url var="appliedJobPost" value="/post/create/confirm"></c:url>
    <form:form class="form-container" action="${appliedJobPost}" method="POST" id="form" modelAttribute="">
      <c:if test="${errorMsg != null }">
        <div class="alert alert-danger">
          <strong>${errorMsg }</strong>
        </div>
      </c:if>
      <form:errors path="expected_salary" class="text-danger" />
      <div class="group clearfix">
        <label for="expected_salary">Expected Salary:</label> <br>
        <form:input path="expected_salary" value="" class="form-input" placeholder="Enter Expected Salary" /> 
      </div>
      <form:errors path="apply_reason" class="text-danger" />
      <div class="group clearfix">
        <label for="Offered Salary">Apply Reason:</label> <br>
        <form:input path="apply_reason" value="" class="form-input" placeholder="Enter Apply Reason." /> 
      </div>
      <form:errors path="cv_file_path" class="text-danger" />
      <div class="group clearfix">
        <label for="cv_file_path">CV File Path:</label> <br>
        <form:input path="cv_file_path" value="" class="form-input" placeholder="Enter your offered work experience." />
      </div>
      <%-- <form:errors path="apply_date" class="text-danger" />
      <div class="group clearfix">
        <label for="apply_date">Apply Date:</label> <br>
        <form:input path="apply_date" value="" class="form-input" placeholder="Enter your no. of vacancy." />
      </div> --%>
      
      <div class="create">
      <button type="submit" class="form-btn" name="confirmJobPost">Confirm</button>
      <button type="reset" class="reset-btn" name="clear">Reset</button>
    </div>
  </form:form>
  </div>
</body>
</html>