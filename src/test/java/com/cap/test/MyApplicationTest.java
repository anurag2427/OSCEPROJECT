package com.cap.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cap.model.User;
import com.cap.repository.UserRepository;
import com.cap.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class MyApplicationTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	public void showUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User("sid", "Siddhant", "Shekhar", 23, "Qwerty"),
				new User("anu", "Anurag", "Tiwari", 24, "Jaya@0901")).collect(Collectors.toList()));
		assertEquals(2, userService.showAllUsers().size());
	}

	
	 @SuppressWarnings("unchecked")
	 
	 @Test public void getbyunameandpwd() 
	 {
		 String username="sid";
		 String password="Qwerty"; 
		 when(userRepository.findByUsernameAndPassword(username,password)).thenReturn((User) Stream.of(new User("sid","Siddhant","Shekhar",23, "Qwerty")).collect(Collectors.toList()));
	 assertEquals(1, ((List<User>) userService.findByUsernameAndPassword(username,password)).size()); 
	 }
	 

	@Test
	public void saveUserTest() {
		User user = new User("satya", "satyam", "Singh", 34, "Ramya");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.saveMyUser(user));
	}
}
