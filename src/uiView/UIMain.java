package uiView;

import java.io.IOException;

import gameplay.commandServices.GameService;
import gameplay.newGame.PlayerInitializer;
import pojos.entity.PlayerEntity;
import commandListener.Init;
import uiView.classes.GUI_Client;
import uiView.classes.LoadGameWindow;
import uiView.classes.MainMenu;
import uiView.classes.NewGameWindow;
import uiView.classes.PlayWindow;
import utilities.Logs;

public class UIMain {
	
    public static PlayWindow play;
    private static PlayerEntity player;
    static PlayerInitializer playerinit = new PlayerInitializer();
    public static Init init = new Init();
    
    final static boolean DEBUG_LOAD = false;
    final boolean DEBUG_SAVE = false;
    
	public static void main (String [] args) {

		 MainMenu menu = new MainMenu();
	        boolean nGame = menu.getNGame();
	        if(nGame == true){//open new game window
	            NewGameWindow window = new NewGameWindow();
	            //player = window.getNewPlayer();

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
	           // Logs.LOGGER.severe(e.getMessage().toString());
	          //  Logs.LOGGER.severe(e.toString());
	        } 
	        boolean run = true;
	        while(run) {
	            GameService system = new GameService(play, run);
    				init.initializeListeners(play, system);	
    			}
	    }
	
    public static void newGame() throws IOException {
        // create new instance of the game for the player using the input from the creator
        //save player

        if(!DEBUG_LOAD) {
        		
        		playerinit.initializePlayer(true);
        		Logs.LOGGER.info(player.toString());
        }
//        else {
//        		loadGameTest();
//        }
        
    }
    
}
