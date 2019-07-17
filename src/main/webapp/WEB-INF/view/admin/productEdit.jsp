<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body>
<section id="cover">
    <div id="cover-caption">
        <div id="container" class="container">

            <div class="col-sm-6 offset-sm-3 ">
                <h1 class="display-4">ProductForm</h1>
                <div class="info-form">
<form:form modelAttribute="product" method="post" action="../update/${product.id}" enctype="multipart/form-data">
    <form:hidden path="id"/>
<div class="input-group mb-3">
    <div class="form-group">
        <label for="exampleInputName1">Name</label>
        <form:input type="text" path="name" class="form-control" id="exampleInputName1" placeholder="name"/>
    </div>
</div>

<div class="input-group mb-3">
    <div class="form-group">
        <label for="exampleInputDescription1">Description</label>
        <form:input type="text" path="description" class="form-control" id="exampleInputDescription1" placeholder="description"/>
    </div>
</div>

<div class="input-group mb-3">
    <div class="form-group">
        <label for="exampleInputPrice1">Price</label>
        <form:input type="text" path="price" class="form-control" id="exampleInputPrice1" placeholder="price"/>
    </div>
</div>

<div class="input-group mb-3">
<div class="form-group">
        <label for="exampleInputQuantity">Quantity</label>
        <form:input type="text" path="quantity" class="form-control" id="exampleInputQuantity" placeholder="quantity"/>
    </div>
</div>

    <div class="input-group mb-6">
        <div class="form-group mb-3">
            <label for="exampleInputQuantity">Image</label>
            <input type="file" name="image" class="form-control" id="exampleInputImage" >
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
                    <br>
                    <form  method="get" action="list">
                        <div class="input-group mb-2">
                            <button type="submit" class="btn btn-success">ProductList</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

</html>