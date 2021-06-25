package com.miniproject.registration.registrationtest;

import static org.junit.Assert.*;

import org.junit.*;

import com.miniproject.registration.controllers.RegistrationController;
import com.miniproject.registration.dao.UserDAO;
import com.miniproject.registration.entity.User;
import com.miniproject.registration.service.UserService;

public class RegistrationUnitTest {

	UserService us;
	UserDAO uDAO;
	User user;

	@Before
	public void defineUser() {
		us = new UserService();
		uDAO = new UserDAO();
		user = new User();
		user.setName("Deepanjan");
		user.setEmail("deepanjan052000@gmail.com");
		user.setPassword("password");
		user.setGender("male");
	}

	@After
	public void removeUser() {
		if (uDAO.getByEmail(user.getEmail())!=null) 
			us.unregisterUser(user.getEmail());
	}

	@Test
	public void simpleRegistration() {
		assertTrue(us.registerUser(user));
		user = uDAO.getByEmail("deepanjan052000@gmail.com");
		assertNotNull(user);
	}

	@Test
	public void avoidDoubleRegistrations() {
		assertTrue(us.registerUser(user));
		assertFalse(us.registerUser(user));
	}

	@Test(expected = IllegalArgumentException.class)
	public void avoidInvalidEMail() {
		user.setEmail("deepanjangmail.com");
		us.registerUser(user);
	}

	@Test
	public void userNotInitiallyRegistered() {
		assertNull(uDAO.getByEmail("eberhard.wolff@gmail.com"));
	}
}