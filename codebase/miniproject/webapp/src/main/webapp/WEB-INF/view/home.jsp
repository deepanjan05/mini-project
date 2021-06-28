<%@page import="com.miniproject.webapp.services.AuthenticationService"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>StackQFlow | Home </title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<% if(!AuthenticationService.isLoggedIn(request)) {
	request.getRequestDispatcher("../../login.jsp").forward(request, response);
}
%>
<body>
	<%@ include file="./header.jsp"%> 
	<div id="displayQuestion">
	
	<c:forEach items="${requestScope.myQuestions}" var="current">
       <div class="card">
       <div class="card-title"> ${current}</div>
       </div>
       <h>${current}</h1>
	</c:forEach>  
	
	</div>

</body>

</html>