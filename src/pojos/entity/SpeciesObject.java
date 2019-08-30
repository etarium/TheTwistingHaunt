package pojos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.Statblock;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeciesObject {

	String name;
	String description;
	int numOfHands;
	Statblock stats;
	
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
	public int getNumOfHands() {
		return numOfHands;
	}
	public void setNumOfHands(int numOfHands) {
		this.numOfHands = numOfHands;
	}
	public Statblock getStats() {
		return stats;
	}
	public void setStats(Statblock stats) {
		this.stats = stats;
	}
	
	@Override
	public String toString() {
		return "SpeciesObject [name=" + name + ", description=" + description + ", numOfHands=" + numOfHands
				+ ", stats=" + stats + "]";
	}
}
