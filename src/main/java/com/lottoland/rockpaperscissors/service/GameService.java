package com.lottoland.rockpaperscissors.service;

import java.util.List;
import java.util.Optional;

import com.lottoland.rockpaperscissors.model.Game;
import com.lottoland.rockpaperscissors.model.Resume;

public interface GameService {
	public List<Game> getAllGames();
	public void addGame(Game game);
	public void restartGames();
	public Optional<Resume> getResume();
}
