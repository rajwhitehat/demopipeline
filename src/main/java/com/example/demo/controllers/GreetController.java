package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.GreetService;

@RestController
public class GreetController {

	private final GreetService greetService;

	public GreetController(GreetService greetService) {
		this.greetService = greetService;
	}

	@GetMapping("/api/v1/greet")
	public String greet(
			@RequestParam(value = "first_name", defaultValue = "") String firstName,
			@RequestParam(value = "last_name", defaultValue = "") String lastName) {
		return greetService.greet(firstName, lastName);
	}
}
