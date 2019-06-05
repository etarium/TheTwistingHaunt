package gameplay.commandServices;

import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import pojos.items.ConsumableItem;
import pojos.items.Item;
import pojos.items.WeaponItem;
import utilities.Logs;

public class CellService {

	PlayerEntity player = new PlayerEntity();
	
	public CellService(PlayerEntity player) {
		this.player = player;
	}
	
	public String inspectCell() {
		Logs.LOGGER.info(player.toString());
		
		String output = "";
		
 			if(player.getCurrentCell().getInspectableObjects() == null) {
				output = "You search long and hard, but your effort turns up nothing of interest.";
			}
			else {
				output = "By your sharp eyes or by good fortune, you find " + player.getCurrentCell().getInspectableObjects() + "!";
			}
		 
		return output;
	}
	
	public String inspectRoom() {
		/*
		 * TODO
		for(Cell cell : cells) {
			if(cell.getLocation().getX() == player.getLocation().getX() &&
					cell.getLocation().getY() == player.getLocation().getY() &&
					cell.getLocation().getZ() == player.getLocation().getZ()) {
				location = cells.indexOf(cell);
				output = cell.getDescription();
				break;
			}
		}
		*/
		return "";
	}
	
	public String inspectItem() {
		//TODO
		/*
		 * if (looked == null) {
					output = "You can look all day, but you still won't find it, " + this.player.getName() + ".";
				}
				else if(looked instanceof ConsumableItem) {
					output = ((ConsumableItem) looked).getDescription();
				}
				else if(looked instanceof WeaponItem ) {
					output = ((WeaponItem) looked).getDescription();
				}
				else if(looked instanceof Item) {
					output = ((Item) looked).getDescription();

				}

			}
		 */
		return "";
	}
}
