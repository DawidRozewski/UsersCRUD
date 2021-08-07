<%--@elvariable id="user" type="pl.coderslab.users.controller.User"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
    <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
      <i class="fas fa-download fa-sm text-white-50"></i>Users list</a>
  </div>
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Edit user</h6>
    </div>
    <div class="card-body">
      <form action="/user/edit" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" value="${user.username}" name="username" class="form-control" id="username">
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" value="${user.email}" name="email" class="form-control" id="email"
                 placeholder="Email">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" name="password" class="form-control" id="password" >
          <small id="passwordHelpBlock" class="form-text text-muted">
            Your password must be 8-20 characters long, contain at least one digit, one lowercase and uppercase character and one special.
          </small>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz</button>
      </form>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>