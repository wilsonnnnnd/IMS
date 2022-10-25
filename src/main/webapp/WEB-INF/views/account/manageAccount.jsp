<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>

<div class="container">
    <div align="center">
        <h2>Account Page</h2>
        <h3><a href="${pageContext.request.contextPath}/">Back to Home</a></h3>
        <form method="get" action="searchaccount">
            <input type="text" name="keyword" /> &nbsp;
            <input type="submit" value="Search" />
        </form>
        <h3><a href="${pageContext.request.contextPath}/newAccount">New Account</a></h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Account Name</th>
                <th scope="col">Account Password</th>
                <th scope="col">Account Role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listAccount}" var="account">
                <tr>
                    <td scope="row">${account.username}</td>
                    <td scope="row">${account.password}</td>
                    <td scope="row">${account.usertype}</td>


                    <td>
                        <a class="btn btn-warning"  href="${pageContext.request.contextPath}/editAccount?id=${account.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger"  href="${pageContext.request.contextPath}/deleteAccount?id=${account.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>



        </table>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
