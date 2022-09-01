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
    <h1 class="profile-header">Confirm Job Type</h1>
    <c:url var="JobTypeInsert" value="/insertJobType"></c:url>
    <form:form class="form-create" action="${JobTypeInsert}" method="POST" id="form" modelAttribute="jobTypeDto">
    <input type="hidden" name="id" value="${jobTypeDto.id }">
      <ul class="list-group list-group-unbordered mb-3">
        <li class="list-group-item"><b>Job Type:</b> 
          <a class="float-right">${jobTypeDto.type_name } 
              <form:input path="type_name" type="hidden" name="type_name"
               value="${jobTypeDto.type_name }" class="form-control" />
          </a>
        </li> 
        <li class="list-group-item"><b>Description:</b> 
          <a class="float-right">${jobTypeDto.description } 
            <form:input path="description" type="hidden" name="description"
             value="${jobTypeDto.description }" class="form-control" />
          </a>
         </li>
    </ul>
    <button type="submit" class="confirm-btn1" name="addJobType">Create</button> &nbsp;
    <button type="submit" class="confirm-btn2" name="cancel">Cancel</button>
  </form:form>
</div>
</body>
</html>