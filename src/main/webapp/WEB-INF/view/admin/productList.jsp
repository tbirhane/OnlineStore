<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Products currently in the shop</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<h1>Products currently in the shop</h1>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Descrption </th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
        <th scope="col">Image</th>
    </tr>
    </thead>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td><a href="findbyid/${product.id}">edit</a></td>
            <td><a href="delete/${product.id}">delete</a></td>
            <td><img src="data:image/jpeg;base64,${product.imageStr}" width="50" height="50"/></td>
        </tr>
    </c:forEach>
</table>

</body>

</html>