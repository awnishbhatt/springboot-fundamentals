package com.abb.springbootfundamentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class SpringbootFundamentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFundamentalsApplication.class, args);
		System.out.println("Hola Spring Boot");
	}

}
