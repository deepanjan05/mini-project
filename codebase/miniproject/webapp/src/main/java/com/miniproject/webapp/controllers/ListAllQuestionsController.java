package com.miniproject.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.mongodb.client.model.Filters.eq;
import com.miniproject.core.dao.QuestionDAO;
import com.miniproject.core.entity.Question;
import com.sun.tools.sjavac.Log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/all-questions")
public class ListAllQuestionsController extends HttpServlet {

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
		
		String URI = "login";
		URI = "WEB-INF/view/home.jsp";
		
		//Check login
		if(session.getAttribute("user-id").equals(null)) {
			req.getRequestDispatcher(URI).forward(req, resp);
		}
		
		QuestionDAO dao = new QuestionDAO();
		
		dao.findWithCondition(eq("uid",session.getAttribute("user-id")), 20).forEachRemaining((q) -> System.out.println(q));
	}
}
