package com.miniproject.authentication.entity;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;
}
