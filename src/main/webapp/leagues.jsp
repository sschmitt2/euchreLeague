<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Leagues" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navmenuUserLoggedIn.jsp"%>

<div class="container-fluid">
    <%@include file="templates/header.jsp"%>

    <h2>Join a league: </h2>

        <div class="row col-6">

            <form action="leagues" method="POST" class="form">

                <c:forEach var="league" items="${upcomingLeagues}">
                <div class="form-check">

                    <label><input type="checkbox" class="form-check-input" name="leagues" value="${league.id}">${league.name}</label>
                </div>
                </c:forEach>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

</div>


</body>
</html>