//package com.miniproject.registration.registrationtest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Matchers;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.miniproject.registration.entity.User;
//
//import static org.junit.Assert.assertThat;
//import static org.mockito.Matchers.anyObject;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class RegistationMockUnitTest {
//
//	@Mock
//	private User userMock;
//
//	@InjectMocks
//	private UserService service;
//
//	@Test
//	public void registerNewUser() {
//		// arrange
//		User user = new User(0, "Eberhard", "Wolff", "eberhard.wolff@gmail.com", null);
//		// act
//		boolean registered = service.register(user);
//		// assert
//		assertThat(registered, is(true));
//		verify(jdbcTemplateMock).update(anyString(), eq(user.getFirstname()), eq(user.getName()), eq(user.getEmail()));
//	}
//
//	@Test
//	public void doNotRegisterExistingUser() {
//		// arrange
//		User user = new User("Eberhard", "Wolff", "eberhard.wolff@gmail.com");
//		List<User> users = new ArrayList<>();
//		users.add(user);
//		// simulating that user already exists
//		when(jdbcTemplateMock.query(anyString(), Matchers.any(RowMapper.class), eq(user.getEmail()))).thenReturn(users);
//		// act
//		boolean registered = service.register(user);
//		// assert
//		assertThat("should not register user with existing mail address", registered, is(false));
//	}
//}