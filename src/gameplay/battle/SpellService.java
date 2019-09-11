package gameplay.battle;

import gameplay.StatModMethods.BattleEnemyStatMethods;
import gameplay.StatModMethods.BattlePlayerStatMethods;
import pojos.Ability;
import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
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

		if(BattlePlayerStatMethods.calculatePlayerHitRate(target)) {
			target.getStats().setCurrentHP(target.getStats().getCurrentHP() - total);
			if(target.getStats().getCurrentHP() < 0) {
				target.getStats().setCurrentHP(0);
			}

			if(!CheckStatuses.isEnemyDead(target)) {
				output = "With a deep breath, you cast " + spell.getName() + ", and the raging magic rings out, ravishing " + target.getName() +" \n"
						+ "You deal " + total + " damage. \n"
						+ "Nice work, hero! \n";
			} else {
				VictoryService.trackXP(target.getXp(), target.getLevel());
				output = "With a deep breath, you cast " + spell.getName() + ", and the raging magic rings out, ravishing " + target.getName() +" \n"
						+ "You deal " + total + " damage. \n" + VictoryService.defeatedEnemy(target);
			}
		} else {
			output = "\nYou lunge toward " + target.getName() + ", but you were sidestepped and missed completely.\n"
					+ "Big bummer, hero. \n";
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
		String output = "With a deep breath, you cast " + spell.getName() + ", and feel yourself being healed. \n"
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
}
