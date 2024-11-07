package com.example.demo.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.ProductModel;
import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.UpdateProfileModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Repository.ProfileRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service_Impl.userImpl;

import jakarta.validation.Valid;

@Controller
public class User {
	
	@Autowired
	private userImpl userImpl;
	
	@Autowired
	private ProfileRepo profileRepo;
	
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
	
	@RequestMapping("/index")
	public String index(Model model) {
		List<ProductModel> list = productRepo.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("userModel", new UserModel());
		
		return "register";
	}
	
	@RequestMapping("/registerProcess")
	public String processR(@Valid @ModelAttribute UserModel userModel, BindingResult bindingResult, Model m) {
		
		if(bindingResult.hasErrors()) {
			return "register";
		}else {
			UserModel userModel1 =	userImpl.saveUser(userModel);
			if(userModel1==null) {
				System.out.println("Registered Unsuccessfully");
			}
			else {
				System.out.println("Registered Successfully");
			}
		return "redirect:index";
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String admin(Model m) {
		List<ProductModel> productModels =	productRepo.findAll();
		m.addAttribute("products", productModels);
		
		List<UserModel> userModels = userRepo.findAll();
		m.addAttribute("users", userModels);
		return "admin";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model, Principal principal) {
		List<ProfileModel> profileModels =	profileRepo.getProfileByEmail(principal.getName());
		model.addAttribute("profileList", profileModels);
		return "profile";
	}
	
	@RequestMapping("/profile1")
	public String profileForm(@RequestParam("p")String p, Principal principal, Model model) {
		List<ProfileModel> profileModels =	profileRepo.getProfileByEmail(principal.getName());
		model.addAttribute("profileList", profileModels);
		model.addAttribute("p1234", p);
		System.out.println(p);
		return "profile";
	}
	
	@RequestMapping("/profileProcess")
	public String profileProcess(ProfileModel profileModel, Principal principal, Model model) {
		profileModel.setEmail(principal.getName());
		ProfileModel profileModel2 = profileRepo.save(profileModel);
		if(profileModel2!=null) {
			return "redirect:/profile";
		}else {
			return null;
		}
	}
	
	@RequestMapping("/updateprofile")
	public String updateProfile(@RequestParam("id")int id, Model model) {
		ProfileModel profileModel =	profileRepo.getProfileById(id);
		model.addAttribute("UpdateProfile", profileModel);
		return "updateProfile";
	}
	
	@RequestMapping("/updateprofileProcess")
	public String updateprofileProcess(@RequestParam("id")int id, UpdateProfileModel updateProfileModel) {
		ProfileModel profileModel =	userImpl.updateUser(id, updateProfileModel);
		if(profileModel!=null) {
			System.out.println("Updated Successfully!!!");
			return "redirect:/profile";
		}	
		return null;
	}
	
	@RequestMapping("/deleteprofile")
	public String deleteprofile(@RequestParam("id")int id){
		profileRepo.deleteById(id);
		return "redirect:/profile";
	}

}
