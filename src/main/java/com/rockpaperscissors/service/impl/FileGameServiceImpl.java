package com.rockpaperscissors.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rockpaperscissors.model.Game;
import com.rockpaperscissors.model.Resume;
import com.rockpaperscissors.service.GameService;

@Service
public class FileGameServiceImpl implements GameService {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private BufferedWriter writer;

	/**
	 * @param nameFile
	 * @param pathFile
	 */
	public FileGameServiceImpl(@Value("${file.name}") String nameFile, @Value("${file.path}") String pathFile) {

		File directory = new File(pathFile);
		if (!directory.exists()) {
			directory.mkdir();
		}

		File file = new File(pathFile + "/" + nameFile);
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			writer = new BufferedWriter(fw);
		} catch (IOException e) {
			LOGGER.error("File {} couldn't be opened.", nameFile);
			e.printStackTrace();
		}
	}

	@Override
	public void printGame(Game game) {
		try {
			print(game.toString());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void printResume(Resume resume) {
		try {
			print(resume.toString());
			writer.newLine();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void print(String s) throws IOException {
		writer.append(s);
		writer.newLine();
	}

	@PreDestroy
	public void cleanUp() throws Exception {
		writer.close();
	}

}
