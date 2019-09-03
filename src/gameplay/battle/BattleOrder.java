package gameplay.battle;

import java.util.List;

import pojos.entity.Entity;

public class BattleOrder {

	public String initializeBattle() {
		determineFirstAttack();
		List<Entity> battleOrder = determineBattleOrder();
		return formatBattleOrder(battleOrder);
	}
	
	private Entity determineFirstAttack() {
		//TODO
		return null;
	}
	
	private List<Entity> determineBattleOrder () {
		//TODO
		return null;
	}
	
	private String formatBattleOrder(List<Entity> battleOrder) {
		return "";
	}
}
