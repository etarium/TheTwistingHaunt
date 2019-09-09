package gameplay.battle;

import java.util.LinkedList;
import java.util.List;

import gameplay.StatModMethods.BattleStatMethods;
import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
import uiView.UIMain;
import utilities.Logs;

public class BattleOrder {

	private BattleStatMethods statMethods = new BattleStatMethods();
	private List<Entity> initialOrder = new LinkedList<Entity>();
	double enemyInit = 0.0;

	public String initializeBattle() {
		UIMain.battleOrder = determineBattleOrder();
		determineFirstAttack();
		return formatBattleOrder(UIMain.battleOrder);
	}

	private Entity determineFirstAttack() {
		Logs.LOGGER.info("Determine First Attacker");
		return UIMain.battleOrder.get(0);
	}

	private List<Entity> calculateAllInits() {
		//reinitializing the lists
		//prevents possibly duplicating old entities in the list
		initialOrder = new LinkedList<Entity>();
		//first calculate the player
		Logs.LOGGER.info("Calculating All Initiatives");
		double playerInit = statMethods.calculateInitiative(UIMain.player);
		UIMain.player.getStats().setInit(playerInit);
		initialOrder.add(UIMain.player);
		
		for(EnemyEntity enemy : UIMain.player.currentCell.getEnemies()) {
			enemyInit = statMethods.calculateInitiative(enemy);
			enemy.getStats().setInit(enemyInit);
			initialOrder.add(enemy);
		}
		
		Logs.LOGGER.info("All initiatives calculated");
		return initialOrder;
	}
	
	public List<Entity> determineBattleOrder () {
		UIMain.battleOrder = new LinkedList<Entity>();
		initialOrder = calculateAllInits();
		//then check against all entities
		for(int i=0; i < initialOrder.size(); i++) {
			if(UIMain.battleOrder.isEmpty()) {
				UIMain.battleOrder.add(initialOrder.get(i));
			} else {
				if(initialOrder.get(i).getStats().getInit() > UIMain.battleOrder.get(i-1).getStats().getInit()) {
					for(int j=0; j<UIMain.battleOrder.size(); j++) {
						double higherStat = initialOrder.get(i).getStats().getInit();
						if(higherStat < UIMain.battleOrder.get(j).getStats().getInit()) {
							UIMain.battleOrder.add(j-1, initialOrder.get(i));
							break;
						}
					}
					UIMain.battleOrder.add(0, initialOrder.get(i));
				} else {
					UIMain.battleOrder.add(initialOrder.get(i));
				}
			}
		}
		
		Logs.LOGGER.info("Battle order for all opponents calculated");
		return UIMain.battleOrder;
	}

	public String formatBattleOrder(List<Entity> battleOrder) {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format("%45s", "************\n"));
		output.append(String.format("%45s", "Battle Order\n"));
		output.append("\n");
		StringBuilder entityOutput = new StringBuilder();
		entityOutput.append(String.format("%30s", ""));
		int lineCounter = 1;
		for(Entity entity : battleOrder) {
			//we should only have 30 chars per line
			if(entityOutput.length() < 50 && lineCounter == 1) {
				entityOutput.append(String.format(entity.getName() + " -> "));
			} else if (entityOutput.length() > 50 && entityOutput.length() < 110 && lineCounter == 2) {
				entityOutput.append(String.format(entity.getName() + " -> "));
			} else if (entityOutput.length() > 110 && entityOutput.length() < 200 && lineCounter == 3) {
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