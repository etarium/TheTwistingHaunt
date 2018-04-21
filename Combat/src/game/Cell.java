package game;

import java.util.ArrayList;

/**
 *
 * @author jason
 */

public class Cell {
    
    private Location location;
    private String desc;
    private String terrain;
    private String encounter;
    private String item;
    private String keyItem;
    private String reqItem;
    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;
    private ArrayList<Equipable> cellEq;
    private ArrayList<KeyItems> cellkey;
    private ArrayList<Usable> cellUse;

    public Cell() {
    }

    public Cell(int x, int y, int z, String desc, String terrain, String encounter, String item, String keyItem, String reqItem, boolean north, boolean south, boolean east, boolean west) {
        this.location = new Location(x, y, z);
        this.desc = desc;
        this.terrain = terrain;
        this.encounter = encounter;
        this.item = item;
        this.keyItem = keyItem;
        this.reqItem = reqItem;
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

    public String getEncounter() {
        return encounter;
    }

    public String getItem() {
        return item;
    }

    public String getKeyItem() {
        return keyItem;
    }

    public String getReqItem() {
        return reqItem;
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

    public void setEncounter(String encounter) {
        this.encounter = encounter;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setKeyItem(String keyItem) {
        this.keyItem = keyItem;
    }

    public void setReqItem(String reqItem) {
        this.reqItem = reqItem;
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
