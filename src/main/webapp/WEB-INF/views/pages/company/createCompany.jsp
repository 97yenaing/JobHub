<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Company Registration</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="WEB-INF/assets/company-css/form.css" />
</head>

<body>
  <div class="form-card">
    <c:url var="createCompany" value="/company/Insert"></c:url>
    <h2 class="form-header">Company Registration</h2>
    <form:form class="form-detail" action="${createCompany}"
      method="POST" id="form" modelAttribute="rollBackCompanyForm">
      <div class="form-group">
        <c:if test="${errorMsg != null }">
          <div class="alert alert-danger">
            <strong>${errorMsg }</strong>
          </div>
        </c:if>
        <form:input type="hidden" path="user.name"
          value="${user.username}" />
        <form:input type="hidden" path="user.email"
          value="${user.email}" />
        <form:input type="hidden" path="user.password"
          value="${user.password}" />
        <form:input type="hidden" path="authority.id"
          value="${user.authority.id }" />
        <label for="company_name">Company Name:</label> <br>
        <form:input path="company_name"
          value=" ${rollBackCompanyForm.company_name}"
          class="form-input" placeholder="Enter Company Name" />
        <form:errors path="company_name" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="email">Company Email:</label> <br>
        <form:input path="email" value="${rollBackCompanyForm.email}"
          class="form-input" placeholder="Enter Company Email" />
        <form:errors path="email" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="Phone No">Phone No:</label> <br>
        <form:input path="phone" value="${rollBackCompanyForm.phone}"
          class="form-input" placeholder="Enter Company Ph Number" />
        <form:errors path="phone" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="Company Address">Company Address:</label> <br>
        <form:input path="address"
          value="${rollBackCompanyForm.address}" class="form-input"
          placeholder="Enter Company Address" />
        <form:errors path="address" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="Website link">Website Link:</label> <br>
        <form:input path="web_link"
          value="${rollBackCompanyForm.web_link}" class="form-input"
          placeholder="Enter Website Link" />
        <form:errors path="web_link" class="text-danger" />
      </div>
      <button type="submit" class="form-btn" name="addCompany">Create</button>
      <button type="reset" class="" name="clear">Reset</button>
    </form:form>
  </div>
</body>

</html>