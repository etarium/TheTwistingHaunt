package pojos.entity;

import java.util.List;

import pojos.Quest;
import pojos.Skill;
import pojos.Statblock;
import pojos.items.ArmorItem;
import pojos.items.Item;
import pojos.items.WeaponItem;

public class PlayerEntity {
	
	EntityClassObject entityClass;
	int numOfHands;
	List<Item> inventory;
	Statblock stats;
	List<Skill> skills;
	List<Quest> quests;
	List<ArmorItem> armor;
	List<WeaponItem> weapons;
	
}
