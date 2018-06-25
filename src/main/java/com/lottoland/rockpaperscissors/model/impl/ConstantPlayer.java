package com.lottoland.rockpaperscissors.model.impl;

import com.lottoland.rockpaperscissors.model.Move;
import com.lottoland.rockpaperscissors.model.Player;

public class ConstantPlayer implements Player{
	
	private Move move;
	
	/**
	 * Constructor.
	 * @param move
	 */
	public ConstantPlayer(Move move) {
		this.move = move;
	}

	/**
	 * Get the value move.
	 * @return the move 
	 */
	public Move getMove() {
		return move;
	}

	/**
	 * Set the value move.
	 * @param move the move to set
	 */
	public void setMove(Move move) {
		this.move = move;
	}
	
}