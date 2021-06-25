package com.miniproject.registration.service;

import javax.persistence.EntityNotFoundException;

import com.miniproject.registration.contracts.IUserDAO;
import com.miniproject.registration.dao.UserDAO;
import com.miniproject.registration.entity.User;
import com.miniproject.registration.util.UserUtil;

public class UserService {
	public static boolean registerUser(User user) {
		if (user == null)
			return false;

		if (UserUtil.validateName(user.getName()) && UserUtil.validateEmail(user.getEmail())) {
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
