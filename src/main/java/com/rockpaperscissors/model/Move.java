package com.rockpaperscissors.model;

public enum Move {
	
	ROCK, PAPER, SCISSORS;

	/**
	 * Decide who is the winner beetwen two moves 0:Draw, 1:First, 2:Second
	 * 
	 * @param move1
	 * @param move2
	 * @return
	 */
	public static int winner(Move move1, Move move2) {
		int win;
		if((move1==null)||(move2==null))
			win=-1;
		else if (move1.equals(move2))
			win = 0;
		else if (move1.equals(Move.ROCK))
			win = move2.equals(Move.SCISSORS) ? 1 : 2;
		else if (move1.equals(Move.PAPER))
			win = move2.equals(Move.ROCK) ? 1 : 2;
		else if (move1.equals(Move.SCISSORS))
			win = move2.equals(Move.PAPER) ? 1 : 2;
		else
			win = -1;
		return win;
	}
	
	public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
