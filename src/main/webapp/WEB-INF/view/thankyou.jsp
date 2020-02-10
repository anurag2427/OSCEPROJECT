<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>THANKYOU FOR BUYING</title>
</head>
<body>
<c:choose>
<c:when test="${mode=='MODE_THANKYOU' }">
<h1>Thank You For Buying FROM US</h1>

<div class="container text-center" id="tasksDiv">
				<hr>
				<form class="form-horizontal" action="/gotohome">
					<div class="table-responsive">
					<input type="submit" class="btn btn-primary" value="HOME" />
					</div>
					</form>
					</div>
</c:when>
</c:choose>
</body>
</html>