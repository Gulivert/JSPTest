package com.rockpaperscissors.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rockpaperscissors.service.GameService;

@Component
public class GameServiceFactory{
	
	private static GameService consoleGameServiceImpl;
	private static GameService fileGameServiceImpl;
	
	public GameServiceFactory(@Qualifier("consoleGameServiceImpl") GameService consoleGameService,@Qualifier("fileGameServiceImpl") GameService fileGameService) {
		GameServiceFactory.consoleGameServiceImpl = consoleGameService;
		GameServiceFactory.fileGameServiceImpl = fileGameService;
	}

	public static GameService getGameService(Integer mode) {
		GameService game = null;
		switch (mode) {
		case 1:
			game = consoleGameServiceImpl;
			break;
		case 2:
			game = fileGameServiceImpl;
			break;

		default:
			break;
		}
		return game;
	}
}