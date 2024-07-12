package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//CONTRACTOR TABLE MODEL - ID, NAME, PHONE, EMAIL, ADDRESS, POSTALZIP, REGION, COUNTRY, CREATEDAT, UPDATEDAT
@Entity
@Table(name = "CONTRACTOR")
public class Contractor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String name;

	@NotBlank
	private String phone;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String address;
	
	@NotBlank
	private String postalZip;
	
	@NotBlank
	private String region;

	@NotBlank
	private String country;
	
	@NotBlank
	private String createdAt;

	@NotBlank
	private String updatedAt;
	
	//CONSTRUCTOR WITHOUT FIELDS
	public Contractor() {
		super();
	}

	//GETTERS AND SETTERS FOR ALL FIELDS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalZip() {
		return postalZip;
	}

	public void setPostalZip(String postalZip) {
		this.postalZip = postalZip;
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

	
	//TOSTRING() METHOD WITH ALL FIELDS
	@Override
	public String toString() {
		return "Contractor [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", postalZip=" + postalZip + ", region=" + region + ", country=" + country + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public Contractor(Integer id, @NotBlank String name, @NotBlank String phone, @NotBlank @Email String email,
			@NotBlank String address, @NotBlank String postalZip, @NotBlank String region, @NotBlank String country,
			@NotBlank String createdAt, @NotBlank String updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.postalZip = postalZip;
		this.region = region;
		this.country = country;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Contractor(@NotBlank String name, @NotBlank String phone, @NotBlank @Email String email,
			@NotBlank String address, @NotBlank String postalZip, @NotBlank String region, @NotBlank String country,
			@NotBlank String createdAt, @NotBlank String updatedAt) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.postalZip = postalZip;
		this.region = region;
		this.country = country;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


}