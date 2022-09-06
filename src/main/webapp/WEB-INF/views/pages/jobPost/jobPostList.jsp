<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content-wrapper">
  <section class="content">
    <div class="row table-list">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">Job Post List</h3>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-sm-12 col-md-12">
                <div class="search-sec">
                  <%-- <c:url var="addAction" value="/searchUser"></c:url> --%>
                  <a
                    href="${pageContext.request.contextPath}/post/create"
                    class="btn btn-info">Create Job Post</a>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-12">
                <table id="example1"
                  class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Position</th>
                      <th>Offered Salary</th>
                      <th>Work Experience(year)</th>
                      <th>No.of Position</th>
                      <th>Created At</th>
                      <th>Updated At</th>
                      <th>Details</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${JobPostList}" var="jobPost"
                      varStatus="loop">
                      <tr>
                        <td>${jobPost.id }</td>
                        <td>${jobPost.position}</td>
                        <td>${jobPost.offered_salary }</td>
                        <td>${jobPost.experience_year}</td>
                        <td>${jobPost.num_of_position}</td>
                        <td>${jobPost.created_at}</td>
                        <td>${jobPost.updated_at}</td>
                        <td>
                          <a href="${pageContext.request.contextPath}/post/details?id=${jobPost.id}">Details</a> 
                        </td>
                        <%-- <c:forEach items="${jobPost.jobType}"
                          var="jobpost" varStatus="loop">
                          <td value="${jobpost.id}">${jobpost.type_name}</td>
                        </c:forEach> --%>
                        <td class="text-right py-0 align-middle">
                          <div class="btn-group btn-group-sm">
                            <a
                              href="${pageContext.request.contextPath}/post/edit?id=${jobPost.id}"
                              class="btn btn-secondary">Update</a> 
                              <a
                              href="${pageContext.request.contextPath}/post/delete?id=${jobPost.id}"
                              onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false">delete</a>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>