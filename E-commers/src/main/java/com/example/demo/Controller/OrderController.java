package com.example.demo.Controller;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.OrderModel;
import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Repository.ProfileRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service_Impl.CartImpl;
import com.example.demo.Service_Impl.OrderImpl;

@Controller
public class OrderController {
	
	@Autowired
	private CartImpl cartImpl;
	
	@Autowired
	private OrderImpl orderImpl;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
	
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
	
	@RequestMapping("/checkout")
	public String checkout() {
		return "redirect:/Checkout";
	}
	
	@RequestMapping("/Checkout")
	public String checkout(Principal principal, Model m) {
		
		List<CartModel> cartModels =cartRepo.getByEmail(principal.getName());
		m.addAttribute("cList", cartModels);
		
		if(cartModels!=null) {
		List<ProfileModel> profileModels =	profileRepo.getProfileByEmail(principal.getName());
		m.addAttribute("profileModels", profileModels);
		double totalPrice = cartImpl.getTotalPrice(principal.getName());
		m.addAttribute("totalPrice", currencyFormatter.format(totalPrice));
		double actualPrice = cartImpl.getActualPrice(principal.getName());
		m.addAttribute("actualPrice", currencyFormatter.format(actualPrice));
		double discount = actualPrice - totalPrice;
		m.addAttribute("discount", currencyFormatter.format(discount));
		return "checkout";
		}else {
			return null;
		}
	}
	
	@RequestMapping("/userAddress")
	public String userAddress(@RequestParam("exampleRadios")int selected, Principal principal) {	
		List<OrderModel> orderModel =	orderImpl.save(selected, principal.getName());
		if(!orderModel.isEmpty()) {
			return "redirect:/orderPlaced";
		}else {
			System.out.println("Hello");
			return null;
		}
	}
	
	@RequestMapping("/orderPlaced")
	public String orderPlaced() {		
		return "orderPlaced";
	}
	
	@RequestMapping("/orderList")
	public String orderList(Principal principal, Model model) {		
		List<OrderModel> orderModels =	orderRepo.findByUemail(principal.getName());
		model.addAttribute("oList", orderModels);
		return "MyOrders";
	}
	
	@RequestMapping("/checkout1")
	public String checkoutOne(@RequestParam("pid")int id) {
		
		return "redirect:/Checkout";
	}

}
