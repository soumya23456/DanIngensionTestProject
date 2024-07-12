package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usersdto {
	
	@Id
	private Integer userid;
	
	private String fullname;
	
	private String email;
	
	private String phonenumber;
	
	private String usertype;
	
	private String address;
	
	private String postalcode;

	private String region;
	
	private String country;
	
	private String createdAt;
	
	private String isActivated;
		
	public Usersdto() {
		super();
	}

	public Usersdto(Integer userid, String fullname, String email, String phonenumber, String usertype, String address,
			String postalcode, String region, String country, String createdAt, String isActivated) {
		super();
		this.userid = userid;
		this.fullname = fullname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.usertype = usertype;
		this.address = address;
		this.postalcode = postalcode;
		this.region = region;
		this.country = country;
		this.createdAt = createdAt;
		this.isActivated = isActivated;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(String isActivated) {
		this.isActivated = isActivated;
	}
	
	
}