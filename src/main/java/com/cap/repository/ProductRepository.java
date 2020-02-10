package com.cap.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.model.Product;
 
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findOne(long id);

	void delete(long id);
	
}
 