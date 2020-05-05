<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Schedules" />
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#team1Table').DataTable();
    } );

</script>
<html>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>


    <table id="team1Table" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Team ID</th>
        <th>Player1 Name</th>
        <th>Player2 Name</th>
        </thead>
        <tbody>
        <tr>
            <td>${team1.id}</td>
            <td>${team1.player1.firstName} ${team1.player1.lastName}</td>
            <td>${team1.player2.firstName} ${team1.player2.lastName}</td>
        </tr>
        <tr>
            <td>${team2.id}</td>
            <td>${team2.player1.firstName} ${team2.player1.lastName}</td>
            <td>${team2.player2.firstName} ${team2.player2.lastName}</td>
        </tr>
        </tbody>
    </table>

</div>


</body>
</html>