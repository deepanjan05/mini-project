package com.miniproject.authentication.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import org.hibernate.PersistentObjectException;

import com.miniproject.authentication.contracts.IUserDAO;
import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.util.JPAUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDAO implements IUserDAO {

	private EntityManager entityManager;

	public UserDAO() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public boolean addUser(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException e) {
			log.info("User already registered! User email: " + user.getEmail());
			return false;
		} catch (PersistenceException e) {
			log.info("Persistent user object! User email: " + user.getEmail());
			return false;
		} catch (IllegalArgumentException e) {
			log.error("Invalid entity passed!");
			log.debug("Check the RegistrationController.class. Check User.class entity match the sql table");
			return false;
		}
		log.info("New user registered! User email: " + user.getEmail());
		return true;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			criteria.select(criteria.from(User.class)); 
			criteria.where(builder.equal(criteria.from(User.class).get("userId"), userId));
			
			user = entityManager.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			log.info("User does not exist for user-id: " + userId);
		} catch (IllegalStateException e) {
			log.error("Entity manager is closed!");
		} catch (IllegalArgumentException e) {
			log.error("Tried executing an invalid query!");
		}
		user.setPassword(null);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		try {
			entityManager.getTransaction().begin(); 
			entityManager.remove(entityManager.getReference(User.class, userId));
			entityManager.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			log.error("Error in User.class!");
			log.debug("Check User.class entity match the sql table");
			return false;
		}
		log.info("User deleted from database! User ID : " + Integer.toString(userId));
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Query query = entityManager
					.createQuery("Select u from User u where u.email = :email");
			query.setParameter("email", email);

			user = (User) query.getSingleResult();
			
			//user = entityManager.createQuery(criteria).getResultList().get(0);
		} catch (NoResultException e) {
			log.info("User does not exist. User email: " + email);
		} catch (NonUniqueResultException e) {
			log.info("User does not exist. User email: " + email);
		} catch (IllegalStateException e) {
			log.error("Entity manager is closed!");
		} catch (IllegalArgumentException e) {
			log.error("Tried executing an invalid query!");
		}
		
		return user;
	}

}
