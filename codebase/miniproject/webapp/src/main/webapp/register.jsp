<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StackQFlow : Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">
</head>
<body>
<sap:if test="${requestScope.errorMsg!=null}">
	<h3> Error: ${requestScope.errorMsg} </h3>
</sap:if>
	<h2>Register Here</h2>
	<form action="register" method="post">
		<div class="container">
			<div class="form-group">
				<label for="name">Name </label> <input type="text"
					class="form-control" id="name" name="name"
					placeholder="Enter Name">
			</div>
			<div class="form-group">
				<label for="email">Email </label> <input type="text"
					class="form-control" id="email" name="email"
					placeholder="Enter Name">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter Password">
			</div>
			<div class="form-group">
				<label for="gender"> Gender </label> <input type="text"
					class="form-control" id="gender" name="gender"
					placeholder="Enter Gender">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</body>
</html>