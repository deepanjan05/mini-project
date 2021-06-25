package com.miniproject.core.contracts;

import java.util.List;

import org.bson.conversions.Bson;
import com.miniproject.core.entity.Question;
import com.mongodb.client.MongoCursor;

public interface IQuestionDAO {
	void insertOne(Question question);
	
	void insertMany(List<Question> questions);
	
	long update(Bson filters, Bson updates);
	
	Question findById(int id);
	
	Iterable<Question> findAll();

	MongoCursor<Question> findWithCondition(Bson condition, int limit);

	boolean deleteById(int id);

	long delete(Bson filters);

}
