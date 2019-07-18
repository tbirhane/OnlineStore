<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${action} Product</title>
</head>

<body>
<h1>Sign Up</h1>
<form:form modelAttribute="registrationFormDTO" method="post" action="/user/register">
    <div>
        <p> Account Information </p>
        First Name: <form:input path="firstName"/><br/>
        Last Name: <form:input path="lastName"/><br/>
        Email: <form:input path="email"/><br/>
        Password: <form:password path="password"/><br/>
    </div>
   <input type="submit" value="Register Me">
</form:form>
<a href="/user"><input type="button" value="Home"/></a>
</body>

</html>