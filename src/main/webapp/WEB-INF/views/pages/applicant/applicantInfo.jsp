<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="form-card">
  <h1 class="form-header applicant-header">Applicant's Registration
  </h1>
  <c:url var="applicantInfo" value="/applicantInfoSave"></c:url>
  <form:form class="form-container" action="${applicantInfo }"
    method="POST" id="form" modelAttribute="applicantInfoForm">
    <form:input type="hidden" path="user.name" value="${user.username}" /> 
    <form:input type="hidden" path="user.email" value="${user.email}" />
    <form:input type="hidden" path="user.password" value="${user.password}" />

    <img src="" class="form-img" alt="profile">
    <div class="form-group">
      <label for="Phone No">Phone No:</label> <br> <form:input
        path="phone" value="${applicantInfoForm.phone }" class="form-input"
        placeholder="Enter Your Ph Number" />
<%--       <form:errors path="email" class="text-danger" /> --%>
    </div>
    <div class="form-group">
      <label for="company name">Address:</label> <br> <form:input
        path="address" value="${applicantInfoForm.address }" class="form-input"
        placeholder="Enter Your Address" />
<%--       <form:errors path="username" class="text-danger" /> --%>
    </div>
    <div class="form-group">
      <label for="email">Gender:</label> <br> <form:select name="gender" path="gender" value="${applicantInfoForm.gender }"
        class="form-select">
        <option>MALE</option>
        <option>FEMALE</option>
      </form:select>
    </div>

    <div class="form-group">
      <label for="experience_year">Job Experience(Year):</label> <br>
      <form:input path="job_exp_year" value="${applicantInfoForm.job_exp_year }" class="form-input"
        placeholder="Enter Your Experience(Year)" />
<%--       <form:errors path="autho.id" class="text-danger" /> --%>
    </div>
    <div class="form-group-textarea clearfix">
      <label for="job_history">Job History:</label> <br>
      <form:textarea path="job_history" value="${applicantInfoForm.job_history }" class="form-textarea" placeholder="Mention your previous jobs" rows="3" />
<%--       <form:errors path="autho.id" class="text-danger" /> --%>
    </div>
    <div class="form-group-textarea clearfix">
      <label for="edu_bg">Education Background:</label> <br>
      <form:textarea path="edu_bg" value="${applicantInfoForm.edu_bg }" class="form-textarea"
        placeholder="Enter Your Edu Background." rows="3" />
<%--       <form:errors path="autho.id" class="text-danger" /> --%>
    </div>
    <div class="form-group-textarea clearfix">
      <label for="certificates">Certificates:</label> <br>
      <form:textarea path="certificates" value="${applicantInfoForm.certificates }" class="form-textarea"
        placeholder="Mention the Certificates you got." rows="3" />
<%--       <form:errors path="autho.id" class="text-danger" /> --%>
    </div>
    <button type="submit" class="form-btn-textarea" name="addApplicant">Create</button>
    <button type="reset" class="" name="clear">Cancel</button>
  </form:form>
</div>
