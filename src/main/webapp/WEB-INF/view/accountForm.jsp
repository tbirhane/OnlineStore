<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Account</title>
</head>

<body>
<h1>Users</h1>
<form:form modelAttribute="accountFormDTO" action="/user/edit/account" method="post">
    <div>
        <p> Account Details : </p>
        Username : <form:input path="userName" readonly="true" value="${account.userName}"/><br/>
        Password : <form:input path="oldPassword" placeholder="Enter your current password"/><br/>
        New Password : <form:input path="newPassword" placeholder="Enter new password"/><br/>

        <input type="submit" value="Update Account">
</form:form>
<a href="/user"><input type="button" value="Home"/></a>
</body>

</html>