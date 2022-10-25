<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 23/10/2022
  Time: 8:38 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../fragment/header.jsp"%>
<%@ include file="../fragment/navigation.jsp"%>

<div class="container">
    <div align="center">
        <h2>New Policy</h2>
        <h3><a href="${pageContext.request.contextPath}/managePolicy">Back to Policy List</a></h3>
        <form:form action="savepolicy" method="post" modelAttribute="policy">
            <table  class = "table">
                <tr>
                    <td>Policy number: </td>
                    <td><form:input path="policy_number" required="true" /></td>
                </tr>
                <tr>
                    <td>Policy type: </td>
                    <td><form:select path="policy_type">
                        <form:option  value = "Life Insurance" label = "Life Insurance" />
                        <form:option  value = "Health Insurance" label = "Health Insurance" />
                        <form:option  value = "Long-Term Disability Coverage" label = "Long-Term Disability Coverage" />
                        <form:option  value = "Auto Insurance" label = "Auto Insurance" />
                    </form:select ></td>
                </tr>
                <tr>
                    <td>Agent list:  </td>
                    <td><form:select path="agent_list" cssStyle="width: 164px;height: 30px">
                        <c:forEach items="${ids}" var="uid">
                            <form:option  value = "${uid}" label = "${uid}" />
                        </c:forEach>
                    </form:select>
                    </td>
                    <%--<td><form:input path="agent_list" /></td>--%>
                </tr>
                <tr>
                    <td>Policy description:  </td>
                    <td><form:textarea path="description" rows="4" cols="50"/></td>
                </tr>
            </table>
            <td colspan="2" >
                <input type="submit" value="Save" class="btn btn-primary">
            </td>
            <tr>
                <td colspan="2" >
                    <a href="${pageContext.request.contextPath}/managePolicy" class="btn btn-primary">Back to List</a>
                </td>
            </tr>
        </form:form>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
