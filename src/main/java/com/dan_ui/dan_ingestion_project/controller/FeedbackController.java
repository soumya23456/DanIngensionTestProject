package com.dan_ui.dan_ingestion_project.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dan_ui.dan_ingestion_project.captcha.CaptchaValidator;
import com.dan_ui.dan_ingestion_project.model.Feedback;
import com.dan_ui.dan_ingestion_project.model.Feedbackdto;
import com.dan_ui.dan_ingestion_project.service.EmailSenderService;
import com.dan_ui.dan_ingestion_project.service.FeedbackServiceImpl;

@Controller
public class FeedbackController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FeedbackServiceImpl feedbackservice;
	
	@Autowired
	private EmailSenderService emailservice;
	
	@Autowired
	private CaptchaValidator captchaValidator;
	
	@PostMapping("/home/savefeedback")
	public String validFeedback(
			@RequestParam("g-recaptcha-response") String captcha,
			@ModelAttribute("feedback") @Valid Feedbackdto feedback,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if(!result.hasErrors()) {
			if(captchaValidator.isValidate(captcha)) {
				LocalDateTime date = LocalDateTime.now();
				Feedback newfdbk = feedbackservice.saveFeedback(new Feedback(feedback.getFullname(),feedback.getEmail(),feedback.getSubject(),feedback.getMessage(), date.toString()));
				logger.info("Feedback is :: "+ newfdbk.toString());
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("Name", feedback.getFullname());
				model.put("Email", feedback.getEmail());
				model.put("Subject", feedback.getSubject());
				model.put("Message", feedback.getMessage());
				emailservice.sendSimpleEmail("m.soumya234@gmail.com", model);
				return "redirect:/home?fdbk_success#contact";		
			}
			redirectAttributes.addFlashAttribute("captchaerr", "Please verify captcha");
		}
		logger.info(result.toString());
		redirectAttributes.addFlashAttribute(feedback);
		if(result.hasFieldErrors("fullname")) {
			redirectAttributes.addFlashAttribute("fnameerr", "Full name is required. Contains only letters.");
		}
		if(result.hasFieldErrors("email")) {
			redirectAttributes.addFlashAttribute("emailerr", "Email is required. Invalid Email");
		}
		if(result.hasFieldErrors("subject")) {
			redirectAttributes.addFlashAttribute("subjecterr", "Subject is required.");
		}
		if(result.hasFieldErrors("message")) {
			redirectAttributes.addFlashAttribute("msgerr", "Message is required.");
		}
		redirectAttributes.addFlashAttribute("captchaerr", "Please verify captcha");
		return "redirect:/home#contact";
	}
}
