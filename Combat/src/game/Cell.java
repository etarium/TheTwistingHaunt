package game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jason Richter & Emily Clark
 */

public class Cell implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6891627105178688717L;
	private Location location;
    private String desc;
    private String terrain;
    private Encounter encounter;
    private Item item;
    private KeyItems keyItem;
    private String reqItem;
    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;
    /*
    private ArrayList<Equipable> cellEq;
    private ArrayList<KeyItems> cellkey;
    private ArrayList<Usable> cellUse;
    */

    public Cell() {
    }

    
    public Cell( Location location, String instance, String desc, Encounter encounter, Item item, KeyItems keyItem, Inspectable inspectable, String terrain, boolean north, boolean south, boolean east, boolean west) {
    	
    		this.location = location;
		this.desc = desc;
		this.terrain = terrain;
		this.encounter = encounter;
		this.item = item;
		this.keyItem = keyItem;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
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
        return keyItem;
    }


    public boolean isNorth() {
        return north;
    }

    public boolean isSouth() {
        return south;
    }

    public boolean isEast() {
        return east;
    }

    public boolean isWest() {
        return west;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setKeyItem(KeyItems keyItem) {
        this.keyItem = keyItem;
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
