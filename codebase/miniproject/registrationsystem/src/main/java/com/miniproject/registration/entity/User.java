package com.miniproject.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "userid")
	private int userId; 
	
	@Column(name="name")
	private String name; 
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "password")
	private String password;
	
	@Column( name = "gender")
	private String gender;
}
