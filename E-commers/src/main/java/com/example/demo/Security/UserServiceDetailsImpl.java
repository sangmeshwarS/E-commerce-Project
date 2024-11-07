package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepo;

public class UserServiceDetailsImpl implements UserDetailsService{
	
	@Autowired
	private	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel userModel =userRepo.findUserByEmail(username);
		if(userModel == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(userModel);
		return userDetailsImpl;
	}

}
