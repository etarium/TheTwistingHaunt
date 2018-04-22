package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PlayerSaveAndLoad {
	
	final static String DIR = "src/saves/";

	public static Player loadPlayer(String fileName){
		
		
		String filePath = DIR + fileName + "";
		
		File loadFile = new File(filePath);
		
		Player loadedPlayer = null;
		
		try {
		FileInputStream fileIn = new FileInputStream(loadFile);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		loadedPlayer = (Player) in.readObject();
		
		in.close();
		fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Player class not found");
			c.printStackTrace();
			return null;
		}
		
		return loadedPlayer;
	}
	
	public static String savePlayer(Player savedPlayer, String fileName) {
		
		String outFileName = DIR + fileName + "";
		File newFile = new File(outFileName);
		
		try {
			  
			  FileOutputStream fileOut = new FileOutputStream(newFile);
			  ObjectOutputStream out = new ObjectOutputStream(fileOut);
			  out.writeObject(savedPlayer);
			  
			  out.close();
			  fileOut.close();
			  
			} catch (IOException i) {
			  i.printStackTrace();
			}
		
		return outFileName;

	}
	
	public static String getSaveDirectory() {
		return DIR;
	}
}
