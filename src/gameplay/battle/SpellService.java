package gameplay.battle;

import gameplay.StatModMethods.BattleEnemyStatMethods;
import gameplay.StatModMethods.BattlePlayerStatMethods;
import general.Ability;
import entity.EnemyEntity;
import entity.Entity;
import uiView.UIMain;

public class SpellService {

	public static String useDamageSpell(Ability spell, EnemyEntity target) {
		String output = "";
		//first, calculate damage based on player's stats and ability
		int dmg = (int) BattlePlayerStatMethods.calculateAbilityDamage(spell);
		//then, calculate the enemy's defense based on spdef
		int enemyDef = (int) BattleEnemyStatMethods.calculateEnemySpDef(target);
		int total = dmg - enemyDef;
		//apply the damage
		if(checkResourcesAvailable(spell)) {
			if(BattlePlayerStatMethods.calculatePlayerHitRate(target)) {
				target.getStats().setCurrentHP(target.getStats().getCurrentHP() - total);
				if(target.getStats().getCurrentHP() < 0) {
					target.getStats().setCurrentHP(0);
				}
				System.out.println(output);
				if(!CheckStatuses.isEnemyDead(target)) {
					output = "With a deep breath, you cast " + spell.getName() + ", and the raging magic rings out, ravishing the" + target.getName() +"! \n"
							+ "You deal " + total + " damage. \n"
							+ "Nice work, hero! \n";
				} else {
					VictoryService.trackXP(target.getXp(), target.getLevel());
					output = "With a deep breath, you cast " + spell.getName() + ", and the raging magic rings out, ravishing the " + target.getName() +"! \n"
							+ "You deal " + total + " damage. \n" + VictoryService.defeatedEnemy(target);
				}
			} else {
				output = "\nYou lunge toward " + target.getName() + ", but you were sidestepped and missed completely.\n"
						+ "Big bummer, hero. \n";
			}
		} else {

			output = "\nYou do not have the necessary resources left to use this skill! \n" +
					listResourceInfo(spell) +
					"\n[use /stats to check your stats, and /skills to see abilities and try again!]";
		}
		//TODO: incorporate elemental strengths and weaknesses

		return output;
	}

	public static String useDrainSpell(Ability spell, EnemyEntity target) {
		//TODO
		//first, calculate damage based on player's stats and ability
		//then, calculate the enemy's defense based on spdef
		//add the total damage to the player's hp
		//ensure the player's health does not exceed max hp
		//ensure the enemy's health does not become negative
		//TODO: incorporate elemental strengths and weaknesses

		return "";
	}

	public static String useHealSpell(Ability spell) {
		//first, calculate the support spell's potency based on player's stats and ability
		int heal = (int) BattlePlayerStatMethods.calculateAbilityHeal(spell);
		//then, apply heal to self
		UIMain.player.getStats().setCurrentHP(UIMain.player.getStats().getCurrentHP() + heal);
		if(UIMain.player.getStats().getCurrentHP() > UIMain.player.getStats().getHp()) {
			UIMain.player.getStats().setCurrentHP(UIMain.player.getStats().getHp());
		}
		String output = "With a deep breath, you cast " + spell.getName() + ", and feel yourself being rejuvenated. \n"
				+ "You have been healed " + heal + ". Your HP is now " + UIMain.player.getStats().getCurrentHP();
		//ensure the stat does not exceed max stat
		//TODO: incorporate elemental strengths and weaknesses
		return output;
	}

	public static String useBuffSpell(Ability spell) {
		//TODO
		//first, calculate stat increase based on player's stats and ability
		//then, calculate the ally's new stat
		//TODO: incorporate elemental strengths and weaknesses
		return "";
	}

	public static String useDeBuffSpell(Ability spell, Entity target) {
		//TODO
		//first, calculate stat decrease based on player's stats and ability
		//then, calculate the enemy's spdef to mitigate the debuff
		//then, apply the stat decrease
		//ensure the stat does not become negative
		//TODO: incorporate elemental strengths and weaknesses
		return "";
	}

	private static boolean checkResourcesAvailable(Ability spell) {
		int newHP = UIMain.player.getStats().getCurrentHP() - spell.getHpCost();
		int newSP = UIMain.player.getStats().getCurrentSP() - spell.getSpCost();
		if(newHP <= 0 || newSP < 0) {
			//the player does not have the necessary hp or sp left to use this skill
			//sp can reach zero, hp cannot.
			return false;
		}

		UIMain.player.getStats().setCurrentHP(newHP);
		UIMain.player.getStats().setCurrentSP(newSP);
		return true;
	}

	private static String listResourceInfo(Ability spell) {
		StringBuilder output = new StringBuilder();
		if(UIMain.player.getSkills().isEmpty() ) { 
			output.append("You have not learned any skills, ");
			output.append(UIMain.player.getName());
			output.append("\n\n");
			output.append("You will need to train more to gain proficiencies.");
		} else {
			output.append(String.format("%-25s", "Name: " + UIMain.player.getName()));
			output.append(String.format("%10s", "Class: " + UIMain.player.getEntityClass().getName()));
			output.append(String.format("%20s", "Level: " + UIMain.player.getLevel()));
			output.append(String.format("%30s",  "Species: " + UIMain.player.getSpeciesObject().getName()));
			output.append("\n\n\n");
			output.append(String.format("%-5s",  "HP: "));
			output.append(String.format("%5s",  UIMain.player.getStats().getHp()));
			output.append(String.format("%13s",  "SP: "));
			output.append(String.format("%6s", UIMain.player.getStats().getSp()));
			output.append("\n**********\n");
			output.append(String.format("%-25s", "Name: " + spell.getName()));
			output.append(String.format("%20s", "Min Level: " + spell.getMinLevel()));
			output.append("\n\n");
			output.append(String.format("%-5s",  "HP COST: "));
			output.append(String.format("%5s",  spell.getHpCost()));
			output.append(String.format("%13s",  "SP COST: "));
			output.append(String.format("%6s", spell.getSpCost()));
		}
		return output.toString();
	}

}
