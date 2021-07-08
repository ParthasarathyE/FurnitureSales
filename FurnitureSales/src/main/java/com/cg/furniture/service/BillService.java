package com.cg.furniture.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.furniture.entity.Bill;
import com.cg.furniture.entity.Customer;
import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.repository.BillRepository;

@Service
@Transactional
public class BillService {
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	Customer customer = new Customer();
	
	public Bill generateBill(Integer billId) throws FurnitureException {
		if(Objects.isNull(billId)) {
			throw new FurnitureException("Order ID should not be null");
		}
		if(billId.equals(0)) {
			throw new FurnitureException("Order ID should not be zero");
		}
		if(billId.equals(-1)) {
			throw new FurnitureException("Order ID should not be negative number");
		}
		Optional<Bill> optional=billRepository.findById(billId);
		Bill billEntity=optional.orElseThrow(()->new FurnitureException("Order ID not found"));
		return billEntity;
	}
	
	public void sendMail(String toMail, String body, String subject) throws FurnitureException {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(toMail);
		message.setFrom("furnituresalescg@gmail.com");
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
	}
	
}
