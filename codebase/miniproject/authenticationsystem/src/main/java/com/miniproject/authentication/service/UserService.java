package com.miniproject.authentication.service;

import com.miniproject.authentication.contracts.IUserDAO;
import com.miniproject.authentication.dao.UserDAO;
import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.util.UserUtil;

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
}
