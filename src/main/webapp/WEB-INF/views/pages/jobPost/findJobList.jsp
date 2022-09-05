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
          <li><a href="${pageContext.request.contextPath}/post/list/byJobType?id=${jobType.id}"
          class="btn btn-info">${jobType.type_name}</a></li>
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
                <a href="<c:url value ="/post/details"/>">More details...</a>
              </div>
            </div>
          </li>
          </c:forEach>
        </ul>
        <%-- <ul id="tab-2" class="post-list">
          <li class="post tab2 heightline-post">
            <div class="clearfix">
              <!--<ul class="left-label">
                <li>Position:</li>
                <li>Salary:</li>
                <li>Experience Year:</li>
              </ul>
              <ul class="right-txt">
                <li>Sales & Marketing Manager</li>
                <li>500000</li>
                <li>5 years</li>
              </ul>-->
              <table>
                <tr>
                  <td>Position:</td>
                  <td>Senior WebDeveloper</td>
                </tr>
                <tr>
                  <td>Salary:</td>
                  <td>400000</td>
                </tr>
                <tr>
                  <td>Experience Year:</td>
                  <td>2 years</td>
                </tr>
              </table>
            </div>
            <div class="detail">
              <a href="">Details...</a>
            </div>
          </li>
        </ul>
        <ul id="tab-3" class="post-list">
          <li class="post tab3 heightline-post">
            <div class="clearfix">
              <!--<ul class="left-label">
                <li>Position:</li>
                <li>Salary:</li>
                <li>Experience Year:</li>
              </ul>
              <ul class="right-txt">
                <li>Translator</li>
                <li>200000</li>
                <li>none</li>
              </ul>-->
              <table>
                <tr>
                  <td>Position:</td>
                  <td>Senior WebDeveloper</td>
                </tr>
                <tr>
                  <td>Salary:</td>
                  <td>400000</td>
                </tr>
                <tr>
                  <td>Experience Year:</td>
                  <td>2 years</td>
                </tr>
              </table>
            </div>
            <div class="detail">
              <a href="<c:url value ="/post/details"/>">Details...</a>
            </div>
          </li>
        </ul> --%>
      </div> 
    </div>
  </section>
</body>
</html>