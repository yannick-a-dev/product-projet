package com.productprojet.productprojet.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import com.productprojet.productprojet.entities.User;
import com.productprojet.productprojet.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRepository;
	
	public Iterable<User> search(String name) {
		if(Strings.isNotEmpty(name)) {
			return userRepository.getByExpression(name);
		}
		return this.userRepository.findAll();
	}
}
