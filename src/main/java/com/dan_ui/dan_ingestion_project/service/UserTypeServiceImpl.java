package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan_ui.dan_ingestion_project.model.UserType;
import com.dan_ui.dan_ingestion_project.repository.UserTypeRepository;

@Service
public class UserTypeServiceImpl implements IUserTypeService {


	@Autowired
	private UserTypeRepository userTypeRepo;
	
	@Override
	public UserType findByTypeName(String typeName) {
		System.out.println("Type Nmae : " + typeName);
		UserType usertype = userTypeRepo.findByTypeName(typeName);
		System.out.println("UserType : "+ usertype);
		return usertype;
	}

	@Override
	public List<UserType> findAll() {
		List<UserType> usertypes = userTypeRepo.findAll();
		return usertypes;
	}

	@Override
	public boolean existsByTypeName(String typeName) {
		boolean isTypeName = userTypeRepo.existsByTypeName(typeName);
		return isTypeName;
	}

}
