package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Item;

@Repository
public class ItemDAO {
	
	 Map<String,Item> itemMap = new TreeMap<>();
	
	public Item save(Item item) {
		System.out.println("Item before save :" + item);
		return itemMap.put(item.getItemID() , item);

	}
	public Item getById(String itemID) {
		
		return itemMap.get(itemID);
	}
	public Item getByPrice(double price) {
		
		Item item=null;
		//look up item by price 
		
		return item;
	}
	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<>();
		itemMap.forEach((k,v)-> {
			itemList.add(v);	
		});
		return itemList;
		
		
	}
}
