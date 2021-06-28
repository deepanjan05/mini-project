package com.miniproject.core.service;

import com.miniproject.core.dao.QuestionDAO;
import com.miniproject.core.entity.Question;

public class QuestionService {

	public static boolean postQuestion(Question q) {
		if (q == null || q.getQTitle()==null)
			return false;
		QuestionDAO dao = new QuestionDAO();
		
		if (dao.insertOne(q)) {
			return true;
		}
		
		return false;
	}
}
