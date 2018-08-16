package com.rockpaperscissors.model.impl;

import java.util.Random;

import com.rockpaperscissors.model.Move;
import com.rockpaperscissors.model.Player;

public class RandomPlayer implements Player{
	
	private Move move;
	
	public RandomPlayer() {
		move = Move.values()[new Random().nextInt(3)];
	}
	
	public Move getMove() {
		return move;
	}

}
