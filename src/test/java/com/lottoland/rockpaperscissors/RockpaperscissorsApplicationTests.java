package com.lottoland.rockpaperscissors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lottoland.rockpaperscissors.model.Game;
import com.lottoland.rockpaperscissors.model.Move;
import com.lottoland.rockpaperscissors.model.Player;
import com.lottoland.rockpaperscissors.model.impl.ConstantPlayer;
import com.lottoland.rockpaperscissors.model.impl.RandomPlayer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockpaperscissorsApplicationTests {

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
	
	

}
