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
<%@ include file="fragment/style.jsp"%>


<div class="row continar">
    <div class="offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3">
        <div class="panel border bg-white">
            <div class="panel-heading">
                <h3 class="pt-3 font-weight-bold">Login</h3>
            </div>
            <div class="panel-body p-3">
                <form:form action="login" method="post" modelAttribute="account" class="colm-form">
                    <div class="form-group py-2">
                        <div class="input-field"> <span class="far fa-user p-2"></span>
                            <input type="text" name="username" placeholder="Enter your Username" required/>
                        </div>
                    </div>
                    <div class="form-group py-1 pb-2">
                        <div class="input-field"> <span class="fas fa-lock px-2"></span>
                            <input type="password" name="password"placeholder="Enter your Password" required />
                        </div>
                    </div>
                <input type="submit" value="login" class="btn btn-primary btn-block mt-3">
                </form:form>
            </div>
        </div>
    </div>
</div>
<script type='text/javascript'></script>
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'></script>

<%@ include file="fragment/footer.jsp"%>
