<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Matches" />
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
<html>
<body>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <h2>Match Results: </h2>

    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Game 1</th>
        <th>Game 2</th>
        <th>Game 3</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>

        </c:forEach>
        <c:forEach var="match" items="${matches}">
                <td>${match.teamOneScoreOne}${match.teamTwoScoreOne}</td>
                <td>${match.teamOneScoreTwo}${match.teamTwoScoreTwo}</td>
                <td>${match.teamOneScoreThree}${match.teamTwoScoreThree}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>