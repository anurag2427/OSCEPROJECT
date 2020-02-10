package com.cap.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cap.model.Cart;
import com.cap.model.Carthistory;
import com.cap.repository.CarthistoryRepository;


@Service
@Transactional
public class CarthistoryService {

	private CarthistoryRepository chrepo;
	
	public CarthistoryService(CarthistoryRepository chrepo)
	{
		this.chrepo=chrepo;
	}
	
	  public Carthistory saveitem(Carthistory ch) {
		  return chrepo.save(ch);
	  }
}
