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
  <div class="card">
    <h1 class="profile-header">Job Post Details</h1>
    <c:url var="postDetails" value="/post/edit/confirm"></c:url>
    <form:form class="form-container" action="${postDetails }" method="POST" id="form" modelAttribute="jobPostDetails">
    <input type="hidden" name="id" value="${jobPostDetails.id }" />
    <ul class="list-group list-group-unbordered mb-3">
    <li class="list-group-item"><b>Position:</b> <a
      class="float-right">${jobPostDetails.position } <form:input
          path="position" type="hidden" name="position"
          value="${jobPostDetails.position }"
          class="form-control" />
    </a></li> 
    <li class="list-group-item"><b>Offered Salary:</b> <a
      class="float-right">${jobPostDetails.offered_salary } <form:input
          path="offered_salary" type="hidden" name="offered_salary"
          value="${jobPostDetails.offered_salary }"
          class="form-control" />
    </a></li>
    <li class="list-group-item"><b>Offered Work Experience:</b> <a
      class="float-right">${jobPostDetails.experience_year } <form:input
          path="experience_year" type="hidden" name="experience_year"
          value="${jobPostDetails.experience_year }"
          class="form-control" />
    </a></li>
    <li class="list-group-item"><b>Num Of Position:</b> <a
      class="float-right">${jobPostDetails.num_of_position } <form:input
          path="num_of_position" type="hidden" name="num_of_position"
          value="${jobPostDetails.num_of_position }"
          class="form-control" />
    </a></li>
    <%-- <li class="list-group-item"><b>Phone Number:</b> <a
      class="float-right">${jobPostDetails.phone } <form:input
          path="phone" type="hidden" name="phone"
          value="${jobPostDetails.phone }"
          class="form-control" />
    </a></li>
    <li class="list-group-item"><b>Email:</b> <a
      class="float-right">${jobPostDetails.email } <form:input
          path="email" type="hidden" name="email"
          value="${jobPostDetails.email }"
          class="form-control" />
    </a></li> --%>
    <li class="list-group-item"><b>Created Date:</b> <a
      class="float-right">${jobPostDetails.created_at } <form:input
          path="created_at" type="hidden" name="created_at"
          value="${jobPostDetails.created_at }"
          class="form-control" />
    </a></li>
    <li class="list-group-item"><b>Expired Date:</b> <a
      class="float-right">${jobPostDetails.expired_at } <form:input
          path="expired_at" type="hidden" name="expired_at"
          value="${jobPostDetails.expired_at }"
          class="form-control" />
    </a></li>
  </ul>
  </form:form>
    <button type="submit" class="confirm-btn1" name="addUser">Apply</button> &nbsp; &nbsp;
    <button type="submit" class="confirm-btn2" name="cancel">Back</button>
</div>
</body>
</html>