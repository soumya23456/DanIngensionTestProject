package com.dan_ui.dan_ingestion_project.captcha;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CaptchaValidator {
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	private CaptchaSettings captchaSettings;
	
	public boolean isValidate(String captcha) {
		
		URI verifyUri = URI.create(String.format(
		          "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
		          captchaSettings.getSecret(), captcha));
		//cap id:
				//6LcDAQgqAAAAALBXp1GWZfwWdwlnZnnvO9mGbe-g
		
		CaptchaResponse res = resttemplate.postForObject(verifyUri, null, CaptchaResponse.class);
		
		return res.isSuccess();
	}
}

