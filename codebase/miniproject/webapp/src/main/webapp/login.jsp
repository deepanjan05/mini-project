<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>StackQFlow | Login</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>

<body>
	<%-- <%@ include file="./header.jsp"%> --%>
	<div class="container">
		<br>

		<!-- <sap:if test="${requestScope.errorMsg!=null}">
			<h3>Error: ${requestScope.errorMsg}</h3>
		</sap:if> -->

		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">Login</h4>
				<form action="login" method="post">
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" class="form-control"
							placeholder="Email address" type="email" required>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input class="form-control" id="password"
							placeholder="Your password" type="password" name="password"
							onchange='check();' required>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Login
						</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						New user? <a href="register.jsp">Sign Up</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->

	</div>
	<!--container end.//-->
</body>
</html>