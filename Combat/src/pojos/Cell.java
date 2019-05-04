package pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Cell {
 int[][][] coordinates;
 String instance;
 String description;
 String terrain;
 InspectableObjects inspectableObjects;
 List<Item> items;
 List<NPC> npcs;
 List<Enemy> enemies;
 boolean isLocked;
 boolean north;
 boolean south;
 boolean east;
 boolean west;
}
