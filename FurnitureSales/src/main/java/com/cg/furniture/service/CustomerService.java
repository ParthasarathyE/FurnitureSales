package com.cg.furniture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.furniture.entity.Customer;
import com.cg.furniture.repository.CustomerRepository;


@Service
@Transactional
public class CustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	// Method to register a customer
	public String registerCustomer(Customer customer) {
		customerRepository.save(customer);									   // call save method
		return "customer Registered successfully";							   // return message
	}
}





