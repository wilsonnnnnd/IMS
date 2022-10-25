<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 25/10/2022
  Time: 4:30 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<%@ include file="fragment/header.jsp"%>
<%@ include file="fragment/navigation.jsp"%>

<div class="container">
    <h2>Login</h2>
    <form:form action="login" method="post" modelAttribute="account">
        <div class="table">
            username:<input type="text" name="username"/>
            password:<input type="password" name="password"/>
        </div>
        <div>
            <input type="submit" value="login">
        </div>

    </form:form>
</div>

<%@ include file="fragment/footer.jsp"%>
