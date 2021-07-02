package com.main.project.java;

import com.main.project.java.Entity.Product;
import com.main.project.java.Entity.User;
import com.main.project.java.Repository.ProductRepository;
import com.main.project.java.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository,
										 ProductRepository productRepository) {
		return args -> {

			User user= new User();
			userRepository.save(user);
			productRepository.save(new Product(1, "tshirt", user));
			productRepository.save(new Product(65, "bag", user));
		};
	}

}
