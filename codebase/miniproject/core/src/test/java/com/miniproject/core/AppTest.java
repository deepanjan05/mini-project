package com.miniproject.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.miniproject.core.dao.QuestionDAO;
import com.miniproject.core.entity.Question;

/**
 * Unit test for simple App.
 */
public class AppTest {
	QuestionDAO dao;
	Question q;
	
	@Before
	public void setUp() {
		 dao = new QuestionDAO();
		 q = new Question(101, "What is a jUnit test?", "Explain in more detail about java tests.", null, null);
	}
	
    @Test
    public void postQuestion() {
    	assertTrue(dao.insertOne(q));	
    }
}
