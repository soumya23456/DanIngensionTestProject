package com.dan_ui.dan_ingestion_project.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dan_ui.dan_ingestion_project.entity.User;
import com.dan_ui.dan_ingestion_project.model.SampleFile;
import com.dan_ui.dan_ingestion_project.model.UserType;
import com.dan_ui.dan_ingestion_project.model.Userdto;
import com.dan_ui.dan_ingestion_project.service.SampleFileServiceImpl;
import com.dan_ui.dan_ingestion_project.service.UserServiceImpl;

@Controller
public class LoginController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserServiceImpl userservice;
		
	@Autowired
	private SampleFileServiceImpl fileservice;
	
	@ModelAttribute("guestuser")
	public Userdto getuserdto() {
		Userdto user = new Userdto();
		return user;
	}
	
	@GetMapping("/home/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/home/login/authuser")
	public String authUser(
			@Valid @RequestParam String username, 
			@Valid @RequestParam String password) {
		System.out.println("email : "+ username);
		logger.info("email : "+ username);
		logger.info("password : "+ password);
		User user = userservice.findByEmailPassword(username,password);
		if(user != null) {
			Collection<UserType> authorities = user.getUserType();
			logger.info("Logged In User :: "+ user.toString());
			logger.info(authorities.toString());
			String redirectUrl = "redirect:/home/";
			for(UserType a: authorities) {
				if(a.getTypeName().contentEquals("ADMIN")) {
					 redirectUrl += "user/admin-dashboard";
					 break;
				}
				if(a.getTypeName().contentEquals("CLIENT")) {
					redirectUrl += "user/client-dashboard";
					break;
				}
				if(a.getTypeName().contentEquals("VENDOR")) {
					redirectUrl += "user/vendor-dashboard";
					break;
				}
			}
			return redirectUrl;
		}
		else {
			return "redirect:/home/login?error";
		}
	}

	@GetMapping("/home/user/admin-dashboard")
	public String adminDashboard(Model model) {
		List<SampleFile> files = fileservice.findAllFiles();
		
		List<com.dan_ui.dan_ingestion_project.entity.User> clientUsers = userservice.findAllUsers();
		List<com.dan_ui.dan_ingestion_project.entity.User> vendorUsers = userservice.findAllUsers();
		model.addAttribute("clients", clientUsers);
		model.addAttribute("vendors", vendorUsers);
		model.addAttribute("files",files);
		return "adminDashboard";
	}

	@GetMapping("/home/user/client-dashboard")
	public String clientDashboard(Model model) {
		List<SampleFile> files = fileservice.findAllFiles();
		model.addAttribute("files",files);

		return "clientDashboard";
	}
	
	@GetMapping("/home/user/vendor-dashboard")
	public String vendorDashboard(Model model) {
		List<SampleFile> files = fileservice.findAllFiles();
		model.addAttribute("files",files);

		return "vendorDashboard";
	}
	
	@GetMapping("/home/user/logout")
	public String userLogout(Model model) {
		return "redirect:/home/login?logout";
	}
}
