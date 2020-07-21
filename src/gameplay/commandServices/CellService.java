package gameplay.commandServices;

import environment.InspectableObjects;
import gameplay.commandServices.utilities.SelectUtility;
import items.Item;
import uiView.UIMain;
import utilities.Logs;

public class CellService {

	public static InspectableObjects recentlyOpenedObject = new InspectableObjects();
	public SelectUtility select = new SelectUtility();

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
				for(int i = 0; i < UIMain.player.getCurrentCell().getInspectableObjects().size(); i++) {
					InspectableObjects item = UIMain.player.getCurrentCell().getInspectableObjects().get(i);
					int position = i + 1;
					if(objects.equals("")) {
						objects = "\n" + position + ". " + item.getName();
					} else {
						objects = objects + "\n" + position + ". " + item.getName();
					}	
				}
				//				for(InspectableObjects item : UIMain.player.getCurrentCell().getInspectableObjects()) {
				//					if(objects.equals("")) {
				//						objects = item.getName();
				//					} else {
				//						objects = objects + ", " + item.getName();
				//					}
				//
				//				}
			}
			if(UIMain.player.getCurrentCell().getItems() != null 
					&& !UIMain.player.getCurrentCell().getItems().isEmpty()) {
				for(int i = 0; i < UIMain.player.getCurrentCell().getItems().size(); i++) {
					Item item = UIMain.player.getCurrentCell().getItems().get(i);
					int position = i + 1;
					if(objects.equals("")) {
						objects = "\n" + position + ". " + item.getName();
					} else {
						objects = objects + "\n" + position + ". " + item.getName();
					}	
				}
				//				for(Item item : UIMain.player.getCurrentCell().getItems()) {
				//					if(objects.equals("")) {
				//						objects = "1. " + item.getName();
				//					} else {
				//						objects = objects + ", " + item.getName();
				//					}
				//				}
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

		if(select.isInteger(param)) {
			int numSelected = Integer.parseInt(param);
			if(numSelected > UIMain.player.getCurrentCell().getInspectableObjects().size()) {
				output = "Your eyes must be bigger than reality, " + UIMain.player.getEntityClass().getName() + ".\n" +
						"There are only " + UIMain.player.getCurrentCell().getInspectableObjects().size() + " items that could hold anything here.";
			} else {
				InspectableObjects item = UIMain.player.getCurrentCell().getInspectableObjects().get(numSelected-1);
				output = item.getDescription();
			}
		} else {
			for(InspectableObjects item : UIMain.player.getCurrentCell().getInspectableObjects()) {
				if(item.getName().equalsIgnoreCase(param)) {
					output = item.getDescription();
					break;
				} else {
					output = "You can look all day, but you still won't find it, " + UIMain.player.getEntityClass().getName() + ".";
				}
			} 
		}
		return output;
	}

	public String openItem(String param) {
		StringBuilder outputBuilder = new StringBuilder();
		if(select.isInteger(param)) {
			int numSelected = Integer.parseInt(param);
			if(numSelected > UIMain.player.getCurrentCell().getInspectableObjects().size()) {
				outputBuilder.append("Your eyes must be bigger than reality, " + UIMain.player.getEntityClass().getName() + ".\n" +
						"There are only " + UIMain.player.getCurrentCell().getInspectableObjects().size() + " items here.");
			} else {
				outputBuilder.append("Hands trembling, you unveil: ");

				InspectableObjects item = UIMain.player.getCurrentCell().getInspectableObjects().get(numSelected-1);
				if(item.getItems()!= null && !item.getItems().isEmpty()) {
					for(Item innerItem: item.getItems()) {
						outputBuilder.append("\n\n***** \n");
						outputBuilder.append(getItemDescription(innerItem));
					}
					recentlyOpenedObject = item;
					outputBuilder.append("\n\n\nYou should consider taking your findings with you.");
				} else if (item.getItems() == null || item.getItems().isEmpty()) {
					return "Sifting around the " + item.getName() + ", you don't find anything of interest.";
				}
			} 
		} else {
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
