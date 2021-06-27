/*
 * @Author: Praduman Pannu
 * @Email: praduman.pannu@publicissapient.com
 */

package com.miniproject.authentication.logintest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.miniproject.authentication.dao.UserDAO;
import com.miniproject.authentication.entity.User;
import com.miniproject.authentication.service.UserService;

public class LoginUnitTest {


	UserService us;
	UserDAO uDAO;
	User user;
	
	private static String EMAIL = "praduman.pannu@publicissapient.com";
	private static String PASSWORD = "password";
	private static Integer INVALID_UID = -1;
	
	@Before
	public void defineUser() {
		us = new UserService();
		uDAO = new UserDAO();
		user = new User();
		user.setName("praduman");
		user.setEmail(EMAIL);
		user.setPassword(PASSWORD);
		user.setGender("male");
		
		assertTrue(UserService.registerUser(user));
		user = uDAO.getByEmail(EMAIL);
		assertNotNull(user);
	}

	@After
	public void removeUser() {
		if (uDAO.getByEmail(user.getEmail())!=null) 
			us.unregisterUser(user.getEmail());
	}
	
	@Test
	public void successfulLogin() {
		assertNotEquals(INVALID_UID, UserService.loginUser(EMAIL, PASSWORD));
	}

	@Test
	public void incorrectEmail() {
		assertEquals(INVALID_UID, UserService.loginUser("prp@gmail.com", PASSWORD));
		
	}
	
	@Test
	public void invalidEmail() {
		assertEquals(INVALID_UID, UserService.loginUser("prp", PASSWORD));
	}
	
	@Test
	public void incorrectPassword() {
		assertEquals(INVALID_UID, UserService.loginUser(EMAIL, "secret"));
	}
	
	@Test
	public void incorrectCredentials() {
		assertEquals(INVALID_UID, UserService.loginUser("prp@gmail.com", "secret"));
	}

}
