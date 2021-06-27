<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a href="#" class="navbar-brand">Stack<b>QFlow</b></a>
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse"
			class="collapse navbar-collapse justify-content-start">
			<div class="navbar-nav">
				<a href="home" class="nav-item nav-link">Home</a> <a href="ask"
					class="nav-item nav-link">Ask Question</a> <a href="about.jsp"
					class="nav-item nav-link">About</a>
			</div>
			<div class="navbar-nav ml-auto">
				<a href="login.jsp" data-toggle="dropdown" class="nav-link mr-4"
					aria-expanded="false">Login</a> <a href="register.jsp"
					data-toggle="dropdown" class="btn btn-primary sign-up-btn"
					aria-expanded="false">Sign up</a>
			</div>
		</div>
	</nav>

	<div>
		<form action="all-questions">
			<button>get</button>
		</form>
	</div>
			

</body>
</html>
