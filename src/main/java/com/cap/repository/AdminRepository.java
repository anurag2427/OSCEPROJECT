package com.cap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByUsernameAndPassword(String username, String password);

}
