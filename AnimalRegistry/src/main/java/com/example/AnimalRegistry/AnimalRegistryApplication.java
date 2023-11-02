package com.example.AnimalRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;




@SpringBootApplication
public class AnimalRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRegistryApplication.class, args);
	}

	@Bean
	public OpenTelemetry openTelemetry() {
	  return AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
	}
    

	/*@RestController
	class Greet {
		@RequestMapping("/")
		String greeting() {
			return "Hello Cat!";
		}
	}*/
}

