package gameplay.StatModMethods;

import pojos.Statblock;
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
	
	public Statblock calculateBaseStats() {
		//compares the stats of the class and species
		Statblock stats = new Statblock();
		stats.setHp(calculateBaseHp());
		stats.setSp(calculateBaseSp());
		stats.setAtk(calculateBaseAtk());
		stats.setDef(calculateBaseDef());
		
		return stats;
	}
	
	private int calculateBaseHp() {
		int hp = UIMain.player.getEntityClass().getStats().getHp() + UIMain.player.getSpeciesObject().getStats().getHp();
		if(hp > 0) {
			return hp;
		}
		return 0;
	}
	private int calculateBaseSp() {
		int sp = UIMain.player.getEntityClass().getStats().getSp() + UIMain.player.getSpeciesObject().getStats().getSp();
		if(sp > 0) {
			return sp;
		}
		return 0;
	}
	private int calculateBaseAtk() {
		int atk = UIMain.player.getEntityClass().getStats().getAtk() + UIMain.player.getSpeciesObject().getStats().getAtk();
		if(atk > 0) {
			return atk;
		}
		return 0;
	}
	private int calculateBaseDef() {
		int def = UIMain.player.getEntityClass().getStats().getDef() + UIMain.player.getSpeciesObject().getStats().getDef();
		if(def > 0) {
			return def;
		}
		return 0;
	}

}
