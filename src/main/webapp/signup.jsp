<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Sign Up" />
<%@include file="templates/head.jsp"%>
<html>
<body>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <div class="container">

        <h2 id="signUp">Sign Up</h2>

        <div class="row">
            <div class="col-6 offset-3">

                <form class="form" action="signupAction" method="post">
                    <div class="form-group">
                        <label for="email">Email: </label>
                        <input class="form-control" type="text" name="email" id="email" required pattern="[a-zA-Z0-9]{1}[a-zA-Z0-9_]{0,29}"  maxlength="30">
                    </div>
                    <div class="form-group">
                        <label for="userName">Username: </label>
                        <input class="form-control" type="text" name="userName" id="userName" required pattern="[a-zA-Z0-9]{1}[a-zA-Z0-9_]{0,29}"  maxlength="30">
                    </div>
                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input type="password" class="form-control" name="password" id="password" required maxlength="50">
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password: </label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" required maxlength="50" >
                    </div>

                    <div class="text-danger mt-2 mb-2" id="passwordMatchStatus"></div>

                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Create Account">
                    </div>
                </form>

            </div>
        </div>


    </div>
</div>
</body>
</html>