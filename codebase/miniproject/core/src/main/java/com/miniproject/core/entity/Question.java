package com.miniproject.core.entity;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	private Integer uid;
	private String qTitle;
	private String qBody;
	private ObjectId bestAnswerId;
	private List<ObjectId> answers;
	
}
