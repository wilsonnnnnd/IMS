<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 23/10/2022
  Time: 8:36 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>

<div class="container">
    <div align="center">
        <h2>Search policy</h2>
        <h3><a href="${pageContext.request.contextPath}/managePolicy">Back to Policy List</a></h3>
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
            <c:forEach items="${result}" var="policy">
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
