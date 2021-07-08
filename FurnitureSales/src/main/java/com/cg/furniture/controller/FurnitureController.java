package com.cg.furniture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.furniture.entity.Furniture;
import com.cg.furniture.entity.Order;
import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.exception.InvalidNameException;
import com.cg.furniture.service.FurnitureService;
import com.cg.furniture.utility.LoggingAspect;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/cg")
public class FurnitureController {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Autowired
    private FurnitureService furnitureService;
	
	@PostMapping(value="/furniture/sell")
	public ResponseEntity<String> sellFurniture(@RequestBody Furniture furniture){
		logger.info("Sell Furniture method started!");
		furnitureService.sellFurniture(furniture);
		return new ResponseEntity<>("Added successfully",HttpStatus.OK);
	}
	
	@PostMapping(value="/furniture/buy")
	public ResponseEntity<String> buyFurniture(@RequestBody Order order){
		logger.info("Buy Furniture method started!");
		furnitureService.buyFurniture(order);
		return new ResponseEntity<>("Order placed successfully",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/furniture/remove/{furnitureId}")
	public ResponseEntity<String> removeFurniture(@PathVariable Integer furnitureId) throws Exception {
		logger.info("Remove Furniture method started!");
		furnitureService.removeFurniture(furnitureId);
		return new ResponseEntity<>("Removed successfully", HttpStatus.OK);
	}
	
	@GetMapping(value="/furniture/view")
	public ResponseEntity<List<Furniture>> viewFurniture() throws FurnitureException{
		logger.info("View Furniture method started!");
		List<Furniture> furnitureList = furnitureService.viewFurnitures();
		return new ResponseEntity<>(furnitureList,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllFurnitureByCategory/{furnitureCategory}")
	public ResponseEntity<List<Furniture>> viewAllFurnitureByCategory(@PathVariable("furnitureCategory") String name)
			throws Exception {	
		logger.info("View Furniture by catagory method started!");
		List<Furniture> furniture = furnitureService.viewAllFurnitureByCategory(name);
		if (furniture.isEmpty()) {	
			throw new InvalidNameException("Furniture not found !!!");
		}
		return new ResponseEntity<List<Furniture>>(furniture, HttpStatus.OK);
	}
	
	@GetMapping(value="/furniture/viewById/{furnitureId}")
	public ResponseEntity<Furniture> viewFurnitureyId(@PathVariable Integer furnitureId) throws FurnitureException{
		logger.info("View Furniture By Id method started!");
		Furniture furniture = furnitureService.viewFurnitureById(furnitureId);
		return new ResponseEntity<>(furniture,HttpStatus.OK);
	}
}
