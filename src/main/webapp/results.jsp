<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Results" />
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

    <h2>Search Results: </h2>

    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>email</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
