package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import items.Equipable;
import items.KeyItems;
import items.Usable;
import querymachine.QueryMachine;

/**
 *
 * @author jason
 */
public class Client {

    final String INSTANCE = "DN1";

    private Player player;
    private Cell[][][] cellList;
    private ArrayList<Usable> usableList;
    private ArrayList<Equipable> equipList;
    private ArrayList<KeyItems> keyList;
    private ArrayList<Encounter> encList;
    

    public Client() {
    }

    public void newGame(Player player, JTextArea output) throws SQLException, IOException {
        // create new instance of the game for the player using the input from the creator
        //save player
        this.player = player;
        
        //loadInstance(INSTANCE, output);
    }

    public void loadGame() {
        //load game for play

    }

    public String move(char input) {
        String output = "You'd like to go that way, wouldn't you?";
        switch (input) {
            case 'n':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isNorth()) {
                    player.getLocation().setY(player.getLocation().getY()+1);
                    output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].toString();
                }
                
                break;
            case 's':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isSouth()) {
                    player.getLocation().setY(player.getLocation().getY()-1);
                    output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].toString();
                }
                break;
            case 'e':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isEast()) {
                    player.getLocation().setX(player.getLocation().getX()+1);
                    output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].toString();
                }
                break;
            case 'w':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isWest()) {
                    player.getLocation().setX(player.getLocation().getX()-1);
                    output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].toString();
                }
                break;
            default:
                output = "This should never happen, please contact your nearest dev.";

        }
        return output;

    }

    public void loadInstance(String instance, JTextArea output) throws SQLException, IOException {
        //execute query for cells in instance
        QueryMachine theDestroyer = new QueryMachine();
        ArrayList<Cell> cellobj;
        cellobj = theDestroyer.getCellInstance(instance);
        ArrayList<Usable> usableobj;
        usableobj = theDestroyer.getHPUsableInstance(cellobj);
        usableobj = theDestroyer.getSPUsableInstance(cellobj, usableobj);
        ArrayList<Equipable> equipableobj;
        equipableobj = theDestroyer.getArmorInstance(cellobj);
        ArrayList<KeyItems> keyitemobj;
        keyitemobj = theDestroyer.getKeyItemsInstance(cellobj);
        ArrayList<Encounter> encounterobj;
        encounterobj = theDestroyer.getEncounterInstance(cellobj);
        Cell[][][] cellArray = theDestroyer.getCellArray(cellobj);
        cellList = cellArray;
        usableList = usableobj;
        equipList = equipableobj;
        encList = encounterobj;
        keyList = keyitemobj;
        
    }

    public void saveGame() {
        //save game state for later loading
    }

}
