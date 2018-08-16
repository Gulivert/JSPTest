package com.rockpaperscissors.factory;

import com.rockpaperscissors.model.Game;
import com.rockpaperscissors.model.Move;
import com.rockpaperscissors.model.impl.ConstantPlayer;
import com.rockpaperscissors.model.impl.RandomPlayer;
import com.rockpaperscissors.service.PlayerService;

public class GameFactory{
	public static Game createGame(Integer mode, PlayerService service) {
		Game game = null;
		switch (mode) {
		case 1:
			game = new Game(new RandomPlayer(), new RandomPlayer());
			break;
		case 2:
			game = new Game(new RandomPlayer(), new ConstantPlayer(Move.ROCK));
			break;
		case 3:
			game = new Game(new RandomPlayer(), service.getPlayer());
			break;

		default:
			break;
		}
		return game;
	}
}