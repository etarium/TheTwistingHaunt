package pojos.environment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.entity.Entity;
import pojos.items.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InspectableObjects {

	String name;
	String description;
	List<Entity> enemies;
	List<Item> items;
	boolean isLocked;
	
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
	public List<Entity> getEnemies() {
		return enemies;
	}
	public void setEnemies(List<Entity> enemies) {
		this.enemies = enemies;
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
	
	@Override
	public String toString() {
		return "InspectableObjects [name=" + name + ", description=" + description + ", enemies=" + enemies + ", items="
				+ items + ", isLocked=" + isLocked + "]";
	}
	
}
