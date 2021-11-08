package com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.model.Item;
import com.mongo.repository.ItemRepository;

public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
     
    
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }
    
    public void saveItem(Item item) {
    	itemRepository.save(item);
    }
	
}
