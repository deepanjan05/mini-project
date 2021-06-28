<%@page import="com.miniproject.webapp.services.AuthenticationService"%>
<% boolean loggedIn = AuthenticationService.isLoggedIn(request);
	pageContext.setAttribute("loggedIn", loggedIn);
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a href="home" class="navbar-brand">Stack<b>QFlow</b></a>
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Collection of navigation links, forms, and other content for toggling -->
		<div id="navbarCollapse"
			class="collapse navbar-collapse justify-content-start">
			<div class="navbar-nav">
				<a href="home" class="nav-item nav-link">Home</a> <a href="question-form.jsp"
					class="nav-item nav-link">Ask Question</a> <a href="#"
					class="nav-item nav-link">About</a>
			</div>
			<div class="navbar-nav ml-auto">
			<sap:if test="${loggedIn==false}">
				<a href="login.jsp" data-toggle="dropdown" class="nav-link mr-4"
					aria-expanded="false">Login</a> <a href="register.jsp" data-toggle="dropdown"
					class="btn btn-primary sign-up-btn" aria-expanded="false">Sign Up</a>
			</sap:if>
			<sap:if test="${loggedIn==true}">
				<a href="profile" data-toggle="dropdown" class="nav-link mr-4"
					aria-expanded="false">${sessionScope.userName}</a> <a href="logout" data-toggle="dropdown"
					class="btn btn-primary sign-up-btn" aria-expanded="false">Logout</a>
			</sap:if>
			</div>
		</div>
	</nav>