package com.dan_ui.dan_ingestion_project.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dan_ui.dan_ingestion_project.captcha.CaptchaValidator;
import com.dan_ui.dan_ingestion_project.entity.User;
import com.dan_ui.dan_ingestion_project.model.Feedbackdto;
import com.dan_ui.dan_ingestion_project.model.UserType;
import com.dan_ui.dan_ingestion_project.model.Userdto;
import com.dan_ui.dan_ingestion_project.service.UserServiceImpl;
import com.dan_ui.dan_ingestion_project.service.UserTypeServiceImpl;

@Controller
public class HomeController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserServiceImpl userservice;
		
	@Autowired
	private UserTypeServiceImpl usertypeservice;
	
	@Autowired
	private CaptchaValidator captchaValidator;
	
	@RequestMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("feedback", new Feedbackdto());
		return "index";
	}
	
	@RequestMapping("/home/register")
	public String register(Model model) {
		model.addAttribute("user",new Userdto());
		return "register";
	}
	
	@RequestMapping("/home/register/adduser")
	public String validateUser(
			@RequestParam("g-recaptcha-response") String captcha,
			@Valid @ModelAttribute("user") Userdto user,
			BindingResult result,
			Model model) {
		LocalDateTime date = LocalDateTime.now();

		if(!result.hasErrors()) {
			if(captchaValidator.isValidate(captcha)) {
				logger.info("verify captcha : "+ captchaValidator.isValidate(captcha));
				logger.info("errors : "+ result.toString());
				boolean isFullName = userservice.existsByFullName(user.getFullName());
				boolean isEmail = userservice.existsByEmail(user.getEmail());
				boolean isPhone = userservice.existsByPhoneNumber(user.getPhoneNumber());
				if(isFullName || isEmail || isPhone) {
					if(isFullName) { model.addAttribute("fnameexists", "Fullname already exists."); }
					if(isEmail) { model.addAttribute("emailexists", "Email already exists."); }
					if(isPhone) { model.addAttribute("phoneexists", "Phone Number already exists."); }
					if(isFullName && isEmail) { model.addAttribute("fnameexists", "Fullname already exists.");
						model.addAttribute("emailexists", "Email already exists.");}
					if(isFullName && isPhone) { model.addAttribute("fnameexists", "Fullname already exists.");
					model.addAttribute("phoneexists", "Phone number already exists.");}
					if(isPhone && isEmail) { model.addAttribute("phoneexists", "Phone Number already exists.");
					model.addAttribute("emailexists", "Email already exists.");}
					if(isFullName && isEmail && isPhone) { model.addAttribute("fnameexists", "Fullname already exists.");
					model.addAttribute("emailexists", "Email already exists."); model.addAttribute("phoneexists", "Phone Number already exists.");}
					return "register";
				}
				Collection<UserType> selectedUserTypes = new ArrayList<UserType>();
				UserType usertype = usertypeservice.findByTypeName(user.getUserType());
				System.out.println("selected UserType : " + usertype.getTypeName());
				selectedUserTypes.add(usertype);
				System.out.println(selectedUserTypes.toString());
				User newUser = new User(user.getFullName(),user.getEmail(), user.getPhoneNumber(),
						user.getPassword(),selectedUserTypes,user.getAddress(),user.getPostalCode(),
						user.getRegion(),user.getCountry(),true,date.toString(), date.toString());
				logger.info("New User before saving to DB : "+newUser.toString());
				userservice.saveUser(newUser);
				return "redirect:/home/login?success";
			}
			model.addAttribute("captchaerr", "Captcha not verified.");
		}
		model.addAttribute("captchaerr", "Captcha not verified.");
		return "register";
	}
}
