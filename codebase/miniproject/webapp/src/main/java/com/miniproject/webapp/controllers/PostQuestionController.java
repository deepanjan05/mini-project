package com.miniproject.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproject.core.entity.Question;
import com.miniproject.core.service.QuestionService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/post-question")
public class PostQuestionController extends HttpServlet {

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
		URI = "register.jsp";
		
		//Check login
		if(session.getAttribute("userId") == null) {
			log.info("you are NOT logged in!");
			req.getRequestDispatcher(URI).forward(req, resp);
			
		}
		
		Question question = new Question();
		
		question.setUid(Integer.parseInt((String) session.getAttribute("userId")));
		question.setQTitle(req.getParameter("question-title"));
		question.setQBody(req.getParameter("question-body"));
		
		QuestionService questionService = new QuestionService();
		if(questionService.postQuestion(question)) {
			log.info("{}",question.toString());
			req.getRequestDispatcher("all-questions").forward(req, resp);
		}
		else {
			log.info("error: unsuccessful");
		}
	}
}
