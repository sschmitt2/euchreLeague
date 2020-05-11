<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Admin - Leagues" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>



        <table id="leagueTable" class="display" cellspacing="0" width="100%">
            <h2>League Name: ${league.name}</h2>
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
            This league has matches scheduled
            <h2>Schedule</h2>

                <c:forEach var="match" items="${league.matches}">
                    <h4>Date: ${match.dateOfPlay}</h4>
                    <table id="matches" class="display" cellspacing="0" width="100%">

                    <thead>
                    <th>Team 1</th>
                    <th>Team 2</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${match.team1.player1.firstName} ${match.team1.player1.lastName} & ${match.team1.player2.firstName} ${match.team1.player2.lastName}</td>
                        <td>${match.team2.player1.firstName} ${match.team2.player1.lastName} & ${match.team2.player2.firstName} ${match.team2.player2.lastName}</td>
                    </tr>
                    </tbody>
                    </table>
                </c:forEach>

        </c:when>
        <c:otherwise>
            <p>This league does not have any matches scheduled yet</p>
            <c:choose>
                <c:when test="${canBeScheduled}">
                  <button type="submit">Generate Schedule</button>
                </c:when>
                <c:otherwise>
                    <p>You need 16 players in the league before you can schedule matches</p>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>




</div>

</body>
</html>
