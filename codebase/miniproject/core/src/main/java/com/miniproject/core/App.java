package com.miniproject.core;

import com.miniproject.core.dao.QuestionDAO;
import com.miniproject.core.entity.Question;
import com.miniproject.core.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		QuestionDAO dao = new QuestionDAO();
		dao.insertOne(new Question(109, 2405, "What is JSP?"));
		
        System.out.println( "Hello World!" );
    }
}
