package com.dan_ui.dan_ingestion_project.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Configuration config;
	
	public void sendSimpleEmail(String toEmail,Map<String, Object> model) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new 
					MimeMessageHelper(message, 
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			helper.setFrom("m.soujanya434@gmail.com");
			helper.setTo(toEmail);
			helper.setText(html,true);
			helper.setSubject("New Feedback Message");
			
			mailSender.send(message);

		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Message sent...");
	}
}
