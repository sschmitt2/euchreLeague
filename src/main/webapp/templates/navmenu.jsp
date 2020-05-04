<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">


            <c:if  test="${!pageContext.request.isUserInRole('user')}">
                <li class="nav-item">
                    <a class="btn btn-outline-primary px-3 mx-3" href="login">Log In</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="signup.jsp">Sign Up</a>
            </li>
        </ul>
    </div>
</nav>