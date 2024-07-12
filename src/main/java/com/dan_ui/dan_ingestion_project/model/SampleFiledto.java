package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class SampleFiledto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String fileName;
	@NotBlank
	private String fileType;
	
	
	//CONSTRUCTOR WITHOUT FIELDS
	public SampleFiledto() {
		super();
	}	
	
	//TOSTRING() METHOD WITH ALL FIELDS
	@Override
	public String toString() {
		return "SampleFile [id=" + id + ", fileName=" + fileName + "fileType=" + fileType + "]";
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	//CONSTRUCTOR WITH ALL FIELDS
	public SampleFiledto(Integer id, @NotBlank String fileName,	@NotBlank String fileType) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
	}

	//CONSTRUCTOR WITH ALL FIELDS EXCEPT ID
	public SampleFiledto(@NotBlank String fileName, @NotBlank String fileType) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
	}
}