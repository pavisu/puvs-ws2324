package com.example.AnimalRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AnimalRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRegistryApplication.class, args);
	}
    
	/*@RestController
	class Greet {
		@RequestMapping("/")
		String greeting() {
			return "Hello Cat!";
		}
	}*/
}

