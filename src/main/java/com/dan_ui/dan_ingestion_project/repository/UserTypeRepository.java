package com.dan_ui.dan_ingestion_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

	UserType findByTypeName(String typeName);

	boolean existsByTypeName(String typeName);
	
}
