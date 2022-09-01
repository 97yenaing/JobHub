<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Job Type</title>
</head>
<body>
  <div class="form-card">
    <h1 class="form-header">Update Job Type</h1>
    <c:url var="editJobType" value="/editedJobTypeConfirm"></c:url>
    <form:form class="form-container" action="${editJobType}" method="POST" id="form" modelAttribute="editJobTypeDto">
    <input type="hidden" name="id"
                value="${editJobTypeDto.id }" />
      <div class="form-group">
        <label for="type_name">Job Type:</label> <br>
        <form:input path="type_name" value="${editJobTypeDto.type_name }" class="form-input" placeholder="Enter Job Type" />
      </div>
      <div class="form-group">
        <label for="description">Description:</label> <br>
        <form:input path="description" value="${editJobTypeDto.description}" class="form-input" placeholder="Enter the description for your job." rows="6" />
        </div>
      <button type="submit" class="form-btn" name="confirmJobType">Confirm Edit</button>
      <a class="btn btn-secondary" href="${pageContext.request.contextPath}/jobTypeList">Back</a>
      <a class="btn btn-secondary" href="${pageContext.request.contextPath}/editJobTypes?id=${editJobTypeDto.id}">Reset</a>
      <!-- <button type="reset" class="" name="clear">Back</button> -->
  </form:form>
  </div>
</body>
</html>