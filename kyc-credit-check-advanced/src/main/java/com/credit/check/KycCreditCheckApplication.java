package com.credit.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@org.springframework.data.mongodb.repository.config.EnableMongoRepositories
public class KycCreditCheckApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KycCreditCheckApplication.class, args);		
	}
}
