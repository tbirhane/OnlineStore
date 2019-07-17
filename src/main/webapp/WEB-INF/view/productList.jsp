<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Products currently in the shop</title>

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="resources/css/mycss.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="resources/js/script.js" type="text/javascript"></script>
    <script src="resources/js/billing.js" type="text/javascript"></script>
</head>

<body>
	<h1>Products currently in the shop</h1>

<%--	<table>--%>
<%--		<c:forEach var="product" items="${products}">--%>
<%--			<tr>--%>
<%--				<td>${product.name}</td>--%>
<%--				<td>${product.description}</td>--%>
<%--				<td>${product.quantity}</td>--%>
<%--				<td>${product.price}</td>--%>
<%--				<sec:authorize access="hasRole('ADMIN')">--%>
<%--					<td><a href="books/${book.id}">edit</a></td>--%>
<%--				</sec:authorize>--%>

<%--			</tr>--%>
<%--		</c:forEach>--%>
<%--	</table>--%>

<%--	<sec:authorize access="hasRole('ADMIN')">--%>
<%--		<a href="books/add"> Add a book</a>--%>
<%--	</sec:authorize>--%>
    <div id="main-container">
        <div id="product-container">
            <c:forEach var="product" items="${products}">
                <div class="products">
                    <h4>${product.name}</h4>
                    <p>${product.description}</p>
                    <p>${product.quantity}</p>
                    <p>${product.price}</p>
                    <input type="text" name="quantity" class="form-control" value="1">
                    <button class="btn btn-info" id="${product.id}" onclick="addToCart(this.id)"> Add To Cart</button>
                </div>
            </c:forEach>
        </div>


        <div id="cart-container">
            <a href="logout">Logout</a>
            <h4> Items in your cart</h4>
            <table id="order-table" class="table table-striped" cellpadding="2" cellspacing="2">
            <tr>
                <th>Option</th>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
                <c:forEach var="item" items="${cart}">
                <tr>
                    <td><button type="button" class="btn btn-danger" id="item-${item.id}" onclick="removeItemFromCart(this.id)">Remove</button></td>
                        <td>${item.product.id}</td>
                        <td>${item.product.name}</td>
                        <td>$${item.product.price}</td>
                        <td>${item.quantity}
<%--                            <input type="text" value="${item.quantity}" id="intput-${item.id}"/>--%>
                        </td>
                        <td id="subtotal-${item.id}">${item.product.price * item.quantity}</td>
                </tr>
                </c:forEach>
            </table>
            <h6 id="total-price">Total: $ <c:out value="${total}" default="0.0"/> </h6>

            <form action="products/checkout" method="get">

            <input type="submit" value="Check Out" class="btn btn-info"/>
            </form>

        </div>
    </div>
</body>

</html>