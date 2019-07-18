<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users</title>
</head>

<body>
<h1>Users</h1>
<table>
    <thead>
        <tr>
            <td>Username</td>
            <td>Password</td>
            <td>Name</td>
            <td>Role</td>
        </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.account.userName}</td>
            <td>${user.account.password}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.account.role}</td>
            <td><a href="/user/edit/${user.id}"><input type="button" value="Edit User"></a></td>
            <td><a href="/user/edit/account/${user.id}"><input type="button" value="Edit Account"></a></td>
            <td><a href="/user/delete/${user.id}"><input type="button" value="Delete"></a></td>
        </tr>
    </c:forEach>
</table>
<a href="/user/register"><input type="button" value="Add User"/></a>
</body>

</html>