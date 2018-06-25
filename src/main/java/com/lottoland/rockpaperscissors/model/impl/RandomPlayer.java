package com.lottoland.rockpaperscissors.model.impl;

import java.util.Random;

import com.lottoland.rockpaperscissors.model.Move;
import com.lottoland.rockpaperscissors.model.Player;

public class RandomPlayer implements Player{

	public Move getMove() {
		return getRandomMove();
	}
	/**
	 * Return a random Move
	 * @return
	 */
	private static Move getRandomMove() {
		return Move.values()[new Random().nextInt(3)];
	}

}
