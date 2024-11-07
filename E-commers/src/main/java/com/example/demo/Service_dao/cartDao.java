package com.example.demo.Service_dao;

import java.security.Principal;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.ProductModel;

public interface cartDao {
	
	public CartModel addtoCart(int id, CartModel cartModel,  Principal principal);
	
	public CartModel quantityDecrease(int id);
	
	public CartModel quantityIncrease(int id);
	
	public double getTotalPrice(String email);
	
	public double getActualPrice(String email);

}
