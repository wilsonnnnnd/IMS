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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
    $( function() {
        $( "#datepicker" ).datepicker({
            inline : true,
            format: 'yyyy-MM-dd',
            maxDate: '0'
        });
    } );
</script>
<script>
    $( function() {
        $( "#datepicker" ).datepicker({
            inline : true,
            format: 'yyyy-MM-dd',
            maxDate: '0'
        });
    } );
</script>

<div class="container">
    <div align="center">
        <h2>New User</h2>
        <h3><a href="${pageContext.request.contextPath}/manageUser">Back to User List</a></h3>
        <form:form action="saveuser" method="post" modelAttribute="user">
            <table class = "table">
                <tr>
                    <td>First Name: </td>
                    <td><form:input path="firstname" required="true" placeholder = "Pleas input first name."  /></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><form:input path="lastname" required="true" placeholder = "Pleas input last name."/></td>
                </tr>
                <tr>
                    <td>Address:  </td>
                    <td><form:input path="address" required="true" placeholder = "Pleas input address." /></td>
                </tr>
                <tr>
                    <td>Sex:  </td>
                    <td>
                        <form:label path="sex" title="Sex" multiple="fasle" required="true"
                                    size="3">
                        <form:radiobutton path = "sex" value = "Male" label = "Male" />
                        <form:radiobutton path = "sex" value = "Female" label = "Female" />
                        <form:radiobutton path = "sex" value = "Nonbinary" label = "Nonbinary" />
                        <form:radiobutton path = "sex" value = "None" label = "Prefer not to say" />
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td>Email:  </td>
                    <td><form:input path="email" required="true" type="email"  placeholder = "Pleas input email."/></td>
                </tr>
                <tr>
                    <td>DOB:  </td>
                    <td><form:input path="dob" id="datepicker" required="true" placeholder = "Pleas input date of brith."/></td>
                </tr>

                <tr>
                    <td>Employment Status:  </td>
                    <td><form:select path="employment_status">
                        <form:option  value = "Worker" label = "Worker" />
                        <form:option  value = "Employee" label = "Employee" />
                        <form:option  value = "Self-employed" label = "Self-employed" />
                        <form:option  value = "None" label = "Prefer not to say" />
                    </form:select ></td>
                </tr>
                <tr>
                    <td>Risk rate:  </td>
                    <td><form:select path="risk_rate">
                        <form:option  value = "1" label = "Level 1" />
                        <form:option  value = "2" label = "Level 2" />
                        <form:option  value = "3" label = "Level 3" />
                        <form:option  value = "4" label = "Level 4" />
                        <form:option  value = "5" label = "Level 5" />
                    </form:select ></td>
                </tr>

                <tr>
                    <td>Role:  </td>
                    <td><form:select path="role">
                        <form:option  value = "Admin" label = "Admin" />
                        <form:option  value = "Agent" label = "Agent" />
                        <form:option  value = "Customer" label = "Customer" />
                    </form:select ></td>
                </tr>
            </table>
            <td colspan="2" >
                <input type="submit" value="Save" class="btn btn-primary">
            </td>
            <tr>
                <td colspan="2" >
                    <a href="${pageContext.request.contextPath}/manageUser" class="btn btn-primary">Back to List</a>
                </td>
            </tr>
        </form:form>
    </div>
</div>

<%@ include file="../fragment/footer.jsp"%>

