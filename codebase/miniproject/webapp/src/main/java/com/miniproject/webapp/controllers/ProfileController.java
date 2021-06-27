package com.miniproject.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/profile")
public class ProfileController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("---------------- Profile page request -----------------");
		//HttpSession session = req.getSession();
		
		// To be completed by Praduman
		
		String URI = "WEB-INF/view/profile.jsp";
		req.getRequestDispatcher(URI).forward(req, resp);
	}
}
