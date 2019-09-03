package gameplay.commandServices;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import uiView.UIMain;
import uiView.classes.HelpWin;
import uiView.classes.PlayWindow;
import utilities.ConfigReader;
import utilities.Logs;

public class GameService {

	PlayWindow play;
	boolean run;

	ObjectMapper mapper = new ObjectMapper();
	ConfigReader config = new ConfigReader();

	public GameService(PlayWindow play, boolean run) {
		this.play = play;
		this.run = run;

	}

	public void quitGame() {
		run = false;
		play.exitGame();
		play = null;
	}

	public void help() {
		//this one might not have needed to be factored out, but it gives us a consistent patter to follow
		new HelpWin();
	}

	public void saveGame(String parameter) {
		String rootPath = System.getProperty("user.dir");
		String saveLoc = config.getProperty("save.location");
		File dir = new File(rootPath+saveLoc+parameter);
		dir.mkdir();

		try {
			mapper.writeValue(new File(dir+"/player-save.txt"), UIMain.player);
			mapper.writeValue(new File(dir+"/cells-save.txt"), UIMain.cells);
			Logs.LOGGER.info("Successfully saved " + UIMain.player);
		} catch (IOException e) {
			e.printStackTrace();
			Logs.LOGGER.severe("Unable to save game state,");
		}
	}

	public void options() {

	}
}
