package gameplay.newGame;

import java.util.List;

import commandListener.Init;
import db.api.DbAPI;
import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import utilities.Logs;

public class PlayerInitializer {

	final static String INSTANCE = "Test Instance";
	DbAPI cellAPI = new DbAPI();
	//PlayerEntity player = new PlayerEntity();
	public PlayerEntity player;
	
	public PlayerEntity initializePlayer(boolean isNewGame, NewPlayerPayload payload) {
		player = new PlayerEntity();
		if(isNewGame) {
			List<Cell> cells = cellAPI.getCellsFromInstance(INSTANCE);
			//set player's location
			player.setLocation(payload.playerLocation);
			player.setEntityClass(payload.getClassName());
			player.setArmorType(payload.getClassName().getArmorType());
			player.setWeaponType(payload.getClassName().getWeaponType());
			player.setStats(payload.getClassName().getStats());
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
			player.setXpToNextLevel(50);

			Logs.LOGGER.info("Player has entered cell. " + player.currentCell);
			Logs.LOGGER.info("Player has initialized class stats " + player.getStats());
			Logs.LOGGER.info("Encounters loaded. " + player.currentCell.getEnemies());
		}
		return player;
	}
	
	public PlayerEntity getPlayer() {
		System.out.println(player);
		return this.player;
	}
}
