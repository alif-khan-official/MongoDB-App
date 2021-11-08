package com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.model.Customer;
import com.mongo.repository.CustomerRepository;

public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
     
    
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
    
    public void saveCustomer(Customer customer) {
    	customerRepository.save(customer);
    }
	
}
