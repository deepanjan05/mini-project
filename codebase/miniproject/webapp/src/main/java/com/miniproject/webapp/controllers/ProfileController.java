package com.miniproject.webapp.controllers;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import static com.mongodb.client.model.Filters.eq;

import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.service.UserService;
import com.miniproject.core.dao.QuestionDAO;
import com.miniproject.webapp.services.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

/*
 * @Author: Praduman Pannu
 * @Email: praduman.pannu@publicissapient.com
 */

@Slf4j
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("---------------- Profile page request -----------------");

		if (AuthenticationService.isLoggedIn(req)) {
			HttpSession session = req.getSession();
			Integer userId = Integer.parseInt((String) session.getAttribute("userId"));

			User user = UserService.getUser(userId);
			req.setAttribute("userName", user.getName());
			req.setAttribute("email", user.getEmail());
			req.setAttribute("gender", user.getGender());

			List<String> list = new ArrayList<>();
			List<String> dup = new ArrayList<>();

			QuestionDAO dao = new QuestionDAO();
			dao.findWithCondition(eq("uid", userId), 20).forEachRemaining((q) -> log.info(q.toString()));
			dao.findWithCondition(eq("uid", userId), 20).forEachRemaining((q) -> {
				if (q.getQTitle() != null) {
					list.add(q.toString());
				}
			});
			list.forEach((item) -> log.info(item));

			req.setAttribute("myQuestions", list);

			String URI = "WEB-INF/view/profile.jsp";
			req.getRequestDispatcher(URI).forward(req, resp);
		}

		String URI = "login.jsp";
		req.getRequestDispatcher(URI).forward(req, resp);

	}
}
