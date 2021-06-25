package com.miniproject.core.entity;

import java.util.List;

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
	private Integer bestAnswerId;
	private List<Integer> answers;
	
}
