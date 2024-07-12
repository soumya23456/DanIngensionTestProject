package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Feedbackdto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.")
	@Size(min = 2,max = 70, message = "Full Name must be 3-70 characters.")
	private String fullname;
	@NotBlank
	@Email
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
	message="Invalid email address.")
	private String email;
	@NotBlank
	private String subject;
	@NotBlank
	private String message;
	
	
	//CONSTRUCTOR WITHOUT FIELDS
	public Feedbackdto() {
		super();
	}
	
	
	//GETTERS AND SETTERS FOR ALL FIELDS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", fullname=" + fullname + ", email=" + email + ", subject=" + subject
				+ ", message=" + message +"]";
	}


	//CONSTRUCTOR WITH ALL FIELDS EXCEPT ID
	public Feedbackdto(
			@NotBlank @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullname,
			@NotBlank @Email @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") String email,
			@NotBlank String subject, @NotBlank String message) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}


	//CONSTRUCTOR WITH ALL FIELDS
	public Feedbackdto(Integer id,
			@NotBlank @Pattern(regexp = "^[a-zA-Z]([ .-](?![ .-])|[a-zA-Z ]){3,70}[a-zA-Z]$", message = "Must contain only letters.") @Size(min = 2, max = 70, message = "Full Name must be 3-70 characters.") String fullname,
			@NotBlank @Email @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") String email,
			@NotBlank String subject, @NotBlank String message) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}	
}