<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Job</title>
</head>
<body>
  <section class="find-first-sec">
    <div class="com-inner clearfix">
      <div class="job-ttl">
        <h2>You can search many jobs online to find the next step in your career. </h2>
      </div>
      <div class="type">
        <ul class="nav-tabs clearfix">
        <c:forEach items="${JobTypeList}" var="jobType" varStatus="loop"> 
          <li><a href="${pageContext.request.contextPath}/post/list/byJobType?id=${jobType.id}">${jobType.type_name}</a></li>
        </c:forEach>
        </ul>
        <ul class="post-list clearfix">
        <c:forEach items="${ApplicantJobPost}" var="jobPost" varStatus="loop">
          <li class="post tab1 heightline-post">
            <div class="clearfix">
              <table>
                <tr>
                  <td>Position:</td>
                  <td>${jobPost.position }</td>
                </tr>
                <tr>
                  <td>Salary:</td>
                  <td>${jobPost.offered_salary }</td>
                </tr>
                <tr>
                  <td>Experience Year:</td>
                  <td>${jobPost.experience_year }</td>
                </tr>
              </table>
              <div class="detail">
                <i class="fa-solid fa-circle-right"></i>
                <a href="${pageContext.request.contextPath}/post/details?id=${jobPost.id}">More Details...</a>
              </div>
            </div>
          </li>
          </c:forEach>
        </ul>
      </div> 
    </div>
  </section>
</body>
</html>