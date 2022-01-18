package com.levysales.FinanceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceApiApplication.class, args);
	}

}
