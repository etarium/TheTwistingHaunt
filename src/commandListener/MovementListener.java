package commandListener;

import gameplay.commandServices.MovementService;
import uiView.UIMain;
import utilities.Logs;

public class MovementListener {

	public Reply listen(String command) {
		MovementService system = new MovementService();

		String output = "";
		//String upperOutput = UIMain.player.currentCell.getDescription();
		String failedMovementOutput = "You'd like to go that way, wouldn't you?";
		String newUpperOutput = "";
		boolean isSuccessful = true;
		switch (command) {
		//determines if movement can be made in the direction sent by the user
		//direction is parsed from /command and streamlined into a single character: n, s, e, or w
		//	so the input for applicable methods should rely on that passed char
		//if UIMain.player can move that direction, sets new current cell and outputs that cell's description
		//if not, outputs some sort of error to user
		case "/north":
		case "/n":
		case "/south":
		case "/s":
		case "/east":
		case "/e":
		case "/west":
		case "/w":

			char direction = command.charAt(1);
			String upperOutput = UIMain.player.currentCell.getDescription();
			switch (direction) {
			case 'n':
				

				newUpperOutput = system.moveNorth(direction);

				if(!upperOutput.equals(newUpperOutput)) {
					output = "You move to the north.";
					upperOutput = newUpperOutput;
				} else {
					output = failedMovementOutput;
				}

				break;
			case 's':

				newUpperOutput = system.moveSouth(direction);

				if(!upperOutput.equals(newUpperOutput)) {
					output = "You move to the south.";
					upperOutput = newUpperOutput;
				} else {
					output = failedMovementOutput;
				}

				break;
			case 'e':

				newUpperOutput = system.moveEast(direction);
				if(!upperOutput.equals(newUpperOutput)) {
					output = "You move to the east.";
					upperOutput = newUpperOutput;
				} else {
					output = failedMovementOutput;
				}

				break;
			case 'w':

				newUpperOutput = system.moveWest(direction);

				if(!upperOutput.equals(newUpperOutput)) {
					output = "You move to the west.";
					upperOutput = newUpperOutput;
				} else {
					output = failedMovementOutput;
				}

				break;

			default:
				Logs.LOGGER.severe("Hit default case in commandListener.MovementListener.listen within internal switch. No movement possible.");
				isSuccessful = false;
			}

			break;
		default:
			Logs.LOGGER.info("Hit default case in commandListener.MovementListener.listen with command " + command);
			isSuccessful = false;
		}//end switch

		return new Reply(isSuccessful, output, newUpperOutput);
	}
}
