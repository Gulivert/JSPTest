package com.lottoland.rockpaperscissors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lottoland.rockpaperscissors.model.Game;
import com.lottoland.rockpaperscissors.model.Move;
import com.lottoland.rockpaperscissors.model.Player;
import com.lottoland.rockpaperscissors.model.Resume;
import com.lottoland.rockpaperscissors.model.impl.ConstantPlayer;
import com.lottoland.rockpaperscissors.model.impl.RandomPlayer;
import com.lottoland.rockpaperscissors.service.GameService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockpaperscissorsApplicationTests {
	
	@Autowired
	GameService gameService;
	
	@Test
	public void gameTest() {
		Player player1 = new RandomPlayer();
		Player player2 = new ConstantPlayer(Move.ROCK);
		Game game = new Game(player1, player2);
		assertThat(game.getWinner(),not(-1));
	}
	
	@Test
	public void equalCaseTest() {
		Player player1 = new ConstantPlayer(Move.ROCK);
		Player player2 = new ConstantPlayer(Move.ROCK);
		Game game = new Game(player1, player2);
		assertThat(game.getWinner(),is(0));
	}
	
	@Test
	public void serviceTest() {
		assertTrue(gameService.getAllGames().isEmpty());
		
		Player player1 = new ConstantPlayer(Move.PAPER);
		Player player2 = new ConstantPlayer(Move.ROCK);
		Game game = new Game(player1, player2);
		
		gameService.addGame(game);
		assertFalse(gameService.getAllGames().isEmpty());
	}
	
	@Test
	public void resumeTest() {
		Resume resume = new Resume();
		resume.incrementP1Wins();
		resume.incrementP2Wins();
		resume.incrementDraws();
		assertThat(resume.getRounds(), is(3));
	}

}
