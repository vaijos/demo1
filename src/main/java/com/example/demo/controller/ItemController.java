package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	//endpoint to post item 
	@PostMapping("/items")
	public Item createItem(@RequestBody Item item) {

		System.out.println("Item as received:" + item);
		//do validation to check required attributes are present ...if not throw validation exception
		
		return itemService.createItem(item);
		
	}		
	
	//endpoint to get all items 
	@GetMapping("/items")
	public List<Item> getAllItem() {
		return itemService.getAllItems() ;
		
	}	
	//endpoint to get item by Id
	@GetMapping("/items/{itemID}")
	public List<Item> getItemByID(@PathVariable  ("itemID") String itemID,@RequestParam ("price") String price) {
		List<Item> iteamList = new ArrayList<>();
		if(itemID !=null) {
			
			iteamList.add( itemService.getItemByID(itemID));
			
		}else if (price != null){
			double dprice = Double.parseDouble(price);
			iteamList = itemService.getItemByPrice(dprice);
			
		}
		return iteamList;
	}	
	
	//get point to get by price
	//@GetMapping("/items")
	//public List<Item> getItemByPrice(@RequestParam ("price") String price) {
		
		
		//double dprice = Double.parseDouble(price);
		//return itemService.getItemByPrice(dprice);
		
	//}		
}
