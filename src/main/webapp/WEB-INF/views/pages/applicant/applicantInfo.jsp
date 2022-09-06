<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="form-card">
  <h1 class="form-header applicant-header">Applicant's Registration
  </h1>
  <c:if test="${errorMsg != null }">
    <div class="alert custom-alert">
      <strong>${errorMsg }</strong>
    </div>
  </c:if>
  <c:url var="applicantInfo" value="/applicantInfoSave"></c:url>
  <form:form class="form-container" action="${applicantInfo }"
    method="POST" id="form" modelAttribute="applicantInfoForm">
    <form:input type="hidden" path="user.name" value="${user.username}" />
    <form:input type="hidden" path="user.email" value="${user.email}" />
    <form:input type="hidden" path="user.password"
      value="${user.password}" />
    <form:input type="hidden" path="authority.id"
      value="${user.authority.id }" />

    <img src="" class="form-img" alt="profile">
    <div class="group">
      <label for="Phone No">Phone No:</label> <br>
      <form:input path="phone" value="${applicantInfoForm.phone }"
        class="form-input" placeholder="Enter Your Ph Number" />
      <form:errors path="phone" class="text-danger" />
    </div>
    <div class="group">
      <label for="company name">Address:</label> <br>
      <form:input path="address" value="${applicantInfoForm.address }"
        class="form-input" placeholder="Enter Your Address" />
      <form:errors path="address" class="text-danger" />
    </div>
    <div class="group">
      <label for="email">Gender:</label> <br>
      <form:select name="gender" path="gender"
        value="${applicantInfoForm.gender }" class="form-select">
        <option>MALE</option>
        <option>FEMALE</option>
      </form:select>
    </div>

    <div class="group">
      <label for="experience_year">Job Experience(Year):</label> <br>
      <form:input path="job_exp_year"
        value="${applicantInfoForm.job_exp_year }" class="form-input"
        placeholder="Enter Your Experience(Year)" />
      <form:errors path="job_exp_year" class="text-danger" />
    </div>
    <div class="group clearfix">
      <label for="job_history">Job History:</label> <br>
      <form:textarea path="job_history"
        value="${applicantInfoForm.job_history }" class="form-textarea"
        placeholder="Mention your previous jobs" rows="3" />
      <form:errors path="job_history" class="text-danger" />
    </div>
    <div class="group clearfix">
      <label for="edu_bg">Education Background:</label> <br>
      <form:textarea path="edu_bg" value="${applicantInfoForm.edu_bg }"
        class="form-textarea" placeholder="Enter Your Edu Background."
        rows="3" />
      <form:errors path="edu_bg" class="text-danger" />
    </div>
    <div class="group clearfix">
      <label for="certificates">Certificates:</label> <br>
      <form:textarea path="certificates"
        value="${applicantInfoForm.certificates }" class="form-textarea"
        placeholder="Mention the Certificates you got." rows="3" />
      <form:errors path="certificates" class="text-danger" />
    </div>
    <div class="create">
    <button type="submit" class="form-btn" name="addApplicant">Create</button>
    <button type="reset" class="reset-btn" name="clear">Reset</button>
  </div>
  </form:form>
</div>