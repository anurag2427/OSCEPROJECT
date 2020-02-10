package com.cap.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cap.model.Cart;
import com.cap.model.Carthistory;
import com.cap.services.CartService;
import com.cap.services.CarthistoryService;
import com.cap.services.ProductService;
import com.cap.services.SellerService;
import com.cap.services.UserService;

@Controller
public class CartController {
	
	@Autowired
	 CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	CarthistoryService chservice;
	
	@RequestMapping("/login-user/cartitems/savetocart")
	public String additems(@ModelAttribute Cart cart,@ModelAttribute Carthistory ch,HttpServletRequest request)
	{
		cartService.saveitem(cart);
	//	chservice.saveitem(ch);
		request.setAttribute("mode", "ALL_ITEMS");
		request.setAttribute("items", cartService.listAll());
		return "cart";
	}
	
	@RequestMapping("/login-user/cartitems")
	public String additems(@ModelAttribute Cart cart,@RequestParam Long id, HttpServletRequest request)
	{
		request.setAttribute("product",productService.get(id));
		request.setAttribute("mode","MODE_PREVIEW");
		return "itempreview";
	}
	
	@RequestMapping("/login-user/viewcart")
	public String viewcart(@ModelAttribute Cart cart, HttpServletRequest request)
	{
		request.setAttribute("mode", "ALL_ITEMS");
		request.setAttribute("items", cartService.listAll());
		return "cart";
		
	}
	@RequestMapping("/login-user/buyitems")
	public String sumofprice(@ModelAttribute Cart cart, HttpServletRequest request)
	{
//		request.setAttribute("mode","ALL_PRICE");
//		request.setAttribute("items", cartService.listAll());
		cartService.getPrice();
		List<Object[]> pricelist=cartService.getPrice();
		request.setAttribute("mode", "ALL_ITEMS");
		request.setAttribute("items", cartService.listAll());
		request.setAttribute("price", pricelist);
		return "sumprice";
	}
	
	@RequestMapping("/deleteitemfromcart")
	public String deleteitem(@RequestParam int quantity, HttpServletRequest request)
	{
		cartService.deleteitem(quantity);
		request.setAttribute("items", cartService.listAll());
		request.setAttribute("mode", "ALL_ITEMS");
		return "cart";
	}
	
	@RequestMapping("/deleteall")
	public String deleteall(@ModelAttribute Cart cart,@RequestParam int quantity, HttpServletRequest request)
	{
		cartService.deleteitem(quantity);
		request.setAttribute("mode", "MODE_THANKYOU");
		return "thankyou";
	}
	@RequestMapping("/gotohome")
	public String deleteall(HttpServletRequest request)
	{
		request.setAttribute("products", productService.listAll());
		request.setAttribute("mode", "ALL_PRODUCTS");
		return "homepage";
	}
}
