package gameplay.StatModMethods;

import pojos.entity.Entity;
import uiView.UIMain;

public class BattleStatMethods {

	public double calculateInitiative(Entity entity) {
		// [ (agility * .8) + (lvl * .15) + (RANDOM * .05)]
		//entity can be the player or any enemy or npc
		double playerAgility = entity.getStats().getAgi() * .8;
		double playerLevel = entity.getLevel() * .15;
		double randomMultiplier = Math.random() * .05;
		double initiative = playerAgility + playerLevel + randomMultiplier;
		return initiative;
	}
	
	public int calculatePhysDamage() {
		//TODO
		return 0;
	}
	
	public int calculateSpellDamage() {
		//TODO
		return 0;
	}
}
