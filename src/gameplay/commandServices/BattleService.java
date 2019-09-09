package gameplay.commandServices;

import java.util.ArrayList;
import java.util.List;

import gameplay.StatModMethods.BattleStatMethods;
import gameplay.battle.CheckStatuses;
import gameplay.battle.DeathService;
import gameplay.battle.VictoryService;
import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
import uiView.UIMain;
import utilities.Logs;

public class BattleService {

	String output = "";
	List<EnemyEntity> defeatedEnemies = new ArrayList<EnemyEntity>();
	public BattleService() {

	}

	public String physAttack(String target) {
		StringBuilder outputBuilder = new StringBuilder();
		for(Entity activeEntity : UIMain.battleOrder) {
			if(activeEntity.equals(UIMain.player)) {
				outputBuilder.append(playerPhysAttack(target));
			} else {
				if(!UIMain.player.isInEncounter) {
					break;
				} else {
					outputBuilder.append(enemyAttack((EnemyEntity) activeEntity));
				}
			}
		}
		outputBuilder.append(formatBattleOutput());
		return outputBuilder.toString();
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
			output = "\nThe " + selectedTarget.getName() + "let out a horrible scream.\n"
					+ "Great Job! Only " + UIMain.player.currentCell.getEnemies().size() + " remaining!\n";
		}
		return output;
	}

	private String enemyAttack(EnemyEntity enemy) {
		//TODO: make it smart enough to use skills instead of just physical attacks
		int totalDamage = (int) ( BattleStatMethods.calculateEnemyPhysDamage(enemy) - BattleStatMethods.calculatePlayerPhysDefense());
		if(BattleStatMethods.calculateEnemyHitRate(enemy)) {
			UIMain.player.getStats().setCurrentHP(UIMain.player.getStats().getCurrentHP() - totalDamage);
			output = "\nThe " + enemy.getName() + " lashes out, inflicting " + totalDamage + "!\n";
		} else {
			output = "\n The " + enemy.getName() + " stumbles, missing its target.\n";
		}
		return output;
	}

	private String playerPhysAttack(String target) {
		EnemyEntity selectedTarget = findEnemy(target);
		if(selectedTarget == null) {
			output = "\nSwinging wildly, you charge after a figment of your imagination. Stopping at the last second, "
					+ "you realize that there doesn't seem to be any enemies called that.\n"
					+ "[try again, or type '/help' for battle assistance]\n";
			
			Logs.LOGGER.info("Target could not be found during phys attack \n" +
					"target: " + target + ", battle: " + UIMain.battleOrder);
		}

		int total = (int) (BattleStatMethods.calculatePlayerPhysDamage() - BattleStatMethods.calculateEnemyPhysDefense(selectedTarget));

		if(BattleStatMethods.calculatePlayerHitRate(selectedTarget)) {
			selectedTarget.getStats().setCurrentHP(selectedTarget.getStats().getCurrentHP() - total);

			if(!CheckStatuses.isEnemyDead(selectedTarget)) {
				output = "\nYou attack " + selectedTarget.getName() + ", and with a stunning blow deal " + total + " damage. \n"
						+ "Nice work, hero! \n";
			} else {
				VictoryService.trackXP(selectedTarget.getXp(), selectedTarget.getLevel());
				output = "\nYou attack " + selectedTarget.getName() + ", and with a stunning blow deal " + total + " damage. \n" + defeatedEnemy(selectedTarget);
			}
		} else {
			output = "\nYou lunge toward " + selectedTarget.getName() + ", but you were sidestepped and missed completely.\n"
					+ "Big bummer, hero. \n";
		}
		return output;
	}

	private String formatBattleOutput() {
		StringBuilder outputBuilder = new StringBuilder();
		//display all enemy's names, levels, hp. Display player's name, level hp
		// [player]			[enemy1]		[enemy2]
		// lvl | hp			lvl | hp		lvl | hp
		List<Entity> printedList = UIMain.battleOrder;
		printedList.remove(UIMain.player);
		outputBuilder.append("\n\n");
		outputBuilder.append(String.format("%-5s",  UIMain.player.getName()));

		for(int i = 0; i<printedList.size(); i++) {
			outputBuilder.append(String.format("%17s",   UIMain.battleOrder.get(i).getName()));
		}
		outputBuilder.append("\n");
		outputBuilder.append(String.format("%-5s",  "LVL: " + UIMain.player.getLevel()));
		for(int i = 0; i<printedList.size(); i++) {
			outputBuilder.append(String.format("%17s", "LVL: " + UIMain.battleOrder.get(i).getLevel()));
		}
		outputBuilder.append("\n");
		outputBuilder.append(String.format("%-5s",  "HP: " + UIMain.player.getStats().getCurrentHP() 
				+ " | " + UIMain.player.getStats().getHp()));
		for(int i = 0; i<printedList.size(); i++) {
			outputBuilder.append(String.format("%15s",   "HP: " +
					UIMain.battleOrder.get(i).getStats().getCurrentHP() + " |" + UIMain.battleOrder.get(i).getStats().getHp()));
		}
		return outputBuilder.toString();
	}

}
