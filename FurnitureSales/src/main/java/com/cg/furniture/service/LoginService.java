package com.cg.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.furniture.entity.Admin;
import com.cg.furniture.entity.Customer;
import com.cg.furniture.repository.AdminRepository;
import com.cg.furniture.repository.CustomerRepository;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public Admin loginAdmin(String adminEmail, String password){
		return adminRepo.loginAdmin(adminEmail, password);
	}
	
	public Customer loginCustomer(String email, String password){
		return customerRepo.loginCustomer(email, password);
	}

}
