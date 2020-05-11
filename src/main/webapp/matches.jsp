<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Matches" />
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#matchTable').DataTable();
    } );
</script>
<html>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <h2>Match Score Results: </h2>


    <table id="matchTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Team ID</th>
        <th>Player1 Name</th>
        <th>Player2 Name</th>
        <th>Game 1</th>
        <th>Game 2</th>
        <th>Game 3</th>
        </thead>

        <tbody>
            <c:forEach var="match" items="${matches}">
            <tr>
                <td>${match.team1.id}</td>
                <td>${match.team1.player1.firstName} ${match.team1.player1.lastName}</td>
                <td>${match.team1.player2.firstName} ${match.team1.player2.lastName}</td>
                <td>${match.teamOneScoreOne}</td>
                <td>${match.teamOneScoreTwo}</td>
                <td>${match.teamOneScoreThree}</td>
            </tr>
            <tr>
                <td>${match.team2.id}</td>
                <td>${match.team2.player1.firstName} ${match.team2.player1.lastName}</td>
                <td>${match.team2.player2.firstName} ${match.team2.player2.lastName}</td>
                <td>${match.teamTwoScoreOne}</td>
                <td>${match.teamTwoScoreTwo}</td>
                <td>${match.teamTwoScoreThree}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>