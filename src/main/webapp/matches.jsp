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
        <tr>
            <td>${match1.team1.id}</td>
            <td>${team1.player1.firstName} ${team1.player1.lastName}</td>
            <td>${team1.player2.firstName} ${team1.player2.lastName}</td>
            <td>${match1.teamOneScoreOne}</td>
            <td>${match1.teamOneScoreTwo}</td>
            <td>${match1.teamOneScoreThree}</td>
        </tr>
        <tr>
            <td>${match1.team2.id}</td>
            <td>${team2.player1.firstName} ${team2.player1.lastName}</td>
            <td>${team2.player2.firstName} ${team2.player2.lastName}</td>
            <td>${match1.teamTwoScoreOne}</td>
            <td>${match1.teamTwoScoreTwo}</td>
            <td>${match1.teamTwoScoreThree}</td>
        </tr>
        <tr>
            <td>${match2.team1.id}</td>
            <td>${team3.player1.firstName} ${team3.player1.lastName}</td>
            <td>${team3.player2.firstName} ${team3.player2.lastName}</td>
            <td>${match2.teamOneScoreOne}</td>
            <td>${match2.teamOneScoreTwo}</td>
            <td>${match2.teamOneScoreThree}</td>
        </tr>
        <tr>
            <td>${match2.team2.id}</td>
            <td>${team4.player1.firstName} ${team4.player1.lastName}</td>
            <td>${team4.player2.firstName} ${team4.player2.lastName}</td>
            <td>${match2.teamTwoScoreOne}</td>
            <td>${match2.teamTwoScoreTwo}</td>
            <td>${match2.teamTwoScoreThree}</td>
        </tr>
        </tbody>
    </table>

</div>


</body>
</html>