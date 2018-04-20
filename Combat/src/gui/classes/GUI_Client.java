package gui.classes;

public class GUI_Client {

	static PlayWindow play;
	static MainMenu mainMenu;
	static HelpWindow help;

	public static void main(String [] args) throws Exception {


		//new HelpWindow();
		play = new PlayWindow();
		//mainMenu = new MainMenu();

	}
	
	public static PlayWindow getPlayWindow() {
		return play;
	}
	

}
