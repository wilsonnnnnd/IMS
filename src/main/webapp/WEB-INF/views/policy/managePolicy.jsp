<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>

<div class="container">
    <div align="center">
        <h2>Policy Page</h2>
        <h3><a href="${pageContext.request.contextPath}/">Back to Home</a></h3>
        <form method="get" action="searchpolicy">
            <input type="text" name="keyword" /> &nbsp;
            <input type="submit" value="Search" />
        </form>
        <h3><a href="${pageContext.request.contextPath}/newpolicy">New Policy</a></h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Policy number</th>
                <th scope="col">Policy type</th>
                <th scope="col">Agent list</th>
                <th scope="col">Policy description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listPolicy}" var="policy">
                <tr>
                    <td scope="row">${policy.policy_number}</td>
                    <td scope="row">${policy.policy_type}</td>
                    <td scope="row">${policy.agent_list}</td>
                    <td scope="row">${policy.description}</td>

                    <td>
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/editpolicy?id=${policy.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/deletepolicy?id=${policy.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>



        </table>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
