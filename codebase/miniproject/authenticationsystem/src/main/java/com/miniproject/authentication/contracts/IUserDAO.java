package com.miniproject.authentication.contracts;

import java.util.List;

import com.miniproject.authentication.entity.User;

public interface IUserDAO {
	/* Basic CRUD */
	public boolean addUser(User user);
	public User getUser(int userId);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId);
	
	/* Miscellaneous */
	public List<User> getAllUsers();
	User getByEmail(String email);
}
