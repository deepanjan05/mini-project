package com.miniproject.core.contracts;

import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.miniproject.core.entity.Question;
import com.mongodb.client.MongoCursor;

public interface IQuestionDAO {
	boolean insertOne(Question question);
	
	void insertMany(List<Question> questions);
	
	long update(Bson filters, Bson updates);
	
	Question findById(ObjectId id);
	
	Iterable<Question> findAll();

	MongoCursor<Question> findWithCondition(Bson condition, int limit);

	boolean deleteById(ObjectId id);

	long delete(Bson filters);

}
