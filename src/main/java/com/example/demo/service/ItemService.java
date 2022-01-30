package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDAO;
import com.example.demo.dao.ItemRepository;
import com.example.demo.domain.Item;
import com.example.demo.domain.Order;
@Service
public class ItemService {

	@Autowired
	ItemRepository itemDAO;
	//ItemDAO itemDAO;	
	
	public Item createItem(Item item) {
		System.out.println("Inside Service Item :" + item);
		itemDAO.save(item);
			//save item
		 //return saved item data 
		return item;
	}

	public Item getItemByID(String itemID) {
		return  itemDAO.findById(itemID).get();
		//return itemDAO.getById(itemID);

	}	
	public List<Item> getItemByPrice(double price) {

		return itemDAO.findByPrice(price);

	}	
	public List<Item> getItemByOrder(Order order) {

		return itemDAO.findItemsByOrder(order) ; 

	}		
	
	public List<Item> getAllItems(){
		
		List<Item> itemList = new ArrayList<>();
		Comparator<Item> idcomp =  Comparator.comparingDouble(Item::getPrice);
		itemDAO.findAll().forEach(i->itemList.add(i));
		return itemList.stream().sorted(idcomp).collect(Collectors.toList());
	}
}
