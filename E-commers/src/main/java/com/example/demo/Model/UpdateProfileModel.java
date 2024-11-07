package com.example.demo.Model;

public class UpdateProfileModel {
	
	private String u_proName;
	private String u_proMobileNo;
	private String u_proLocality;
	private String u_proCity;
	private String u_proState;
	private int u_proPincode;
	public UpdateProfileModel(String u_proName, String u_proMobileNo, String u_proLocality, String u_proCity,
			String u_proState, int u_proPincode) {
		super();
		this.u_proName = u_proName;
		this.u_proMobileNo = u_proMobileNo;
		this.u_proLocality = u_proLocality;
		this.u_proCity = u_proCity;
		this.u_proState = u_proState;
		this.u_proPincode = u_proPincode;
	}
	public UpdateProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getU_proName() {
		return u_proName;
	}
	public void setU_proName(String u_proName) {
		this.u_proName = u_proName;
	}
	public String getU_proMobileNo() {
		return u_proMobileNo;
	}
	public void setU_proMobileNo(String u_proMobileNo) {
		this.u_proMobileNo = u_proMobileNo;
	}
	public String getU_proLocality() {
		return u_proLocality;
	}
	public void setU_proLocality(String u_proLocality) {
		this.u_proLocality = u_proLocality;
	}
	public String getU_proCity() {
		return u_proCity;
	}
	public void setU_proCity(String u_proCity) {
		this.u_proCity = u_proCity;
	}
	public String getU_proState() {
		return u_proState;
	}
	public void setU_proState(String u_proState) {
		this.u_proState = u_proState;
	}
	public int getU_proPincode() {
		return u_proPincode;
	}
	public void setU_proPincode(int u_proPincode) {
		this.u_proPincode = u_proPincode;
	}
	@Override
	public String toString() {
		return "UpdateProfileModel [u_proName=" + u_proName + ", u_proMobileNo=" + u_proMobileNo + ", u_proLocality="
				+ u_proLocality + ", u_proCity=" + u_proCity + ", u_proState=" + u_proState + ", u_proPincode="
				+ u_proPincode + "]";
	}
	
	

}
