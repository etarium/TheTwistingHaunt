package gui.classes;

import game.Cell;
import game.Encounter;
import game.Equipable;
import game.KeyItems;
import game.Location;
import game.ObjectComparator;
import game.Player;
import game.Usable;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JTextArea;
import querymachine.QueryMachine;

public class CommandListener {
    final String INSTANCE = "DN1";
    public static PlayWindow play;
    private Player player;
    private Cell[][][] cellList;
    private ArrayList<Usable> usableList;
    private ArrayList<Equipable> equipList;
    private ArrayList<KeyItems> keyList;
    private ArrayList<Encounter> encList;

    public CommandListener() {
        MainMenu menu = new MainMenu();
        boolean nGame = menu.getNGame();
        if(nGame == true){//open new game window
            NewGameWindow window = new NewGameWindow();
            this.player = window.getNewPlayer();

        }
        else{   //load game
            new LoadGameWindow();
        }
        
        
        try{
        GUI_Client.main(null);
        play = GUI_Client.getPlayWindow();
        } catch(Exception e) {
        	System.out.print("Exception");
        }
        try{
            newGame();
        }catch(Exception e){
            System.out.print("Hah got one!");
        }
        boolean run = true;
        int count = 0;
        while(run) {
        			
        			System.out.println("Iteration " + ++count);        			
        			listen(play , run);
        		}
    }

