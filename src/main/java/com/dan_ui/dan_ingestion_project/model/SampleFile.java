package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//FILE TABLE MODEL -- ID, FILENAME, USERNAME, USERTYPE, FILETYPE, FILESIZE, CREATEDAT
@Entity
@Table(name = "FILE")
public class SampleFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String fileName;
	@NotBlank
	private String userName;
	@NotBlank
	private String userType;
	@NotBlank
	private String fileType;
	@NotBlank
	private String createdAt;
	@NotNull
	private float fileSize;
	
	
	//CONSTRUCTOR WITHOUT FIELDS
	public SampleFile() {
		super();
	}	
	
	//TOSTRING() METHOD WITH ALL FIELDS
	@Override
	public String toString() {
		return "SampleFile [id=" + id + ", fileName=" + fileName + ", userName=" + userName + ", userType="
				+ userType + ", fileType=" + fileType + ", createdAt=" + createdAt + ", fileSize=" + fileSize
				+ "]";
	}
		
	//GETTERS AND SETTERS FOR ALL FIELDS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public float getFileSize() {
		return fileSize;
	}

	public void setFileSize(float fileSize) {
		this.fileSize = fileSize;
	}

	//CONSTRUCTOR WITH ALL FIELDS
	public SampleFile(Integer id, @NotBlank String fileName, @NotBlank String userName, @NotBlank String userType,
			@NotBlank String fileType, @NotBlank String createdAt, @NotNull float fileSize) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.userName = userName;
		this.userType = userType;
		this.fileType = fileType;
		this.createdAt = createdAt;
		this.fileSize = fileSize;
	}

	//CONSTRUCTOR WITH ALL FIELDS EXCEPT ID
	public SampleFile(@NotBlank String fileName, @NotBlank String userName, @NotBlank String userType,
			@NotBlank String fileType, @NotBlank String createdAt, @NotNull float fileSize) {
		super();
		this.fileName = fileName;
		this.userName = userName;
		this.userType = userType;
		this.fileType = fileType;
		this.createdAt = createdAt;
		this.fileSize = fileSize;
	}


}