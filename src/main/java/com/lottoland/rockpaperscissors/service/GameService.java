package com.lottoland.rockpaperscissors.service;

import java.util.List;

import com.lottoland.rockpaperscissors.model.Game;

public interface GameService {
	public List<Game> getAllGames();
	public void addGame(Game game);
	public void restartGames();
}
