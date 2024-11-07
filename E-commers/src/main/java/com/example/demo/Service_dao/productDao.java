package com.example.demo.Service_dao;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.ProductModel;

public interface productDao {
	
	public ProductModel save(ProductModel p, MultipartFile pimage);

}
