<%@include file="templates/taglib.jsp"%>
<%@include file="templates/head.jsp"%>

<html>
<body>


<div class="container-fluid">
    <h2>Search Results: </h2>

    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.userName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
