package gameplay.commandServices;

import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import pojos.environment.Location;
import uiView.UIMain;

public class MovementService {

	PlayerEntity player = UIMain.player;

	public MovementService(PlayerEntity player) {
		this.player = player;
	}

	public String moveNorth(char direction) {
		if(player.currentCell.isNorth()) {
			Location newLoc = player.getLocation();
			newLoc.setY(newLoc.getY()+1);
			setNewCell(newLoc);
		}
		return player.currentCell.getDescription();
	}

	public String moveSouth(char direction) {
		if(player.currentCell.isSouth()) {
			Location newLoc = player.getLocation();
			newLoc.setY(newLoc.getY()-1);
			setNewCell(newLoc);
		}
		return player.currentCell.getDescription();
	}

	public String moveEast(char direction) {
		if(player.currentCell.isEast()) {
			Location newLoc = player.getLocation();
			newLoc.setX(newLoc.getX()+1);
			setNewCell(newLoc);
		}
		return player.currentCell.getDescription();
	}

	public String moveWest(char direction) {
		if(player.currentCell.isWest()) {
			Location newLoc = player.getLocation();
			newLoc.setX(newLoc.getX()-1);
			setNewCell(newLoc);
			return player.currentCell.getDescription();
		}
		return "";
	}

	private void setNewCell(Location newLoc) {
		for(Cell cell : UIMain.cells) {
			if(cell.getLocation().getX() == newLoc.getX() &&
					cell.getLocation().getY() == newLoc.getY() &&
					cell.getLocation().getZ() == newLoc.getZ()) {;
					player.setCurrentCell(cell);
					player.setLocation(newLoc);
					break;
			}
		}
	}
}
