<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>

<div class="container">
    <div align="center">
        <h2>Edit Account</h2>
        <form:form action="saveaccount" method="post" modelAttribute="account">
            <table  class = "table">
                <tr>
                    <td>ID: </td>
                    <td>${account.id}
                        <form:hidden path="id" readonly="true"/>
                    </td>
                <tr>
                <tr>
                    <td>Account Name(User for login): </td>
                    <td><form:input path="username" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Account Password:  </td>
                    <td><form:input path="password" required="true" /></td>
                </tr>
                <tr>
                    <td>Account type: </td>
                    <td>
                        <form:select path="usertype">
                            <form:option  value = "Admin" label = "Admin" />
                            <form:option  value = "Agent" label = "Agent" />
                            <form:option  value = "User" label = "Customer" />
                        </form:select >
                    </td>
            </table>
        </form:form>
        <td colspan="2" >
            <input type="submit" value="Save" class="btn btn-primary">
        </td>
        <tr>
            <td colspan="2" >
                <a href="${pageContext.request.contextPath}/manageAccount" class="btn btn-primary">Back to List</a>
            </td>
        </tr>
    </div>

</div>

<%@ include file="../fragment/footer.jsp"%>
