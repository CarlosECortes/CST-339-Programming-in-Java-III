package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcu"}) //make spring scan our package for controller, etc.
public class Topic43Application {

	public static void main(String[] args) {
		SpringApplication.run(Topic43Application.class, args);
	}

}
