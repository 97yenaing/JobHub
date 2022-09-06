<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="card">
    <c:url var="applicantProfile" value="/applicant/edit"></c:url>
    <form:form class="form-detail" action="${applicantProfile}" method="POST"
      id="form" modelAttribute="ApplicantProfile">
    <h1 class="profile-header">Profile</h1>
    <ul class="list-group list-group-unbordered mb-3">
     <li class="list-group-item"> <a
        class="float-right"> <form:input
            path="applicantInfo.profile" type="hidden" name="applicantProfile"
            value="${ApplicantProfile.applicantInfo.profile}" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Name:</b> <a
        class="float-right">${ApplicantProfile.name } <form:input
            path="name" type="hidden" name="company_name"
            value="${ApplicantProfile.name }" class="form-control" />
      </a></li>
     <li class="list-group-item"><b>Email:</b> <a
        class="float-right">${ApplicantProfile.email } <form:input
            path="email" type="hidden" name="email"
            value="${ApplicantProfile.email }" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Phone Number:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.phone } <form:input
            path="applicantInfo.phone" type="hidden" name="phone"
            value="${ApplicantProfile.applicantInfo.phone }" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Address:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.address} <form:input
            path="applicantInfo.address" type="hidden" name="address"
            value="${ApplicantProfile.applicantInfo.address}" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Job Experience Year:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.job_exp_year} <form:input
            path="applicantInfo.job_exp_year" type="hidden" name="job_experience"
            value="${ApplicantProfile.applicantInfo.job_exp_year}" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Job History:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.job_history} <form:input
            path="applicantInfo.job_history" type="hidden" name="job_history"
            value="${ApplicantProfile.applicantInfo.job_history}" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Education Background:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.edu_bg} <form:input
            path="applicantInfo.edu_bg" type="hidden" name="edu background"
            value="${ApplicantProfile.applicantInfo.edu_bg}" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Gender:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.gender} <form:input
            path="applicantInfo.gender" type="hidden" name="gender"
            value="${ApplicantProfile.applicantInfo.gender}" class="form-control" />
      </a></li>
      <li class="list-group-item"><b>Certificates:</b> <a
        class="float-right">${ApplicantProfile.applicantInfo.certificates} <form:input
            path="applicantInfo.certificates" type="hidden" name="certificates"
            value="${ApplicantProfile.applicantInfo.certificates}" class="form-control" />
      </a></li>
    </ul>
    <div class="btn-div">
      <button type="submit" class="btn button1" name="editCompany">Edit</button>
      &nbsp;
      <button type="submit" class="btn btn-secondary button2"
        name="cancel">Close</button>
    </div>
    </form:form>
  </div>