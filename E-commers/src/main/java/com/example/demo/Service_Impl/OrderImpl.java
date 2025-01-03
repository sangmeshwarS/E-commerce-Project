package com.example.demo.Service_Impl;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.OrderModel;
import com.example.demo.Model.ProfileModel;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Repository.ProfileRepo;
import com.example.demo.Service_dao.OrderDao;

@Service
public class OrderImpl implements OrderDao{
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

	@Override
	public List<OrderModel> save(int id, String email) {
		// TODO Auto-generated method stub
		ProfileModel profileModel =	profileRepo.findById(id).get();
		List<CartModel> cartModel1 = cartRepo.getByEmail(email);
		List<OrderModel> orderModels = new ArrayList<>();
		for(CartModel cartModel: cartModel1) {
			
		OrderModel orderModel = new OrderModel("Processing", new Date(), cartModel.getTotalprice(), cartModel.getPname(), cartModel.getPimage(), cartModel.getPquantity(), profileModel.getProLocality(), profileModel.getProCity(), profileModel.getProState(), profileModel.getProPincode(), email);
		orderModel.setFormattedOprice(numberFormat.format(orderModel.getOprice()));
		OrderModel orderModel1 =	orderRepo.save(orderModel);
		orderModels.add(orderModel);
		
		if(orderModel1!=null) {
			cartRepo.deleteById(cartModel.getId());
			System.out.println("Elements Added Successfully");
		}else {
			System.out.println("No Products in Cart");
		}
		
		}
		return orderModels;
	}

}
