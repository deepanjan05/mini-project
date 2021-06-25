package com.miniproject.core;

import org.bson.types.BSONTimestamp;
import org.bson.types.ObjectId;

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
		dao.insertOne(new Question(2401, "What is JSP?","I want to know about JSPs in java, please help", null, null));
		
        System.out.println( "Hello World!" );
    }
}
