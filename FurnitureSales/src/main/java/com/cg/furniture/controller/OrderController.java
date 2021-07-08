package com.cg.furniture.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.furniture.entity.Order;
import com.cg.furniture.service.OrderService;
import com.cg.furniture.utility.LoggingAspect;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/cg")
public class OrderController {

	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
     @Autowired 
     private OrderService orderService;
     
     //Get all orders
     @GetMapping("/getOrders") 
     public ResponseEntity<List<Order>> getOrder(){
    	 logger.info("Get all orders Method Started!");
    	 List<Order> list = orderService.getAllOrders();
    		 if(list.size() <= 0) {
    			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    		 }
    	 return ResponseEntity.of(Optional.of(list));
    	 }
     
     @DeleteMapping("/deleteOrder/{orderId}")
     public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") int orderId){
    	 logger.info("Delete Order Method Started!");
    	 try {
    		 this.orderService.cancelOrder(orderId);
    		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	 }
     }
}











