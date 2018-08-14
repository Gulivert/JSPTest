package com.lottoland.rockpaperscissors.controller.impl;

import org.springframework.stereotype.Controller;

import com.lottoland.rockpaperscissors.model.Move;
import com.lottoland.rockpaperscissors.model.Player;
import com.lottoland.rockpaperscissors.model.impl.ConstantPlayer;
import com.lottoland.rockpaperscissors.model.impl.RandomPlayer;
import com.lottoland.rockpaperscissors.service.GameService;

@Controller
public class GameControllerImpl {
	
	GameService gameService;
	Player player1;
	Player player2; 
	
	/**
	 * Constructor.
	 * @param gameService
	 */
	public GameControllerImpl(GameService gameService) {
		this.gameService = gameService;
		player1 = new ConstantPlayer(Move.ROCK);
		player2 = new RandomPlayer();
	}

}
