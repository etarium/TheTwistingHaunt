package gameplay.battle;

import java.util.List;

import gameplay.StatModMethods.BattleStatMethods;
import pojos.entity.Entity;
import uiView.UIMain;

public class BattleOrder {

	private BattleStatMethods statMethods = new BattleStatMethods();
	
	public String initializeBattle() {
		determineFirstAttack();
		List<Entity> battleOrder = determineBattleOrder();
		return formatBattleOrder(battleOrder);
	}
	
	private Entity determineFirstAttack() {
		//first calculate the player
		double playerInit = statMethods.calculateInitiative(UIMain.player);
		
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
