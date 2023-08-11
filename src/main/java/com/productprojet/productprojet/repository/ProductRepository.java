package com.productprojet.productprojet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.productprojet.productprojet.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
	//select * from product where name = param;
	Iterable<Product> findByName(String name);
	
	//select * from product where name LIKE param;
	Iterable<Product> findByNameContainingOrderByPriceDesc(String name);
	
	Iterable<Product> findByPriceAfter(int price);
	
	List<Product> findBySentimentsTextContaining(String text);
}
