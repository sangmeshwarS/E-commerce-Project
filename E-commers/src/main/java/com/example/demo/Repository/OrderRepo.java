package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.OrderModel;

public interface OrderRepo extends JpaRepository<OrderModel, Integer>{
	
	public List<OrderModel> findByUemail(String uemail);

}
