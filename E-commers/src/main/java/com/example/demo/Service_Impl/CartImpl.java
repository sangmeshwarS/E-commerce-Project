package com.example.demo.Service_Impl;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.ProductModel;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service_dao.cartDao;

import jakarta.servlet.http.HttpSession;

@Service
public class CartImpl implements cartDao{
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

	@Override
	public CartModel addtoCart(int id, CartModel cartModel, Principal principal) {
		// TODO Auto-generated method stub
		ProductModel productModel =	productRepo.getById(id);
		double totalPrice = productModel.getPprice();
			
		cartModel = new CartModel(id,
					productModel.getPname(),
					productModel.getPprice(),
					productModel.getpActualPrice(),
					totalPrice,
					1,
					productModel.getPimage(),
					principal.getName());
		cartModel.setFormattedPprice(numberFormat.format(productModel.getPprice()));
		cartModel.setFormattedTotalprice(numberFormat.format(totalPrice));
		CartModel cartModel2 =	cartRepo.save(cartModel);
		if(cartModel2!=null) {
			System.out.println("Added to Cart Successfully!!!");
			return cartModel;
		}else {
			System.out.println("Not Added to Cart!!!");
			return null;
		}
		
	}

	@Override
	public CartModel quantityDecrease(int id) {
		// TODO Auto-generated method stub
		CartModel cartModel = cartRepo.getById(id);
		if(cartModel!=null) {
			int quantity =	cartModel.getPquantity();
			quantity = quantity - 1;
			cartModel.setPquantity(quantity);
			if(quantity < 1) {
				cartRepo.deleteById(id);
			}else {
			double price =	cartModel.getPprice();
			price = price * quantity;
			cartModel.setTotalprice(price);
			cartModel.setFormattedTotalprice(numberFormat.format(price));
			cartRepo.save(cartModel);
			}
			return cartModel;
		}else {
			return null;
		}
	}

	@Override
	public CartModel quantityIncrease(int id) {
		// TODO Auto-generated method stub
		CartModel cartModel = cartRepo.getById(id);
		if(cartModel!=null) {
			int quantity =	cartModel.getPquantity();
			quantity = quantity + 1;
			cartModel.setPquantity(quantity);
			double price =	cartModel.getPprice();
			price = price * quantity;
			cartModel.setTotalprice(price);
			cartModel.setFormattedTotalprice(numberFormat.format(price));
			cartRepo.save(cartModel);
			return cartModel;
		}else {
			return null;
		}
	}

	@Override
	public double getTotalPrice(String email) {
		// TODO Auto-generated method stub
		double totalPrice =	cartRepo.getTotalPrice(email);
		return totalPrice;
	}

	@Override
	public double getActualPrice(String email) {
		// TODO Auto-generated method stub
		double actualPrice = cartRepo.getActualPrice(email);
		return actualPrice;
	}
	
	

}
