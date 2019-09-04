package gameplay.battle;

import java.util.LinkedList;
import java.util.List;

import gameplay.StatModMethods.BattleStatMethods;
import pojos.entity.Entity;
import uiView.UIMain;
import utilities.Logs;

public class BattleOrder {

	private BattleStatMethods statMethods = new BattleStatMethods();
	private List<Entity> battleOrder = new LinkedList<Entity>();
	private List<Entity> initialOrder = new LinkedList<Entity>();
	double enemyInit = 0.0;

	public String initializeBattle() {
		List<Entity> battleOrder = determineBattleOrder();
		determineFirstAttack();
		return formatBattleOrder(battleOrder);
	}

	private Entity determineFirstAttack() {
		Logs.LOGGER.info("Determine First Attacker");
		return battleOrder.get(0);
	}

	private List<Entity> calculateAllInits() {
		//first calculate the player
		Logs.LOGGER.info("Calculating All Initiatives");
		double playerInit = statMethods.calculateInitiative(UIMain.player);
		UIMain.player.getStats().setInit(playerInit);
		initialOrder.add(UIMain.player);
		
		for(Entity enemy : UIMain.player.currentCell.getEnemies()) {
			enemyInit = statMethods.calculateInitiative(enemy);
			enemy.getStats().setInit(enemyInit);
			initialOrder.add(enemy);
		}
		
		Logs.LOGGER.info("All initiatives calculated");
		return initialOrder;
	}
	private List<Entity> determineBattleOrder () {
		
		initialOrder = calculateAllInits();
		//then check against all entities
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
		Logs.LOGGER.info("Battle order for all opponents calculated");
		return battleOrder;
	}

	private String formatBattleOrder(List<Entity> battleOrder) {
		StringBuilder output = new StringBuilder();
		for(Entity entity : battleOrder) {
		output.append(String.format(entity.getName() + " -> "));
		}
		output.replace(output.length()-4, output.length(), "");
		Logs.LOGGER.info("Formatted battle order for game output " + output.toString());
		return output.toString();
	}


}