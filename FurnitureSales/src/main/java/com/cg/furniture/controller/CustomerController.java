package com.cg.furniture.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.furniture.entity.Customer;
import com.cg.furniture.service.CustomerService;
import com.cg.furniture.utility.LoggingAspect;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/cg")
public class CustomerController {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	@Autowired
	private CustomerService customerService;

	@PostMapping(value="/customer/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		logger.info("Customer registration method started!");
		
		customerService.registerCustomer(customer);
		return new ResponseEntity<>("Customer Registered Successfully",HttpStatus.OK);
	}
}



