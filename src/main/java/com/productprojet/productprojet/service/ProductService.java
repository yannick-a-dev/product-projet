package com.productprojet.productprojet.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;
import com.productprojet.productprojet.entities.Product;
import com.productprojet.productprojet.entities.Sentiment;
import com.productprojet.productprojet.entities.User;
import com.productprojet.productprojet.repository.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductRepository productRepository;

	public Iterable<Product> search(String name, String sentiment) {
		if (Strings.isNotEmpty(name)) {
			return productRepository.findByNameContainingOrderByPriceDesc(name);
		}if(Strings.isNotEmpty(sentiment)) {
			return productRepository.findBySentimentsTextContaining(sentiment);
		}
		return this.productRepository.findAll();
	}

	public void initializeProducts() {
		Faker faker = new Faker();
		List<Product> products = IntStream.range(30, 100).mapToObj(index -> {

			User user = User.builder().name(faker.name().fullName()).build();

			List<Sentiment> sentiments = IntStream.range(2, 5)
					.mapToObj(i -> Sentiment.builder().user(user).creation(Instant.now()).text(faker.lorem().sentence()).build())
					.collect(Collectors.toList());
			return Product.builder().sentiments(sentiments).name("Product " + index).price(index * 100).build();
		}

		).collect(Collectors.toList());

		this.productRepository.saveAll(products);
	}
}
