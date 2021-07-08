package com.cg.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.cg.furniture.entity.Customer;
import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.service.BillService;

@SpringBootApplication
public class FurnitureSalesApplication {

	@Autowired
	private BillService billService;
	
	Customer customer= new Customer();

	
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws FurnitureException
	{
		billService.sendMail("furnituresalescg@gmail.com", "Body of the mail", "Confirmation of Order");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FurnitureSalesApplication.class, args);
	}

}
