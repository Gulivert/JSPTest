package com.rockpaperscissors.controller.impl;

import org.springframework.stereotype.Controller;

import com.rockpaperscissors.controller.GameController;
import com.rockpaperscissors.factory.GameFactory;
import com.rockpaperscissors.factory.GameServiceFactory;
import com.rockpaperscissors.model.Game;
import com.rockpaperscissors.model.Resume;
import com.rockpaperscissors.service.GameService;
import com.rockpaperscissors.service.PlayerService;

@Controller
public class GameControllerImpl implements GameController {

	private Resume resume;
	private PlayerService playerService;

	/**
	 * Constructor.
	 * 
	 * @param gameService
	 */
	public GameControllerImpl(PlayerService playerService) {
		this.playerService = playerService;
		this.resume = new Resume();
	}

	@Override
	public void play(Integer mode, Integer destination) {

		GameService gameService = GameServiceFactory.getGameService(destination);

		if (mode == 4) {
			gameService.printResume(resume);
		} else {
			Game game = GameFactory.createGame(mode, playerService);
			resume.incrementWinner(game.getWinner());

			gameService.printGame(game);
		}
	}

}
