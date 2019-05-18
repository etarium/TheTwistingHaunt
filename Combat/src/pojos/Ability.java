package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.enums.Attribute;

@JsonIgnoreProperties
public class Ability {

	String name;
	String description;
	Attribute attribute;
	int hpCost;
	int spCost;
	int accuracy;
	int duration;
	int numOfTargets;
	int minLevel;
	int damage;
	int healing;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	public int getHpCost() {
		return hpCost;
	}
	public void setHpCost(int hpCost) {
		this.hpCost = hpCost;
	}
	public int getSpCost() {
		return spCost;
	}
	public void setSpCost(int spCost) {
		this.spCost = spCost;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNumOfTargets() {
		return numOfTargets;
	}
	public void setNumOfTargets(int numOfTargets) {
		this.numOfTargets = numOfTargets;
	}
	public int getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealing() {
		return healing;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}
	
	@Override
	public String toString() {
		return "Skill [name=" + name + ", description=" + description + ", attribute=" + attribute + ", hpCost="
				+ hpCost + ", spCost=" + spCost + ", accuracy=" + accuracy + ", duration=" + duration
				+ ", numOfTargets=" + numOfTargets + ", minLevel=" + minLevel + ", damage=" + damage + ", healing="
				+ healing + "]";
	}
	
}
