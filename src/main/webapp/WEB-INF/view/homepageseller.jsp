<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<meta charset="ISO-8859-1">
<title>Seller Home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>

<h1>Hello Seller</h1>
	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Welcome Seller</h1>
			<thead>
			
			</thead>
			<h3></h3>
		</div>
	</div>
	

	<c:choose>

		<c:when test="${mode=='ALL_PRODUCTS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Products</h3>
				<hr>
				<form class="form-horizontal" action="/login-seller">
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Brand</th>
									<th>Made In</th>
									<th>Model Name</th>
									<th>Price</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${products }">
									<tr>
										<td>${product.id}</td>
										<td>${product.name}</td>
										<td>${product.brand}</td>
										<td>${product.madein}</td>
										<td>${product.modelName}</td>
										<td>${product.price}</td>
										<td><a href="/deleteproduct?id=${product.id }" action="/saveproduct"><span
												class="glyphicon glyphicon-trash"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>
	<a href="/newproduct">Create New Product</a>
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>