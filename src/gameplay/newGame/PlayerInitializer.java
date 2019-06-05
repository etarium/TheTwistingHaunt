package gameplay.newGame;

import java.util.List;

import db.api.DbAPI;
import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import pojos.environment.Location;
import utilities.Logs;

public class PlayerInitializer {

	final static String INSTANCE = "Test Instance";
	DbAPI cellAPI = new DbAPI();
	//PlayerEntity player = new PlayerEntity();
	PlayerEntity player;
	
	public PlayerEntity initializePlayer(boolean isNewGame) {
		if(isNewGame) {
			List<Cell> cells = cellAPI.getCellsFromInstance(INSTANCE);
			//set player's location
			player.setLocation(new Location(0,1,0));
			for(Cell cell : cells) {
				if(cell.getLocation().getX() == player.getLocation().getX() &&
						cell.getLocation().getY() == player.getLocation().getY() &&
						cell.getLocation().getZ() == player.getLocation().getZ()) {;
						player.setCurrentCell(cell);
						break;
				}
			}
			player.setLevel(1);
			player.setXp(0);
			Logs.LOGGER.info("Player Initialized. " + player.toString());
		}
		return player;
	}
}
