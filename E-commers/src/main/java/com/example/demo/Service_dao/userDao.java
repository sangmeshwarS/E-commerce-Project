package com.example.demo.Service_dao;

import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.UpdateProfileModel;
import com.example.demo.Model.UserModel;

public interface userDao {
	
	public UserModel saveUser(UserModel userModel);
	public ProfileModel updateUser(int id, UpdateProfileModel updateProfileModel);

}
