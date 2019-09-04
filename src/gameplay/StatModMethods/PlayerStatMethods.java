package gameplay.StatModMethods;

import pojos.Statblock;
import uiView.UIMain;

public class PlayerStatMethods {

	public PlayerStatMethods() {
		
	}
	
	public String fullHP(){
		StringBuilder output = new StringBuilder();
		output.append("HP: " + UIMain.player.getStats().getCurrentHP() + " -> "); 
		UIMain.player.getStats().setCurrentHP(UIMain.player.getStats().getHp());
		output.append(UIMain.player.getStats().getCurrentHP());
		return output.toString();
	}
	public String fullSP(){
		StringBuilder output = new StringBuilder();
		output.append("SP: " + UIMain.player.getStats().getCurrentSP() + " -> "); 
		UIMain.player.getStats().setCurrentSP(UIMain.player.getStats().getSp());
		output.append(UIMain.player.getStats().getCurrentSP());
		return output.toString();
	}
	
	public Statblock calculateBaseStats() {
		//compares the stats of the class and species
		//sets HP and SP to max
		Statblock stats = new Statblock();
		stats.setHp(calculateBaseHp());
		stats.setSp(calculateBaseSp());
		stats.setAtk(calculateBaseAtk());
		stats.setDef(calculateBaseDef());
		stats.setSpatk(calculateBaseSpAtk());
		stats.setSpdef(calculateBaseSpDef());
		stats.setEva(calculateBaseEva());
		stats.setIntel(calculateBaseIntel());
		stats.setCha(calculateBaseCha());
		stats.setSta(calculateBaseSta());
		stats.setAgi(calculateBaseAgi());
		stats.setAcc(calculateBaseAcc());
		stats.setCurrentHP(stats.getHp());
		stats.setCurrentSP(stats.getSp());
		return stats;
	}
	
	private int calculateBaseHp() {
		int hp = UIMain.player.getEntityClass().getStats().getHp() 
				+ UIMain.player.getSpeciesObject().getStats().getHp();
		if(hp > 0) {
			return hp;
		}
		return 0;
	}
	private int calculateBaseSp() {
		int sp = UIMain.player.getEntityClass().getStats().getSp() 
				+ UIMain.player.getSpeciesObject().getStats().getSp();
		if(sp > 0) {
			return sp;
		}
		return 0;
	}
	private int calculateBaseAtk() {
		int atk = UIMain.player.getEntityClass().getStats().getAtk() 
				+ UIMain.player.getSpeciesObject().getStats().getAtk();
		if(atk > 0) {
			return atk;
		}
		return 0;
	}
	private int calculateBaseDef() {
		int def = UIMain.player.getEntityClass().getStats().getDef() 
				+ UIMain.player.getSpeciesObject().getStats().getDef();
		if(def > 0) {
			return def;
		}
		return 0;
	}
	private int calculateBaseSpAtk() {
		int spAtk = UIMain.player.getEntityClass().getStats().getSpatk() 
				+ UIMain.player.getSpeciesObject().getStats().getSpatk();
		if(spAtk > 0) {
			return spAtk;
		}
		return 0;
	}
	private int calculateBaseSpDef() {
		int spDef = UIMain.player.getEntityClass().getStats().getSpdef() 
				+ UIMain.player.getSpeciesObject().getStats().getSpdef();
		if(spDef > 0) {
			return spDef;
		}
		return 0;
	}
	private int calculateBaseEva() {
		int eva = UIMain.player.getEntityClass().getStats().getEva() 
				+ UIMain.player.getSpeciesObject().getStats().getEva();
		if(eva > 0) {
			return eva;
		}
		return 0;
	}	
	private int calculateBaseIntel() {
		int intel = UIMain.player.getEntityClass().getStats().getIntel() 
				+ UIMain.player.getSpeciesObject().getStats().getIntel();
		if(intel > 0) {
			return intel;
		}
		return 0;
	}	
	private int calculateBaseCha() {
		int cha = UIMain.player.getEntityClass().getStats().getCha() 
				+ UIMain.player.getSpeciesObject().getStats().getCha();
		if(cha > 0) {
			return cha;
		}
		return 0;
	}	
	private int calculateBaseSta() {
		int sta = UIMain.player.getEntityClass().getStats().getSta() 
				+ UIMain.player.getSpeciesObject().getStats().getSta();
		if(sta > 0) {
			return sta;
		}
		return 0;
	}
	private int calculateBaseAgi() {
		int agi = UIMain.player.getEntityClass().getStats().getAgi() 
				+ UIMain.player.getSpeciesObject().getStats().getAgi();
		if(agi > 0) {
			return agi;
		}
		return 0;
	}
	private int calculateBaseAcc() {
		int acc = UIMain.player.getEntityClass().getStats().getAcc() 
				+ UIMain.player.getSpeciesObject().getStats().getAcc();
		if(acc > 0) {
			return acc;
		}
		return 0;
	}	
}
