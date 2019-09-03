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
		String encryptionKey = "encrypted1234567";
		byte[] encryptionKeyBytes = encryptionKey.getBytes();
		File dir = new File(rootPath+saveLoc+parameter);
		dir.mkdir();
	
		try {
			Cipher cipher = Cipher.getInstance("AES");
			SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
		    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		    byte[] encryptedPlayer = cipher.doFinal((""+UIMain.player).getBytes());
		    byte[] encryptedCells = cipher.doFinal((""+UIMain.cells).getBytes());
			mapper.writeValue(new File(dir+"/player-save.txt"),encryptedPlayer);
			mapper.writeValue(new File(dir+"/cells-save.txt"), encryptedCells);
			Logs.LOGGER.info("Successfully saved " + UIMain.player);
		} catch (Exception e) {
			e.printStackTrace();
			Logs.LOGGER.severe("Unable to save game state,");
		}
	}
	
	public void loadGame(String selected) {
		selected = "/"+selected;
		String rootPath = System.getProperty("user.dir");
		String saveLoc = config.getProperty("save.location");
		File dir = new File(rootPath+saveLoc+selected);
		try {
			Logs.LOGGER.info("Opening Save " + dir); 
			
			File playerFile = new File (dir+"/player-save.txt");
			File cellsFile = new File (dir+"/cells-save.txt");
			
			UIMain.player = mapper.readValue(playerFile,  PlayerEntity.class);
			UIMain.cells = mapper.readValue(cellsFile, new TypeReference<List<Cell>>(){});

			Logs.LOGGER.info("Loaded player-save from " + selected);
			Logs.LOGGER.info("Loaded cell-save from " + dir);
			
		} catch (IOException e ){
			Logs.LOGGER.severe("Could not load save " + dir);
		}
	}
	
	public void options() {
		
	}
}
