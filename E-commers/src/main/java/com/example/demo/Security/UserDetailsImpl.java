package com.example.demo.Security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Model.UserModel;

public class UserDetailsImpl implements UserDetails{
	
	private UserModel userModel;
	
	public UserDetailsImpl(UserModel userModel) {
		super();
		this.userModel = userModel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority s = new SimpleGrantedAuthority(userModel.getRole());
		return List.of(s);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userModel.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userModel.getEmail();
	}

}
