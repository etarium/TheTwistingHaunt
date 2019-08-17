package gameplay.StatModMethods;

import uiView.UIMain;

public class PlayerStatMethods {

	public PlayerStatMethods() {
		
	}
	
	public String fullHP(){
		UIMain.player.getStats().setCurrentHP(UIMain.player.getStats().getHp());
		return "Health Points: " + UIMain.player.getStats().getHp();
	}
	public String fullSP(){
		UIMain.player.getStats().setCurrentSP(UIMain.player.getStats().getSp());
		return "Spell Points: " + UIMain.player.getStats().getSp();
	}
}
