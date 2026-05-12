package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetService {

	public String greet(String firstName, String lastName) {
		return "hello " + firstName + " " + lastName;
	}
}
