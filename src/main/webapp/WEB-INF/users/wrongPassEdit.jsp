<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- 404 Error Text -->
    <div class="text-md-center">
        <div class="alert alert-danger" role="alert">
            <p>Wrong type of password!</p>
            <p> Follow the instructions below the password field</p>
        </div>
        <a href="<c:url value="/user/edit?id=${cookie.id.value}"/>">&larr; Back to form</a>
    </div>
</div>
<!-- /.container-fluid -->
<%@include file="footer.jsp" %>