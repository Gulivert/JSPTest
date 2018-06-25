package com.lottoland.rockpaperscissors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lottoland.rockpaperscissors.model.Game;
import com.lottoland.rockpaperscissors.model.Move;
import com.lottoland.rockpaperscissors.model.Player;
import com.lottoland.rockpaperscissors.model.Resume;
import com.lottoland.rockpaperscissors.model.impl.ConstantPlayer;
import com.lottoland.rockpaperscissors.model.impl.RandomPlayer;
import com.lottoland.rockpaperscissors.service.GameService;

@Controller
public class GameController {
	
	GameService gameService;
	Player player1;
	Player player2; 
	
	/**
	 * Constructor.
	 * @param gameService
	 */
	public GameController(GameService gameService) {
		this.gameService = gameService;
		player1 = new ConstantPlayer(Move.ROCK);
		player2 = new RandomPlayer();
	}
	
	/**
	 * Response to the index web.
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("games", gameService.getAllGames());
		model.addAttribute("resume", gameService.getResume().orElse(new Resume()));
		return "index";
	}
	
	/**
	 * Create a new element.
	 * @param model
	 * @return
	 */
	@RequestMapping("/create")
	public String create(Model model) {
		gameService.addGame(new Game(player1, player2));
		model.addAttribute("games", gameService.getAllGames());
		model.addAttribute("resume", gameService.getResume().orElse(new Resume()));
		return "index";
	}
	
	/**
	 * Restart the list.
	 * @param model
	 * @return
	 */
	@RequestMapping("/restart")
	public String restart(Model model) {
		gameService.restartGames();
		model.addAttribute("games", gameService.getAllGames());
		model.addAttribute("resume", gameService.getResume().orElse(new Resume()));
		return "index";
	}
}
