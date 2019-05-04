package pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.entity.EnemyEntity;
import pojos.entity.NPCEntity;
import pojos.items.Item;

@JsonIgnoreProperties
public class Cell {
 int[][][] coordinates;
 String instance;
 String description;
 String terrain;
 InspectableObjects inspectableObjects;
 List<Item> items;
 List<NPCEntity> npcs;
 List<EnemyEntity> enemies;
 boolean isLocked;
 boolean north;
 boolean south;
 boolean east;
 boolean west;
}
