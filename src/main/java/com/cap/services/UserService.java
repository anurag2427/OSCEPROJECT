package com.cap.services;

 
import java.util.List; 


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cap.model.User;
import com.cap.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public User saveMyUser(User user ) {
		return userRepository.save(user);
	}
	
	/*
	 * public List<User> showAllUsers(){ List<User> users = new ArrayList<User>();
	 * for(User user : userRepository.findAll()) { users.add(user); }
	 * 
	 * return users; }
	 */
	public List<User> showAllUsers(){
		List<User> users = userRepository.findAll();
		System.out.println("Getting Data from Database:"+ users);
		return users;
	}
	
	public void deleteMyUser(int id) {
		  userRepository.delete(id);
	}
	public User findSpecific(String username)
	{
		return userRepository.findByusername(username);
	}
	
	public User editUser(int id) {
		return userRepository.findOne(id);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public Object findAll(String username, String firstname, String lastname, int age, String password) {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
//	public User findName(String username )
//	{
//		return userRepository.getName(username);
//	}
	
	/*
	 * // public User findbyUsername(String username) { // return
	 * userRepository.findByUserName(username); // } //
	 */	
	}

	