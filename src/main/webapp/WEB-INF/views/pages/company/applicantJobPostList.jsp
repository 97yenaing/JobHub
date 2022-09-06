<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="list-data">
    <div>
      <div class="table-responsive">
        <table id="data-table" class="table table-striped" style="width:100%">
          <thead class="table-header">
            <tr>
              <th>ID</th>
              <th>Applicant Name</th>
              <th>Applicant Profile</th>
              <th>Position</th>
              <th>Work Experience(year)</th>
              <th>Job History</th>
              <th>Status</th>
              <th>CV File</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Mya Mya</td>
              <td>
                <img class="profile-img" src="img/profile/img_applicant_profile.jpg">
              </td>
              <td>Web Developer</td>
              <td>2 years</td>
              <td>Java Developer</td>
              <td>Accept</td>
              <td>CV File download</td>
              <td>
                <a href="${pageContext.request.contextPath}/editJobPosts?id=${jobPost.id}" class="btn btn-info">Details</a>
                <a href="${pageContext.request.contextPath}/editJobPosts?id=${jobPost.id}" class="btn btn-success">Accept</a>
                <a href="#" data-toggle="modal" data-href="${pageContext.request.contextPath}/deleteJobPost?id=${jobPost.id }" data-target="#myModal" class="btn btn-danger btn-ok">
                  Reject
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>