package items;
/**
 * Authors: Emily Clark
 * Item should be able to replace Usable, Equipable, and KeyItems
 */
import game.StatBlock;

public class Item {
	String item_id;
	String type;
	String armorType;
	StatBlock statblock;
	int duration;
	int numHands;
	int numTarget;
	int minLevel;
	
	//Armor Equipable
	/**
	 * @param item_id
	 * @param type
	 * @param armorType
	 * @param statblock
	 * @param minLevel
	 */
	public Item ( String item_id, String type, String armorType, StatBlock statblock, int minLevel) {
		this.item_id = item_id;
		this.type = type;
		this.armorType = armorType;
		this.statblock = statblock;
		this.minLevel = minLevel;
	}
	
	//Weapon Equipable
	/**
	 * @param item_id
	 * @param type
	 * @param statblock
	 * @param numHands
	 * @param numTarget
	 * @param minLevel
	 */
	public Item (String item_id, String type, StatBlock statblock, int numHands, int minLevel) {
		this.item_id = item_id;
		this.type = type;
		this.statblock = statblock;
		this.numHands = numHands;
		this.minLevel = minLevel;	
	}
	
	//Usable
	public Item (String item_id, String type, StatBlock statblock, int duration, int numTarget, int minLevel) {
		this.item_id = item_id;
		this.type = type;
		this.statblock = statblock;
		this.duration = duration;
		this.numTarget = numTarget;
		this.minLevel = minLevel;
	}
	
}
