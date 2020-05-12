<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Schedules" />
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#teamTable').DataTable();
    } );

</script>
<html>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>


    <table id="teamTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>League Name</th>
        <th>Date</th>
        <th>Table #</th>
        <th>Team 1</th>
        <th>Team 2</th>
        </thead>
        <tbody>
        <c:forEach var="team" items="${matches}">
        <tr>
            <td>${team.league.name}</td>
            <td>${team.dateOfPlay}</td>
            <td>${team.tableNumber}</td>
            <td>${team.team1.player1.firstName} ${team.team1.player1.lastName} & ${team.team1.player2.firstName} ${team.team1.player2.lastName}</td>
            <td>${team.team2.player1.firstName} ${team.team2.player1.lastName} & ${team.team2.player2.firstName} ${team.team2.player2.lastName}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>