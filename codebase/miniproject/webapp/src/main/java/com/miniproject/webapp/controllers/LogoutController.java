
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
@WebServlet("/logout")
public class LogoutController extends HttpServlet{
	
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
		HttpSession session = req.getSession();
		session.invalidate();
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}		
		}
		String URI = "logout";
		URI = "WEB-INF/view/home.jsp";
		req.getRequestDispatcher(URI).forward(req, resp);
		
	}

}
