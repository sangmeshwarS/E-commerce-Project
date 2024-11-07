package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int pid;
	private String pname;
	private double pprice;
	private String formattedPprice;
	private double pActualprice;
	private double totalprice;
	private String  formattedTotalprice;
	private int pquantity;
	private String pimage;
	private String uemail;
	
	public CartModel(int pid, String pname, double pprice, double pActualprice, double totalprice, int pquantity, String pimage,
			String uemail) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pActualprice = pActualprice;
		this.totalprice = totalprice;
		this.pquantity = pquantity;
		this.pimage = pimage;
		this.uemail = uemail;
	}
	public CartModel() {
		super();
	}
	public String getFormattedPprice() {
		return formattedPprice;
	}
	public void setFormattedPprice(String formattedPprice) {
		this.formattedPprice = formattedPprice;
	}
	public String getFormattedTotalprice() {
		return formattedTotalprice;
	}
	public void setFormattedTotalprice(String formattedTotalprice) {
		this.formattedTotalprice = formattedTotalprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public double getpActualprice() {
		return pActualprice;
	}
	public void setpActualprice(double pActualprice) {
		this.pActualprice = pActualprice;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	@Override
	public String toString() {
		return "CartModel [id=" + id + ", pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", formattedPprice="
				+ formattedPprice + ", pActualprice=" + pActualprice + ", totalprice=" + totalprice
				+ ", formattedTotalprice=" + formattedTotalprice + ", pquantity=" + pquantity + ", pimage=" + pimage
				+ ", uemail=" + uemail + "]";
	}
	
	

}
