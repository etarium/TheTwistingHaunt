package gameplay.commandServices;

import pojos.environment.InspectableObjects;
import pojos.items.Item;
import uiView.UIMain;
import utilities.Logs;

public class CellService {

	public static InspectableObjects recentlyOpenedObject = new InspectableObjects();
	public CellService() {
	}

	public String inspectCell() {
		Logs.LOGGER.info("Inspect Active Cell " + UIMain.player.currentCell.toString());
		String failedOutput = "You search long and hard, but your effort turns up nothing of interest.";
		String output = "";
		String objects = "";

		if(UIMain.player.getCurrentCell().getInspectableObjects() == null && UIMain.player.getCurrentCell().getItems() == null) {
			output = failedOutput;
		}
		else {
			if(UIMain.player.getCurrentCell().getInspectableObjects() != null
					&& !UIMain.player.getCurrentCell().getInspectableObjects().isEmpty()) {
				for(InspectableObjects item : UIMain.player.getCurrentCell().getInspectableObjects()) {
					if(objects.equals("")) {
						objects = item.getName();
					} else {
						objects = objects + ", " + item.getName();
					}

				}
			}
			if(UIMain.player.getCurrentCell().getItems() != null 
					&& !UIMain.player.getCurrentCell().getItems().isEmpty()) {
				for(Item item : UIMain.player.getCurrentCell().getItems()) {
					if(objects.equals("")) {
						objects = item.getName();
					} else {
						objects = objects + ", " + item.getName();
					}
				}
			}
			if(objects.equals("")) {
				output = failedOutput;
			}
			else {
				output = "By your sharp eyes or by good fortune, you find " + objects + "!";
			}
		}

		return output;
	}

	public String inspectItem(String param) {
		String output = "";

		for(InspectableObjects item : UIMain.player.getCurrentCell().getInspectableObjects()) {
			if(item.getName().equalsIgnoreCase(param)) {
				output = item.getDescription();
				break;
			} else {
				output = "You can look all day, but you still won't find it, " + UIMain.player.getEntityClass().getName() + ".";
			}
		} 
		return output;
	}

	public String openItem(String param) {
		StringBuilder outputBuilder = new StringBuilder();
		outputBuilder.append("Hands trembling, you unveil: ");

		for(InspectableObjects item : UIMain.player.getCurrentCell().getInspectableObjects()) {
			if(item.getName().equalsIgnoreCase(param) && item.getItems()!= null && !item.getItems().isEmpty()) {
				for(Item innerItem: item.getItems()) {
					outputBuilder.append("\n\n***** \n");
					outputBuilder.append(getItemDescription(innerItem));
				}
				recentlyOpenedObject = item;
				outputBuilder.append("\n\n\nYou should consider taking your findings with you.");
				break;
			} else if (item.getItems() == null || item.getItems().isEmpty()) {
				return "Sifting around the " + item.getName() + ", you don't find anything of interest.";
			} else {
				return "You fumble with various items around the room, failing to find any latches like what you're looking for.";
			}
		}

		return outputBuilder.toString();

	}

	public String getItemDescription(Item item) {
		StringBuilder outputBuilder = new StringBuilder();

		outputBuilder.append(item.getName());
		outputBuilder.append("\n\n- ");
		outputBuilder.append(item.getDescription());

		return outputBuilder.toString();
	}
}
