package gameplay.StatModMethods;

import pojos.Ability;
import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
import uiView.UIMain;
import utilities.Logs;

public class BattlePlayerStatMethods {

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

	public static double calculatePlayerPhysDefense() {
		double playerDef = UIMain.player.getStats().getDef();
		double playerLvl = UIMain.player.getLevel() *.4;
		double randomMultiplier = Math.random() * 4;
		double calculatedDefense = ((playerDef + playerLvl + randomMultiplier) * .75);

		Logs.LOGGER.info("Calculated Player's phys defense rate " + calculatedDefense);

		return calculatedDefense;
	}

	public static double calculateAbilityDamage(Ability ability) {
		double playerSpAtk = UIMain.player.getStats().getSpatk() * .8;
		double playerLvl = UIMain.player.getLevel() * .6;
		double playerIntel = UIMain.player.getStats().getIntel() * 1.2;
		double abilityDmg = ability.getStats().getSpatk() * .7;
		double randomMultiplier = Math.random() * 2;
		double totalDmg = playerSpAtk + playerIntel + abilityDmg + playerLvl + randomMultiplier;
		
		Logs.LOGGER.info("Calculated player ability damage " + totalDmg);
		return totalDmg;
	}

	public static double calculateAbilityHeal(Ability ability) {
		double playerSpAtk = UIMain.player.getStats().getSpatk() * .8;
		double playerLvl = UIMain.player.getLevel() * .6;
		double playerIntel = UIMain.player.getStats().getIntel() * 1.2;
		double abilityHpUp = ability.getStats().getHp() * 1.1;
		double randomMultiplier = Math.random() * 2;
		double totalHeal = playerSpAtk + playerIntel + abilityHpUp + playerLvl + randomMultiplier;

		Logs.LOGGER.info("Calculated player ability heal " + totalHeal);
		
		return totalHeal;
	}

	public static double calculateIntel(EnemyEntity enemy) {
		//TODO
		return 0.0;
	}

}
