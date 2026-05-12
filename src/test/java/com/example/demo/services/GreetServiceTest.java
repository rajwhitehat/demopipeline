package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreetServiceTest {

	private final GreetService greetService = new GreetService();

	@Test
	void greet_returnsHelloWithFirstAndLastName() {
		assertThat(greetService.greet("Jane", "Doe")).isEqualTo("hello Jane Doe");
	}

	@Test
	void greet_handlesEmptyStrings() {
		assertThat(greetService.greet("", "")).isEqualTo("hello  ");
	}

	@Test
	void greet_handlesOnlyFirstName() {
		assertThat(greetService.greet("Alex", "")).isEqualTo("hello Alex ");
	}
}
