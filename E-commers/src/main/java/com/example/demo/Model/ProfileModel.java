package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProfileModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Name")
	private String proName;
	
	@Column(name = "MobileNo")
	private String proMobileNo;
	
	@Column(name = "Locality")
	private String proLocality;
	
	@Column(name = "City")
	private String proCity;
	
	@Column(name = "State")
	private String proState;
	
	@Column(name = "Pincode")
	private int proPincode;
	
	private String email;
	public ProfileModel(String proName, String proMobileNo, String proLocality, String proCity, String proState,
			int proPincode, String email) {
		super();
		this.proName = proName;
		this.proMobileNo = proMobileNo;
		this.proLocality = proLocality;
		this.proCity = proCity;
		this.proState = proState;
		this.proPincode = proPincode;
		this.email = email;
	}
	public ProfileModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProMobileNo() {
		return proMobileNo;
	}
	public void setProMobileNo(String proMobileNo) {
		this.proMobileNo = proMobileNo;
	}
	public String getProLocality() {
		return proLocality;
	}
	public void setProLocality(String proLocality) {
		this.proLocality = proLocality;
	}
	public String getProCity() {
		return proCity;
	}
	public void setProCity(String proCity) {
		this.proCity = proCity;
	}
	public String getProState() {
		return proState;
	}
	public void setProState(String proState) {
		this.proState = proState;
	}
	public int getProPincode() {
		return proPincode;
	}
	public void setProPincode(int proPincode) {
		this.proPincode = proPincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ProfileModel [id=" + id + ", proName=" + proName + ", proMobileNo=" + proMobileNo + ", proLocality="
				+ proLocality + ", proCity=" + proCity + ", proState=" + proState + ", proPincode=" + proPincode
				+ ", email=" + email + "]";
	}

}
