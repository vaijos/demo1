package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Item;
import com.example.demo.domain.Order;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	ItemService itemService;	
	
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {

		System.out.println("Order as received" + order);
		return orderService.createOder(order);
	}

	@PostMapping("/orders/{orderID}/item")
	public Order createOrderItem(@PathVariable  ("orderID") String orderID,@RequestBody Item item) {

		System.out.println("OrderID as received" + orderID);
		Order ord1 = orderService.getOrder(orderID);
		item.setOrder(ord1);
		item = itemService.createItem(item);
		ord1.getItems().add(item);
		return ord1;
		
	}
	
	@GetMapping("/orders/{orderID}")
	public Order getOrder(@PathVariable  ("orderID") String orderID) {

		System.out.println("OrderID as received" + orderID);
		Order ord1 = orderService.getOrder(orderID);
		//item.setOrder(ord1);
		//List<Item> items = itemService.getItemByOrder(ord1);
		//ord1.setItems(items.stream().collect(Collectors.toSet()));  
		//ord1.getItems().add(item);
		return ord1;
		
	}	
}
