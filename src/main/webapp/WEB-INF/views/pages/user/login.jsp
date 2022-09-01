<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="content">
	<div>
	<a class="btn" href="<c:url value ="/"/>">Back</a><br>
    <a href="${pageContext.request.contextPath}/jobPostList">Company View JobPost List</a><br>
    <a href="<c:url value ="/createJobPosts"/>">Create Job Post</a><br>
    
    <a href="${pageContext.request.contextPath}/jobTypeList">Job Type List</a><br>
	</div>
	<section>
		<div>
			<h1>LOGIN PAGE</h1>
		</div>
	</section>
</div>
