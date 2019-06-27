package gameplay.commandServices;

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
		System.out.println("is east " + UIMain.player.currentCell.isEast());
		if(UIMain.player.currentCell.isEast()) {
			Location newLoc = UIMain.player.getLocation();
			newLoc.setX(newLoc.getX()+1);
			System.out.println("location" + newLoc);
			setNewCell(newLoc);
		}
		System.out.println("player current cell after movement " + UIMain.player.currentCell);
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
		System.out.println("new cell block");
		System.out.println("all loaded cells " +UIMain.cells);
		for(Cell cell : UIMain.cells) {
			System.out.println(cell.getDescription());
			System.out.println("Cell " + cell.getLocation());
			System.out.println("New Location " + newLoc);
			if(cell.getLocation().getX() == newLoc.getX() &&
					cell.getLocation().getY() == newLoc.getY() &&
					cell.getLocation().getZ() == newLoc.getZ()) {
				System.out.println("inside the if block for new locations");
					UIMain.player.setCurrentCell(cell);
					UIMain.player.setLocation(newLoc);
					break;
			}
		}
		return UIMain.player.currentCell.getDescription();
	}
}
