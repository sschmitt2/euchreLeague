<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Leagues" />
<%@include file="templates/head.jsp"%>
<html>
<body>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <h2>Upcoming Leagues: </h2>
    // TODO need to display each league only once
    <table id="leagueTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Leagues</th>
        </thead>
        <tbody>
        <c:forEach var="league" items="${leagues}">
            <tr>
                <td>${league.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>