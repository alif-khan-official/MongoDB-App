package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Item;
import com.mongo.repository.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return (List<Item>) this.itemRepository.findAll();
	} 
	

	@PostMapping("/items")
	public Item saveItem(@RequestBody Item item) {
	    return this.itemRepository.save(item);
	}
	
}
