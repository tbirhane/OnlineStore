<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Details</title>
</head>

<body>
       OrderDate: ${customerOrder.orderDate}<br>
       OrderNumber: ${customerOrder.id}

       <fieldset class="scheduler-border">
           <legend class="scheduler-border">ShippingAddress</legend>
           <div class="control-group">
               <div class="controls bootstrap-timepicker">
                   <p> Street : ${customerOrder.shippingAddress.street} </p>
                   <i class="icon-time"></i>
               </div>
               <div class="controls bootstrap-timepicker">
                   <p> City : ${customerOrder.shippingAddress.city} </p>
                   <i class="icon-time"></i>
               </div>
               <div class="controls bootstrap-timepicker">
                   <p> State : ${customerOrder.shippingAddress.state} </p>
                   <i class="icon-time"></i>
               </div>
               <div class="controls bootstrap-timepicker">
                   <p> Zip: ${customerOrder.shippingAddress.zip} </p>
                   <i class="icon-time"></i>
               </div>

           </div>
       </fieldset>
       <c:forEach var="order" items="${customerOrder.orderLineList}">

              <P>Product Name:   ${order.product.name}</P>
              <P>Product Price:${order.product.price}</P>
              <p>Product Quantiy:${order.quantity}</p>


       </c:forEach>

</body>

</html>