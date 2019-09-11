package gameplay.battle;

import pojos.Ability;
import pojos.entity.EnemyEntity;
import pojos.entity.Entity;

public class SpellService {

	public static String useDamageSpell(Ability spell, EnemyEntity target) {
		//TODO
		//first, calculate damage based on player's stats and ability
		//then, calculate the enemy's defense based on spdef
		//ensure the enemy's health does not become negative
		//TODO: incorporate elemental strengths and weaknesses
		
		return "";
	}

	public static String useDrainSpell(Ability spell, EnemyEntity target) {
		//TODO
		//first, calculate damage based on player's stats and ability
		//then, calculate the enemy's defense based on spdef
		//ensure the enemy's health does not become negative
		//TODO: incorporate elemental strengths and weaknesses
		
		return "";
	}

	public static String useHealSpell(Ability spell, Entity target) {
		//TODO
		//first, calculate the support spell's potency based on player's stats and ability
		//then, apply heal to ally
		//ensure the stat does not exceed max stat
		//TODO: incorporate elemental strengths and weaknesses
		return "";
	}

	public static String useBuffSpell(Ability spell, Entity target) {
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
