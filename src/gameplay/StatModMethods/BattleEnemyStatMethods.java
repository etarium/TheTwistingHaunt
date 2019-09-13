package gameplay.StatModMethods;

import pojos.entity.EnemyEntity;
import uiView.UIMain;
import utilities.Logs;

public class BattleEnemyStatMethods {
	public static double calculateEnemyPhysDamage(EnemyEntity enemy) {
		// damage =
		// [ (playerAttk * .6) + (level *.2) + (RANDOM * 4) + 2]
		double enemyAtk = enemy.getStats().getAtk() * .8 + (Math.random() * .5);
		double enemyLvl = enemy.getLevel() * .2;
		double randomMultiplier = Math.random() * 3;
		double calculatedDamage = (enemyAtk + enemyLvl + randomMultiplier + 1);

		Logs.LOGGER.info("Calculated Enemy's attack rate " + calculatedDamage);

		return calculatedDamage;
	}
	
	public static boolean calculateEnemyHitRate(EnemyEntity enemy) {
		double enemyAcc = enemy.getStats().getAcc() * .5;
		double enemyLvl = enemy.getLevel() * .3;
		double enemyAgi = enemy.getStats().getAgi() * .1;
		double enemyRandomMultiplier = Math.random() * 2;
		double enemyHitRate = enemyAcc + enemyLvl + enemyAgi + enemyRandomMultiplier;

		Logs.LOGGER.info("Calculated enemy hit rate " + enemyHitRate);

		double playerEva = UIMain.player.getStats().getEva() * .5;
		double playerLvl = UIMain.player.getLevel() * .4;
		double playerAgi = UIMain.player.getStats().getAgi() * .1;
		double playerRandomMultiplier = Math.random() * 3;
		double playerEvasionRate = playerEva + playerLvl + playerAgi + playerRandomMultiplier;

		Logs.LOGGER.info("Calculated player evasion rate " + playerEvasionRate);

		return enemyHitRate - playerEvasionRate > 0;
	}
	
	public static double calculateEnemyPhysDefense(EnemyEntity selectedTarget) {
		// defense =
		// [ ((enemyDef * .5) + (level *.35) + (RANDOM * 3)) *.75]
		double enemyDef = selectedTarget.getStats().getDef();
		double enemyLvl = selectedTarget.getLevel() *.2;
		double randomMultiplier = Math.random() * 3;
		double calculatedDefense = ((enemyDef + enemyLvl + randomMultiplier) * .75);

		Logs.LOGGER.info("Calculated Enemy's defense rate " + calculatedDefense);

		return calculatedDefense;
	}

	public static double calculateEnemySpDef(EnemyEntity enemy) {

		double enemySpDef = enemy.getStats().getSpdef() * .8 + (Math.random() * .5);
		double enemyLvl = enemy.getLevel() * .8;
		double randomMultiplier = Math.random() * 3;
		double totalDef = (enemySpDef + enemyLvl + randomMultiplier + 1);

		Logs.LOGGER.info("Calculated Enemy's sp def rate " + totalDef);

		return totalDef;
	}
}
