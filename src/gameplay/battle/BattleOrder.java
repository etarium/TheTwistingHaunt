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
		initialOrder = calculateAllInits();
		initialOrder = calculateAllInits();
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
		
		output.append(String.format("%40s", "Battle Order"));
		output.append("\n");
		StringBuilder entityOutput = new StringBuilder();
		entityOutput.append(String.format("%30s", ""));
		for(Entity entity : battleOrder) {
			int lineCounter = 1;
			//we should only have 30 chars per line
			if(entityOutput.length() < 30 && lineCounter == 1) {
				entityOutput.append(String.format(entity.getName() + " -> "));
			} else if (output.length() > 30 && output.length() < 60 && lineCounter == 3) {
				entityOutput.append(String.format(entity.getName() + " -> "));
			} else if (output.length() > 60 && output.length() < 90 && lineCounter == 4) {
				entityOutput.append(String.format(entity.getName() + " -> "));
			} else {
				entityOutput.append("\n");
				lineCounter++;
				entityOutput.append(String.format("%30s", ""));
				entityOutput.append(String.format(entity.getName() + " -> "));
				
			}
		}
		entityOutput.replace(entityOutput.length()-4, entityOutput.length(), "");
		output.append(entityOutput);
		Logs.LOGGER.info("Formatted battle order for game output " + output.toString());
		return output.toString();
	}

}