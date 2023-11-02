package com.example.AnimalRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;

@SpringBootApplication
public class AnimalRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRegistryApplication.class, args);
	}

	@Configuration
	public class OpenTelemetryConfig {

		@Bean
		public Tracer jaegerTracer() {
			// Create a TracerProvider using OpenTelemetrySdk
			TracerProvider tracerProvider = SdkTracerProvider.builder().build();

			// Get a Tracer instance from the TracerProvider
			Tracer tracer = tracerProvider.get("jaeger-service");

			// Return the Tracer
			return tracer;
		}
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
