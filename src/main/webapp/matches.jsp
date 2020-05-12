<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Matches" />
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#scores').DataTable();
    } );
</script>
<html>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <h2>Team Score Results: </h2>



    <table id="scores" class="display" cellspacing="0" width="100%">
        <thead>
        <th>League</th>
        <th>Date</th>
        <th>Table #</th>
        <th>Team</th>
        <th>Game 1</th>
        <th>Game 2</th>
        <th>Game 3</th>
        </thead>
        <tbody>

        <c:forEach var="match" items="${matches}">
            <tr>
                <td>${match.league.name}</td>
                <%-- https://stackoverflow.com/questions/6162401/convert-and-format-a-date-in-jsp--%>
                <%-- https://stackoverflow.com/questions/13428788/according-to-tld-or-attribute-directive-in-tag-file-attribute-items-does-not-ac--%>
                <td><fmt:formatDate value="${match.dateOfPlay}" pattern="MM/dd/yy" /></td>
                <td>${match.tableNumber}</td>
                <td>${match.team1.player1.firstName} ${match.team1.player1.lastName} & ${match.team1.player2.firstName} ${match.team1.player2.lastName} </td>
                <td>${match.teamOneScoreOne}</td>
                <td>${match.teamOneScoreTwo}</td>
                <td>${match.teamOneScoreThree}</td>
            </tr>
            <tr>
                <td>${match.league.name}</td>
                <%-- https://stackoverflow.com/questions/6162401/convert-and-format-a-date-in-jsp--%>
                <%-- https://stackoverflow.com/questions/13428788/according-to-tld-or-attribute-directive-in-tag-file-attribute-items-does-not-ac--%>
                <td><fmt:formatDate value="${match.dateOfPlay}" pattern="MM/dd/yy" /></td>
                <td>${match.tableNumber}</td>
                <td>${match.team2.player1.firstName} ${match.team2.player1.lastName} & ${match.team2.player2.firstName} ${match.team2.player2.lastName}</td>
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