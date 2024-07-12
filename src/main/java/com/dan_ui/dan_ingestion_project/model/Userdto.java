package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Userdto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="Full Name cannot be empty.")
	@Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.")
	@Size(min = 2,max = 70, message = "Full Name must be 3-70 characters.")
	private String fullName;
	
	@NotBlank(message="Email cannot be empty.")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
	message="Invalid email address.")
	@Email
	private String email;
	
	@NotBlank(message="Phone number cannot be empty.")
	@Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.")
	@Size(min = 10, message = "Phone number cannot be less than 10 characters.")
	private String phoneNumber;
	
	@NotBlank(message="Password cannot be empty.")
	@Size(min = 8, message = "Password cannot be less than 8 characters.")
	private String password;

	@NotBlank(message = "Select user type.")
	@Pattern(regexp = "^([a-zA-Z]){2,20}$", message = "Invalid user type.")
	private String userType;
	
	@NotBlank(message = "Address cannot be empty.")
	private String address;
	
	@NotBlank(message = "Postal Code cannot be empty.")
	@Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)",message = "Invalid Postal Code.")
	private String postalCode;

	@NotBlank(message = "State cannot be empty.")
	@Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid State name.")
	private String region;
	
	@NotBlank(message = "Country cannot be empty.")
	@Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid Country name.")
	private String country;
		
	//CONSTRUCTOR WITHOUT FIELDS
	public Userdto() {
		super();
	}
	
	//TOSTRING() METHOD WITH ALL FIELDS EXCEPT ID
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber +
				", password=" + password
				+", userType=" + userType
				+ ", address=" + address + ", postalCode=" + postalCode + ", region=" + region + ", country="
				+ country+ "]";
	}
	
	//CONSTRUCTOR WITH FIELDS -- FULLNAME, EMAIL, PHONENUMBER, PASSWORD, USERTYPE, ADDRESS, POSTALCODE, REGION, COUNTRY
	public Userdto(
			@NotBlank(message = "Full Name cannot be empty.") @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullName,
			@NotBlank(message = "Email cannot be empty.") @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") @Email String email,
			@NotBlank(message = "Phone number cannot be empty.") @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.") @Size(min = 10, message = "Phone number cannot be less than 10 characters.") String phoneNumber,
			@NotBlank(message = "Password cannot be empty.") @Size(min = 8, message = "Password cannot be less than 8 characters.") String password,
			@NotBlank(message = "Select user type.") @Pattern(regexp = "^([a-zA-Z]){2,20}$", message = "Invalid user type.") String userType, @NotBlank(message = "Address cannot be empty.") String address,
			@NotBlank(message = "Postal Code cannot be empty.") @Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)", message = "Invalid Postal Code.") String postalCode,
			@NotBlank(message = "State cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid State name.") String region,
			@NotBlank(message = "Country cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid Country name.") String country) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.postalCode = postalCode;
		this.region = region;
		this.country = country;
	}

	//CONSTRUCTOR WITH ALL FIELDS
	public Userdto(Integer id,
			@NotBlank(message = "Full Name cannot be empty.") @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullName,
			@NotBlank(message = "Email cannot be empty.") @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") @Email String email,
			@NotBlank(message = "Phone number cannot be empty.") @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.") @Size(min = 10, message = "Phone number cannot be less than 10 characters.") String phoneNumber,
			@NotBlank(message = "Password cannot be empty.") @Size(min = 8, message = "Password cannot be less than 8 characters.") String password,
			@NotBlank(message = "Select user type.") @Pattern(regexp = "^([a-zA-Z]){2,20}$", message = "Invalid user type.") String userType, @NotBlank(message = "Address cannot be empty.") String address,
			@NotBlank(message = "Postal Code cannot be empty.") @Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)", message = "Invalid Postal Code.") String postalCode,
			@NotBlank(message = "State cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid State name.") String region,
			@NotBlank(message = "Country cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid Country name.") String country) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.postalCode = postalCode;
		this.region = region;
		this.country = country;
	}

	//GETTERS AND SETTERS FOR ALL FIELDS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
