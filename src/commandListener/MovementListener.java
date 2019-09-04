package commandListener;

import gameplay.commandServices.MovementService;
import pojos.entity.EnemyEntity;
import uiView.UIMain;
import utilities.Logs;

public class MovementListener {

	public Reply listen(String command) {
		MovementService system = new MovementService();

		String output = "";
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

			//if there's a fight, the player cannot move cells.
			if(UIMain.player.isInEncounter) {
				return new Reply(false, output, UIMain.player.currentCell.getDescription());
			}
			
			StringBuilder outputBuilder = new StringBuilder(); 
			
			char direction = command.charAt(1);
			String upperOutput = UIMain.player.currentCell.getDescription();
			switch (direction) {
			case 'n':

				newUpperOutput = system.moveNorth(direction);

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						outputBuilder.append("You move to the north, and find yourself surrounded by ");
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append("You move to the north.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					output = failedMovementOutput;
				}

				break;
			case 's':

				newUpperOutput = system.moveSouth(direction);

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						outputBuilder.append("You move to the south, and find yourself surrounded by ");
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append("You move to the south.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					output = failedMovementOutput;
				}

				break;
			case 'e':

				newUpperOutput = system.moveEast(direction);
				
				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						outputBuilder.append("You move to the east, and find yourself surrounded by ");
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append("You move to the east.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					System.out.println("failed movement east");
					output = failedMovementOutput;
				}

				break;
			case 'w':

				newUpperOutput = system.moveWest(direction);

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						
						outputBuilder.append("You move to the west, and find yourself surrounded by ");
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append("You move to the west.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {;
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

	private String battleOutput(StringBuilder outputBuilder) {
		for(EnemyEntity enemy : UIMain.player.currentCell.getEnemies()) {
			outputBuilder.append(enemy.getName());
			outputBuilder.append(", ");
		}
		outputBuilder.replace(outputBuilder.length()-2, outputBuilder.length(), "!");
		outputBuilder.append("\nQuick, you must fight!");

		return outputBuilder.toString();
	}
	
	private String restOutput() {
		if(UIMain.player.currentCell.canRest()) {
			return "\n\nThis area seems safer than most. It wouldn't be a terrible place to have a short rest. \n"
					+ "[type '/rest' to refill your HP and SP!]";
		}
		return "";
	}
}
