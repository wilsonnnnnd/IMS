<%@ include file="fragment/header.jsp"%>
<%@ include file="fragment/navigation.jsp"%>

<div class="container">
    <h2>${message}</h2>
    <div align="center">
        <c:choose>
            <c:when test="${userType == 'Agent' }">
                <div>
                    <div>
                        <a href="${pageContext.request.contextPath}/manageUser">Go to User Manager Page</a>
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/managePolicy">Go to Policy Manager Page</a>
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/managePolicyHolderRecord">Go to policyHolderRecord Page</a>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <c:if test="${userType == 'User' }">
                    <div>
                        <div>
                            <a href="${pageContext.request.contextPath}/managePolicy">Go to Policy Manager Page</a>
                        </div>
                        <div>
                            <a href="${pageContext.request.contextPath}/managePolicyHolderRecord">Go to PolicyHolderRecord Page</a>
                        </div>
                    </div>
                </c:if>
                <c:if test="${userType == 'Admin' }">
                    <div>
                        <div>
                            <a href="${pageContext.request.contextPath}/manageAccount">Account Page</a>
                        </div>
                        <div>
                            <a href="${pageContext.request.contextPath}/manageUser">User Page</a>
                        </div>
                        <div>
                            <a href="${pageContext.request.contextPath}/managePolicy">Policy Page</a>
                        </div>
                        <div>
                            <a href="${pageContext.request.contextPath}/managePolicyHolderRecord">PolicyHolderRecord Page</a>
                        </div>
                    </div>
                </c:if>
            </c:otherwise>

        </c:choose>
    </div>
</div>

<%@ include file="fragment/footer.jsp"%>
