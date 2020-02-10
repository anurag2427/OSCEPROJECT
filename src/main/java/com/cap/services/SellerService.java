package com.cap.services;

import java.util.ArrayList; 
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cap.model.Seller;
import com.cap.repository.SellerRepository;

@Service
@Transactional
public class SellerService {
	
	private final SellerRepository sellerRepository;
	public SellerService(SellerRepository sellerRepository) {
		this.sellerRepository=sellerRepository;
	}
	
	public void saveMyseller(Seller seller ) {
		sellerRepository.save(seller);
	}
	
	public List<Seller> showAllsellers(){
		List<Seller> sellers = new ArrayList<Seller>();
		for(Seller seller : sellerRepository.findAll()) {
			sellers.add(seller);
		}
		
		return sellers;
	}
	
	public void deleteMyseller(int id) {
		sellerRepository.delete(id);
	}
	
	public Seller editseller(int id) {
		return sellerRepository.findOne(id);
	}
	
	public Seller findByUsernameAndPassword(String username, String password) {
		return sellerRepository.findByUsernameAndPassword(username, password);
	}

}
