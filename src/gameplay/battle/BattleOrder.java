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
		return null;
	}

	private List<Entity> determineBattleOrder () {
		//TODO
		//first calculate the player
		System.out.println("entered determine battle ordeR");
		double playerInit = statMethods.calculateInitiative(UIMain.player);
		UIMain.player.getStats().setInit(playerInit);
		initialOrder.add(UIMain.player);
		battleOrder.add(UIMain.player);
		//then check against all entities
//		for(Entity enemy : UIMain.player.currentCell.getEnemies()) {
//			System.out.println("calculate Enemies for loop");
//			enemyInit = statMethods.calculateInitiative(enemy);
//			enemy.getStats().setInit(enemyInit);
//			initialOrder.add(enemy);
//		}
//		System.out.println("sort array");
//		for(int i=0; i < initialOrder.size()-1; i++) {
//			if(initialOrder.get(i).getStats().getInit() > initialOrder.get(i+1).getStats().getInit()) {
//				battleOrder.add(i, initialOrder.get(i));
//			} else {
//				battleOrder.add(initialOrder.get(i));
//			}
//		}
		for(Entity entity: battleOrder) {
			System.out.println(entity.getName() + " " + entity.getStats().getInit());
		}

		System.out.println("end of determine battle order");
		return battleOrder;
	}

	private String formatBattleOrder(List<Entity> battleOrder) {
		return "";
	}


}