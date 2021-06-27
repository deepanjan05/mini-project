package com.miniproject.authentication.service;

import com.miniproject.authentication.contracts.IUserDAO;
import com.miniproject.authentication.dao.UserDAO;
import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.util.UserUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
	public static boolean registerUser(User user) {
		if (user == null)
			return false;

		if (UserUtil.validateName(user.getName()) && UserUtil.validateEmail(user.getEmail()) && UserUtil.validatePassword(user.getPassword())) {
			IUserDAO uDAO = new UserDAO();
			if (uDAO.addUser(user)) {
				return true;
			}
		} else {
			throw new IllegalArgumentException("Invalid Email or Name!");
		}
		return false;
	}

	public static boolean unregisterUser(String email) {
		if (UserUtil.validateEmail(email)) {
			IUserDAO uDAO = new UserDAO();
			User user = uDAO.getByEmail(email);
			if (user != null) {
				if (uDAO.deleteUser(user.getUserId())) {
					return true;
				} else {
					throw new IllegalArgumentException("Error in User.class");
				}
			} else {
				return false;
			}
		} else {
			throw new IllegalArgumentException("Invalid Email!");
		}
	}
	
	public static Integer loginUser(String email, String password) {
		if (email == null || password == null)
			return -1;

		if (UserUtil.validateEmail(email)) {
			IUserDAO uDAO = new UserDAO();
			User user = uDAO.getByEmail(email);
			if (user != null) {
				if (password.equals(user.getPassword())) {
					log.info("Login successfull!");
					return user.getUserId();
				} else {
					log.info("Wrong password!");
				}
			} else {
				log.info("User doesn't exist!");
			}
		} else {
			log.info("Invalid email!");
		}
		
		return -1;
		
		
		
	}
	
	public static User getUser(Integer userId) {
		if (userId == null || userId == -1)
			return null;

		IUserDAO uDAO = new UserDAO();
		return uDAO.getUser(userId);
		
		
	}
}
