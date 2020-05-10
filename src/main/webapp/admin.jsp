<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Admin - Login" />
<%@include file="templates/head.jsp"%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>
<%@include file="templates/header.jsp"%>

<c:forEach var="league" items="${upcomingLeagues}">
    <ul>
        <li><a href="/displayleague?leagueid=${league.id}">${league.name}</a></li>
    </ul>
</c:forEach>

</body>
</html>
