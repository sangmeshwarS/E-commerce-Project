package com.example.demo.Service_dao;



import java.util.List;

import com.example.demo.Model.CartModel;
import com.example.demo.Model.OrderModel;
import com.example.demo.Model.ProfileModel;

public interface OrderDao {
	
	List<OrderModel> save(int id, String email);

}
