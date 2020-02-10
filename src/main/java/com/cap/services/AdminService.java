package com.cap.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cap.model.Admin;
import com.cap.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

	private  final AdminRepository adminRepository;
	
	 public AdminService(AdminRepository adminRepository) {
		// TODO Auto-generated constructor stub
		this.adminRepository=adminRepository;
	}
	 
	 public Admin findByUsernameAndPassword(String username, String password) {
			return adminRepository.findByUsernameAndPassword(username, password);
		}
}
