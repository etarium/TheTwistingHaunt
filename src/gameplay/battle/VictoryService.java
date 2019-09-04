package gameplay.battle;

import uiView.UIMain;

public class VictoryService {
	
	public static boolean isVictory() {
		if(UIMain.player.currentCell.getEnemies().size() == 0) {
			return true;
		}
		return false;
	}
	
	public static String victory() {
		//TODO
		return "";
	}
	
	private void awardXP() {
		
	}
	
	private boolean didLevelUp() {
		
		return false;
	}
	
	private void exitBattle() {
		UIMain.player.setIsInEncounter(false);
	}

}
