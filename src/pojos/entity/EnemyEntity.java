package pojos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.Ability;
import pojos.Statblock;
import pojos.items.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnemyEntity extends Entity{

	String battleCry;
	String victoryCry;
	String loserCry;
	List<Item> loot;
	List<Ability> skills;
	int numOfHands;
	int xp;
	
	public EnemyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnemyEntity(String battleCry, String victoryCry, String loserCry, List<Item> loot, List<Ability> skills,
			Statblock stats, int numOfHands, int xp) {
		super();
		this.battleCry = battleCry;
		this.victoryCry = victoryCry;
		this.loserCry = loserCry;
		this.loot = loot;
		this.skills = skills;
		this.stats = stats;
		this.numOfHands = numOfHands;
		this.xp = xp;
	}
	
	public String getBattleCry() {
		return battleCry;
	}
	public void setBattleCry(String battleCry) {
		this.battleCry = battleCry;
	}
	public String getVictoryCry() {
		return victoryCry;
	}
	public void setVictoryCry(String victoryCry) {
		this.victoryCry = victoryCry;
	}
	public String getLoserCry() {
		return loserCry;
	}
	public void setLoserCry(String loserCry) {
		this.loserCry = loserCry;
	}
	public List<Item> getLoot() {
		return loot;
	}
	public void setLoot(List<Item> loot) {
		this.loot = loot;
	}
	public List<Ability> getSkills() {
		return skills;
	}
	public void setSkills(List<Ability> skills) {
		this.skills = skills;
	}
	
	public int getNumOfHands() {
		return numOfHands;
	}
	public void setNumOfHands(int numOfHands) {
		this.numOfHands = numOfHands;
	}
	
	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	@Override
	public String toString() {
		return "EnemyEntity [battleCry=" + battleCry + ", victoryCry=" + victoryCry + ", loserCry=" + loserCry
				+ ", loot=" + loot + ", skills=" + skills + ", numOfHands=" + numOfHands + ", xp=" + xp + ", name="
				+ name + ", description=" + description + ", temperament=" + temperament + ", species=" + species
				+ ", inventory=" + inventory + ", stats=" + stats + ", level=" + level + "]";
	}
	
}
