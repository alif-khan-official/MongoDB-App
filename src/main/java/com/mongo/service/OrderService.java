package com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.model.Order;
import com.mongo.repository.OrderRepository;

public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
     
    
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
    
    public void saveOrder(Order order) {
    	orderRepository.save(order);
    }
	
}
