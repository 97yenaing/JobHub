<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    href="${pageContext.request.contextPath}/createJobPosts"
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
                      <!-- <th>Contact Phone</th>
                      <th>Contact Email</th> -->
                      <th>Created At</th>
                      <th>Expired At</th>
                      <!-- <th>Job Type</th> -->
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
                        <td>${jobPost.expired_at}</td>
                        <%-- <c:forEach items="${jobPost.jobType}"
                          var="jobpost" varStatus="loop">
                          <td value="${jobpost.id}">${jobpost.type_name}</td>
                        </c:forEach> --%>
                        <td class="text-right py-0 align-middle">
                          <div class="btn-group btn-group-sm">
                            <a
                              href="${pageContext.request.contextPath}/editJobPosts?id=${jobPost.id}"
                              class="btn btn-secondary">Update</a> <a
                              href="#" data-toggle="modal"
                              data-href="${pageContext.request.contextPath}/deleteJobPost?id=${jobPost.id }"
                              data-target="#myModal"
                              class="btn btn-danger btn-ok"> Delete</a>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <form action="<%=request.getContextPath()%>/logout"
            method="POST">
            <input type="submit" value="Logout" /> <input type="hidden"
              name="${_csrf.parameterName}" value="${_csrf.token}" />
          </form>
        </div>
      </div>
    </div>
  </section>
</div>

<div class="modal fade" id="myModal" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    Modal content
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Delete User Confirmation!</h4>
      </div>
      <div class="modal-body">
        <p>Are You Sure Want to Delete!</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
          data-dismiss="modal">Cancel</button>
        <a class="btn btn-danger btn-ok">OK</a>
      </div>
    </div>
  </div>
</div>
<script>
	$('#myModal').on(
			'show.bs.modal',
			function(e) {
				$(this).find('.btn-ok').attr('href',
						$(e.relatedTarget).data('href'));
				$('.debug-url').html(
						'Delete URL: <strong>'
								+ $(this).find('.btn-ok').attr('href')
								+ '</strong>');
			});
</script>