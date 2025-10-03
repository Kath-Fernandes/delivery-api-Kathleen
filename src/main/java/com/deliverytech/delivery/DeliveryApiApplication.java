package com.deliverytech.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
    info = @Info(
    title = "API de Clientes",
    version = "1.0",
    description = "Documentação da API para gerenciamento de clientes"
)
)

@SpringBootApplication
public class DeliveryApiApplication {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

	
}
