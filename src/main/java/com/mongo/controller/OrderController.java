package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Order;
import com.mongo.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return (List<Order>) this.orderRepository.findAll();
	} 
	

	@PostMapping("/orders")
	public Order saveOrder(@RequestBody Order order) {
	    return this.orderRepository.save(order);
	}
	
}
