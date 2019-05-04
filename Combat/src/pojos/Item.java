package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.enums.ItemType;

@JsonIgnoreProperties
public class Item {
	
	String name;
	ItemType type;
	String description;
	String usedDescription;
	Statblock stats;
	int minLevel;
}
