package com.rockpaperscissors.model;

public class Resume {

	private int rounds;
	private int p1Wins;
	private int p2Wins;
	private int draws;
	
	public int getRounds() {
		return rounds;
	}

	public int getP1Wins() {
		return p1Wins;
	}

	public int getP2Wins() {
		return p2Wins;
	}

	public int getDraws() {
		return draws;
	}

	private void incrementP1Wins() {
		this.p1Wins++;
		this.rounds++;
	}

	private void incrementP2Wins() {
		this.p2Wins++;
		this.rounds++;

	}

	private void incrementDraws() {
		this.draws++;
		this.rounds++;

	}

	public void incrementWinner(int winner) {
		switch (winner) {
		case 0:
			incrementDraws();
			break;
		case 1:
			incrementP1Wins();
			break;
		case 2:
			incrementP2Wins();
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rounds = ");
		builder.append(rounds);
		builder.append(",  Player 1 wins = ");
		builder.append(p1Wins);
		builder.append(",  Player 2 wins = ");
		builder.append(p2Wins);
		builder.append(",  Draws = ");
		builder.append(draws);
		return builder.toString();
	}

}
