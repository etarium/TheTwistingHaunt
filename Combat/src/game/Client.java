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

    public void newGame(Player player, JTextArea output) throws SQLException, IOException {
        // create new instance of the game for the player using the input from the creator
        //save player
        this.player = player;
        loadInstance(INSTANCE, output);
    }

    public void loadGame() {
        //load game for play

    }

    public String move(char input) {
        
        switch (input) {
            case 'n':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isNorth()) {
                    player.getLocation().setY(player.getLocation().getY()+1);
                    return cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                }
                
                break;
            case 's':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isSouth()) {
                    player.getLocation().setY(player.getLocation().getY()-1);
                    return cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                }
                break;
            case 'e':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isEast()) {
                    player.getLocation().setX(player.getLocation().getX()+1);
                    return cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                }
                break;
            case 'w':
                //check to see of movement possible
                if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isWest()) {
                    player.getLocation().setX(player.getLocation().getX()-1);
                    return cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                }
                break;
            default:
                return "This should never happen, please contact your nearest dev.";

        }
        return "This should never happen, please contact your nearest dev.";

    }

    public void loadInstance(String instance, JTextArea output) throws SQLException, IOException {
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
        Cell[][][] cellArray = theDestroyer.getCellArray(cellobj);

    }

    public void saveGame() {
        //save game state for later loading
    }

}
