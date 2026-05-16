package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetService {

	private static final Logger log = LoggerFactory.getLogger(GreetService.class);

	public String greet(String firstName, String lastName) {
		log.info("Building greeting");
		log.debug("Input firstName='{}', lastName='{}'", firstName, lastName);
		String message = "hello " + firstName + " " + lastName;
		log.debug("Greeting built, length={}", message.length());
		return message;
	}
}
