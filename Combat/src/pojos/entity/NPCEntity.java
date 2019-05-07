package pojos.entity;

import java.util.List;

import pojos.Quest;
import pojos.entity.enums.Faction;

public class NPCEntity extends Entity{

	List<Quest> quests;
	Faction faction;
	int xpEarned;
	int xpLost; //should we?
	
	public List<Quest> getQuests() {
		return quests;
	}
	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}
	public Faction getFaction() {
		return faction;
	}
	public void setFaction(Faction faction) {
		this.faction = faction;
	}
	
	@Override
	public String toString() {
		return "NPCEntity [quests=" + quests + ", faction=" + faction + ", name=" + name + ", description="
				+ description + ", temperament=" + temperament + ", species=" + species + ", inventory=" + inventory
				+ ", level=" + level + "]";
	}
	
}
