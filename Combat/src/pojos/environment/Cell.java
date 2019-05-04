package pojos.environment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.entity.EnemyEntity;
import pojos.entity.NPCEntity;
import pojos.items.Item;

@JsonIgnoreProperties
public class Cell {
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
}
