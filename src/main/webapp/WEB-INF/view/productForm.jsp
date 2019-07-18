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
</head>

<body>
<section id="cover">
    <div id="cover-caption">
        <div id="container" class="container">

                <div class="col-sm-6 offset-sm-3 ">
                    <h1 class="display-4">ProductForm</h1>
                    <div class="info-form">
	<form:form modelAttribute="product" method="post" action="add" enctype="multipart/form-data">
    <div class="input-group mb-6">
        <div class="form-group">
            <label for="exampleInputName1">Name</label>
            <input type="text" name="name" class="form-control" id="exampleInputName1" >
        </div>

    </div>

        <div class="input-group mb-6">
        <div class="form-group">
            <label for="exampleInputDescription1">Description</label>
            <input type="text" name="description" class="form-control" id="exampleInputDescription1" >
        </div>
        </div>
        <div class="input-group mb-6">
        <div class="form-group">
            <label for="exampleInputPrice1">Price</label>
            <input type="text" name="price" class="form-control" id="exampleInputPrice1" >
        </div>
        </div>
        <div class="input-group mb-6">
        <div class="form-group">
            <label for="exampleInputQuantity">Quantity</label>
            <input type="text" name="quantity" class="form-control" id="exampleInputQuantity">
        </div>
        </div>

        <div class="input-group mb-6">
            <div class="form-group mb-3">
                <label for="exampleInputQuantity">Image</label>
                <input type="file" name="productImage" class="form-control" id="productImage" >
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