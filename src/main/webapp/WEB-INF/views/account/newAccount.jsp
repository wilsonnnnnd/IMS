<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 23/10/2022
  Time: 8:38 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>

<div class="container">
    <div align="center">
        <h2>New Account</h2>
        <h3><a href="${pageContext.request.contextPath}/manageAccount">Back to Account List</a></h3>
        <form:form action="saveaccount" method="post" modelAttribute="account">
            <table  class = "table">
                <tr>
                    <td>Account Name(User for login): </td>
                    <td><form:input path="username" required="true" maxlength="8"/></td>
                </tr>
                <tr>
                    <td>Account Password:  </td>
                    <td><form:input path="password" required="true" maxlength="8" /></td>
                </tr>
                <tr>
                    <td>Account type: </td>
                    <td>
                        <form:select path="usertype">
                        <form:option  value = "Admin" label = "Admin" />
                        <form:option  value = "Agent" label = "Agent" />
                        <form:option  value = "Customer" label = "Customer" />
                        </form:select >
                    </td>
                </tr>
            </table>
            <td colspan="2" >
                <input type="submit" value="Save" class="btn btn-primary">
            </td>
            <tr>
                <td colspan="2" >
                    <a href="${pageContext.request.contextPath}/manageAccount" class="btn btn-primary">Back to List</a>
                </td>
            </tr>
        </form:form>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
