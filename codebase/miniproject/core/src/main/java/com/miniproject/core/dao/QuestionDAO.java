package com.miniproject.core.dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.miniproject.core.contracts.IQuestionDAO;
import com.miniproject.core.entity.Question;
import com.miniproject.core.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class QuestionDAO implements IQuestionDAO {
	private MongoClient mongoClient ; 
	private MongoCollection collection ; 
	
	public QuestionDAO() {
		mongoClient = MongoUtil.mongoUtil(); 
		collection = MongoUtil.getCollectionFromDB("qdb", "questions", Question.class); 

	}

	@Override
	public boolean insertOne(Question question) {
		collection.insertOne(question);
		return true;
		
	}

	@Override
	public void insertMany(List<Question> questions) {
		collection.insertMany(questions);
		
	}

	@Override
	public long update(Bson filters, Bson updates) {
		
		return collection.updateMany(filters, updates).getModifiedCount();;
	}
	
	@Override
	public Question findById(ObjectId id) {
		return (Question) collection.find(eq("uid", id)).first(); 
	}

	@Override
	public Iterable<Question> findAll() {
		return collection.find().into(new ArrayList<Question>());
	}

	@Override
	public MongoCursor<Question> findWithCondition(Bson condition, int limit) {
		return collection.find(condition).limit(limit).iterator(); 
	}

	@Override
	public boolean deleteById(ObjectId id) {
		return collection.deleteOne(eq("qid", id)).getDeletedCount()>0; 
	}

	@Override
	public long delete(Bson filters) {
		return collection.deleteMany(filters).getDeletedCount();
	}

}
