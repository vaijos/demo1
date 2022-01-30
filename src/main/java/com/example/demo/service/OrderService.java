package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;
	public Order createOder(Order order) {
		
		if (order.getItems() != null) {
			order.getItems().forEach(i->i.setOrder(order));
		}
		//save order
		orderRepo.save(order);
		return order;
	}

	public Order getOrder(String orderID) {
		//save order
		Order order = orderRepo.findById(orderID).get();
		return order;
	}	
}
