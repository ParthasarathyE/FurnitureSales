package com.cg.furniture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.furniture.entity.Bill;
import com.cg.furniture.service.BillService;
import com.cg.furniture.utility.LoggingAspect;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/cg")
public class BillController {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Autowired
	private BillService billService;
	
	@GetMapping(value="/bill/{billId}")
	public ResponseEntity<Bill> generateBill(@PathVariable Integer billId) throws Exception{
		logger.info("Generating mail started!");
		
		Bill billEntity=billService.generateBill(billId);
		System.out.println("Generate the Bill with ID"+billId);
		return new ResponseEntity<>(billEntity,HttpStatus.OK);	
	}
}
