package com.abb;

import com.abb.entity.Application;
import com.abb.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@Configuration, @EnableAutoConfiguration, @ComponentScan
//@ComponentScan("com.abb")
@SpringBootApplication
public class SpringbootFundamentalsApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringbootFundamentalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFundamentalsApplication.class, args);
		System.out.println("Hola Spring Boot");
	}

	@Bean
	public CommandLineRunner demo(ApplicationRepository repository) {
		CommandLineRunner cmdLR =  (args) -> {
			repository.save(new Application("Trackzilla","kesha.williams","Application for tracking bugs."));
			repository.save(new Application("Expenses","mary.jones","Application to track expense reports."));
			repository.save(new Application("Notifications","karen.kane","Application to send alerts and notifications to users."));

			for (Application application : repository.findAll()) {
				log.info("The application is: " + application.toString());
			}
		};
		return cmdLR;
	}

}
