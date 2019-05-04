package pojos;

import java.util.List;

import pojos.entity.Entity;
import pojos.environment.Location;
import pojos.items.Item;

public class Quest {

	String _id;
	String name;
	String description;
	List<Item> questItems;
	List<Item> questRewards;
	List<Entity> questEntities;
	Location coordinatesOfQuest;
	Location coordinatesOfNPC;
	String npcDialogueForQuest;
	String npcDialogueForQuestCompletion;
	String npcDialogueForQuestAbandonment;
	int minLevel;
}
