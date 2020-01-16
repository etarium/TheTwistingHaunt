package gameplay.battle;

import java.util.ArrayList;

import gameplay.commandServices.PlayerService;
import entity.Entity;
import uiView.UIMain;

public class VictoryService {
	
	static int accruedXP = 0;
	
	public static boolean isVictory() {
		if(countRemainingEnemies() == 0) {
			UIMain.battleOrder = new ArrayList();
			return true;
		}
		return false;
	}
	
	public static void trackXP(int xp, int enemyLevel) {
		double multiplier = (enemyLevel / UIMain.player.getLevel());
		int calculatedXP = (int) (xp * multiplier);
		accruedXP += calculatedXP;
	}
	
	public static String victory() {
		//TODO
		StringBuilder output = new StringBuilder();
		output.append("All foes have been vanquished");
		if(didLevelUp()) {
			PlayerService service = new PlayerService();
			output.append(", and you feel yourself become stronger!");
			output.append("\nXP Earned: " + accruedXP);
			output.append("\n" + service.getPlayerStats());
		} else {
			output.append("!");
			output.append("\n**********");
			output.append("\nXP Earned: " + accruedXP);
			output.append("\nXP to Next Level: " + UIMain.player.getXpToNextLevel());
		}
		
		awardXP();
		exitBattle();
		
		accruedXP = 0;
		return output.toString();
	}
	
	private static void awardXP() {
		UIMain.player.setXp(accruedXP);
		
		//after XP has been awared, set the value back to zero for the next battle
		
	}
	
	private static boolean didLevelUp() {
		if(accruedXP > UIMain.player.getXpToNextLevel()) {
			UIMain.player.setLevel(UIMain.player.getLevel()+1);
			UIMain.player.setXpToNextLevel(calculateXpToNextLevel());
			return true;
		} else {
			UIMain.player.setXpToNextLevel(UIMain.player.getXpToNextLevel() - accruedXP);
		}
		return false;
	}
	
	private static void exitBattle() {
		UIMain.player.setIsInEncounter(false);
	}
	
	private static int calculateXpToNextLevel() {
		//xp beyond what was needed to level will carry over to help with the next level
		int overflowXP = - (UIMain.player.getXpToNextLevel() - accruedXP);
		int remainingXP = ((UIMain.player.getLevel() * 3) + 100) - overflowXP;
		return remainingXP;
	}

	public static String defeatedEnemy(entity.EnemyEntity selectedTarget) {
		String output = "";
		if(VictoryService.isVictory()) {
			output = VictoryService.victory();
		} else {
			output = "\nThe " + selectedTarget.getName() + " let out a horrible scream.\n"
					+ "Great Job! Only " + countRemainingEnemies() + " remaining!\n";
		}
		return output;
	}
	
	private static int countRemainingEnemies() {
		int remainingEnemies = 0;
		for(Entity entity : UIMain.battleOrder) {
			if(!entity.getName().equals(UIMain.player.getName()) && entity.getStats().getCurrentHP() > 0) {
				remainingEnemies++;
			}
		}
		return remainingEnemies;
	}
}
