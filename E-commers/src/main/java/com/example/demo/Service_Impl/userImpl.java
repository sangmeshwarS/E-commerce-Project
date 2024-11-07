package com.example.demo.Service_Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.UpdateProfileModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.ProfileRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service_dao.userDao;

@Service
public class userImpl implements userDao{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserModel saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userModel.setRole("ROLE_USER");
		UserModel userModel2=	userRepo.save(userModel);
		
		return userModel2;
	}

	@Override
	public ProfileModel updateUser(int id ,UpdateProfileModel updateProfileModel) {
		// TODO Auto-generated method stub
		ProfileModel profileModel =	profileRepo.getProfileById(id);
		if(profileModel!=null) {
			profileModel.setProName(updateProfileModel.getU_proName());
			profileModel.setProMobileNo(updateProfileModel.getU_proMobileNo());
			profileModel.setProLocality(updateProfileModel.getU_proLocality());
			profileModel.setProCity(updateProfileModel.getU_proCity());
			profileModel.setProState(updateProfileModel.getU_proState());
			profileModel.setProPincode(updateProfileModel.getU_proPincode());
			profileRepo.save(profileModel);
		return profileModel;
		}
		return null;
	}

}
