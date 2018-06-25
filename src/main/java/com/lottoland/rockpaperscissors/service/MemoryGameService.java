package com.lottoland.rockpaperscissors.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.lottoland.rockpaperscissors.model.Game;

@Service
@SessionScope
public class MemoryGameService implements GameService {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static List<Game> games;

	/**
	 * Constructor.
	 */
	public MemoryGameService() {
		games = new ArrayList<Game>();
	}

	@Override
	public List<Game> getAllGames() {
		if (!games.isEmpty())
			LOGGER.info("\nList of games recovered:\n"
					+ games.stream().map(Object::toString).collect(Collectors.joining("\n")));
		return games;
	}

	@Override
	public void addGame(Game game) {
		games.add(game);
	}

	@Override
	public void restartGames() {
		games.clear();
	}

}
