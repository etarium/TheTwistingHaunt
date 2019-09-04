package gameplay.commandServices;

import gameplay.battle.CheckStatuses;
import gameplay.battle.DeathHandlers;
import pojos.entity.EnemyEntity;
import uiView.UIMain;
import utilities.Logs;

public class BattleService {
	
	String output = "";
	public BattleService() {
		
	}
	
	public String physAttack(String target) {
		EnemyEntity selectedTarget = findEnemy(target);
		if(selectedTarget == null) {
			return "Swinging wildly, you charge after a figment of your imagination. Stopping at the last second, you realize that there doesn't seem to be any enemies called that.\n"
					+ "[try again, or type '/help' for battle assistance]";
		}
		
		double damage = calculatePlayerPhysDamage();
		double defense = calculateEnemyPhysDefense(selectedTarget);
		int total = (int) (damage - defense);
		
		if(calculateHitRate(selectedTarget)) {
			selectedTarget.getStats().setCurrentHP(selectedTarget.getStats().getCurrentHP() - total);
			
			if(!CheckStatuses.isEnemyDead(selectedTarget)) {
			output = "You attack " + selectedTarget.getName() + ", and with a stunning blow deal " + total + " damage. \n"
					+ "Nice work, hero! \n\n"
					+ selectedTarget.getName() + " Remaining HP: " + selectedTarget.getStats().getCurrentHP();
			} else {
				DeathHandlers.removeEnemy(selectedTarget);
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
	
	private double calculatePlayerPhysDamage() {
		// damage =
		// [ (playerAttk * .6) + (level *.2) + (RANDOM * 4) + 2]
		double playerAtk = UIMain.player.getStats().getAtk() * .6 + (Math.random() * .5);
		double playerLvl = UIMain.player.getLevel() * .2;
		double randomMultiplier = Math.random() * 4;
		double calculatedDamage = (playerAtk + playerLvl + randomMultiplier + 2);
		
		Logs.LOGGER.info("Calculated Player's attack rate " + calculatedDamage);
		
		return calculatedDamage;
	}
	
	private double calculateEnemyPhysDefense(EnemyEntity selectedTarget) {
		// defense =
		// [ ((enemyDef * .5) + (level *.35) + (RANDOM * 3)) *.75]
		double enemyDef = selectedTarget.getStats().getDef();
		double enemyLvl = selectedTarget.getLevel() *.2;
		double randomMultiplier = Math.random() * 3;
		double calculatedDefense = ((enemyDef + enemyLvl + randomMultiplier) * .75);
		
		Logs.LOGGER.info("Calculated Enemy's defense rate " + calculatedDefense);
		
		return calculatedDefense;
	}
	private boolean calculateHitRate(EnemyEntity selectedTarget) {
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

}
