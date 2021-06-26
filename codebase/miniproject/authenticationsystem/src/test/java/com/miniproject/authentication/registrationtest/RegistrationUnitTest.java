package com.miniproject.authentication.registrationtest;

import static org.junit.Assert.*;

import org.junit.*;

import com.miniproject.authentication.dao.UserDAO;
import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.service.UserService;

public class RegistrationUnitTest {
	UserDAO uDAO;
	User user;

	@Before
	public void defineUser() {
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
			UserService.unregisterUser(user.getEmail());
	}

	@Test
	public void simpleRegistration() {
		assertTrue(UserService.registerUser(user));
		user = uDAO.getByEmail("deepanjan052000@gmail.com");
		assertNotNull(user);
	}
	
	@Test
	public void multipleRegistration() {
		assertTrue(UserService.registerUser(user));
		user = uDAO.getByEmail("deepanjan052000@gmail.com");
		assertNotNull(user);
		UserService.unregisterUser(user.getEmail());
		
		user = new User();
		user.setName("Deepanjan Datta");
		user.setEmail("deepanjan052@gmail.com");
		user.setPassword("password");
		user.setGender("male");
		
		assertTrue(UserService.registerUser(user));
		user = uDAO.getByEmail("deepanjan052@gmail.com");
		assertNotNull(user);
	}

	@Test
	public void avoidDoubleRegistrations() {
		assertTrue(UserService.registerUser(user));
		assertFalse(UserService.registerUser(user));
	}

	@Test(expected = IllegalArgumentException.class)
	public void avoidInvalidEMail() {
		user.setEmail("deepanjangmail.com");
		UserService.registerUser(user);
	}

	@Test(expected = IllegalArgumentException.class)
	public void avoidEmptyPassword() {
		user.setPassword("");
		UserService.registerUser(user);
	}
	
	@Test
	public void userNotInitiallyRegistered() {
		assertNull(uDAO.getByEmail("eberhard.wolff@gmail.com"));
	}
}