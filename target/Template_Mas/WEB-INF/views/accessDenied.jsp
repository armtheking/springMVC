<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html>
    <head>

        <%@ include file="../template/head.jspf" %>

    </head>
    <body>

        <%@ include file="../template/pageTitle.jspf" %>


        <div class="container">
            <div class="success">
                <br/>
                <br/>
                <h1>Dear <strong>${user}</strong>, You are not authorized to access this page.</h1>
                <br/>
                <a href="<c:url value="/home" />">Go to home</a>  
                <sec:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')">
                    OR  <a href="<c:url value="/logout" />">Logout</a>
                </sec:authorize>
            </div>
        </div>

        <%@ include file="../template/footer.jspf" %>
        <%@ include file="../template/scripts.jspf" %>

    </body>
</html>