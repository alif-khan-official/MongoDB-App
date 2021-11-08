package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}