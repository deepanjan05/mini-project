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
import com.miniproject.webapp.services.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/home")
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
		
		String URI = "login.jsp";		
		//Check login
		if(!AuthenticationService.isLoggedIn(req)) {
			log.info("you are NOT logged in");
			req.getRequestDispatcher(URI).forward(req, resp);
		}
		
		QuestionDAO dao = new QuestionDAO();
		
		log.info(">>>>>>>>>>>getting your questions----- " + session.getAttribute("userId"));
	
		List<String> list = new ArrayList<>();
		
		/*
		 * if(Integer.valueOf(session.getAttribute("user-id").toString()) ==
		 * (Integer)3)log.info("both are integers"); else
		 * log.info("incompatible types!!!!!!!!!");
		 */
//		Integer userId = Integer.valueOf(session.getAttribute("userId").toString());
//		dao.findWithCondition(eq("uid", userId), 20).forEachRemaining((q) -> log.info(q.toString()));
//		dao.findWithCondition(eq("uid", userId), 20).forEachRemaining((q) -> list.add(q.toString()));
//		list.forEach((item) -> log.info(item));
		
		dao.findAll().forEach((q) -> log.info(q.toString()));
		dao.findAll().forEach((q) -> list.add((q) -> {
			if (q.getQTitle() != null) {
				list.add(q.toString());
			}
		}));
		list.forEach((item) -> log.info(item));
		
		req.setAttribute("myQuestions", list);
		
		req.getRequestDispatcher("WEB-INF/view/home.jsp").forward(req, resp);
		
		
	}
}
