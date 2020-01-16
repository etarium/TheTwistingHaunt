package gameplay.commandServices;

import java.util.ArrayList;
import java.util.List;

import gameplay.StatModMethods.BattleEnemyStatMethods;
import gameplay.StatModMethods.BattlePlayerStatMethods;
import gameplay.battle.PhysicalService;
import gameplay.battle.SpellService;
import general.Ability;
import ability.enums.AbilityType;
import entity.EnemyEntity;
import entity.Entity;
import uiView.UIMain;
import utilities.Logs;

public class BattleService {

	String output = "";
	List<EnemyEntity> defeatedEnemies = new ArrayList<EnemyEntity>();
	public BattleService() {
	}

	public String physAttack(String target) {
		StringBuilder outputBuilder = new StringBuilder();
		EnemyEntity selectedTarget = findEnemy(target);
		if(selectedTarget == null) {
			output = "\nSwinging wildly, you charge after a figment of your imagination. Stopping at the last second, "
					+ "you realize that there doesn't seem to be any enemies called that.\n"
					+ "[try again, or type '/help' for battle assistance]\n";

			Logs.LOGGER.info("Target could not be found during phys attack \n" +
					"target: " + target + ", battle: " + UIMain.battleOrder);

			return output;
		}

		for(Entity activeEntity : UIMain.battleOrder) {
			if(activeEntity.equals(UIMain.player)) {
				outputBuilder.append(PhysicalService.playerPhysAttack(selectedTarget));
				outputBuilder.append("\n**********\n");
			} else {
				if(!UIMain.player.isInEncounter) {
					break;
				} else {
					if(activeEntity.getStats().getCurrentHP() == 0) {
						//do nothing and skip their turn
					} else {
						outputBuilder.append(enemyAttack((EnemyEntity) activeEntity));
						outputBuilder.append("\n**********\n");
					}
				}
			}

		}
		outputBuilder.append(formatBattleOutput());
		return outputBuilder.toString();
	}

	public String spAttack(Ability spell, String target) {
		StringBuilder outputBuilder = new StringBuilder();
		EnemyEntity selectedTarget = findEnemy(target);

		if(selectedTarget == null && ( spell.getType().equals(AbilityType.DAMAGE) 
				|| spell.getType().equals(AbilityType.DEBUFF) 
				|| spell.getType().equals(AbilityType.DRAIN))) {
			output = "\nSwinging wildly, you charge after a figment of your imagination. Stopping at the last second, "
					+ "you realize that there doesn't seem to be any enemies called that.\n"
					+ "[try again, or type '/help' for battle assistance]\n";

			Logs.LOGGER.info("Target could not be found during spell attack \n" +
					"target: " + target + ", battle: " + UIMain.battleOrder);

			return output;
		}

		for(Entity activeEntity : UIMain.battleOrder) {
			if(activeEntity.equals(UIMain.player)) {
				outputBuilder.append(spAtk(spell, selectedTarget));
				outputBuilder.append("\n**********\n");
			} else {
				if(!UIMain.player.isInEncounter) {
					break;
				} else {
					if(activeEntity.getStats().getCurrentHP() == 0) {
						//do nothing and skip their turn
					} else {
						outputBuilder.append(enemyAttack((EnemyEntity) activeEntity));
						outputBuilder.append("\n**********\n");
					}
				}
			}
		}
		outputBuilder.append(formatBattleOutput());
		return outputBuilder.toString();
	}

	public String spSupport(Ability spell) {
		StringBuilder outputBuilder = new StringBuilder();
		//TODO
		//add support for party members.
		//all support skills are currently used on the player.

		//if the target is the player
		//determine type of spell being used for the appropriate method
		for(Entity activeEntity : UIMain.battleOrder) {
			if(activeEntity.equals(UIMain.player)) {
				if (spell.getType().equals(AbilityType.HEAL)) {
					outputBuilder.append(SpellService.useHealSpell(spell));
				} else if(spell.getType().equals(AbilityType.BUFF)) {
					outputBuilder.append(SpellService.useBuffSpell(spell));
				}
				outputBuilder.append("\n**********\n");
			} else {
				if(!UIMain.player.isInEncounter) {
					break;
				} else {
					if(activeEntity.getStats().getCurrentHP() == 0) {
						//do nothing and skip their turn
					} else {
						outputBuilder.append(enemyAttack((EnemyEntity) activeEntity));
						outputBuilder.append("\n**********\n");
					}
				}
			}
		}
		outputBuilder.append(formatBattleOutput());
		return outputBuilder.toString();
	}

