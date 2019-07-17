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
	<h1>${action} Product</h1>
	<form:form modelAttribute="product" method="post" action="edit">
		Name: <form:input path="name" title="Name"/><br/>
		Description:<form:textarea path="description" title="Short Description"/><br/>
		Price: <form:input path="price" title="Price (USD)"/><br/>
		Quantity: <form:input path="quantity" title="Quantity"/><br/>
		<input type="submit" value="${action} Product">
	</form:form>
	<a href="/products"><input type="button" value="Home"/></a>
</body>

</html>