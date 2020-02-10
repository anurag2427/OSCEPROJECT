package com.cap.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cap.model.Seller;

import com.cap.services.SellerService;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	/*
	 * @Autowired private UserService userService;
	 */
	
	@Autowired
	private SellerService sellerService;

	@GetMapping("/")
	public String hello() {
		return "This is Home page";
	}
	
	/*
	 * @GetMapping("/saveuser") public String saveUser(@RequestParam String
	 * username, @RequestParam String firstname, @RequestParam String
	 * lastname, @RequestParam int age, @RequestParam String
	 * password,HttpServletRequest request) { User user = new User(username,
	 * firstname, lastname, age, password); userService.saveMyUser(user); return
	 * "User Saved"; }
	 */
	
	/*
	 * @GetMapping("/saveseller") public String saveSeller(@RequestParam String
	 * username, @RequestParam String firstname, @RequestParam String
	 * lastname, @RequestParam int age, @RequestParam String password) { Seller
	 * seller = new Seller(username, firstname, lastname, age, password);
	 * sellerService.saveMyseller(seller); return "User Saved"; }
	 */
	
}
