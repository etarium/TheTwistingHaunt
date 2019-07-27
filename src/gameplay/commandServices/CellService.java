package gameplay.commandServices;

import pojos.environment.InspectableObjects;
import uiView.UIMain;
import utilities.Logs;

public class CellService {

	public CellService() {
	}

	public String inspectCell() {
		Logs.LOGGER.info("Inspect Active Cell " + UIMain.player.currentCell.toString());
		String output = "";

		if(UIMain.player.getCurrentCell().getInspectableObjects() == null) {
			output = "You search long and hard, but your effort turns up nothing of interest.";
		}
		else {
			String objects = "";
			for(InspectableObjects item : UIMain.player.getCurrentCell().getInspectableObjects()) {
				if(objects.equals("")) {
					objects = item.getName();
				} else {
					objects = objects + ", " + item.getName();
				}
			}
			output = "By your sharp eyes or by good fortune, you find " + objects + "!";
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
}
