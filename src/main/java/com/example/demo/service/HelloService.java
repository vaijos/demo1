package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Value( "${testprop1}" )
	private String confname;
	
	public String sayHello(String name) {
		String msg = "Good Day Mr:" + name +"::confname" + confname;
		return msg;
	}
}
