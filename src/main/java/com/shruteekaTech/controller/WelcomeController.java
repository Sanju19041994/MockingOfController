package com.shruteekaTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shruteekaTech.service.WelcomeService;

import ch.qos.logback.core.status.Status;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg(){
		String msg = welcomeService.welcomeMethod();
		System.out.println(msg);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greetMsg(){
		String msg1 = welcomeService.greet();
		System.out.println(msg1);
		return new ResponseEntity<String>(msg1,HttpStatus.OK);
	}
	
	@GetMapping("/tazaNews")
	public ResponseEntity<String> news(){
		String msg = welcomeService.newsMethod();
		System.out.println(msg);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
