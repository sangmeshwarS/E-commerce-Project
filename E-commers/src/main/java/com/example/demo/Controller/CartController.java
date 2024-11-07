package com.example.demo.Controller;

import java.security.Principal;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service_Impl.CartImpl;

@Controller
public class CartController {
	
	@Autowired
	private CartImpl cartImpl;
	
	@Autowired
	private CartRepo cartRepo;	
	
	@Autowired
	private UserRepo userRepo;
	
	@ModelAttribute
	public void userDetails(Principal principal, Model model) {
		if(principal!=null) {
			String email =	principal.getName();
			UserModel userModel =	userRepo.findUserByEmail(email);
			model.addAttribute("user", userModel);
			List<CartModel> cartModels =cartRepo.getByEmail(principal.getName());
			model.addAttribute("cList", cartModels);
		}
	}
	
	@RequestMapping("/cart")
	public String save(@RequestParam("pid")int pid, CartModel cartModel, Principal principal) {
		CartModel cartModel2 =	cartImpl.addtoCart(pid, cartModel, principal);
		if(cartModel2 != null) {
			return "redirect:/Cart";
		}else {
			return "index";
		}
	}
	
	@RequestMapping("/Cart")
	public String cart (Principal principal, Model m) {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		List<CartModel> cartModels =cartRepo.getByEmail(principal.getName());
		m.addAttribute("cList", cartModels);
		
		if(cartModels!=null) {			
		double totalPrice = cartImpl.getTotalPrice(principal.getName());
		m.addAttribute("totalPrice", currencyFormatter.format(totalPrice));
		double actualPrice = cartImpl.getActualPrice(principal.getName());
		m.addAttribute("actualPrice", currencyFormatter.format(actualPrice));
		double discount = actualPrice - totalPrice;
		m.addAttribute("discount", currencyFormatter.format(discount));
		}else {
			return "cart";
		}
		return null;
	}
	
	@RequestMapping("/quantityDecrease")
	public String quantityDecrease(@RequestParam("cid")int id) {
		CartModel cartModel = cartImpl.quantityDecrease(id);
		if(cartModel!=null) {
			return "redirect:/Cart";
		}else {
			return null;
		}
	}
	
	@RequestMapping("/quantityIncrease")
	public String quantityIncrease(@RequestParam("cid")int id) {
		CartModel cartModel = cartImpl.quantityIncrease(id);
		if(cartModel!=null) {
			return "redirect:/Cart";
		}else {
			return null;
		}
	}
	
	@RequestMapping("/deletecart")
	public String deleteCart(@RequestParam("cid")int id) {
		cartRepo.deleteById(id);
		System.out.println("Deleted Successfully!!!");
		return "redirect:/Cart";
	}
	

}
