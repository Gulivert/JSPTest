package com.lottoland;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockpaperscissorsApplicationTests {

	@Test
	public void gameTest() {
		Player player1 = new Player("ROCK");
		Player player2 = new Player("RANDOM");
		Game game = new Game(player1, player2);
		assertThat(game.getWinner(),not(-1));
	}

}
