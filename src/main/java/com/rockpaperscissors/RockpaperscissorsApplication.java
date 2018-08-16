package com.rockpaperscissors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class RockpaperscissorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockpaperscissorsApplication.class, args).close();
	}
}
