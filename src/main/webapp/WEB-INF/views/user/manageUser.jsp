<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>
<style>
    .box{
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<div class="container">
    <div align="center">
        <h2>User Page</h2>
        <h3><a href="${pageContext.request.contextPath}/">Back to Home</a></h3>
        <form method="get" action="searchuser">
            <input type="text" name="keyword" /> &nbsp;
            <input type="submit" value="Search" />
        </form>
        <h3><a href="${pageContext.request.contextPath}/newuser">New User</a></h3>
        <table class="table">
            <thead>
                <tr >
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Sex</th>
                    <th scope="col">Email</th>
                    <th scope="col">DOB</th>
                    <th scope="col">Employment Status</th>
                    <th scope="col">Risk Rate</th>
                    <th scope="col">Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listUser}" var="user">
                    <tr>
                        <td scope="row">${user.firstname}</td>
                        <td scope="row">${user.lastname}</td>
                        <td scope="row">${user.address}</td>
                        <td scope="row">${user.sex}</td>
                        <td scope="row">${user.email}</td>
                        <td scope="row"><fmt:formatDate value="${user.dob}" type="date" pattern="yyyy-MM-dd"/></td>
                        <td scope="row">${user.employment_status}</td>
                        <td scope="row">${user.risk_rate}</td>
                        <td scope="row">${user.role}</td>
                        <td>
                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/edituser?id=${user.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteuser?id=${user.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
