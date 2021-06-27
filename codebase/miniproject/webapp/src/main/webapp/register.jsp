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
<title>StackQFlow | Register</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>

<body>

<%-- 	<%@ include file="./WEB-INF/view/header.jsp"%> --%>

	<div class="container">
		<br>

		<!-- <sap:if test="${requestScope.errorMsg!=null}">
			<h3>Error: ${requestScope.errorMsg}</h3>
		</sap:if> -->

		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">Create Account</h4>
				<p class="text-center">Get started with your free account</p>
				<form action="register" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="name" class="form-control" placeholder="Full name"
							type="text" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" class="form-control"
							placeholder="Email address" type="email" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i
								class="fa fa-venus-mars"></i>
							</span>
						</div>
						<select class="form-control" name="gender">
							<option selected="">Select Gender</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="non-binary">Non-binary</option>
						</select>
					</div>
					<!-- form-group end.// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input class="form-control" id="password"
							placeholder="Create password" type="password" name="password"
							onchange='check();' required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input class="form-control" id="confirm_password"
							placeholder="Repeat password" type="password" onchange="check();"
							required>
						<div class="input-group-append" id="password_match_message"></div>
					</div>
					<sap:if test="${requestScope.errorMsg!=null}">
						<div class="alert alert-danger" role="alert">
							${requestScope.errorMsg}</div>
					</sap:if>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Create Account</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="login.jsp">Log In</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->

	</div>
	<!--container end.//-->
</body>
<script type="text/javascript">
	var check = function() {
		if (document.getElementById('password').value == document
				.getElementById('confirm_password').value
				&& document.getElementById('password').value != "") {
			document.getElementById('password_match_message').innerHTML = '<span class="input-group-text"> <i class="fa fa-check" style="color:green"></i></span>';
		} else {
			document.getElementById('password_match_message').innerHTML = '<span class="input-group-text"> <i class="fa fa-times" style="color:red"></i></span>';
		}
	}
</script>
</html>