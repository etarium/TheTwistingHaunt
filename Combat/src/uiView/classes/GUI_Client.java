package uiView.classes;

public class GUI_Client {

	static PlayWindow play;
	static MainMenu mainMenu;
	static HelpWin help;
	static NewGameWindow newGame;
	static LoadGameWindow loadGame;

	public static void main(String [] args) throws Exception {


		//new HelpWindow();
		//play = new PlayWindow();
            //    mainMenu = new MainMenu();
                CommandListener ear = new CommandListener();
		//newGame = new NewGameWindow();
		//loadGame = new LoadGameWindow();
		

	}
	
	public static PlayWindow getPlayWindow() {
		return play;
	}
	

}
