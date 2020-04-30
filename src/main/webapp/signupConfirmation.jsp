<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Euchre League - Sign Up Confirmation" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<div class="container-fluid">
    <%@include file="templates/navmenu.jsp"%>
    <%@include file="templates/header.jsp"%>

    <div class="container">

        <div class="row mt-5">
            <div class="col-10">

                <c:choose>
                    <c:when test = "${errorMessage == null}">
                        <div class="alert alert-success" role="alert">
                            <span class="text-bold">New User Signup -- Success</span>.
                            Head to the <a href="login">login page</a> to get started.
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-danger" role="alert">
                            <p><strong>New User Signup -- Failed</strong></p>
                            <p>
                                    ${errorMessage}

                            </p>
                        </div>
                        <div>
                            <a href="signup.jsp"><button type="button" class="btn btn-primary">Try Again</button></a>
                            <a href="index.jsp"><button type="button" class="btn btn-default">Cancel</button></a>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>


    </div>
</div>
</body>
</html>