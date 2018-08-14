package com.lottoland.rockpaperscissors.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lottoland.rockpaperscissors.model.Game;
import com.lottoland.rockpaperscissors.model.Resume;

@Service
public class MemoryGameService implements GameService {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static List<Game> games;
	private static Resume resume;

	/**
	 * Constructor.
	 */
	public MemoryGameService() {
		games = new ArrayList<Game>();
		resume = new Resume();
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
		switch (game.getWinner()) {

		case 0:
			resume.incrementDraws();
			break;
		case 1:
			resume.incrementP1Wins();
			break;
		case 2:
			resume.incrementP2Wins();
			break;

		}
		games.add(game);
	}

	@Override
	public void restartGames() {
		games.clear();
	}

	@Override
	public Optional<Resume> getResume() {
		LOGGER.info("\nResume recovered:\n" + resume.toString());
		return Optional.of(resume);
	}

}