	public String spAtk(Ability spell, EnemyEntity selectedTarget) {
		StringBuilder outputBuilder = new StringBuilder();
		if(spell.getType().equals(AbilityType.DAMAGE)) {
			outputBuilder.append(SpellService.useDamageSpell(spell, (EnemyEntity) selectedTarget));

		} else if(spell.getType().equals(AbilityType.DEBUFF)) {
			//TODO
			outputBuilder.append(SpellService.useDeBuffSpell(spell, (EnemyEntity) selectedTarget));
		} else if(spell.getType().equals(AbilityType.DRAIN)) {
			//TODO
			outputBuilder.append(SpellService.useDrainSpell(spell, (EnemyEntity) selectedTarget));
		}

		return outputBuilder.toString();
	}

	public String inspectEnemy(String target) {
		EnemyEntity selectedTarget = findEnemy(target);
		if(selectedTarget == null) {
			return "You squinted at the enemies before you, unable to focus on any foe in particular."
					+ "\nYou realize that there doesn't seem to be any enemies called that.\n"
					+ "[try again, or type '/help' for battle assistance]\n";
		}
		output = getEnemyStats(selectedTarget);
		return output;
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

	private String enemyAttack(EnemyEntity enemy) {
		//TODO: make it smart enough to use skills instead of just physical attacks
		int totalDamage = (int) ( BattleEnemyStatMethods.calculateEnemyPhysDamage(enemy) - BattlePlayerStatMethods.calculatePlayerPhysDefense());
		if(BattleEnemyStatMethods.calculateEnemyHitRate(enemy)) {
			UIMain.player.getStats().setCurrentHP(UIMain.player.getStats().getCurrentHP() - totalDamage);
			output = "\nThe " + enemy.getName() + " lashes out, inflicting " + totalDamage + " damage!\n";
		} else {
			output = "\n The " + enemy.getName() + " stumbles, missing its target.\n";
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
//		outputBuilder.append("\n\n");
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
					UIMain.battleOrder.get(i).getStats().getCurrentHP() + " | " + UIMain.battleOrder.get(i).getStats().getHp()));
		}
		outputBuilder.append("\n");
		outputBuilder.append(String.format("%-5s",   "SP: " +
				UIMain.player.getStats().getCurrentSP() + " | " + UIMain.player.getStats().getSp()));
		for(int i = 0; i<printedList.size(); i++) {
			outputBuilder.append(String.format("%15s",   "SP: " +
					UIMain.battleOrder.get(i).getStats().getCurrentSP() + " | " + UIMain.battleOrder.get(i).getStats().getSp()));
		}
		return outputBuilder.toString();
	}

	private String getEnemyStats(EnemyEntity enemy) {
		StringBuilder output = new StringBuilder();
		output.append(String.format("%-25s", "Name: " + enemy.getName()));
		output.append(String.format("%20s", "Level: " + enemy.getLevel()));
		output.append(String.format("%30s",  "Species: " + enemy.getSpecies()));
		output.append("\n\n\n");
		output.append(String.format("%-5s",  "HP: "));
		output.append(String.format("%5s",  enemy.getStats().getHp()));
		output.append(String.format("%13s",  "SP: "));
		output.append(String.format("%6s", enemy.getStats().getSp()));
		output.append(String.format("%14s",  "EVA: " + enemy.getStats().getEva()));
		output.append(String.format("%14s",  "STA: " + enemy.getStats().getSta()));
		output.append("\n\n\n");
		output.append(String.format("%-5s",  "ATK: "));
		output.append(String.format("%5s", enemy.getStats().getAtk()));
		output.append(String.format("%14s",  "DEF: "));
		output.append(String.format("%5s",  + enemy.getStats().getDef()));
		output.append(String.format("%14s",  "INT: " + enemy.getStats().getIntel()));
		output.append(String.format("%15s",  "AGI: " + enemy.getStats().getAgi()));
		output.append("\n\n\n");
		output.append(String.format("%-5s",  "SP ATK: " + enemy.getStats().getSpatk()));
		output.append(String.format("%19s",  "SP DEF: " + enemy.getStats().getSpdef()));
		output.append(String.format("%13s",  "CHA: " + enemy.getStats().getCha()));
		output.append(String.format("%15s",  "ACC: " + enemy.getStats().getAcc()));
		output.append("\n\n\n**********\n\n\n");
		output.append(String.format("%-25s", "XP: " + enemy.getXp()));

		return output.toString();
	}
}
