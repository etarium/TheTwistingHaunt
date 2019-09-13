package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.ability.enums.AbilityType;
import pojos.enums.Attribute;

@JsonIgnoreProperties
public class Ability {

	String name;
	String description;
	Attribute attribute;
	AbilityType type;
	Statblock stats;
	int hpCost;
	int spCost;
	int duration;
	int numOfTargets;
	int minLevel;

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
	public AbilityType getType() {
		return type;
	}
	public void setType(AbilityType type) {
		this.type = type;
	}
	public Statblock getStats() {
		return stats;
	}
	public void setStats(Statblock stats) {
		this.stats = stats;
	}
	@Override
	public String toString() {
		return "Ability [name=" + name + ", description=" + description + ", attribute=" + attribute + ", type=" + type
				+ ", stats=" + stats + ", hpCost=" + hpCost + ", spCost=" + spCost + ", duration=" + duration
				+ ", numOfTargets=" + numOfTargets + ", minLevel=" + minLevel + "]";
	}
}
