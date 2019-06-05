package commandListener;

import gameplay.commandServices.InventoryService;
import pojos.entity.PlayerEntity;

public class InventoryListener {

	public Reply listen(String command, String parameter, PlayerEntity player) {
		InventoryService system = new InventoryService(player);
		
		String output = "";
		boolean isSuccessful = true;
		switch(command) {
		case "/take":
			output = system.takeItem(parameter);
			break;

		case "/drop":
			output = system.dropItem(parameter);
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
			
		}//ends switch

		return new Reply(isSuccessful, output);
	}
}
