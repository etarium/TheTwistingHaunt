package gui.classes;

public class GUI_Client {

	static PlayWindow play;
	static MainMenu mainMenu;
	static HelpWindow help;
	static NewGameWindow newGame;
	static LoadGameWindow loadGame;

	public static void main(String [] args) throws Exception {


		//new HelpWindow();
		play = new PlayWindow();
		//mainMenu = new MainMenu();
		//newGame = new NewGameWindow();
		//loadGame = new LoadGameWindow();
		

	}
	
	public static PlayWindow getPlayWindow() {
		return play;
	}
	

}
