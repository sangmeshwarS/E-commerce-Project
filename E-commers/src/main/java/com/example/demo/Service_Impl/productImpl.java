package com.example.demo.Service_Impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.ProductModel;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service_dao.productDao;

@Service
public class productImpl implements productDao{
	
	@Autowired
	private	ProductRepo productRepo;

	@Override
	public ProductModel save(ProductModel p,
			MultipartFile pimage) {
		// TODO Auto-generated method stub
		p = new ProductModel(p.getPname(), p.getPdesc(), p.getPquantity(), p.getpActualPrice(), p.getPprice(), p.getPdiscount(), pimage.getOriginalFilename());
		productRepo.save(p);
		System.out.println(p);
		try {
			File file2 = new ClassPathResource("static/img").getFile();
			Path path = Paths.get(file2.getAbsolutePath()+File.separator+pimage.getOriginalFilename());
			System.out.println(path);
			Files.copy(pimage.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
