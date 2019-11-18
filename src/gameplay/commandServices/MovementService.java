package gameplay.commandServices;

import gameplay.battle.BattleOrder;
import environment.Cell;
import environment.InspectableObjects;
import environment.Location;
import uiView.UIMain;

public class MovementService {
	
	String output = "";
	public MovementService() {
		//empty constructor
	}

	public String moveNorth() {
		if(UIMain.player.currentCell.isNorth()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setY(newLoc.getY()+1);
			output = setNewCell(newLoc);
		}
		output = UIMain.player.currentCell.getDescription();
		return output;
	}

	public String moveSouth() {
		if(UIMain.player.currentCell.isSouth()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setY(newLoc.getY()-1);
			output = setNewCell(newLoc);
		}
		output = UIMain.player.currentCell.getDescription();
		return output;
	}

	public String moveEast() {
		if(UIMain.player.currentCell.isEast()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setX(newLoc.getX()+1);
			output = setNewCell(newLoc);
		}
		output = UIMain.player.currentCell.getDescription();
		return output;
	}

	public String moveWest() {
		if(UIMain.player.currentCell.isWest()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setX(newLoc.getX()-1);
			output = setNewCell(newLoc);
		}
		output = UIMain.player.currentCell.getDescription();
		return output;
	}

	private String setNewCell(Location newLoc) {
		for(Cell cell : UIMain.cells) {
			if(cell.getLocation().getX() == newLoc.getX() &&
					cell.getLocation().getY() == newLoc.getY() &&
					cell.getLocation().getZ() == newLoc.getZ()) {
					UIMain.player.setCurrentCell(cell);
					UIMain.player.setLocation(newLoc);
					UIMain.player.setIsInEncounter(checkForEncounters());
        
					//every time a new cell is entered, reset the recentlyOpened item
					CellService.recentlyOpenedObject = new InspectableObjects();
					if(checkForEncounters()) {
						BattleOrder battle = new BattleOrder();
						return (UIMain.player.currentCell.getDescription() + "\n" + battle.initializeBattle());
					}
					break;
			}
		}
		return UIMain.player.currentCell.getDescription();
	}
	
	
	private boolean checkForEncounters() {
		if(UIMain.player.currentCell.getEnemies().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
