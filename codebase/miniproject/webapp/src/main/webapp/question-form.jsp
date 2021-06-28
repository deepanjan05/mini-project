<%@page import="com.miniproject.webapp.services.AuthenticationService"%>
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
<title>StackQFlow | Ask </title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<% if(!AuthenticationService.isLoggedIn(request)) {
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
<body>
	<%@ include file="WEB-INF/view/header.jsp"%> 
	
	<div class="container mt-3">
		<form method="post" action="post-question">
			<div class="mb-3">
				<label for="question-title" class="form-label">Title</label> <input
					type="text" class="form-control" name="question-title"
					required="required">
			</div>
			<div class="mb-3">
				<label for="question-body" class="form-label">Question</label> <input
					type="text" class="form-control" name="question-body">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>



</body>
</html>
