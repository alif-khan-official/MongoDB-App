package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}
