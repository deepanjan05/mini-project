package com.miniproject.registration.client;

import javax.persistence.EntityManager;

import com.miniproject.registration.dao.UserDAO;
import com.miniproject.registration.entity.User;


public class App {
	public static void main(String[] args) {
		User user = new User(101, "Deepanjan", "deepanjan@gmail", "deep", "male");
		
		UserDAO udao = new UserDAO();
		udao.insertUser(user);
	}
}
