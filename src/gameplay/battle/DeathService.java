package gameplay.battle;

import entity.EnemyEntity;
import uiView.UIMain;

public class DeathService {

	
	public static void removeEnemy(EnemyEntity selectedTarget) {
		for(int i=0; i<UIMain.player.currentCell.getEnemies().size(); i++) {
			if(UIMain.player.currentCell.getEnemies().get(i).getName().equalsIgnoreCase(selectedTarget.getName())) {
				UIMain.player.currentCell.getEnemies().remove(i);
			}
			if(UIMain.battleOrder.get(i).getName().equalsIgnoreCase(selectedTarget.getName())) {
				UIMain.battleOrder.remove(i);
				break;
			}
		}
	}
}
