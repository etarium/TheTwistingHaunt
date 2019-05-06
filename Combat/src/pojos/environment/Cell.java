package pojos.environment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.entity.EnemyEntity;
import pojos.entity.NPCEntity;
import pojos.items.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cell {
 String _id;
 Location coordinates;
 Instance instance;
 String description;
 String terrain;
 InspectableObjects inspectableObjects;
 List<Item> items;
 List<NPCEntity> npcs;
 List<EnemyEntity> enemies;
 boolean isLocked;
 List<Item> requiredItems; //used for places that require certain triggers to be able to enter, locked doors, etc
 boolean north;
 boolean south;
 boolean east;
 boolean west;
@Override
public String toString() {
	return "Cell [id = " +_id + "coordinates=" + coordinates + ", instance=" + instance + ", description=" + description + ",\n"
			+ " terrain=" + terrain + ", inspectableObjects=" + inspectableObjects + ", items=" + items + ",\n"
			+ " npcs=" + npcs + ", enemies=" + enemies + ", isLocked=" + isLocked + ", requiredItems=" + requiredItems + ", north="
			+ north + ", south=" + south + ", east=" + east + ", west=" + west + "]";
}
 
 
}
