<%@page import="com.miniproject.webapp.services.AuthenticationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>StackQFlow | Profile</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<%
if (!AuthenticationService.isLoggedIn(request)) {
	request.getRequestDispatcher("../../login.jsp").forward(request, response);
}
%>
<body>
	<%@ include file="./header.jsp"%>
	<div class="container mt-3">
		<div class="main-body">
			<div class="row">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<sap:if test="${requestScope.gender=='male'}">
									<img src="https://www.w3schools.com/howto/img_avatar.png"
										alt="Profile" class="rounded-circle" width="150">
								</sap:if>
								<sap:if test="${requestScope.gender!='male'}">
									<img src="https://www.w3schools.com/howto/img_avatar2.png"
										alt="Profile" class="rounded-circle" width="150">
								</sap:if>
								<div class="mt-3">
									<h4>${requestScope.userName}</h4>
									<p class="text-muted font-size-sm">${requestScope.email}</p>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Full Name</h6>
								</div>
								<div class="col-sm-9 text-secondary">${requestScope.userName}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									${requestScope.email}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Gender</h6>
								</div>
								<div class="col-sm-9 text-secondary">${requestScope.gender}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col text-secondary">Member since 1 Day</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col mb-3">
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-link active" id="nav-questions-tab"
										data-toggle="tab" href="#nav-questions" role="tab"
										aria-controls="nav-questions" aria-selected="true">Questions</a>
									<a class="nav-link" id="nav-answers-tab" data-toggle="tab"
										href="#nav-answers" role="tab" aria-controls="nav-answers"
										aria-selected="false">Answers</a>
								</div>
							</nav>
							<div class="tab-content" id="nav-tabContent">
								<div class="tab-pane fade show active" id="nav-questions"
									role="tabpanel" aria-labelledby="nav-questions-tab">
									<!-- Questions by user show here -->
									<div class="card mt-2">
										<div class="card-body">

											<!-- <h5>Question 1</h5> -->
											<sap:forEach items="${requestScope.myQuestions}" var="current">
												<div class="card">
													<div class="card-title">${current}</div>
												</div>
												<h>${current}</h1>
											</sap:forEach>
											<!-- <p class="text-dark">Question 1 explaination</p>
											<hr class="short br-lighter">

											<h5>Question 2</h5>
											<p class="text-dark">Question 2 explaination</p>
											<hr class="short br-lighter">

											<h5>Question 3</h5>
											<p class="text-dark">Question 3 explaination</p>
											<hr class="short br-lighter">

											<h5>Question 4</h5>
											<p class="text-dark">Question 4 explaination</p>
											<hr class="short br-lighter"> -->

										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="nav-answers" role="tabpanel"
									aria-labelledby="nav-answers-tab">
									<!-- Answers by user show here -->
									<div class="card mt-2">
										<div class="card-body">

											<h5>Question 1</h5>
											<p class="text-dark">Answer by user</p>
											<hr class="short br-lighter">

											<h5>Question 1</h5>
											<p class="text-dark">Answer by user</p>
											<hr class="short br-lighter">

											<h5>Question 1</h5>
											<p class="text-dark">Answer by user</p>
											<hr class="short br-lighter">

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script>
	$('#myTab a').on('click', function(event) {
		event.preventDefault()
		$(this).tab('show')
	})
</script>

</html>