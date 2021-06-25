package com.miniproject.registration.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.miniproject.registration.entity.User;
import com.miniproject.registration.service.UserService;
import com.miniproject.registration.util.UserUtil;
import com.sun.tools.sjavac.Log;

/*
 * @Author: Deepanjan Datta
 * @Description: Web servlet for user registration
 */
@WebServlet("/register")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean registered = false;
		String err = "";
		HttpSession session = req.getSession();

		// Create entity from req
		User user;
		try {
			user = new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setGender(req.getParameter("gender"));
		} catch (Exception e) {
			Log.error("User entity not created! Check parameter typecast");
			err = "Invalid credentials!";
			user = null;
		}

		// validate email, name, gender and try adding to database
		try {
			if (UserService.registerUser(user)) {
				registered = true;
			} else {
				err = "An account already exist with this email id";
			}
		} catch (IllegalArgumentException e) {
			err = "Invalid Email or Name";
		}

		// login if successful else error message
		// redirect to respective page
		if (registered) {
			String URI = "login";
			req.getRequestDispatcher(URI).include(req, resp);
		} else {
			String URI = "WEB-INF/view/register.jsp";
			
			req.getRequestDispatcher(URI).forward(req, resp);;
		}
	}
}
