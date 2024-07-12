package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//USERTYPE TABLE MODEL -- ID, TYPENAME
@Entity
@Table(name = "USER_TYPE", uniqueConstraints = @UniqueConstraint(columnNames = "usertype"))
public class UserType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typeid",nullable = false)
	private Integer typeId;
	@Column(name = "usertype",nullable = false)
	private String typeName;
	
	//CONSTRUCTOR WITH ALL FIELDS 
	public UserType(Integer typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	//GETTERS AND SETTERS FOR ALL FIELDS
	public Integer getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	
	//CONSTRUCTOR WITH TYPENAME
	public UserType(String typeName) {
		super();
		this.typeName = typeName;
	}

	//CONSTRUCTOR WITHOUT FIELDS
	public UserType() {
		super();
	}

	
	//TOSTRING() METHOD WITH TYPENAME
	@Override
	public String toString() {
		return "UserType [typeName=" + typeName + "]";
	}
}