<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
<table>
    <tr><td>Username : ${user.account.userName}</td></tr>
    <tr><td>Password : ${user.account.password}</td></tr>
    <tr><td>Role : ${user.account.role}</td></tr>
    <tr><td></td></tr>
    <tr><td>Name : ${user.firstName} ${user.lastName}</td></tr>
    <tr><td>Phone : ${user.phone}</td></tr>
    <tr><td></td></tr>
    <tr><td>Street : ${user.address.street}</td></tr>
    <tr><td>City : ${user.address.city}</td></tr>
    <tr><td>State : ${user.address.state}</td></tr>
    <tr><td>Zip : ${user.address.zip}</td></tr>
</table>
<a href="/user/register"><input type="button" value="Add User"/></a>
<a href="/user"><input type="button" value="Home"/></a>
</body>
</html>