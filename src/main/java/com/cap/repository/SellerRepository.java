package com.cap.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.cap.model.Seller;


public interface SellerRepository extends JpaRepository<Seller, Integer>{
	
	public Seller findByUsernameAndPassword(String username, String password);

}
