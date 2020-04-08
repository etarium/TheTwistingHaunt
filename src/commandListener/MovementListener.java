package commandListener;

import entity.EnemyEntity;
import gameplay.GamePlayConstants;
import gameplay.battle.BattleOrder;
import gameplay.commandServices.MovementService;

import uiView.UIMain;
import utilities.Logs;

public class MovementListener {

	MovementService system = new MovementService();
	
	public Reply listen(String command) {
		
		BattleOrder battle = new BattleOrder();
		String output = "";
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
				
				newUpperOutput = system.moveNorth();

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "north, " + GamePlayConstants.BATTLE_OUTPUT);
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "north.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					output = GamePlayConstants.FAILED_MOVEMENT;
				}

				break;
			case 's':

				newUpperOutput = system.moveSouth();

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "south, " + GamePlayConstants.BATTLE_OUTPUT);
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "south.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					output = GamePlayConstants.FAILED_MOVEMENT;
				}

				break;
			case 'e':

				newUpperOutput = system.moveEast();

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {
						newUpperOutput = newUpperOutput + "\n" + battle.updateBattleOrder();
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "east, " + GamePlayConstants.BATTLE_OUTPUT);
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "east");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					output = GamePlayConstants.FAILED_MOVEMENT;
				}

				break;
			case 'w':

				newUpperOutput = system.moveWest();

				if(!upperOutput.equals(newUpperOutput) && !upperOutput.equals("")) {
					if(UIMain.player.isInEncounter) {

						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "west, " + GamePlayConstants.BATTLE_OUTPUT);
						output = battleOutput(outputBuilder);
					} else {
						outputBuilder.append(GamePlayConstants.SUCCESS_MOVE + "west.");
						outputBuilder.append(restOutput());
						output = outputBuilder.toString();
					}
					upperOutput = newUpperOutput;
				} else {
					output = GamePlayConstants.FAILED_MOVEMENT;
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
