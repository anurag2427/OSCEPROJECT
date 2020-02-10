<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>User Home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	
	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Welcome User</h1>
			<h3></h3>
		</div>
	</div>
	
		
	<div class="container" id="homediv">
		<div class="jumbotron text-top-right">
			<form class="form-horizontal" method="POST" action="/viewcart">
			<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="VIEW CART" />
					</div>
			</form>
		</div>
	</div>	
	
	<c:choose>
	
	<c:when test="${mode=='USER' }">
			<div class="container text-center" id="tasksDiv">
				<h3></h3>
				<hr>
				<form class="form-horizontal" action="/login-user">
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
								<th>First Name</th>
									<!-- <th>Id</th> 
									<th>User Name</th>
									
									<th>Last Name</th>
									<th>Age</th>
									<th>Password</th> -->
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${users }">
									<tr>
									<td>${user.firstname}</td>
										<%-- <td>${user.id}</td>
										<td>${user.username}</td>
										<td>${user.firstname}</td>
										<td>${user.lastname}</td>
										<td>${user.age}</td>
										<td>${user.password}</td> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='ALL_PRODUCTS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Products</h3>
				<hr>
				<form class="form-horizontal" action="/login-user">
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
									<th>Add To Cart</th>
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
										<td><a href="cartitems/?id=${product.id}" action="/login-user"><span
												class="glyphicon glyphicon-plus"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>