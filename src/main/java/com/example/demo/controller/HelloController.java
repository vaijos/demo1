package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/test1")
	public String getTest1(@RequestParam ("name") String name,@RequestParam("title") String title) {
		return helloService.sayHello(title + "::" +name);
		
	}	
}