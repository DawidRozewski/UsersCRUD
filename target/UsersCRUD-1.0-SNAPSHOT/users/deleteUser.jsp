<%--@elvariable id="user" type="pl.coderslab.users.User"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>


<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Lista użytkowników</a>
    </div>

    <div class="card-body">
        <form action="/user/delete" method="post">
            <input type="hidden" name="id" value="${user.id}"/>
            <table cellpadding="5px" style="width: 40%">
                <tbody>
                <tr>
                    <td> <i class="m-0 font-weight-bold text-primary">Id</i></td>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <td> <i class="m-0 font-weight-bold text-primary">Nazwa użytkownika</i></td>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <td> <i class="m-0 font-weight-bold text-primary">Email</i></td>
                    <td>${user.email}</td>
                </tr>
                </tbody>
            </table>
            <button type="submit" class="btn btn-danger">Usuń</button>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>