    /**
     * Uses parsed input in a {command}{parameter} format in order to filter
     * user input based on help file commands Input comes from JTextField and
     * output goes to JTextArea, both in PlayWindow class.
     *
     * Every /command should generate some sort of output for the user to see
     * the effect of their actions. If no command is recognized, then output
     * warns user of an invalid input, referencing the help file for more
     * instructions.
     *
     * Case-switch determines which methods or blocks of code are run, and which
     * output is to be sent to the JTextArea for the user to see.
     *
     *
     *
     * @param play Instance of play window in which the input/output can be
     * found
     * @param run Boolean representing whether or not the listener loop should
     * still run after current iteration
     */
    public void listen(PlayWindow play, boolean run) {

        String[] stringArray = inputParser(play.requestInput());
        
        String command = stringArray[0];
        String parameter = stringArray[1];
        
        
        String output = "";
        //String copycat = "/" + play.getOutputBox().getText();

        switch (command) {

            //if no parameter is present in the {command}{parameter} structure, then output is set
            //	to current room's description
            //otherwise, parameter may fall into entity, item, equipment, etc., and should be output
            //	based upon that
            case "/look":
                //inspect room
                if (parameter == null) {
                    //TO_DO
                    output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                } //inspect object of command
                else {
                    //TO_DO
                    output = "You can look all day, but you still won't find it, " + this.player.getName() + ".";

                }
                break;
                

            case "/take":
            		if (parameter == null) {
                    //TO_DO
                    output = "Oh, come one. You've got to give me more info than that!";
                } //inspect object of command
                else {
                    //TO_DO
                    output = "You can look all day, but you still won't find it, " + this.player.getName() + ".";

                }
                break;

            case "/drop":
            		if (parameter == null) {
                    //TO_DO
                    output = "Stop, drop, and roll is often useful, but not here.";
                } //inspect object of command
                else {
                    //TO_DO
                    output = "You can look all day, but you still won't find it, " + this.player.getName() + ".";

                }
                break;

            case "/use":
            		if (parameter == null) {
                    //TO_DO
                    output = "Giving more information would be ... USEful.";
                } //inspect object of command
                else {
                    //TO_DO
                    output = "You can look all day, but you still won't find it, " + this.player.getName() + ".";

                }
                break;

            case "/equip":
            		if (parameter == null) {
                    //TO_DO
                    output = "Are you sure you're equipped for this task if you can't give me more information?";
                } //inspect object of command
                else {
                    //TO_DO
                    output = "You can look all day, but you still won't find it, " + this.player.getName() + ".";

                }
                break;

            case "/inventory":
            case "/inv":
            	
            		if(this.player.getItemList() == null) {
            			output = "Nothing to see here.";
            		}
            		else if(this.player.getItemList().isEmpty()) {
            			output = "You don't have anything in your backpack. Poor you.";
            		}
            		else {
            			for(Usable item : player.getItemList()) {
            				output += item.getName() + "\n";
            			}
            		}
            		
            	
                break;

            case "/equipment":
            		Equipable armor = this.player.getWornArmor();
            		Equipable weapon = this.player.getUsedWeapon();
            		
	            	if(armor == null && weapon == null) {
	        			output = "You might as well be naked! Maybe that's why the villagers ushered you into this cave...\n\nHmmmm.....";
	        		}
	        		else {
	        			if(armor != null) {
	        				output += "You are wearing " + armor.getName() + ".\n";
	        			}
	        			if(weapon != null) {
	        				output += "You are wielding " + weapon.getName() + ".\n";
	        			}
	        		}
            	
                break;

            case "/status":
            case "/stats":
                output = this.player.printEntityInfo();
                break;

            //determines if movement can be made in the direction sent by the user
            //direction is parsed from /command and streamlined into a single character: n, s, e, or w
            //	so the input for applicable methods should rely on that passed char
            //if player can move that direction, sets new current cell and outputs that cell's description
            //if not, outputs some sort of error to user
            case "/north":
            case "/n":
            case "/south":
            case "/s":
            case "/east":
            case "/e":
            case "/west":
            case "/w":

                char direction = command.charAt(1);

                output = "You'd like to go that way, wouldn't you?";
                switch (direction) {
                    case 'n':
                        //check to see of movement possible
                        if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isNorth()) {
                            player.getLocation().setY(player.getLocation().getY() + 1);
                            output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                        }

                        break;
                    case 's':
                        //check to see of movement possible
                        if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isSouth()) {
                            player.getLocation().setY(player.getLocation().getY() - 1);
                            output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                        }
                        break;
                    case 'e':
                        //check to see of movement possible
                        if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isEast()) {
                            player.getLocation().setX(player.getLocation().getX() + 1);
                            output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                        }
                        break;
                    case 'w':
                        //check to see of movement possible
                        if (cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].isWest()) {
                            player.getLocation().setX(player.getLocation().getX() - 1);
                            output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                        }
                        break;
                    default:
                        output = "This should never happen, please contact your nearest dev.";

                }

                break;

            case "/help":
                output = "Your cries for help go answered, and text appears before your eyes.";
                new HelpWin();
                break;

            case "/quit":
                output = "Next time, hero.";
                run = false;
                //new MainMenu();
                play.exitGame();
                play = null;
                break;

            case "/save":
                		output = "You're past the point of no return.";
            		//play.outGUI("Enter the name of your save file.\n)"
                //       + "WARNING: Duplicating a save file name will override the original save.");
                //String fileName = play.requestInput();
                //output = "TEST SAVE";
                break;
                
            //case copycat:
            //		output = "HEY! Stop copying me!";
            //		break;

            //if command is not recognized, outputs a flavorful error and references the /help command for assistance
            default:
                output = "Your mutterings echo softly, but go unanswered.\n"
                        + "[try again, or type '/help' for assistance]";
                break;

        }//end switch

        //sends output generated from user selection to the GUI window
        play.outGUI(output);

    }//end commandListener()
    
    
    //WIP
    private Object parseParameter(String parameter) {
    	
    		Object someObject = null;
    	
    		Cell currentCell = player.getCurrentCell(cellList);
    		
    		ObjectComparator comp = new ObjectComparator();
    		
    		

    	    //private ArrayList<Usable> usableList;
    	    //private ArrayList<Equipable> equipList;
    	    //private ArrayList<KeyItems> keyList;
    	    //private ArrayList<Encounter> encList;
    		String test = currentCell.getEncounter();
    		
    		int usableIndex = comp.isPresentUsable(currentCell.getItem(), usableList);
    		int equipIndex = comp.isPresentEquipable(currentCell.getItem(), equipList);
    		int keyIndex = comp.isPresentKeyItem(currentCell.getKeyItem(), keyList);
    		//int entityIndex = equipIndex;
    		
    		/*
    		Encounter enc = currentCell.getEncounter()
    		if( index > -1) {
    			if equipList.get(index).getName().equals(parameter){
    				return
    			}
    			
    		}
    		*/
    		
    		
    
    		return someObject;
    }
    

    /**
     * Parses input into an array with the format {verb},{object}. If no
     * parameter is present, that field will be null.
     *
     * @param input
     * @return String array with command and parameter.
     */
    public String[] inputParser(String input) {

        String[] stringArray = new String[2];

        input = input.trim().toLowerCase();

        boolean containsSpace = input.contains(" ");

        //will be -1 if no space present
        int indexOfSpace = input.indexOf(" ");

        stringArray[0] = (containsSpace) ? input.substring(0, input.indexOf(" ")) : input;
        stringArray[1] = (containsSpace) ? input.substring(indexOfSpace + 1) : null;

        return stringArray;

    }

    public void newGame() throws SQLException, IOException {
        // create new instance of the game for the player using the input from the creator
        //save player
    		Location tempLoc = new Location();
    		player.setLocation(tempLoc);
    	
        player.getLocation().setX(0);
        player.getLocation().setY(3);
        player.getLocation().setZ(0);
        System.out.print("ayylmao");
        loadInstance(INSTANCE);
    }

    public void loadInstance(String instance) throws SQLException, IOException {
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

}
