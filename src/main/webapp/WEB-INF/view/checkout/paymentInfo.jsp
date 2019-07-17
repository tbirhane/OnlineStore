<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Payment Form</title>
</head>
<body>
<h3>Payment Information</h3>
<form:form modelAttribute="paymentInfo" action="paymentInfo" method="post">
    <label>Type:</label>
    <fieldset>
        <legend>Card Type: </legend>
        <label for="visa"> Visa </label><input type="radio" name="type" value="" id="visa"/>
        <label for="master-card"> Master Card </label><input type="radio" name="type" value="" id="master-card"/>
        <label for="discover"> Discover </label><input type="radio" name="type" value="" id="discover"/>
    </fieldset>
    <pre>
    <label>Card Number:</label>
    <input type="text" name="cardNumber" value=""/>
    <label>Expiration Date:</label>
    <input type="date" name="expireDate" value=""/>
    <input type="submit" value="Confirm">
        </pre>
</form:form>
</body>

</html>