package com.miniproject.webapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.mongodb.client.model.Filters.eq;
import com.miniproject.core.dao.QuestionDAO;
import com.miniproject.core.entity.Question;

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
		if(session.getAttribute("user-id") == null) {
			log.info("you are NOT logged in");
			req.getRequestDispatcher(URI).forward(req, resp);
		}
		
		QuestionDAO dao = new QuestionDAO();
		
		log.info(">>>>>>>>>>>getting your questions----- " + session.getAttribute("user-id"));
	
		List<Question> list = new ArrayList<>();
		
		/*
		 * if(Integer.valueOf(session.getAttribute("user-id").toString()) ==
		 * (Integer)3)log.info("both are integers"); else
		 * log.info("incompatible types!!!!!!!!!");
		 */
		Integer userId = Integer.valueOf(session.getAttribute("user-id").toString());
		dao.findWithCondition(eq("uid", userId), 20).forEachRemaining((q) -> log.info(q.toString()));
		
		session.setAttribute("my-questions", list);
		
		
	}
}
