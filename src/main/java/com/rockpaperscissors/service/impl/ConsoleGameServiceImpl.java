package com.rockpaperscissors.service.impl;

import org.springframework.stereotype.Service;

import com.rockpaperscissors.model.Game;
import com.rockpaperscissors.model.Resume;
import com.rockpaperscissors.service.GameService;

@Service
public class ConsoleGameServiceImpl implements GameService {

	@Override
	public void printGame(Game game) {

		System.out.println("\n" + game.toString());
	}

	@Override
	public void printResume(Resume resume) {
		System.out.println("\n" + resume.toString());
	}

}
