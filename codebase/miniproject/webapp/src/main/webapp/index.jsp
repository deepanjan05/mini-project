<%@page import="com.miniproject.webapp.services.AuthenticationService"%>
<% if(AuthenticationService.isLoggedIn(request)) {
	request.getRequestDispatcher("home").forward(request, response);
} else {
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>