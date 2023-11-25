package com.example.AnimalRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
public class AnimalRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRegistryApplication.class, args);
	}


	/*
	 * @RestController
	 * class Greet {
	 * 
	 * @RequestMapping("/")
	 * String greeting() {
	 * return "Hello Cat!";
	 * }
	 * }
	 */

	
}
