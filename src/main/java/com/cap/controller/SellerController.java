package com.cap.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cap.model.Product;
import com.cap.model.Seller;
import com.cap.model.User;
import com.cap.services.ProductService;
import com.cap.services.SellerService;

@Controller
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
    @Autowired
    private ProductService service;
	
	@RequestMapping("/seller-welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOMESELLER");
		return "welcomepageseller";
	}

	@RequestMapping("/registerseller")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTERSELLER");
		return "welcomepageseller";
	}

	@PostMapping("/save-seller")
	public String registerUser(@ModelAttribute Seller seller, BindingResult bindingResult, HttpServletRequest request) {
		sellerService.saveMyseller(seller);
		request.setAttribute("mode", "MODE_HOMESELLER");
		return "welcomepageseller";
	}

	/*
	 * @GetMapping("/show-users") public String showAllUsers(HttpServletRequest
	 * request) { request.setAttribute("users", userService.showAllUsers());
	 * request.setAttribute("mode", "ALL_USERS"); return "welcomepage"; }
	 */
	
	/*
	 * @GetMapping("/show-sellers") public String showAllUserss(HttpServletRequest
	 * request) { request.setAttribute("sellers", sellerService.showAllsellers());
	 * request.setAttribute("mode", "ALL_SELLERS"); return "admin"; }
	 */

	@RequestMapping("/delete-seller")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {	
		sellerService.deleteMyseller(id);
		request.setAttribute("sellers", sellerService.showAllsellers());
		request.setAttribute("mode", "ALL_SELLERS");
		return "admin";
	}
	
	@RequestMapping("/edit-seller")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("sellers", sellerService.editseller(id));
		request.setAttribute("mode", "MODE_UPDATESELLERS");
		return "admin";
	}
	
	@RequestMapping("/loginseller")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGINSELLER");
		return "welcomepageseller";
	}
	
	@RequestMapping ("/login-seller")
	public String loginSeller(@ModelAttribute Seller seller, HttpServletRequest request) {
		if(sellerService.findByUsernameAndPassword(seller.getUsername(), seller.getPassword())!=null)
		{
			request.setAttribute("products", service.listAll());
			request.setAttribute("mode", "ALL_PRODUCTS");
			return "homepageseller";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGINSELLER");
			return "welcomepageseller";
		}
	}
	@RequestMapping("/login-seller/newproduct")
	public String showNewProductPage(HttpServletRequest request) {
	    request.setAttribute("mode", "NEW_PRODUCT");
	    return "createproduct";
	}
	
	@RequestMapping("/login-seller/newproduct/saveproduct")
	public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult,HttpServletRequest request)
	{
	    service.save(product);
	    // request.setAttribute("mode", "SAVE_PRODUCT");
	    request.setAttribute("products", service.listAll());
	     request.setAttribute("mode", "ALL_PRODUCTS");	
	    return "homepageseller";
	}
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
//	    ModelAndView mav = new ModelAndView("edit_product");
//	    Product product = service.get(id);
//	    mav.addObject("product", product);
//	     
//	    return mav;
//	}
	
	@RequestMapping("/login-seller/deleteproduct")
	public String deleteProduct(@RequestParam int id, HttpServletRequest request) {
	    service.delete(id);
	    request.setAttribute("products", service.listAll());
	    request.setAttribute("mode", "ALL_PRODUCTS");
	    return "homepageseller";       
	}

}
