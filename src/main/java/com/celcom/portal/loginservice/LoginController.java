package com.celcom.portal.loginservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Value("${my.service}")
	private String greetingMessage;
	
	@Value("#{${db.value}}")
	private Map<String,String> dbValues;
	
	@Autowired
	private DBSettings dbSettings;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage + dbSettings.getConnection() +" " +dbSettings.getHost();
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		return env.toString();
	}

}
