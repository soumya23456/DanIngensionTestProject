package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.entity.User;
import com.dan_ui.dan_ingestion_project.model.Usersdto;

public interface IUserService {

	public User saveUser(User user);
	public boolean existsById(Integer id);
	public boolean existsByFullName(String fullName);
	public boolean existsByEmail(String email);
	public boolean existsByPhoneNumber(String phoneNumber);
	
	public User findByFullName(String fullName);
	public User findByEmail(String email);
	public User findByEmailPassword(String email,String password);
	public User findByPhoneNumber(String phoneNumber);
	
	public List<User> findAllUsers();
	
	public List<Usersdto> findAllClientUsers();
	public List<Usersdto> findAllVendorUsers();
	public List<Usersdto> findAllAdminUsers();
}
