package uiView.classes;

import utilities.Logs;

public class GUI_Client {

	static PlayWindow play;

	public static PlayWindow getPlayWindow() {
		Logs.LOGGER.info("GUI_Client.getPlayWindow()");
		play = new PlayWindow();
		System.out.println(play);
		return play;
	}


}
