package pojos.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.Statblock;
import pojos.items.enums.ItemType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	
	String name;
	ItemType type;
	String description;
	String usedDescription;
	Statblock stats;
	int minLevel;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsedDescription() {
		return usedDescription;
	}

	public void setUsedDescription(String usedDescription) {
		this.usedDescription = usedDescription;
	}

	public Statblock getStats() {
		return stats;
	}

	public void setStats(Statblock stats) {
		this.stats = stats;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", type=" + type + ", description=" + description + ", usedDescription="
				+ usedDescription + ", \nstats=" + stats + ", \nminLevel=" + minLevel + "]";
	}
	
}
