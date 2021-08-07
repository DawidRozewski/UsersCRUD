<%--@elvariable id="user" type="pl.coderslab.users.User"--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<div class="container-fluid" >

    <!-- 404 Error Text -->
    <div class="text-center">
        <div class="error mx-auto">Ops! You forgot something :) </div>
        <p class="lead text-gray-800 mb-5">  Fill in all fields </p>
        <a href="<c:url value="/user/edit?id=${cookie.id.value}"/>">&larr; Back to form</a>
    </div>

</div>
<!-- /.container-fluid -->

<%@include file="footer.jsp" %>