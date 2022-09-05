<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">User List</h3>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-sm-12 col-md-12">
                <div class="search-sec">
                  <a
                    href="${pageContext.request.contextPath}/createUser"
                    class="btn btn-info">Add User</a>
                </div>
              </div>
            </div>
            <br>
            <div class="table-responsive">
              <div class="row">
                <div class="col-sm-12">
                  <table id="example1"
                    class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Created At</th>
                        <th>Updated At</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${UserList}" var="user"
                        varStatus="loop">
                        <c:if test="${user.deleted_at == null }">
                          <tr>
                            <td>${user.id }</td>
                            <td>${user.name }</td>
                            <td>${user.email}</td>
                            <c:forEach items="${user.authorities }"
                              var="auo" varStatus="loop">
                              <td>${auo.name }</td>
                            </c:forEach>
                            <td>${user.created_at}</td>
                            <td>${user.updated_at}</td>
                            <td class="text-right py-0 align-middle">
                              <div class="btn-group btn-group-sm">
                                <a
                                  href="${pageContext.request.contextPath}/editUser?id=${user.id}"
                                  class="btn btn-secondary">Edit</a> <a
                                  href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
                                  data-target="#myModal"
                                  class="btn btn-danger">Delete</a>
                              </div>
                            </td>
                          </tr>
                        </c:if>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>