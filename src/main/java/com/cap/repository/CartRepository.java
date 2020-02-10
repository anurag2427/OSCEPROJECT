package com.cap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cap.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	
//	public Cart savedata(int id,String name, String brand, String madein, int price);
//	 public Cart deletebymodelname(String modelname);
	@Query(value="select SUM(p.price * p.quantity) from Cart p")
	 public  List<Object[]> getPrice();
	 
	 @Query(value="select p.quantity from Cart p")
	 public List<Object[]> getquantity();

//	 @Query(value="delete from Cart p where p.quantity > 0")
//	public void deleteAll();
	 
	/*
	 * @Query(value="delete from Cart p where p.quantity > 0") public void
	 * deleteitems();
	 */
	
}
