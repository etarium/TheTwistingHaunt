package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statblock {

	int hp;
	int sp;
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
	@Override
	public String toString() {
		return "Statblock [hp=" + hp + ", sp=" + sp + ", atk=" + atk + ", def=" + def + ", spatk=" + spatk + ", spdef="
				+ spdef + ", eva=" + eva + ", intel=" + intel + ", cha=" + cha + ", sta=" + sta + ", agi=" + agi
				+ ", acc=" + acc + "]";
	}
	
}
