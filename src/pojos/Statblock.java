package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statblock {

	int hp;
	int sp;
	int currentHP;
	int currentSP;
	int atk;
	int def;
	int spatk;
	int spdef;
	int eva;
	int intel;
	int cha;
	int sta;
	int agi;
	int acc;
	double init;
	
	public Statblock() {
		this.hp = 0;
		this.sp = 0;
		this.currentHP = 0;
		this.currentSP = 0;
		this.atk = 0;
		this.def = 0;
		this.spatk = 0;
		this.spdef  = 0;
		this.eva = 0;
		this.intel = 0;
		this.cha = 0;
		this.sta = 0;
		this.agi = 0;
		this.acc = 0;
		this.init = 0;
	}
	
	public Statblock(int hp, int sp, int atk, int def, int spatk, int spdef, int eva, int intel, int cha, int sta,
			int agi, int acc) {
		super();
		this.hp = hp;
		this.sp = sp;
		//start at full HP and SP
		this.currentHP = hp;
		this.currentSP = sp;
		this.atk = atk;
		this.def = def;
		this.spatk = spatk;
		this.spdef = spdef;
		this.eva = eva;
		this.intel = intel;
		this.cha = cha;
		this.sta = sta;
		this.agi = agi;
		this.acc = acc;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getCurrentSP() {
		return currentSP;
	}

	public void setCurrentSP(int currentSP) {
		this.currentSP = currentSP;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getSpatk() {
		return spatk;
	}
	public void setSpatk(int spatk) {
		this.spatk = spatk;
	}
	public int getSpdef() {
		return spdef;
	}
	public void setSpdef(int spdef) {
		this.spdef = spdef;
	}
	public int getEva() {
		return eva;
	}
	public void setEva(int eva) {
		this.eva = eva;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}
	
	public double getInit() {
		return init;
	}

	public void setInit(double init) {
		this.init = init;
	}

	@Override
	public String toString() {
		return "Statblock [hp=" + hp + ", sp=" + sp + ", atk=" + atk + ", def=" + def + ", spatk=" + spatk + ", spdef="
				+ spdef + ", eva=" + eva + ", intel=" + intel + ", cha=" + cha + ", sta=" + sta + ", agi=" + agi
				+ ", acc=" + acc + "]";
	}
	
}
