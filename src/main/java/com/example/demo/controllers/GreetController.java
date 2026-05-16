package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.GreetService;

@RestController
public class GreetController {

	private static final Logger log = LoggerFactory.getLogger(GreetController.class);

	private final GreetService greetService;

	public GreetController(GreetService greetService) {
		this.greetService = greetService;
	}

	@GetMapping("/api/v1/greet")
	public String greet(
			@RequestParam(value = "first_name", defaultValue = "") String firstName,
			@RequestParam(value = "last_name", defaultValue = "") String lastName) {
		log.info("GET /api/v1/greet");
		log.debug("first_name='{}', last_name='{}'", firstName, lastName);
		String body = greetService.greet(firstName, lastName);
		log.debug("Response body length={}", body.length());
		return body;
	}
}
