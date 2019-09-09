package commandListener;

import gameplay.commandServices.PlayerService;
import uiView.UIMain;
import utilities.Logs;

public class PlayerListener {

	public Reply listen(String command, String parameter) {
		PlayerService system = new PlayerService();
		
		String output = "";
		boolean isSuccessful = true;
		//only use, equip, inventory, and stats can be used inside of battle
		switch(command) {
		case "/take":
			if(UIMain.player.isInEncounter) {
				output = "Looking around, you see imminent danger. You have to defeat the enemies before looting them!";
			} else {
			output = system.takeItem(parameter);
			}
			break;

		case "/drop":
			if(UIMain.player.isInEncounter) {
				output = "Looking around, you see imminent danger. You probably shouldn't unload your loot right now.";
			} else {
			output = system.dropItem(parameter);
			}
			break;
			
		case "/rest":
			if(UIMain.player.isInEncounter || !UIMain.player.currentCell.canRest()) {
				output = "Looking around, you see imminent danger. Resting here would not be wise.";
			} else {
				output = system.rest();
			}
			break;
			
		case "/use":
			output = system.useItem(parameter);
			break;

		case "/equip":
			output = system.equipItem(parameter);
			break;

		case "/inventory":
		case "/inv":
			output = system.inventory();
			break;

		case "/equipment":
			output = system.equipment();
			break;
			
		case "/status":
		case "/stats":
			output = system.getPlayerStats();
			break;
			
		default:
			Logs.LOGGER.info("Hit default case in commandListener.InventoryListener.listen with command " + command);
			isSuccessful = false;
		}//ends switch

		return new Reply(isSuccessful, output);
	}
}
