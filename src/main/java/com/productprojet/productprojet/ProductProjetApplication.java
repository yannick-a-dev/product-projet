package com.productprojet.productprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productprojet.productprojet.service.ProductService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class ProductProjetApplication implements CommandLineRunner{

	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.productService.initializeProducts();
	}

}
