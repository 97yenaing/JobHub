<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%-- <div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">Company List</h3>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-sm-12 col-md-12">
                <div class="search-sec">
                  <c:url var="addAction" value="/searchStudent"></c:url>
                  <form:form action="${addAction}"
                    commandName="studentForm" method="student" id="form"
                    class="searchForm-mr">
                    <label><input type="text"
                      class="form-control form-control-sm search-text-pd"
                      aria-controls="example1" name="search-input"
                      value="${searchData }"></label>
                    <input name="searchStudent" type="submit"
                      value="Search" class="btn btn-secondary">
                    
                    <a
                      href="${pageContext.request.contextPath}/uploadCSV"
                      class="btn btn-info">Upload</a>
                    <input type="submit" class="btn btn-info"
                      value="Download" name="downloadExcel">
                  </form:form>
                  <a
                    href="${pageContext.request.contextPath}/company/Create"
                    class="btn btn-info">Add</a>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-12">
                <table id="example1"
                  class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>company_id</th>
                      <th>company_name</th>
                      <th>email</th>
                      <th>address</th>
                      <th>phone</th>
                      <th>web_link</th>                   
                     <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${companyList}" var="company"
                      varStatus="loop">
                      <tr>
                        <td>${company.company_id }</td>
                        <td>${company.company_name}</td>
                        <td>${company.email}</td>
                        <td>${company.address}</td>
                        <td>${company.phone}</td>
                        <td>${company.web_link}</td>                  
                        <td class="text-right py-0 align-middle">
                          <div class="btn-group btn-group-sm">
                            <a
                              href="${pageContext.request.contextPath}/company/Edit-Update?company_id=${company.company_id}"
                              class="btn btn-secondary"><i
                              class="fas fa-edit"></i></a> <a href="${pageContext.request.contextPath}/company/Delete?company_id=${company.company_id}"
                              data-toggle="modal"
                              data-href="${pageContext.request.contextPath}/company/Delete?company_id=${company.company_id}"
                              data-target="#myModal"
                              class="btn btn-danger"><i
                              class="fas fa-trash"></i></a>
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

<div class="modal fade" id="myModal" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
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
</script> --%>
<div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
      <a
                    href="${pageContext.request.contextPath}/company/Create"
                    class="btn btn-info">Add</a>
        <table id="data-table" class="table table-striped" style="width:100%">
          <thead class="table-header">
            <tr>
              <th>company_id</th>
                      <th>company_name</th>
                      <th>email</th>
                      <th>address</th>
                      <th>phone</th>
                      <th>web_link</th>                   
                     <th>Action</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${companyList}" var="company"
                      varStatus="loop">
            <tr>
              <td>${company.company_id }</td>
                        <td>${company.company_name}</td>
                        <td>${company.email}</td>
                        <td>${company.address}</td>
                        <td>${company.phone}</td>
                        <td>${company.web_link}</td>
              <td>
                <a href="${pageContext.request.contextPath}/company/Edit-Update?company_id=${company.company_id}" class="btn btn-info"><i
                    class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                <a
                              href="${pageContext.request.contextPath}/company/Delete?company_id=${company.company_id}"
                              onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i
                    class="fa fa-trash" aria-hidden="true"></i></a>
              </td>
            </tr>
            </c:forEach>
            
            
          </tbody>
        </table>
      </div>
    </div>
  </div>
