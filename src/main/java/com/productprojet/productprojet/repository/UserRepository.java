package com.productprojet.productprojet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.productprojet.productprojet.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	List<User> findByNameContaining(String expression);
	
	@Query("FROM User u WHERE u.name LIKE %?1%")
	Iterable<User> getByExpression(String expression);
	
	@Query(value = "SELECT * FROM utilisateur u WHERE u.name LIKE '%?1%'", nativeQuery = true) //Depuis le BDD
	Iterable<User> getByExpressionUsingNativeQuery(String expression);
}
