package com.dan_ui.dan_ingestion_project.entity;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dan_ui.dan_ingestion_project.model.UserType;


//USER TABLE MODEL
@Entity
@Table(name = "DAN_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer id;
	
	@NotBlank(message="Full Name cannot be empty.")
	@Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.")
	@Size(min = 2,max = 70, message = "Full Name must be 3-70 characters.")
	@Column(name = "fullname")
	private String fullName;
	
	@NotBlank(message="Email cannot be empty.")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
	message="Invalid email address.")
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank(message="Phone number cannot be empty.")
	@Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.")
	@Size(min = 10, message = "Phone number cannot be less than 10 characters.")
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@NotBlank(message="Password cannot be empty.")
	@Size(min = 8, message = "Password cannot be less than 8 characters.")
	@Column(name = "userpassword")
	private String password;
	
	  @ManyToMany(fetch = FetchType.EAGER)
	  
	  @JoinTable( name = "USERROLES", joinColumns = @JoinColumn(name =
	  "user_id", referencedColumnName = "userid"), inverseJoinColumns
	  = @JoinColumn(name = "type_id", referencedColumnName = "typeId") )
	  private Collection<UserType> userType;
	
	@NotBlank(message = "Address cannot be empty.")
	@Column(name = "address")
	private String address;
	
	@NotBlank(message = "Postal Code cannot be empty.")
	@Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)",message = "Invalid Postal Code.")
	@Column(name = "postalcode")
	private String postalCode;

	@NotBlank(message = "State cannot be empty.")
	@Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid State name.")
	@Column(name = "region")
	private String region;
	
	@NotBlank(message = "Country cannot be empty.")
	@Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid Country name.")
	@Column(name = "country")
	private String country;
	
	@Column(name = "isActivated")
	private boolean isActivated;
	
	@NotBlank
	@Column(name = "createdAt")
	private String createdAt;
	
	@NotBlank
	@Column(name = "updatedAt")
	private String updatedAt;
	
	//CONSTRUCTOR WITHOUT FIELDS
	public User() {
		super();
	}
	
	//TOSTRING() METHOD WITH ALL FIELDS EXCEPT ID
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber +
				", password=" + password
				+", userType=" + userType
				+ ", address=" + address + ", postalCode=" + postalCode + ", region=" + region + ", country="
				+ country + ", isActivated=" + isActivated + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	//CONSTRUCTOR WITH FIELDS -- FULLNAME, EMAIL, PHONENUMBER, PASSWORD, USERTYPE, ADDRESS, POSTALCODE, REGION, COUNTRY
	public User(
			@NotBlank(message = "Full Name cannot be empty.") @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullName,
			@NotBlank(message = "Email cannot be empty.") @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") @Email String email,
			@NotBlank(message = "Phone number cannot be empty.") @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.") @Size(min = 10, message = "Phone number cannot be less than 10 characters.") String phoneNumber,
			@NotBlank(message = "Password cannot be empty.")   @Size(min = 8, message = "Password cannot be less than 8 characters.") String password,
			Collection<UserType> userType, @NotBlank(message = "Address cannot be empty.") String address,
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
	public User(Integer id,
			@NotBlank(message = "Full Name cannot be empty.") @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullName,
			@NotBlank(message = "Email cannot be empty.") @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") @Email String email,
			@NotBlank(message = "Phone number cannot be empty.") @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.") @Size(min = 10, message = "Phone number cannot be less than 10 characters.") String phoneNumber,
			@NotBlank(message = "Password cannot be empty.")   @Size(min = 8, message = "Password cannot be less than 8 characters.") String password,
			Collection<UserType> userType, @NotBlank(message = "Address cannot be empty.") String address,
			@NotBlank(message = "Postal Code cannot be empty.") @Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)", message = "Invalid Postal Code.") String postalCode,
			@NotBlank(message = "State cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid State name.") String region,
			@NotBlank(message = "Country cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid Country name.") String country,
			boolean isActivated, @NotBlank String createdAt, @NotBlank String updatedAt) {
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
		this.isActivated = isActivated;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//CONSTRUCTOR WITH ALL FIELDS EXCEPT ID
	public User(
			@NotBlank(message = "Full Name cannot be empty.") @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullName,
			@NotBlank(message = "Email cannot be empty.") @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") @Email String email,
			@NotBlank(message = "Phone number cannot be empty.") @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Must contain only numbers.") @Size(min = 10, message = "Phone number cannot be less than 10 characters.") String phoneNumber,
			@NotBlank(message = "Password cannot be empty.")   @Size(min = 8, message = "Password cannot be less than 8 characters.") String password,
			Collection<UserType> userType, @NotBlank(message = "Address cannot be empty.") String address,
			@NotBlank(message = "Postal Code cannot be empty.") @Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)", message = "Invalid Postal Code.") String postalCode,
			@NotBlank(message = "State cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid State name.") String region,
			@NotBlank(message = "Country cannot be empty.") @Pattern(regexp = "^([a-zA-Z ]){2,20}$", message = "Invalid Country name.") String country,
			boolean isActivated, @NotBlank String createdAt, @NotBlank String updatedAt) {
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
		this.isActivated = isActivated;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
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

	public Collection<UserType> getUserType() {
		return userType;
	}

	public void setUserType(Collection<UserType> userType) {
		this.userType = userType;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public boolean hasUserType(String userTypeName){
		Iterator<UserType> iterator = userType.iterator();
		while(iterator.hasNext()){
		UserType type = iterator.next();
		if(type.getTypeName().equals(userTypeName)){
			return true;
		}
		}
		return false;
		}
}
