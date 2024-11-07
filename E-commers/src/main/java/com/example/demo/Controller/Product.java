package com.example.demo.Controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.ProductModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service_Impl.productImpl;

@Controller
public class Product {
	
	@Autowired
	private productImpl productImpl;
	
	@Autowired
	private ProductRepo productRepo;
	
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
	
	@RequestMapping("/productProcess")
	public String saveProduct(@ModelAttribute ProductModel p, @RequestParam("productimage")MultipartFile pimage, Model m) {
		ProductModel productModel =	productImpl.save(p, pimage);
		if(productModel!=null) {
			m.addAttribute("product", productModel);
			System.out.println(productModel);
			return "redirect:index";
		}else {
		return "admin";
		}
	}
	
	@RequestMapping("/details")
	public String productDetails(@RequestParam("id")int id, Model model) {
		ProductModel op =	productRepo.getById(id);
		if(op != null) {
			model.addAttribute("pList", op);
			System.out.println(op);
			return "details";
		}else {
		return "index";
		}
	}

}
