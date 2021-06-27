package com.miniproject.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * @Author: Deepanjan Datta
 * @Description: Web servlet for user registration
 */
@Slf4j
@WebServlet("/register")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("---------------- Starting registration -----------------");
		boolean registered = false;
		String err = "";
		HttpSession session = req.getSession();

		// Create entity from req
		log.info(">>>>>>> Creating User object entity");
		User user;
		try {
			user = new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setGender(req.getParameter("gender"));
		} catch (Exception e) {
			log.error("User entity not created! Check parameter typecast");
			err = "Invalid credentials!";
			user = null;
		}

		// validate email, name, gender and try adding to database
		log.info(">>>>>>> Validating User object and adding to database");
		try {
			if (UserService.registerUser(user)) {
				registered = true;
				log.info("New user registered! User email: " + user.getEmail());
			} else {
				err = "An account already exist with this email id";
			}
		} catch (IllegalArgumentException e) {
			err = "Invalid Credentials!";
		}

		// login if successful else error message
		// redirect to respective page
		if (registered) {
			session.setAttribute("name", user.getName());
			session.setAttribute("user-id", user.getUserId);
			log.info(">>>>>>> Registration successful. Logging in...");
			
			
			String URI = "login";
			URI = "WEB-INF/view/home.jsp";
			req.getRequestDispatcher(URI).forward(req, resp);
		} else {
			req.setAttribute("errorMsg", err);
			log.info(">>>>>>> Registration unsuccessful. ...");
			
			String URI = "register.jsp";
			req.getRequestDispatcher(URI).forward(req, resp);
		}
	}
}
