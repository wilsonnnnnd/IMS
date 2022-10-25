<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 24/10/2022
  Time: 9:42 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

    <nav role="navigation" class="navbar navbar-default">
        <div>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand">Home</a>
        </div>
        <div>
            <div>
                <ul class="nav navbar-nav">
                    <c:choose>
                        <c:when test="${user_role == 'Admin' }">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.request.contextPath}/manageUser">User</a></li>
                                <li><a href="${pageContext.request.contextPath}/managePolicy">Policy</a></li>
                                <li><a href="${pageContext.request.contextPath}/managePolicyHolderRecord">PolicyHolderRecord</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${userType == 'Customer' }">
                                <ul class="nav navbar-nav">
                                    <li><a href="${pageContext.request.contextPath}/managePolicy">Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/managePolicyHolderRecord">PolicyHolderRecord</a></li>
                                </ul>
                            </c:if>
                            <c:if test="${userType == 'Agent' }">
                                <ul class="nav navbar-nav">
                                    <li><a href="${pageContext.request.contextPath}/manageUser">User</a></li>
                                    <li><a href="${pageContext.request.contextPath}/managePolicy">Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/managePolicyHolderRecord">PolicyHolderRecord</a></li>
                                </ul>
                            </c:if>
                        </c:otherwise>
                    </c:choose>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>    <a href="${pageContext.request.contextPath}/exit">Logout</a></li>
                </ul>
            </div>

        </div>
    </nav>
</html>
