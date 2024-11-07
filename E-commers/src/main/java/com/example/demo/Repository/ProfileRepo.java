package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.ProfileModel;

public interface ProfileRepo extends JpaRepository<ProfileModel, Integer>{
	
	@Query("select u from ProfileModel u where u.email=:email")
	public List<ProfileModel> getProfileByEmail(@Param("email")String email);
	
	@Query("select u from ProfileModel u where u.id=:id")
	public ProfileModel getProfileById(@Param("id")int id);
	
	@Modifying
	@Transactional
	@Query("update ProfileModel u set u.proName= :proName, u.proMobileNo= :proMobileNo, u.proLocality= :proLocality, u.proCity= :proCity, u.proState= :proState, u.proPincode= :proPincode where u.id= :id and u.email= :email")
	public int updateProfileById( @Param("proName")String name, @Param("proMobileNo")String number, @Param("proCity")String city, @Param("proLocality")String locality, @Param("proState")String state, @Param("proPincode")int pincode, @Param("id")int id, @Param("email")String email);

}
