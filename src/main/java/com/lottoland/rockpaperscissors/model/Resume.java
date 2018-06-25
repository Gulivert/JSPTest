package com.lottoland.rockpaperscissors.model;

public class Resume {
	
	private int rounds;
	private int p1Wins;
	private int p2Wins;
	private int draws;
	
	/**
	 * @return the rounds
	 */
	public int getRounds() {
		return rounds;
	}
	/**
	 * @param rounds the rounds to set
	 */
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	/**
	 * @return the p1Wins
	 */
	public int getP1Wins() {
		return p1Wins;
	}
	/**
	 * @param p1Wins the p1Wins to set
	 */
	public void setP1Wins(int p1Wins) {
		this.p1Wins = p1Wins;
	}
	/**
	 * @return the p2Wins
	 */
	public int getP2Wins() {
		return p2Wins;
	}
	/**
	 * @param p2Wins the p2Wins to set
	 */
	public void setP2Wins(int p2Wins) {
		this.p2Wins = p2Wins;
	}
	/**
	 * @return the draws
	 */
	public int getDraws() {
		return draws;
	}
	/**
	 * @param draws the draws to set
	 */
	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	public void incrementP1Wins() {
		this.p1Wins++;
		this.rounds++;
	}
	
	public void incrementP2Wins() {
		this.p2Wins++;
		this.rounds++;
		
	}
	
	public void incrementDraws() {
		this.draws++;
		this.rounds++;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\tRounds = ");
		builder.append(rounds);
		builder.append("  P1Wins = ");
		builder.append(p1Wins);
		builder.append("  P2Wins = ");
		builder.append(p2Wins);
		builder.append("  Draws = ");
		builder.append(draws);
		return builder.toString();
	}
	
	
	
	
}
