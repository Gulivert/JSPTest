package com.rockpaperscissors.command;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rockpaperscissors.controller.GameController;

@Component
public class CommandRunner implements CommandLineRunner {

	private GameController gameControllerImpl;

	public CommandRunner(GameController gameControllerImpl) {
		this.gameControllerImpl = gameControllerImpl;
	}

	@Override
	public void run(String... args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println();

		Integer valueDestination = 0;
		
		Boolean destinyValid = false;
		while (!destinyValid) {
			System.out.println("---------------");
			System.out.println("Choose the destination: ");
			System.out.println("1) Console");
			System.out.println("2) File");
			System.out.println("---------------");
			System.out.print("> ");
			String destination = scanner.nextLine();
			try {
				valueDestination = Integer.parseInt(destination);
			} catch (NumberFormatException e) {
				System.out.println("\nError: Value " + destination + " is not valid.\n");
				continue;
			}

			if (0 < valueDestination && valueDestination < 3) {
				destinyValid = true;
			} else {
				System.out.println("\nError: Value \"" + valueDestination + "\" is not valid.\n");
			}
		}

		Integer valueMode = 0;
		while (valueMode != 4) {

			System.out.println("\n---------------");
			System.out.println("   New Game!");
			System.out.println("---------------");
			System.out.println("Mode of play: ");
			System.out.println("1) Fair");
			System.out.println("2) Unfair");
			System.out.println("3) Remote ");
			System.out.println("4) Exit ");
			System.out.println("---------------");
			System.out.print("> ");
			String mode = scanner.nextLine();
			try {
//				System.out.println();
				valueMode = Integer.parseInt(mode);
			} catch (NumberFormatException e) {
				System.out.println("\nError: Value \'" + mode + "\' is not valid.\n");
				continue;
			}
			if (0 < valueMode && valueMode < 5) {
				gameControllerImpl.play(valueMode, valueDestination);
			} else {
				System.out.println("\nError: Value \"" + valueMode + "\" is not valid.\n");
				continue;
			}

		}

	}
}