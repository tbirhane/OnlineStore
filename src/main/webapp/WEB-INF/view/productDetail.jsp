<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product Details</title>
</head>

<body>
	<table>
		<tr><td>Name: ${product.name}</td></tr>
		<tr><td>Description: ${product.description}</td></tr>
		<tr><td>Price: ${product.price}</td></tr>
		<tr><td>Quantity: ${product.quantity}</td></tr>
		<td>Image:<img width="50" height="50" src="data:image/jpeg;base64,${product.imageStr}"/></td>
	</table>
	<a href="/admin/products/list"><input type="button" value="ProductList"/></a>
</body>

</html>