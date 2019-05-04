package pojos.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.Statblock;
import pojos.items.enums.ItemType;

@JsonIgnoreProperties
public class Item {
	
	String name;
	ItemType type;
	String description;
	String usedDescription;
	Statblock stats;
	int minLevel;
}
