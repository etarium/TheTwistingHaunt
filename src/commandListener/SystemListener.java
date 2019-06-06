package commandListener;

import gameplay.commandServices.GameService;
import pojos.entity.PlayerEntity;
import utilities.Logs;

public class SystemListener {

	public Reply listen(String command, GameService system, PlayerEntity player) {

		String output = "";
		boolean success = true;
		
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

		default:
			Logs.LOGGER.info("Hit default case in commandListener.SystemListener.listen with command " + command);
			success = false;
			break;

		}
		
		return new Reply(success, output);
	}
}
