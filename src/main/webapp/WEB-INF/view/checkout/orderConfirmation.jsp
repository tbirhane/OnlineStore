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
               <label class="control-label input-label" for="street">Street :</label>
               <div class="controls bootstrap-timepicker">
                   <input type="text" class="street" id="street" name="${customerOrder.shippingAddress.street}"  />
                   <i class="icon-time"></i>
               </div>
               <label class="control-label input-label" for="city">City :</label>
               <div class="controls bootstrap-timepicker">
                   <input type="text" class="city" id="city" name="${customerOrder.shippingAddress.city}"  />
                   <i class="icon-time"></i>
               </div>
               <label class="control-label input-label" for="state">State :</label>
               <div class="controls bootstrap-timepicker">
                   <input type="text" class="state" id="state" name="${customerOrder.shippingAddress.state}" />
                   <i class="icon-time"></i>
               </div>
               <label class="control-label input-label" for="zipe">ZipeCode :</label>
               <div class="controls bootstrap-timepicker">
                   <input type="text" class="zipe" id="zipe" name="${customerOrder.shippingAddress.zipe}" />
                   <i class="icon-time"></i>
               </div>

           </div>
       </fieldset>
       <c:forEach var="order" items="${customerOrder}">

              <P>Product Name:   ${order.product.name}</P>
              <P>Product Price:${order.product.price}</P>
              <p>Product Quantiy:${order.orderLineList.quantity}</p>


       </c:forEach>

</body>

</html>