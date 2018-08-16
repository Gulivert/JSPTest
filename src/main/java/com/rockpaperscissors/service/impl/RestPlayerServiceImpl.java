package com.rockpaperscissors.service.impl;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rockpaperscissors.model.Move;
import com.rockpaperscissors.model.Player;
import com.rockpaperscissors.model.impl.ConstantPlayer;
import com.rockpaperscissors.model.impl.RandomPlayer;
import com.rockpaperscissors.service.PlayerService;

@Service
public class RestPlayerServiceImpl implements PlayerService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private String host;

	public RestPlayerServiceImpl(@Value("${remote.host}") String host) {
		this.host = host;
	}

	@Override
	public Player getPlayer() {
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.get("http://" + host + "/getPlayer").header("Accept", "application/json").asJson();
			try {
				String moveName = (String) jsonResponse.getBody().getObject().get("move");
				return new ConstantPlayer(Move.valueOf(moveName));
			} catch (JSONException e) {
				throw new UnirestException("Error: Move hasn't found on rest call.");
			}
		} catch (UnirestException e) {
			LOGGER.error(e.getMessage());
			System.out.println(
					"\nError: It hasn't been posible to recover the remote player, a random player will be recovered by default.");
			return new RandomPlayer();
		}
	}

}
