package gameplay.battle;

import java.util.LinkedList;
import java.util.List;

import gameplay.StatModMethods.BattleStatMethods;
import pojos.entity.Entity;
import uiView.UIMain;

public class BattleOrder {

	private BattleStatMethods statMethods = new BattleStatMethods();
	private List<Entity> battleOrder = new LinkedList<Entity>();
	private List<Entity> initialOrder = new LinkedList<Entity>();
	double enemyInit = 0.0;

	public String initializeBattle() {
		determineFirstAttack();
		List<Entity> battleOrder = determineBattleOrder();
		return formatBattleOrder(battleOrder);
	}

	private Entity determineFirstAttack() {
		return battleOrder.get(0);
	}

	private List<Entity> calculateAllInits() {
		//first calculate the player
		double playerInit = statMethods.calculateInitiative(UIMain.player);
		UIMain.player.getStats().setInit(playerInit);
		initialOrder.add(UIMain.player);
		
		for(Entity enemy : UIMain.player.currentCell.getEnemies()) {
			System.out.println("calculate Enemies for loop");
			enemyInit = statMethods.calculateInitiative(enemy);
			enemy.getStats().setInit(enemyInit);
			initialOrder.add(enemy);
		}
		
		return initialOrder;
	}
	private List<Entity> determineBattleOrder () {
		
		initialOrder = calculateAllInits();
		//then check against all entities
		for(Entity enemy : UIMain.player.currentCell.getEnemies()) {
			System.out.println("calculate Enemies for loop");
			enemyInit = statMethods.calculateInitiative(enemy);
			enemy.getStats().setInit(enemyInit);
			initialOrder.add(enemy);
		}
		for(int i=0; i < initialOrder.size(); i++) {
			if(battleOrder.isEmpty()) {
				battleOrder.add(initialOrder.get(i));
			} else {
				if(initialOrder.get(i).getStats().getInit() > battleOrder.get(i-1).getStats().getInit()) {
					battleOrder.add(i, initialOrder.get(i));
				} else {
					battleOrder.add(initialOrder.get(i));
				}
			}
		}

		return battleOrder;
	}

	private String formatBattleOrder(List<Entity> battleOrder) {
		return "";
	}


}