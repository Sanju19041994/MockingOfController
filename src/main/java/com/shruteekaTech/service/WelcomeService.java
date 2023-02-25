package com.shruteekaTech.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public String welcomeMethod() {
		return "welcome to service layer";
	}
	
	public String greet() {
		String msg = "this is my second method for testing";
		return msg;
	}
	
	public String newsMethod() {
		return "This is fresh news of the morning";
	}
}
