package com.miniproject.registration.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.miniproject.registration.contracts.IUserDAO;
import com.miniproject.registration.entity.User;
import com.miniproject.registration.util.JPAUtil;

public class UserDAO implements IUserDAO {
	
	private EntityManager entityManager;
	public UserDAO() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public boolean insertUser(User user) {
		entityManager.getTransaction().begin(); 
		entityManager.persist(user);
		entityManager.getTransaction().commit(); 
		return false;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
