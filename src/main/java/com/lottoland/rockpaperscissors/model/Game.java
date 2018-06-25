package com.lottoland.rockpaperscissors.model;

public class Game {
	
	private Move movePlayer1;
	private Move movePlayer2;
	private int winner;
	
	public Game(Player player1, Player player2) {
		this.movePlayer1 = player1.getMove();
		this.movePlayer2 = player2.getMove();
		this.winner = Move.winner(this.movePlayer1, this.movePlayer2);
	}

	/**
	 * Get the value movePlayer1.
	 * @return the movePlayer1 
	 */
	public Move getMovePlayer1() {
		return movePlayer1;
	}

	/**
	 * Get the value movePlayer2.
	 * @return the movePlayer2 
	 */
	public Move getMovePlayer2() {
		return movePlayer2;
	}

	/**
	 * Get the value winner.
	 * @return the winner 
	 */
	public int getWinner() {
		return winner;
	}

	/**
	 * Set the value movePlayer1.
	 * @param movePlayer1 the movePlayer1 to set
	 */
	public void setMovePlayer1(Move movePlayer1) {
		this.movePlayer1 = movePlayer1;
	}

	/**
	 * Set the value movePlayer2.
	 * @param movePlayer2 the movePlayer2 to set
	 */
	public void setMovePlayer2(Move movePlayer2) {
		this.movePlayer2 = movePlayer2;
	}

	/**
	 * Set the value winner.
	 * @param winner the winner to set
	 */
	public void setWinner(int winner) {
		this.winner = winner;
	}
	
}
