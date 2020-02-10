package com.cap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {	
	
	public User findByUsernameAndPassword(String username, String password);

	/* public User findByUserName(String username); */
	
	public User findByusername(String username);
	
//	@Query(value="select u.firstname from auth_user u where u.username=username ")
//	public User getName(String username);
}
