package com.miniproject.authentication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "logtable")
public class LogData {
	@Id
	@Column(name = "logid")
	private int logId; 
	
	@Column(name="type")
	private String type;
	
	@Column(name="log")
	private String log; 
}
