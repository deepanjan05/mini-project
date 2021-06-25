package com.miniproject.registration.contracts;

import java.util.List;

import com.miniproject.registration.entity.User;

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
