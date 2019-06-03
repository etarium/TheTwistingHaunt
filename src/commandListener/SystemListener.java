package commandListener;

import utilities.GameCommands;

public class SystemListener {

	public String systemCommandListener(String command, GameCommands system) {
		String output = "";
		switch (command) {
		case "/help":
			output = "Your cries for help go answered, and text appears before your eyes.";
			system.help();
			break;

		case "/quit":
			output = "Next time, hero.";
			system.quitGame();
			break;

		case "/save":
			output = "You're past the point of no return.";
			//play.outGUI("Enter the name of your save file.\n)"
			//       + "WARNING: Duplicating a save file name will override the original save.");
			//String fileName = play.requestInput();
			//output = "TEST SAVE";
			break;


			//if command is not recognized, outputs a flavorful error and references the /help command for assistance
		default:
			output = "Your mutterings echo softly, but go unanswered.\n"
					+ "[try again, or type '/help' for assistance]";
			break;

		}
		
		return output;
	}
}
