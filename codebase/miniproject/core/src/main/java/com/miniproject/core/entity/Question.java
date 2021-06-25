package com.miniproject.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	private Integer qid;
	private Integer uid;
	private String qBody;
	
}
