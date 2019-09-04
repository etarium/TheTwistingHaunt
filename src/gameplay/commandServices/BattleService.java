package gameplay.commandServices;

import java.util.ArrayList;
import java.util.List;

import gameplay.StatModMethods.BattleStatMethods;
import gameplay.battle.CheckStatuses;
import gameplay.battle.DeathService;
import gameplay.battle.VictoryService;
import pojos.entity.EnemyEntity;
import uiView.UIMain;
import utilities.Logs;

public class BattleService {

	String output = "";
	List<EnemyEntity> defeatedEnemies = new ArrayList<EnemyEntity>();
	public BattleService() {

	}

	public String physAttack(String target) {
		EnemyEntity selectedTarget = findEnemy(target);
		if(selectedTarget == null) {
			return "Swinging wildly, you charge after a figment of your imagination. Stopping at the last second, you realize that there doesn't seem to be any enemies called that.\n"
					+ "[try again, or type '/help' for battle assistance]";
		}

		int total = (int) (BattleStatMethods.calculatePlayerPhysDamage() - BattleStatMethods.calculateEnemyPhysDefense(selectedTarget));

		if(BattleStatMethods.calculateHitRate(selectedTarget)) {
			selectedTarget.getStats().setCurrentHP(selectedTarget.getStats().getCurrentHP() - total);

			if(!CheckStatuses.isEnemyDead(selectedTarget)) {
				output = "You attack " + selectedTarget.getName() + ", and with a stunning blow deal " + total + " damage. \n"
						+ "Nice work, hero! \n\n"
						+ selectedTarget.getName() + " Remaining HP: " + selectedTarget.getStats().getCurrentHP();
			} else {
				VictoryService.trackXP(selectedTarget.getXp(), selectedTarget.getLevel());
				output = defeatedEnemy(selectedTarget);
			}
		} else {
			output = "You lunge toward " + selectedTarget.getName() + ", but you were sidestepped and missed completely.\n"
					+ "Big bummer, hero. \n\n"
					+ selectedTarget.getName() + " Remaining HP: " + selectedTarget.getStats().getCurrentHP();
		}
		return output;
	}

	public String spAttack(String target) {
		//TODO
		return "";
	}

	public String inspectEnemy(String target) {
		//TODO
		return "";
	}

	private EnemyEntity findEnemy(String target) {
		for(EnemyEntity enemy : UIMain.player.currentCell.getEnemies()) {
			if(enemy.getName().equalsIgnoreCase(target)) {
				return enemy;
			}
		}
		Logs.LOGGER.info("Enemy was not found with parameter " + target);
		Logs.LOGGER.info("Enemies present in battle were " + UIMain.player.currentCell.getEnemies());
		return null;
	}

	private String defeatedEnemy(EnemyEntity selectedTarget) {
		DeathService.removeEnemy(selectedTarget);
		if(VictoryService.isVictory()) {
			output = VictoryService.victory();
		} else {
			output = "The " + selectedTarget.getName() + "let out a horrible scream\n"
					+ selectedTarget.getName() + ": " + selectedTarget.getLoserCry() + "\n"
							+ "Great Job! Only " + UIMain.player.currentCell.getEnemies().size() + " remaining!";
		}
		return output;
	}
}
