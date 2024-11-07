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
	private int pActualPrice;
	private int pprice;
	private int pdiscount;
	private String pimage;
	public ProductModel(String pname, String pdesc, int pquantity, int pActualPrice, int pprice, int pdiscount,
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
	public int getpActualPrice() {
		return pActualPrice;
	}
	public void setpActualPrice(int pActualPrice) {
		this.pActualPrice = pActualPrice;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
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
