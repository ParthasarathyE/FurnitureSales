package com.cg.furniture.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.furniture.entity.Admin;
import com.cg.furniture.entity.Customer;
import com.cg.furniture.service.LoginService;
import com.cg.furniture.utility.LoggingAspect;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping(value="/cg")
public class LoginController {

	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Autowired
	private LoginService loginService;
	
	//http://localhost:8080/cg/login/admin?adminEmail=admin@gmail.com&password=admin@123
	@PostMapping("/login/admin")
	public ResponseEntity<String> loginAdmin(@RequestParam String adminEmail,@RequestParam String password ) {
		logger.info("Admin Login Method Started!");
		Admin obj =loginService.loginAdmin(adminEmail,password);
		if (obj !=null) {
			return new ResponseEntity<String>("Admin Login Successfull!!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Admin Login Failed!!!", HttpStatus.BAD_REQUEST);
	}
	
	//http://localhost:8080/cg/login/customer?email=anup@gmail.com&password=Anup@123
	@PostMapping("/login/customer")
	public ResponseEntity<String> loginCustomer(@RequestParam String email,@RequestParam String password ) {
		logger.info("Customer Login Method Started!");
		Customer obj =loginService.loginCustomer(email,password);
		if (obj !=null) {
			return new ResponseEntity<String>("User Login Successfull!!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("User Login Failed!!!", HttpStatus.BAD_REQUEST);
	}
	
}
