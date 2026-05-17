package com.apoio.apoio_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApoioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApoioApiApplication.class, args);
	}

}
