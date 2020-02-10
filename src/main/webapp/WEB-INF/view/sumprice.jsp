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
<title>TOTAL SUM </title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
<body>

<c:choose>

		<c:when test="${mode=='ALL_ITEMS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Items</h3>
				<hr>
				<form class="form-horizontal" action="/savetocart">
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Brand</th>
									<th>Made In</th>
									<th>Model Name</th>
									<th>Price</th>
									<th>Quantity</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${items }">
									<tr>
										<td>${item.name}</td>
										<td>${item.brand}</td>
										<td>${item.madein}</td>
										<td>${item.modelName}</td>
										<td>${item.price}</td>
										<td>${item.quantity}</td>
											
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="container text-center" id="tasksDiv">
					<h1>TOTAL AMOUNT</h1>
	<form action="prices">
	<c:forEach var="price" items="${price}">
	${price}
	</c:forEach>
	</form>
	</div>
	
	<div class="container text-center" id="tasksDiv">
	<form class="form-horizontal" method="POST">
	<div class="form-group ">
						<!-- <input type="submit" class="btn btn-primary" value="BUY" /> -->
						<c:forEach var="item" items="${items }">
									<tr>
									<%-- <c:forEach var="quantity" items="${quantitys}"> --%>
						<td><a href="/deleteall?quantity=${item.quantity }"><span
												class="glyphicon glyphicon-plus"></span></a></td>
												<%-- </c:forEach> --%>
												</tr>
								</c:forEach>
					</div>
				</form>
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