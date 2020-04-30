<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Matches" />
<%@include file="templates/head.jsp"%>

<html>
<body>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <h2>Match Results: </h2>

    <table id="matchesTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Team 1 Id</th>
        <th>Team 2 Id</th>
        <th>Team 1 Match 1 Score</th>
        <th>Team 2 Match 1 Score</th>
        </thead>
        <tbody>
        <c:forEach var="match" items="${matches}">
            <tr>
                <td>${match.team1}</td>
                <td>${match.team2}</td>
                <td>${match.teamOneScoreOne}</td>
                <td>${match.teamTwoScoreOne}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>