package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}