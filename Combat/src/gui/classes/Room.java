package gui.classes;

import java.awt.Color;

public class Room {
	
	//data members
	protected Room[] path;
	private Room north, east, south, west;
	private boolean exists;
	private boolean current;
	public Color tileColor;
	
	
	//constructors
	
	//empty room
	public Room() {
		setEmpty();
		this.tileColor = Color.BLACK;
	}
	
	public Room(Room[] path) {
		this.north = path[0];
		this.east = path[1];
		this.south = path[2];
		this.west = path[3];
		this.tileColor = Color.BLACK;
	}
	public Room(Room[] path, boolean revealed) {
	
	}
	
	//setters and getters
	public Room getNorth() {
		return north;
	}

	public void setNorth(Room north) {
		this.north = north;
	}

	public Room getEast() {
		return east;
	}

	public void setEast(Room east) {
		this.east = east;
	}

	public Room getSouth() {
		return south;
	}

	public void setSouth(Room south) {
		this.south = south;
	}

	public Room getWest() {
		return west;
	}

	public void setWest(Room west) {
		this.west = west;
	}
	


	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}
	
	

	//methods
	public boolean hasNorth() {
		return this.north != null;
	}

	public boolean hasEast() {
		return this.east != null;
	}
	
	public boolean hasSouth() {
		return this.south != null;
	}
	
	public boolean hasWest() {
		return this.west != null;
	}
	
	public void setEmpty() {
		this.north = null;
		this.east = null;
		this.south = null;
		this.west = null;
		this.path = null;
		
		this.current = false;
		this.exists = false;
		
	}
	
	
}//end class
