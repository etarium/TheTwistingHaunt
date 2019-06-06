package uiView.classes;

import utilities.Logs;

public class GUI_Client {

	static PlayWindow play;

	public static void main(String [] args) throws Exception {

		play = new PlayWindow();

	}
	
	public static PlayWindow getPlayWindow() {
		Logs.LOGGER.info("GUI_Client.getPlayWindow()");
		return play;
	}
	

}
