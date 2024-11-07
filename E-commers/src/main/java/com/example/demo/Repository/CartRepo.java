package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.CartModel;


@Repository
public interface CartRepo extends JpaRepository<CartModel, Integer>{
	
	@Query("select u from CartModel u where u.uemail=:uemail")
	public List<CartModel> getByEmail(@Param("uemail")String email);
	
	@Query("select u from CartModel u where u.uemail=:uemail")
	public CartModel findByEmail(@Param("uemail")String email);
	
	@Query("select u from CartModel u where u.id=:id")
	public CartModel getById(@Param("id")int id);
	
	@Query("select sum(u.totalprice) from CartModel u where u.uemail=:uemail")
	public double getTotalPrice(@Param("uemail")String email);
	
	@Query("select sum(u.pActualprice * u.pquantity) from CartModel u where u.uemail=:uemail")
	public double getActualPrice(@Param("uemail")String email);

}
