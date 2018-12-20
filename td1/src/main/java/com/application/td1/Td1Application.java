package com.application.td1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class Td1Application {
	public static void main(String[] args) {
		SpringApplication.run(Td1Application.class, args);
	}
}
