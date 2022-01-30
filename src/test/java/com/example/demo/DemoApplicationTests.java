package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	OrderService orderService;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void TestOrderCreate(){
		
		Order order = new Order();
		order.setOrderID("111");
		order.setClientName("abc");
		Order testorder = orderService.createOder(order);
		
		assertTrue("111".equalsIgnoreCase(testorder.getOrderID())); 
	}
}
