package com.cg.furniture.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.furniture.entity.Order;
import com.cg.furniture.repository.OrderRepository;

@Service
@Transactional
public class OrderService{

	@Autowired 
	private OrderRepository orderRepo;

	//Get all orders

	public List<Order> getAllOrders(){ 
		List<Order> list = (List<Order>)this.orderRepo.findAll(); 
		return list;
	}

	//Cancel Order 
	public String cancelOrder(int orderId) {
		orderRepo.deleteById(orderId);
		return "Order cancelled successfully";
	}



}
