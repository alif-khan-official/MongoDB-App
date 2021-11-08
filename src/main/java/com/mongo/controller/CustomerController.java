package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Customer;
import com.mongo.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return (List<Customer>) this.customerRepository.findAll();
	} 
	

	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
	    return this.customerRepository.save(customer);
	}
	
}
