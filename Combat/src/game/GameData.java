package game;

import java.util.ArrayList;

public class GameData {

	private Player player;
    private Cell[][][] cellList;
    private ArrayList<Usable> usableList;
    private ArrayList<Equipable> equipList;
    private ArrayList<KeyItems> keyList;
    private ArrayList<Encounter> encList;
    
    public GameData() {
    	
    }
    
    public GameData(Player player, Cell[][][] cellList, ArrayList<Usable> usableList,ArrayList<Equipable> equipList,
    		ArrayList<KeyItems> keyList, ArrayList<Encounter> encList) {
    	
    		this.player = player;
    		this. cellList = cellList;
    		this.usableList = usableList;
    		
    }
}
