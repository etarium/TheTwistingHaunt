package gameplay.StatModMethods;

import gameplay.GamePlayConstants;
import general.Statblock;
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
		if(hp > GamePlayConstants.MIN_STAT) {
			return hp;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseSp() {
		int sp = UIMain.player.getEntityClass().getStats().getSp() 
				+ UIMain.player.getSpeciesObject().getStats().getSp();
		if(sp > GamePlayConstants.MIN_STAT) {
			return sp;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseAtk() {
		int atk = UIMain.player.getEntityClass().getStats().getAtk() 
				+ UIMain.player.getSpeciesObject().getStats().getAtk();
		if(atk > GamePlayConstants.MIN_STAT) {
			return atk;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseDef() {
		int def = UIMain.player.getEntityClass().getStats().getDef() 
				+ UIMain.player.getSpeciesObject().getStats().getDef();
		if(def > GamePlayConstants.MIN_STAT) {
			return def;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseSpAtk() {
		int spAtk = UIMain.player.getEntityClass().getStats().getSpatk() 
				+ UIMain.player.getSpeciesObject().getStats().getSpatk();
		if(spAtk > GamePlayConstants.MIN_STAT) {
			return spAtk;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseSpDef() {
		int spDef = UIMain.player.getEntityClass().getStats().getSpdef() 
				+ UIMain.player.getSpeciesObject().getStats().getSpdef();
		if(spDef > GamePlayConstants.MIN_STAT) {
			return spDef;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseEva() {
		int eva = UIMain.player.getEntityClass().getStats().getEva() 
				+ UIMain.player.getSpeciesObject().getStats().getEva();
		if(eva > GamePlayConstants.MIN_STAT) {
			return eva;
		}
		return GamePlayConstants.MIN_STAT;
	}	
	private int calculateBaseIntel() {
		int intel = UIMain.player.getEntityClass().getStats().getIntel() 
				+ UIMain.player.getSpeciesObject().getStats().getIntel();
		if(intel > GamePlayConstants.MIN_STAT) {
			return intel;
		}
		return GamePlayConstants.MIN_STAT;
	}	
	private int calculateBaseCha() {
		int cha = UIMain.player.getEntityClass().getStats().getCha() 
				+ UIMain.player.getSpeciesObject().getStats().getCha();
		if(cha > GamePlayConstants.MIN_STAT) {
			return cha;
		}
		return GamePlayConstants.MIN_STAT;
	}	
	private int calculateBaseSta() {
		int sta = UIMain.player.getEntityClass().getStats().getSta() 
				+ UIMain.player.getSpeciesObject().getStats().getSta();
		if(sta > GamePlayConstants.MIN_STAT) {
			return sta;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseAgi() {
		int agi = UIMain.player.getEntityClass().getStats().getAgi() 
				+ UIMain.player.getSpeciesObject().getStats().getAgi();
		if(agi > GamePlayConstants.MIN_STAT) {
			return agi;
		}
		return GamePlayConstants.MIN_STAT;
	}
	private int calculateBaseAcc() {
		int acc = UIMain.player.getEntityClass().getStats().getAcc() 
				+ UIMain.player.getSpeciesObject().getStats().getAcc();
		if(acc > GamePlayConstants.MIN_STAT) {
			return acc;
		}
		return GamePlayConstants.MIN_STAT;
	}	
}
