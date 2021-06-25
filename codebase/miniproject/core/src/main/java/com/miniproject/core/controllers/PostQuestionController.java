package com.miniproject.core.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproject.core.entity.Question;

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
		
		Question question = new Question();
		
		question.setUid(Integer.parseInt(req.getParameter("user-id")));
		question.setQTitle(req.getParameter("question-title"));
		question.setQBody(req.getParameter("question-body"));
		question.setBestAnswerId(null);
		question.setAnswers(null);
	}
}
