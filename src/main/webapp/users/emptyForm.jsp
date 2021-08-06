<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<div class="container-fluid">

            <!-- 404 Error Text -->
            <div class="text-center">
                <div class="error mx-auto" data-text="Error">Error</div>
                <p class="lead text-gray-800 mb-5">Username can't be empty!</p>
                <a href="/user/list">&larr; Back to Dashboard</a>
            </div>

</div>
        <!-- /.container-fluid -->

<%@include file="footer.jsp" %>