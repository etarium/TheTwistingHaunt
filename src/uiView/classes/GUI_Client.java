package uiView.classes;

import commandListener.Init;
import gameplay.commandServices.GameService;
import gameplay.newGame.PlayerInitializer;
import pojos.entity.PlayerEntity;
import utilities.Logs;

public class GUI_Client {

	static PlayWindow play;
	static MainMenu mainMenu;
	static HelpWin help;
	static NewGameWindow newGame;
	static LoadGameWindow loadGame;
	static PlayerInitializer playerinit = new PlayerInitializer();
//	static PlayerEntity player;
	static Init init = new Init();

	public static void main(String [] args) throws Exception {


		//new HelpWindow();
            //    mainMenu = new MainMenu();
		play = new PlayWindow();
		
         //CommandListener ear = new CommandListener();
		//newGame = new NewGameWindow();
		//loadGame = new LoadGameWindow();
		

	}
	
	public static PlayWindow getPlayWindow() {
		Logs.LOGGER.info("GUI_Client.getPlayWindow()");
		//GameService system = new GameService(play, true);
		//init.initializeListeners(play, system, player);
		return play;
	}
	

}
