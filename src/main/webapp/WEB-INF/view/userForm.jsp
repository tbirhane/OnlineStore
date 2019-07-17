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
<form:form modelAttribute="user" action="/user/edit" method="post">
    <div>
        <p> User Details : </p>
        First Name : <form:input path="firstName" placeholder="${user.firstName}"/><br/>
        Last Name : <form:input path="lastName" placeholder="${user.lastName}"/><br/>
        Phone Number : <form:input path="phone" placeholder="${user.phone}"/><br/>
    </div>
    <div>
        <p> Address : </p>
        Street : <form:input path="address.street" placeholder="${user.address.street}"/><br/>
        City : <form:input path="address.city" placeholder="${user.address.city}"/><br/>
        State : <form:input path="address.state" placeholder="${user.address.state}"/><br/>
        Zip : <form:input path="address.zip" placeholder="${user.address.zip}"/><br/>
    </div>
           <input type="submit" value="Update Account">
</form:form>
<a href="/user"><input type="button" value="Home"/></a>
</body>

</html>