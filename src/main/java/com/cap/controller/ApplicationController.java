package com.cap.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cap.exception.InvalidInputException;
import com.cap.model.Admin;
//import com.cap.model.Product;
import com.cap.model.User;
import com.cap.services.AdminService;
import com.cap.services.ProductService;
import com.cap.services.SellerService;
import com.cap.services.UserService;

@Controller
public class ApplicationController {

	Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	UserService userService;

	@Autowired
	SellerService sellerService;

	@Autowired
	AdminService adminService;

	@Autowired
	ProductService service;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	/*
	 * @GetMapping("/show-users") public String showAllUsers(HttpServletRequest
	 * request) { request.setAttribute("users", userService.showAllUsers());
	 * request.setAttribute("mode", "ALL_USERS"); return "welcomepage"; }
	 */

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "admin";
	}

	/*
	 * @RequestMapping("/edit-user") public String editUser(@RequestParam int
	 * id,HttpServletRequest request) { request.setAttribute("user",
	 * userService.editUser(id)); request.setAttribute("mode", "MODE_UPDATE");
	 * return "admin"; }
	 */

	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws InvalidInputException {
		request.setAttribute("mode", "MODE_LOGIN");
		return "login";
	}

	@RequestMapping(value = { "login-user" })
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if (userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			logger.trace("Home Page Accessed");
//			request.setAttribute("users", userService.findName(username));
//			request.setAttribute("mode", "USER");
			request.setAttribute("products", service.listAll());
			request.setAttribute("mode", "ALL_PRODUCTS");
			return "homepage";
		} else {
			logger.error("Error Occoured");
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";

		}
	}

	@RequestMapping("/loginadmin")
	public String loginadmin(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGINADMIN");
		return "adminlogin";
	}

	@RequestMapping("/login-admin")
	public String loginadminn(@ModelAttribute Admin admin, HttpServletRequest request) {
		if (adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword()) != null) {
			request.setAttribute("sellers", sellerService.showAllsellers());
			request.setAttribute("mode", "ALL_SELLERS");
			return "admin";
		} else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGINADMIN");
			return "adminlogin";
		}
	}

	@RequestMapping("/showbuyer")
	public String showbuyers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "showbuyer";
	}

	/*
	 * @GetMapping("/show-users") public String showAllUserss(HttpServletRequest
	 * request) { request.setAttribute("users", userService.showAllUsers());
	 * request.setAttribute("mode", "ALL_USERS"); return "admin"; }
	 */

}
