package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pname;
	private String pdesc;
	private int pquantity;
	private double pActualPrice;
	private String formattedpActualPrice;
	private double pprice;
	private String formattedpPrice;
	private int pdiscount;
	private String pimage;
	
	public String getFormattedpActualPrice() {
		return formattedpActualPrice;
	}
	public void setFormattedpActualPrice(String formattedpActualPrice) {
		this.formattedpActualPrice = formattedpActualPrice;
	}
	public String getFormattedpPrice() {
		return formattedpPrice;
	}
	public void setFormattedpPrice(String formattedpPrice) {
		this.formattedpPrice = formattedpPrice;
	}
	public void setpActualPrice(double pActualPrice) {
		this.pActualPrice = pActualPrice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public ProductModel(String pname, String pdesc, int pquantity, double pActualPrice, double pprice, int pdiscount,
			String pimage) {
		super();
		this.pname = pname;
		this.pdesc = pdesc;
		this.pquantity = pquantity;
		this.pActualPrice = pActualPrice;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pimage = pimage;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public double getpActualPrice() {
		return pActualPrice;
	}
	public double getPprice() {
		return pprice;
	}
	public int getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", pname=" + pname + ", pdesc=" + pdesc + ", pquantity=" + pquantity
				+ ", pActualPrice=" + pActualPrice + ", pprice=" + pprice + ", pdiscount=" + pdiscount + ", pimage="
				+ pimage + "]";
	}
	
	

}
