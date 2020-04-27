<%@include file="templates/taglib.jsp"%>
<%@include file="templates/head.jsp"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>
<%-- TODO add form here for logging in --%>

<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>
</html>


