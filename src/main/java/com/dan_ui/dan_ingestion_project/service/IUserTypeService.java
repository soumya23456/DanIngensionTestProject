package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.model.UserType;

public interface IUserTypeService {

	public UserType findByTypeName(String typeName);
	public List<UserType> findAll();
	public boolean existsByTypeName(String typeName);
}
