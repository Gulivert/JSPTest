package com.rockpaperscissors.test;

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

import com.rockpaperscissors.model.Game;
import com.rockpaperscissors.model.Move;
import com.rockpaperscissors.model.Player;
import com.rockpaperscissors.model.Resume;
import com.rockpaperscissors.model.impl.ConstantPlayer;
import com.rockpaperscissors.model.impl.RandomPlayer;
import com.rockpaperscissors.service.GameService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockpaperscissorsApplicationTests {

	@Autowired
	private GameService gameService;

	@Test
	public void gameTest() {
		Player player1 = new RandomPlayer();
		Player player2 = new ConstantPlayer(Move.ROCK);
		Game game = new Game(player1, player2);
		assertThat(game.getWinner(), not(-1));
	}

	@Test
	public void equalCaseTest() {
		Player player1 = new ConstantPlayer(Move.ROCK);
		Player player2 = new ConstantPlayer(Move.ROCK);
		Game game = new Game(player1, player2);
		assertThat(game.getWinner(), is(0));
	}

	@Test
	public void resumeTest() {
		Resume resume = new Resume();
		resume.incrementWinner(0);
		resume.incrementWinner(1);
		resume.incrementWinner(2);
		assertThat(resume.getRounds(), is(3));
	}

}
