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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
    $( function() {
        $( "#datepicker" ).datepicker({
            inline : true,
            format: 'yyyy-MM-dd',
            maxDate: '0'
        });
        $( "#datepicker1" ).datepicker({
            inline : true,
            format: 'yyyy-MM-dd',
            maxDate: '0'
        });
        $( "#datepicker2" ).datepicker({
            inline : true,
            format: 'yyyy-MM-dd',
            minDate: '0'
        });
    } );
</script>
<div class="container">
    <div align="center">
        <h2>New PolicyHolderRecord</h2>
        <h3><a href="${pageContext.request.contextPath}/managePolicyHolderRecord">Back to PolicyHolderRecord List</a></h3>
        <form:form action="savePolicyHolderRecord" method="post" modelAttribute="policyHolderRecord">
            <table  class = "table">
                <tr>
                    <td>PolicyHolderRecord number: </td>
                    <td><form:input path="policyNumber" required="true" /></td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Customer: </td>
                    <td><form:select path="customerId" cssStyle="width: 164px;height: 30px">
                    <c:forEach items="${ids}" var="uid">
                        <form:option  value = "${uid}" label = "${uid}" />
                    </c:forEach>
                </form:select>
                    </td>
                    <%--<td><form:input path="customerId" required="true" /></td>--%>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Applied date:  </td>
                    <td><form:input path="appliedDate" id="datepicker1" required="true"/></td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Status:  </td>
                    <td><form:select path="status">
                        <form:option  value = "Activated" label = "Activated" />
                        <form:option  value = "Inactivated" label = "Inactivated" />
                        <form:option  value = "Unknown" label = "Unknown" />
                    </form:select ></td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Start date:  </td>
                    <td><form:input path="startDate" id="datepicker" required="true" /></td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord End date:  </td>
                    <td><form:input path="endDate" id="datepicker2" required="true" /></td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Premium:  </td>
                    <td>
                        <form:label path="premium" title="Sex" multiple="fasle" required="true"
                                    size="3">
                        <form:radiobutton path = "premium" value = "Yes" label = "Yes" />
                        <form:radiobutton path = "premium" value = "No" label = "No" />

                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Other details:  </td>
                    <td><form:textarea path="otherDetails" rows="4" cols="50" /></td>
                </tr>
                <tr>
                    <td>PolicyHolderRecord Agent: </td>
                    <td><form:select path="agent" cssStyle="width: 164px;height: 30px">
                        <c:forEach items="${agentsIds}" var="uid">
                            <form:option  value = "${uid}" label = "${uid}" />
                        </c:forEach>
                        </form:select>
                    <%--<td><form:input path="agent"  required="true"/></td>--%>
                </tr>
            </table>
            <td colspan="2" >
                <input type="submit" value="Save" class="btn btn-primary">
            </td>
            <tr>
                <td colspan="2" >
                    <a href="${pageContext.request.contextPath}/managePolicyHolderRecord" class="btn btn-primary">Back to List</a>
                </td>
            </tr>
        </form:form>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>
