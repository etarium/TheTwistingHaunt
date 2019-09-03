package gameplay.commandServices;

import gameplay.battle.BattleOrder;
import pojos.environment.Cell;
import pojos.environment.Location;
import uiView.UIMain;

public class MovementService {
	
	public MovementService() {
		//empty constructor
	}

	public String moveNorth(char direction) {
		if(UIMain.player.currentCell.isNorth()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setY(newLoc.getY()+1);
			setNewCell(newLoc);
		}
		return UIMain.player.currentCell.getDescription();
	}

	public String moveSouth(char direction) {
		if(UIMain.player.currentCell.isSouth()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setY(newLoc.getY()-1);
			setNewCell(newLoc);
		}
		return UIMain.player.currentCell.getDescription();
	}

	public String moveEast(char direction) {
		if(UIMain.player.currentCell.isEast()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setX(newLoc.getX()+1);
			setNewCell(newLoc);
		}
		return UIMain.player.currentCell.getDescription();
	}

	public String moveWest(char direction) {
		if(UIMain.player.currentCell.isWest()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setX(newLoc.getX()-1);
			setNewCell(newLoc);
		}
		return UIMain.player.currentCell.getDescription();
	}

	private String setNewCell(Location newLoc) {
		for(Cell cell : UIMain.cells) {
			if(cell.getLocation().getX() == newLoc.getX() &&
					cell.getLocation().getY() == newLoc.getY() &&
					cell.getLocation().getZ() == newLoc.getZ()) {
					UIMain.player.setCurrentCell(cell);
					UIMain.player.setLocation(newLoc);
					UIMain.player.setIsInEncounter(checkForEncounters());
					if(checkForEncounters()) {
						BattleOrder battle = new BattleOrder();
						return battle.initializeBattle();
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
