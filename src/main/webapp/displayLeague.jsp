<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Admin - Leagues" />
<%@include file="templates/head.jsp"%>
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#leagueTable').DataTable();
    } );
</script>

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

        <table id="leagueTable" class="display" cellspacing="0" width="100%">
            <h2>League Name: ${league.name}</h2><br>
            <thead>
            <th>Players in League: </th>
            </thead>
            <tbody>
            <c:forEach var="user" items="${league.users}">

            <tr>
                <td>${user.firstName} ${user.lastName}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    <br>

    <c:choose>
        <c:when test="${hasMatches}">
            This league has matches scheduled<br>
            <h2>Schedule</h2>

            <table id="teamTable" class="display" cellspacing="0" width="100%">
                <thead>
                <th>League Name</th>
                <th>Date</th>
                <th>Table #</th>
                <th>Team 1</th>
                <th>Team 2</th>
                </thead>
                <tbody>
                <c:forEach var="match" items="${league.matches}">

                    <tr>
                        <td>${match.league.name}</td>
                        <%-- https://stackoverflow.com/questions/6162401/convert-and-format-a-date-in-jsp--%>
                        <%-- https://stackoverflow.com/questions/13428788/according-to-tld-or-attribute-directive-in-tag-file-attribute-items-does-not-ac--%>
                        <td><fmt:formatDate value="${match.dateOfPlay}" pattern="MM/dd/yy" /></td>
                        <td>${match.tableNumber}</td>
                        <td>${match.team1.player1.firstName} ${match.team1.player1.lastName} & ${match.team1.player2.firstName} ${match.team1.player2.lastName}</td>
                        <td>${match.team2.player1.firstName} ${match.team2.player1.lastName} & ${match.team2.player2.firstName} ${match.team2.player2.lastName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:when>
        <c:otherwise>
            <p>This league does not have any matches scheduled yet</p>
            <c:choose>
                <c:when test="${canBeScheduled}">
                    <form class="form" action="displayleague" method="POST">
                        <input type="hidden" name="leagueid" value="${league.id}"/>
                        <button type="submit">Generate Schedule</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <p id="needExactNumOfPlayersAlert">You need exactly 16 players in the league before you can schedule matches</p>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
