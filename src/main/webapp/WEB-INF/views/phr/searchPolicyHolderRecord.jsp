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
        <h2>Search PolicyHolderRecord</h2>
        <h3><a href="${pageContext.request.contextPath}/managePolicyHolderRecord">Back to PolicyHolderRecord List</a></h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Policy number</th>
                <th scope="col">Customer</th>
                <th scope="col">Applied date</th>
                <th scope="col">Status</th>
                <th scope="col">Start date</th>
                <th scope="col">End date</th>
                <th scope="col">Premium</th>
                <th scope="col">Other details</th>
                <th scope="col">Agent</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${result}" var="policyHolderRecord">
                <tr>
                    <td scope="row">${policyHolderRecord.policyNumber}</td>
                    <td scope="row">${policyHolderRecord.customerId}</td>
                    <td scope="row"><fmt:formatDate value="${policyHolderRecord.appliedDate}" type="date" pattern="yyyy-MM-dd"/></td>
                    <td scope="row">${policyHolderRecord.status}</td>
                    <td scope="row"><fmt:formatDate value="${policyHolderRecord.startDate}" type="date" pattern="yyyy-MM-dd"/></td>
                    <td scope="row"><fmt:formatDate value="${policyHolderRecord.endDate}" type="date" pattern="yyyy-MM-dd"/></td>
                    <td scope="row">${policyHolderRecord.premium}</td>
                    <td scope="row">${policyHolderRecord.otherDetails}</td>
                    <td scope="row">${policyHolderRecord.agent}</td>

                    <td>
                        <a class="btn btn-warning"  href="${pageContext.request.contextPath}/editPolicyHolderRecord?id=${policyHolderRecord.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger"  href="${pageContext.request.contextPath}/deletePolicyHolderRecord?id=${policyHolderRecord.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>



        </table>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
