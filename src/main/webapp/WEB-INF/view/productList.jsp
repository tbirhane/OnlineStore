<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Products currently in the shop</title>
</head>

<body>
	<h1>Products currently in the shop</h1>
	<table>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.quantity}</td>
				<td>${product.price}</td>
<%--				<sec:authorize access="hasRole('ADMIN')">--%>
<%--					<td><a href="books/${book.id}">edit</a></td>--%>
<%--				</sec:authorize>--%>
			</tr>
		</c:forEach>
	</table>

<%--	<sec:authorize access="hasRole('ADMIN')">--%>
<%--		<a href="books/add"> Add a book</a>--%>
<%--	</sec:authorize>--%>
	<a href="logout">Logout</a>
</body>

</html>