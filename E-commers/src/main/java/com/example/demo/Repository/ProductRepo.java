package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Integer>{
	
	@Query("select u from ProductModel u where u.id= :id")
	public ProductModel getById(@PathVariable("id")int id);

}
