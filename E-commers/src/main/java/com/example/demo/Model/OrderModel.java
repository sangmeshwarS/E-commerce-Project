package com.example.demo.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String oStatus;
	private Date odate;
	private double oprice;
	private String formattedOprice;
	private String pname;
	private String pimage;
	private int pquantity;
	private String ulocation;
	private String ucity;
	private String ustate;
	private int pincode;
	private String uemail;
	public OrderModel(String oStatus, Date odate, double oprice, String pname, String pimage, int pquantity,
			String uemail) {
		super();
		this.oStatus = oStatus;
		this.odate = odate;
		this.oprice = oprice;
		this.pname = pname;
		this.pimage = pimage;
		this.pquantity = pquantity;
		this.uemail = uemail;
	}
	public OrderModel(String oStatus, Date odate, double oprice, String pname, String pimage, int pquantity,
			String ulocation, String ucity, String ustate, int pincode, String uemail) {
		super();
		this.oStatus = oStatus;
		this.odate = odate;
		this.oprice = oprice;
		this.pname = pname;
		this.pimage = pimage;
		this.pquantity = pquantity;
		this.ulocation = ulocation;
		this.ucity = ucity;
		this.ustate = ustate;
		this.pincode = pincode;
		this.uemail = uemail;
	}
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getFormattedOprice() {
		return formattedOprice;
	}
	public void setFormattedOprice(String formattedOprice) {
		this.formattedOprice = formattedOprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getoStatus() {
		return oStatus;
	}
	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public double getOprice() {
		return oprice;
	}
	public void setOprice(double oprice) {
		this.oprice = oprice;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public String getUlocation() {
		return ulocation;
	}
	public void setUlocation(String ulocation) {
		this.ulocation = ulocation;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public String getUstate() {
		return ustate;
	}
	public void setUstate(String ustate) {
		this.ustate = ustate;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", oStatus=" + oStatus + ", odate=" + odate + ", oprice=" + oprice + ", pname="
				+ pname + ", pimage=" + pimage + ", pquantity=" + pquantity + ", ulocation=" + ulocation + ", ucity="
				+ ucity + ", ustate=" + ustate + ", pincode=" + pincode + ", uemail=" + uemail + "]";
	}
	
	
	
	
}
