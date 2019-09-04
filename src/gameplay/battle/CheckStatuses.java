package gameplay.battle;

import pojos.entity.EnemyEntity;
import uiView.UIMain;

public class CheckStatuses {

	public void checkAllDeaths() {
		isPlayerDead();
		for (EnemyEntity enemy : UIMain.player.currentCell.getEnemies()) {
			isEnemyDead(enemy);
		}
	}

	public boolean isEnemyDead(EnemyEntity enemy) {
		if(enemy.getStats().getCurrentHP() > 0) {
			return false;
		}
		return true;
	}

	public boolean isPlayerDead() {
		if(UIMain.player.getStats().getCurrentHP() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
