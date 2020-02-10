package com.cap.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cap.model.Cart;
import com.cap.repository.CartRepository;

@Service
@Transactional
public class CartService {

	private CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	  public Cart saveitem(Cart cart) {
		  return cartRepository.save(cart);
	  }

	public List<Cart> listAll() {
		return (List<Cart>) cartRepository.findAll();
	}
	
	 public List<Object[]> getPrice() {
         return cartRepository.getPrice();

         }
	 
	public void deleteitem(int quantity) {
		 cartRepository.delete(quantity);
	}
//	
//	public List<Object[]> removecartitems() {
//		// TODO Auto-generated method stub
//		   return cartRepository.getquantity();
//		
//		
//	}

	
}
