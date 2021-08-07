<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Users list</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Users list</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive ">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <%--@elvariable id="users" type="java.util.Arrays"--%>
                    <%--@elvariable username="users" type="java.util.Arrays"--%>
                    <%--@elvariable email="users" type="java.util.Arrays"--%>
                    <c:forEach  var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>
                                <a href='<c:url value="/user/delete?id=${user.id}"/>' class="btn btn-outline-danger">Delete</a>
                                <a href='<c:url value="/user/edit?id=${user.id}"/>' class="btn btn-outline-primary">Edit</a>
                                <a href='<c:url value="/user/show?id=${user.id}"/>' class="btn btn-outline-dark">Show</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                </div>
            </div>
        </div>
    </div>
<!-- /.container-fluid -->
<%@include file="footer.jsp" %>