package gameplay.StatModMethods;

import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
import uiView.UIMain;
import utilities.Logs;

public class BattleStatMethods {

	public double calculateInitiative(Entity entity) {
		// [ (agility * .8) + (lvl * .15) + (RANDOM * .05)]
		//entity can be the player or any enemy or npc
		double playerAgility = entity.getStats().getAgi() * .8;
		double playerLevel = entity.getLevel() * .15;
		double randomMultiplier = Math.random() * .05;
		double initiative = playerAgility + playerLevel + randomMultiplier;
		Logs.LOGGER.info(entity.getName() + " rolled a " + initiative + " initiative."); 
		return initiative;
	}
	
	public static double calculatePlayerPhysDamage() {
		// damage =
		// [ (playerAttk * .6) + (level *.2) + (RANDOM * 4) + 2]
		double playerAtk = UIMain.player.getStats().getAtk() * .6 + (Math.random() * .5);
		double playerLvl = UIMain.player.getLevel() * .2;
		double randomMultiplier = Math.random() * 4;
		double calculatedDamage = (playerAtk + playerLvl + randomMultiplier + 2);

		Logs.LOGGER.info("Calculated Player's attack rate " + calculatedDamage);

		return calculatedDamage;
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
	
	public static boolean calculatePlayerHitRate(EnemyEntity selectedTarget) {
		//hit rate = 
		//   [ (playerAcc * .5) + (playerLvl * .3) + (playerAgi * .1) + (RANDOM * 2)]
		// - [ (enemyEva * .3) + (enemyLvl * .4) + (enemyAgi * .1) + (RANDOM * 1.5)]
		//if player - enemy > 0, hit = true

		double playerAcc = UIMain.player.getStats().getAcc() * .5;
		double playerLvl = UIMain.player.getLevel() * .3;
		double playerAgi = UIMain.player.getStats().getAgi() * .1;
		double playerRandomMultiplier = Math.random() * 2;
		double playerHitRate = playerAcc + playerLvl + playerAgi + playerRandomMultiplier;

		Logs.LOGGER.info("Calculated player hit rate " + playerHitRate);

		double enemyEva = selectedTarget.getStats().getEva() * .3;
		double enemyLvl = selectedTarget.getLevel() * .4;
		double enemyAgi = selectedTarget.getStats().getAgi() * .1;
		double enemyRandomMultiplier = Math.random() * 3;
		double enemyEvasionRate = enemyEva + enemyLvl + enemyAgi + enemyRandomMultiplier;

		Logs.LOGGER.info("Calculated enemy evasion rate " + enemyEvasionRate);

		return playerHitRate - enemyEvasionRate > 0;
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
	
	public static double calculatePlayerPhysDefense() {
		double playerDef = UIMain.player.getStats().getDef();
		double playerLvl = UIMain.player.getLevel() *.4;
		double randomMultiplier = Math.random() * 4;
		double calculatedDefense = ((playerDef + playerLvl + randomMultiplier) * .75);

		Logs.LOGGER.info("Calculated Player's phys defense rate " + calculatedDefense);

		return calculatedDefense;
	}
	
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
	public static double calculateIntel(EnemyEntity enemy) {
		return 0.0;
	}

}
