package pojos.entity;

import java.util.List;

import pojos.Ability;
import pojos.Statblock;
import pojos.items.Item;

public class EnemyEntity extends Entity{

	String battleCry;
	String victoryCry;
	String loserCry;
	List<Item> loot;
	List<Ability> skills;
	Statblock stats;
	int numOfHands;
	
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
	public Statblock getStats() {
		return stats;
	}
	public void setStats(Statblock stats) {
		this.stats = stats;
	}
	
	public int getNumOfHands() {
		return numOfHands;
	}
	public void setNumOfHands(int numOfHands) {
		this.numOfHands = numOfHands;
	}
	
	@Override
	public String toString() {
		return "EnemyEntity [battleCry=" + battleCry + ", victoryCry=" + victoryCry + ", loserCry=" + loserCry
				+ ", loot=" + loot + ", skills=" + skills + ", stats=" + stats + ", numOfHands=" + numOfHands
				+ ", name=" + name + ", description=" + description + ", temperament=" + temperament + ", species="
				+ species + ", inventory=" + inventory + ", level=" + level + "]";
	}
	
}
