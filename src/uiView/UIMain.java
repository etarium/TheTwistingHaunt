package uiView;

import java.io.IOException;

import db.api.CellAPI;
import pojos.entity.PlayerEntity;
import uiView.classes.CommandListener;
import uiView.classes.GUI_Client;
import uiView.classes.LoadGameWindow;
import uiView.classes.MainMenu;
import uiView.classes.NewGameWindow;
import uiView.classes.PlayWindow;
import utilities.Logs;

public class UIMain {
	
    final static String INSTANCE = "Test Instance";
    public static PlayWindow play;
    private static PlayerEntity player;
    static CellAPI cellService = new CellAPI();
    
    final static boolean DEBUG_LOAD = false;
    final boolean DEBUG_SAVE = false;
    
	public static void main (String [] args) {
		/* CellAPI apiCaller = new CellAPI();
		
		List<Cell> cells = apiCaller.getCellsFromInstance("Test Instance");
		cells.forEach(cell -> {
			System.out.println(cell.getDescription());
			System.out.println(cell.getInstance());
			System.out.println(cell.getTerrain());
			System.out.println(cell.getEnemies());
			System.out.println(cell.getLocation());
			System.out.println(cell.getItems());
		});
		*/
		//CommandListener ear = new CommandListener();

		 MainMenu menu = new MainMenu();
	        boolean nGame = menu.getNGame();
	        if(nGame == true){//open new game window
	            NewGameWindow window = new NewGameWindow();
	            player = window.getNewPlayer();

	        }
	        else{   //load game
	            new LoadGameWindow();
	        }
	        
	        
	        try{
	        GUI_Client.main(null);
	        play = GUI_Client.getPlayWindow();
	        Logs.LOGGER.info("Play Window launched.");
	        } catch(Exception e) {
	        	Logs.LOGGER.severe("Exception when trying to play GUI_Client.getPlayWindow()");
	        }
	        
	        try{
	            newGame();
	            Logs.LOGGER.info("New Game started");
	        }catch(Exception e){
	            Logs.LOGGER.severe("Exception when trying to load newGame()");
	            Logs.LOGGER.severe(e.toString());
	        } 
	        boolean run = true;
	        int count = 0;
	    }
	
    public static void newGame() throws IOException {
        // create new instance of the game for the player using the input from the creator
        //save player

        if(!DEBUG_LOAD) {
        		cellService.getCellsFromInstance(INSTANCE);
        }
//        else {
//        		loadGameTest();
//        }
        
    }

    /*
 // TODO: Can probably delete everything below this point. Should be in the back-end.
  
    public void loadInstance(String instance) throws IOException {
    		
    		cells = cellService.getCellsFromInstance("Test Instance");
    		
    }
    */
    
}
