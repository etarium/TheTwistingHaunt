package gameplay.battle;

import entity.EnemyEntity;
import environment.Cell;
import uiView.UIMain;
import utilities.Logs;

public class DeathService {


	public static void removeEnemy(EnemyEntity selectedTarget) {
		for(int i=0; i<UIMain.player.currentCell.getEnemies().size(); i++) {
			if(UIMain.player.currentCell.getEnemies().get(i).getName().equalsIgnoreCase(selectedTarget.getName()) && (UIMain.player.currentCell.getEnemies().get(i).getStats().getCurrentHP() <= 0 )) {
				UIMain.player.currentCell.getEnemies().remove(i);

				Logs.LOGGER.info("Removed " + selectedTarget + " from Cell enemy list at index " + i);
			}
		}
	}

	public static void removeAllEnemiesFromCell(Cell currentCell) {
		for(Cell cell : UIMain.cells) {
			if(cell.getLocation().getX() == UIMain.player.currentCell.getLocation().getX() &&
					cell.getLocation().getY() == UIMain.player.currentCell.getLocation().getY() &&
					cell.getLocation().getZ() == UIMain.player.currentCell.getLocation().getZ()) {
				cell.setEnemies(currentCell.getEnemies());

				Logs.LOGGER.info("Removed all enemies from Cell " + currentCell.getLocation());
			}
		}
	}
}
