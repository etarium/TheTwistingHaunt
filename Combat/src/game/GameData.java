package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import items.Equipable;
import items.KeyItems;
import items.Usable;

public class GameData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 346156002131066312L;
	private Player player;
    private Cell[][][] cellList;
    private ArrayList<Usable> usableList;
    private ArrayList<Equipable> equipList;
    private ArrayList<KeyItems> keyList;
    private ArrayList<Encounter> encList;
    
    final static String DIR = "src/db_save/";
    final static String FILE = "warriorSave";
    final static String FILE_PATH = DIR + FILE + "";
    
    

	public GameData() {
    	
    }
    
    public GameData(Player player, Cell[][][] cellList, ArrayList<Usable> usableList,ArrayList<Equipable> equipList,
    		ArrayList<KeyItems> keyList, ArrayList<Encounter> encList) {
    	
    		this.player = player;
    		this.cellList = cellList;
    		this.equipList = equipList;
    		this.usableList = usableList;
    		this.keyList = keyList;
    		this.encList = encList;
    		
    }
    
    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Cell[][][] getCellList() {
		return cellList;
	}

	public void setCellList(Cell[][][] cellList) {
		this.cellList = cellList;
	}

	public ArrayList<Usable> getUsableList() {
		return usableList;
	}

	public void setUsableList(ArrayList<Usable> usableList) {
		this.usableList = usableList;
	}

	public ArrayList<Equipable> getEquipList() {
		return equipList;
	}

	public void setEquipList(ArrayList<Equipable> equipList) {
		this.equipList = equipList;
	}

	public ArrayList<KeyItems> getKeyList() {
		return keyList;
	}

	public void setKeyList(ArrayList<KeyItems> keyList) {
		this.keyList = keyList;
	}

	public ArrayList<Encounter> getEncList() {
		return encList;
	}

	public void setEncList(ArrayList<Encounter> encList) {
		this.encList = encList;
	}
	
public String serializeGameData(GameData data) {
		
		String outFileName = FILE_PATH;
		File newFile = new File(outFileName);
		
		try {
			  
			  FileOutputStream fileOut = new FileOutputStream(newFile);
			  ObjectOutputStream out = new ObjectOutputStream(fileOut);
			  out.writeObject(data);
			  
			  out.close();
			  fileOut.close();
			  
			} catch (IOException i) {
			  i.printStackTrace();
			}
		
		return outFileName;
    }
    
    public  GameData deserializeGameData(String fileName){
		
		File loadFile = new File(FILE_PATH);
		
		GameData loadedData = null;
		
		try {
		FileInputStream fileIn = new FileInputStream(loadFile);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		loadedData = (GameData) in.readObject();
		
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
		
		return loadedData;
	}
    
    public GameData returnWarriorInstance() {
    		
    		GameData warriorGame = this.deserializeGameData(FILE_PATH);
    		return warriorGame;
    }
    
    
}