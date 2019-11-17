package gameplay.battle;

import gameplay.StatModMethods.BattleEnemyStatMethods;
import gameplay.StatModMethods.BattlePlayerStatMethods;
import entity.EnemyEntity;

public class PhysicalService {
	
	public static String playerPhysAttack(EnemyEntity selectedTarget) {
		String output = "";
		int total = (int) (BattlePlayerStatMethods.calculatePlayerPhysDamage() - BattleEnemyStatMethods.calculateEnemyPhysDefense(selectedTarget));

		if(BattlePlayerStatMethods.calculatePlayerHitRate(selectedTarget)) {
			selectedTarget.getStats().setCurrentHP(selectedTarget.getStats().getCurrentHP() - total);
			if(selectedTarget.getStats().getCurrentHP() < 0) {
				selectedTarget.getStats().setCurrentHP(0);
			}

			if(!CheckStatuses.isEnemyDead(selectedTarget)) {
				output = "\nYou attack " + selectedTarget.getName() + ", and with a stunning blow deal " + total + " damage. \n"
						+ "Nice work, hero! \n";
			} else {
				VictoryService.trackXP(selectedTarget.getXp(), selectedTarget.getLevel());
				output = "\nYou attack " + selectedTarget.getName() + ", and with a stunning blow deal " + total + " damage. \n" + VictoryService.defeatedEnemy(selectedTarget);
			}
		} else {
			output = "\nYou lunge toward " + selectedTarget.getName() + ", but you were sidestepped and missed completely.\n"
					+ "Big bummer, hero. \n";
		}
		return output;
	}
}
