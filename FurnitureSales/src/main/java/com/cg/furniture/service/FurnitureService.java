package com.cg.furniture.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.furniture.entity.Furniture;
import com.cg.furniture.entity.Order;
import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.exception.InvalidNameException;
import com.cg.furniture.repository.FurnitureRepository;
import com.cg.furniture.repository.OrderRepository;

@Service
@Transactional
public class FurnitureService  {
	
	@Autowired
	FurnitureRepository furnitureRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	public String sellFurniture(Furniture furniture) {
		furnitureRepo.save(furniture);
		return "Furniture Added";
	}
	
	public String buyFurniture(Order order) {
		orderRepo.save(order);
		return "Order placed successfully";
	}
	
	public String removeFurniture(Integer furnitureId) throws FurnitureException {
		Optional<Furniture> furniture = furnitureRepo.findById(furnitureId);
		furniture.orElseThrow(() -> new FurnitureException("Furniture not found"));
		furnitureRepo.deleteById(furnitureId);
		return "Furniture deleted successfully.";
	}
	
	public List<Furniture> viewFurnitures(){ 
		List<Furniture> furnitureList = new ArrayList<Furniture>();
		furnitureRepo.findAll().forEach(u1 -> furnitureList.add(u1));
       	return furnitureList;
	}
	
	public List<Furniture> viewAllFurnitureByCategory(String name) throws InvalidNameException {
		List<Furniture> list= furnitureRepo.findFurnitureByCategory(name);
		return list;		
	}
	
	public Furniture viewFurnitureById(Integer furnitureId) throws FurnitureException {
		Optional<Furniture> opt= furnitureRepo.findById(furnitureId);
		Furniture furniture = opt.orElseThrow(() -> new FurnitureException("Furniture Id not found"));
		return furniture;
	}
}

