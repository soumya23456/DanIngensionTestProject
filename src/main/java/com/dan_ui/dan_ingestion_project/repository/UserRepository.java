package com.dan_ui.dan_ingestion_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsById(Integer id);
	boolean existsByFullName(String fullName);
	boolean existsByEmail(String email);
	boolean existsByPhoneNumber(String phoneNumber);
	
	User findByFullName(String fullName);
	User findByEmail(String email);
	User findByPhoneNumber(String phoneNumber);
	List<User> findAll();
}
