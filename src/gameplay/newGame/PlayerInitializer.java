package gameplay.newGame;

import db.api.DbAPI;
import gameplay.StatModMethods.PlayerStatMethods;
import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import uiView.UIMain;
import utilities.Logs;

public class PlayerInitializer {

	static final String INSTANCE = "Test Instance";
	DbAPI cellAPI = new DbAPI();
	PlayerStatMethods statMethods = new PlayerStatMethods();

	public PlayerEntity initializePlayer(boolean isNewGame, NewPlayerPayload payload) {
		if(isNewGame) {
			UIMain.cells = cellAPI.getCellsFromInstance(INSTANCE);
			//set player's location
			UIMain.player.setName(payload.getName());
			UIMain.player.setLocation(payload.getPlayerLocation());
			UIMain.player.setSpecies(payload.getSpecies());
			UIMain.player.setEntityClass(payload.getClassName());
			UIMain.player.setArmorType(payload.getClassName().getArmorType());
			UIMain.player.setWeaponType(payload.getClassName().getWeaponType());
			//TODO: create an algorithm based on class and species for stats
			UIMain.player.setStats(statMethods.calculateBaseStats());
			for(Cell cell : UIMain.cells) {
				if(cell.getLocation().getX() == UIMain.player.getLocation().getX() &&
						cell.getLocation().getY() == UIMain.player.getLocation().getY() &&
						cell.getLocation().getZ() == UIMain.player.getLocation().getZ()) {
						UIMain.player.setCurrentCell(cell);
						break;
				}
			}
			UIMain.player.setLevel(1);
			UIMain.player.setXp(0);
			UIMain.player.setXpToNextLevel(50);
	
		}
		Logs.LOGGER.info("Player has entered cell. " + UIMain.player.currentCell);
		Logs.LOGGER.info("Player has initialized class stats " + UIMain.player.getStats());
		Logs.LOGGER.info("Encounters loaded. " + UIMain.player.currentCell.getEnemies());
		return UIMain.player;
	}

	public PlayerEntity getPlayer() {
		return UIMain.player;
	}
}
