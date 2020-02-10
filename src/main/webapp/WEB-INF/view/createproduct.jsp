<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8" />
<title>NEW PRODUCT</title>
</head>
<body>
	<c:choose>
<%-- 		<c:when test="${mode=='SAVE_PRODUCT' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
				</div>
			</div>

		</c:when> --%>

		<c:when test="${mode=='NEW_PRODUCT' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/saveproduct">
				<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<input type="hidden" name="id" value="${product.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${product.name }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">BRAND</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="brand"
								value="${product.brand }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Made In</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="madein"
								value="${product.madein }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Model Name </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="modelName"
								value="${product.modelName }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Price </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="price"
								value="${product.price }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		</c:choose>
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>