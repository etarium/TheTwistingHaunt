package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import querymachine.QueryMachine;

/**
 *
 * @author jason
 */
public class Client {
    
    final String INSTANCE = "DN1";
    
    private Player player;
    private Cell[][][] cellList;
    
    
    public Client() {
    }
    
    public void newGame(Player player, JTextArea output) throws SQLException, IOException{
        // create new instance of the game for the player using the input from the creator
        //save player
        this.player = player;
        loadInstance(INSTANCE, output);
    }
    
    public void loadGame(){
        //load game for play
        
    }
    
    public void move(char input){
        
        
        switch(input){
            case 'n':
                if(cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isNorth()){
                    
                }
                break;
            case 's':
                
                break;
            case 'e':
                
                break;
            case 'w':
                
                break;
            
        }
        
    }
    
    public void loadInstance(String instance, JTextArea output) throws SQLException, IOException{
        //execute query for cells in instance
    		QueryMachine theDestroyer = new QueryMachine(output);
    		ArrayList<Cell> cellobj;
		cellobj = theDestroyer.getCellInstance(instance);
		ArrayList<Usable> usableobj;
		usableobj = theDestroyer.getHPUsableInstance(cellobj);
		usableobj = theDestroyer.getSPUsableInstance(cellobj, usableobj);
		ArrayList<Equipable> equipableobj;
		equipableobj = theDestroyer.getArmorInstance(cellobj);
		ArrayList<Encounter> encounterobj;
		encounterobj = theDestroyer.getEncounterInstance(cellobj);
		Cell [][][]	cellArray = theDestroyer.getCellArray(cellobj);
		 
        
    }
    
    public void saveGame(){
        //save game state for later loading
    }
    
}


