package com.lottoland.rockpaperscissors;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RockpaperscissorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockpaperscissorsApplication.class, args);
		
		 Scanner scanner = new Scanner(System.in);

	        while (true) {

	            System.out.print("Choose the  : ");
	            String input = scanner.nextLine();

	            if ("q".equals(input)) {
	                System.out.println("Exit!");
	                break;
	            }

	            System.out.println("input : " + input);
	            System.out.println("-----------\n");
	        }

	        scanner.close();
	}
}
