package game;

import java.io.Serializable;
import java.util.ArrayList;

import items.Item;
import items.KeyItems;

/**
 *
 * @author Jason Richter & Emily Clark
 */

public class Cell implements Serializable{
    
    /**
	 * Fields ENCOUNTER, ITEMS, and REQUIREDITEMS are all optional fields and do not need to be populated for each cell.
	 */
	private static final long serialVersionUID = -6891627105178688717L;
	private String _id;
	private Location location;
	private String instance_id;
    private String desc;
    private String terrain;
    private Encounter encounter;
    private Item item;
    private KeyItems requiredItem;
    private Inspectable inspectable;
    private boolean moveN;
    private boolean moveS;
    private boolean moveE;
    private boolean moveW;
    /*
    private ArrayList<Equipable> cellEq;
    private ArrayList<KeyItems> cellkey;
    private ArrayList<Usable> cellUse;
    */

    /*
     * Empty Constructor
     */
    public Cell() {
    }

    /*
     * If all fields are populated
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, Encounter encounter, Item item, KeyItems requiredItem, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
    		this._id = _id;
    		this.location = location;
    		this.instance_id = instance_id;
		this.desc = desc;
		this.inspectable = inspectable;
		this.encounter = encounter;
		this.item = item;
		this.requiredItem = requiredItem;
		this.terrain = terrain;
		this.moveN = moveN;
		this.moveS = moveS;
		this.moveE = moveE;
		this.moveW = moveW;
    }
    
    /*
     * No Encounter
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, Item item, KeyItems requiredItem, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
	this._id = _id;
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.inspectable = inspectable;
	this.item = item;
	this.requiredItem = requiredItem;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}
    /*
     * No Items
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, Encounter encounter, KeyItems requiredItem, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
	this._id = _id;
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.inspectable = inspectable;
	this.encounter = encounter;
	this.requiredItem = requiredItem;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}
    /*
     * No RequiredItem
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, Encounter encounter, Item item, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
	this._id = _id;
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.inspectable = inspectable;
	this.encounter = encounter;
	this.item = item;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}
    /*
     * No Encounters and No Items
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, KeyItems requiredItem, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
	this._id = _id;
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.inspectable = inspectable;
	this.requiredItem = requiredItem;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}
    /*
     * No Encounters and No RequiredItems
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, Item item, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
	this._id = _id;
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.inspectable = inspectable;
	this.item = item;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}
    /*
     * No Items and No RequiredItems
     */
    public Cell( String _id, Location location, String instance_id, String desc, Inspectable inspectable, Encounter encounter, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
    	
	this._id = _id;
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.inspectable = inspectable;
	this.encounter = encounter;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}

    
    /*
     * Uses this constructor if there are no items, encounters, or required items.
     */
    public Cell( Location location, String instance_id, String desc, Inspectable inspectable, String terrain, boolean moveN, boolean moveS, boolean moveE, boolean moveW) {
	this.location = location;
	this.instance_id = instance_id;
	this.desc = desc;
	this.terrain = terrain;
	this.moveN = moveN;
	this.moveS = moveS;
	this.moveE = moveE;
	this.moveW = moveW;
}

	public Location getLocation() {
        return location;
    }


    public String getDesc() {
        return desc;
    }

    public String getTerrain() {
        return terrain;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public Item getItem() {
        return item;
    }

    public KeyItems getKeyItem() {
        return requiredItem;
    }


    public boolean isNorth() {
        return moveN;
    }

    public boolean isSouth() {
        return moveS;
    }

    public boolean isEast() {
        return moveE;
    }

    public boolean isWest() {
        return moveW;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setKeyItem(KeyItems requiredItem) {
        this.requiredItem = requiredItem;
    }

    
    
/*
 * @override toString
 */
    public String toString()
    {
    		String formatString = "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n\n"
	    		+ this.getDesc() + "\n\n"
	    		+ "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";
		
		return formatString;
    }
    

    
    
}
