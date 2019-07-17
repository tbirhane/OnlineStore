<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shipping Form</title>
</head>
<body>
<h3>Shipping Address</h3>
<form:form modelAttribute="shippingAddress" action="checkout" method="post">
    <pre>
    <label>Street:</label>
    <input type="text" name="street" value=""/>
    <label>City:</label>
    <input type="text" name="city" value=""/>
    <label>State:</label>
    <input type="text" name="state" value=""/>
    <label>Zip:</label>
    <input type="text" name="zip" value=""/>
    <input type="submit" value="Continue">
        </pre>
</form:form>

</body>


</html>