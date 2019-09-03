package pojos.environment;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
import pojos.items.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cell {
	
	String _id;
	Location location;
	Instance instance;
	String description;
	String terrain;
	List<InspectableObjects> inspectableObjects;
	List<Item> items;
	List<Entity> npcs;
	List<EnemyEntity> enemies = new ArrayList<EnemyEntity>();
	boolean isLocked;
	List<Item> requiredItems; //used for places that require certain triggers to be able to enter, locked doors, etc
	boolean north;
	boolean south;
	boolean east;
	boolean west;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public List<InspectableObjects> getInspectableObjects() {
		return inspectableObjects;
	}

	public void setInspectableObjects(List<InspectableObjects> inspectableObjects) {
		this.inspectableObjects = inspectableObjects;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public List<Item> getRequiredItems() {
		return requiredItems;
	}

	public void setRequiredItems(List<Item> requiredItems) {
		this.requiredItems = requiredItems;
	}

	public List<Entity> getNpcs() {
		return npcs;
	}

	public void setNpcs(List<Entity> npcs) {
		this.npcs = npcs;
	}

	public List<EnemyEntity> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<EnemyEntity> enemies) {
		this.enemies = enemies;
	}

	public boolean isNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean isSouth() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean isWest() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	@Override
	public String toString() {
		return "Cell [location=" + location + ", instance=" + instance + ", description=" + description + ", terrain="
				+ terrain + ", inspectableObjects=" + inspectableObjects + ", items=" + items + ", npcs=" + npcs
				+ ", enemies=" + enemies + ", isLocked=" + isLocked + ", requiredItems=" + requiredItems + ", north="
				+ north + ", south=" + south + ", east=" + east + ", west=" + west + "]";
	} 

}
