
package com.miniproject.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * @Author: Praduman Pannu
 * @Email: praduman.pannu@publicissapient.com
 */

@Slf4j
@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("---------------- Authenticating User -----------------");

		String err = null;
		HttpSession session = req.getSession();

		// Credentials
		String email = null;
		String password = null;
		try {
			email = req.getParameter("email");
			password = req.getParameter("password");
		} catch (Exception e) {
			log.error("Credentials not found in the request");
			err = "Invalid request!";
		}

		// validate credentials
		log.info(">>>>>>> Validating credentials");
		try {
			Integer userId = UserService.loginUser(email, password); 
			if (userId != -1) {
				log.info("Login Success!");
				User user = UserService.getUser(userId); 
				
				// set session attributes
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("userName", user.getName());
				
				// set session attributes
				Cookie userNameCookie = new Cookie("userName", (String) session.getAttribute("userName"));
				Cookie userIDCookie = new Cookie("userId", user.getName());
				
				resp.addCookie(userNameCookie);
				resp.addCookie(userIDCookie);
				
				String URI = "login";
				URI = "WEB-INF/view/home.jsp";
				req.getRequestDispatcher(URI).forward(req, resp);
			} else {
				err = "Wrong credentials!";
			}
		} catch (IllegalArgumentException e) {
			err = "Invalid Credentials!";
			
		}

		// Display error
		if (err != null) {
			req.setAttribute("errorMsg", err);
			log.info(">>>>>>> Authentication failed ...");
			
			String URI = "login.jsp";
			req.getRequestDispatcher(URI).forward(req, resp);
		}
	}

}
