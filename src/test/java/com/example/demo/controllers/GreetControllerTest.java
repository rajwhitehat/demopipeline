package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.services.GreetService;

class GreetControllerTest {

	private MockMvc mockMvc;

	//@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new GreetController(new GreetService())).build();
	}

	//@Test
	void greet_returnsHelloWithQueryParams() throws Exception {
		mockMvc.perform(get("/api/v1/greet").param("first_name", "John").param("last_name", "Smith"))
				.andExpect(status().isOk())
				.andExpect(content().string("hello John Smith"));
	}

	//@Test
	void greet_usesDefaultEmptyParams() throws Exception {
		mockMvc.perform(get("/api/v1/greet"))
				.andExpect(status().isOk())
				.andExpect(content().string("hello  "));
	}

	//@Test
	void greet_acceptsExplicitEmptyParams() throws Exception {
		mockMvc.perform(get("/api/v1/greet").param("first_name", "").param("last_name", ""))
				.andExpect(status().isOk())
				.andExpect(content().string("hello  "));
	}
}
