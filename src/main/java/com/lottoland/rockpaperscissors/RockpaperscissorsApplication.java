package com.lottoland.rockpaperscissors;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lottoland.rockpaperscissors.controller.GameController;
import com.lottoland.rockpaperscissors.controller.impl.GameControllerImpl;

@SpringBootApplication
public class RockpaperscissorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockpaperscissorsApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		System.out.println();

		Integer valueMode = 0;

		while (valueMode != 4) {
			System.out.println("---------------");
			System.out.println("   New Game");
			System.out.println("---------------");
			System.out.println("Mode of play: ");
			System.out.println("1) Fair");
			System.out.println("2) Unfair");
			System.out.println("3) Remote ");
			System.out.println("---------------");
			System.out.print("> ");
			String mode = scanner.nextLine();
			try {
				valueMode = Integer.parseInt(mode);
			} catch (NumberFormatException e) {
				System.out.println("\nError: Value " + mode + " is not valid.\n");
				continue;
			}

			if (0 < valueMode && valueMode < 4) {

				System.out.println("---------------");
				System.out.println("Destination: ");
				System.out.println("1) Console");
				System.out.println("2) File");
				System.out.println("---------------");
				String destination = scanner.nextLine();
				Integer valueDestination;
				try {
					valueDestination = Integer.parseInt(destination);
				} catch (NumberFormatException e) {
					System.out.println("\nError: Value " + destination + " is not valid.\n");
					continue;
				}
				if (0 < valueDestination && valueDestination < 3) {
					gameControllerImpl.
				} else {
					System.out.println("\nError: Value " + valueDestination + " is not valid.\n");
					continue;
				}

			} else {
				System.out.println("\nError: Value " + valueMode + " is not valid.\n");
				continue;
			}

		}

	}
}
