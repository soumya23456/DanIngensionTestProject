package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan_ui.dan_ingestion_project.entity.User;
import com.dan_ui.dan_ingestion_project.model.Usersdto;
import com.dan_ui.dan_ingestion_project.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean existsById(Integer id) {
		boolean isId = userRepo.existsById(id);
		return isId;
	}

	@Override
	public boolean existsByFullName(String fullName) {
		boolean isFullName = userRepo.existsByFullName(fullName);
		return isFullName;
	}

	@Override
	public boolean existsByEmail(String email) {
		boolean isEmail = userRepo.existsByEmail(email);
		return isEmail;
	}

	@Override
	public boolean existsByPhoneNumber(String phoneNumber) {
		boolean isPhoneNumber = userRepo.existsByPhoneNumber(phoneNumber);
		return isPhoneNumber;
	}

	@Override
	public User findByFullName(String fullName) {
		User user = userRepo.findByFullName(fullName);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public User findByEmailPassword(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}			
		}
		return null;
	}
	
	@Override
	public User findByPhoneNumber(String phoneNumber) {
		User user = userRepo.findByPhoneNumber(phoneNumber);
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User saveUser(User user) {
		
		User newUser = new User(
				user.getFullName(),
				user.getEmail(), 
				user.getPhoneNumber(),
				user.getPassword(), 
				user.getUserType(),
				user.getAddress(),
				user.getPostalCode(),
				user.getRegion(),
				user.getCountry(), 
				user.isActivated(),
				user.getCreatedAt(), 
				user.getUpdatedAt());
		logger.info("saving New User in Service class : "+newUser.toString());
		userRepo.save(newUser);
		return newUser;
	}

	@Override
	public List<Usersdto> findAllClientUsers() {
		return null;
	}

	@Override
	public List<Usersdto> findAllVendorUsers() {
//		List<Usersdto> vendors = userRepo.getAllVendorUsers();
		return null;
	}

	@Override
	public List<Usersdto> findAllAdminUsers() {
		return null;
	}
}