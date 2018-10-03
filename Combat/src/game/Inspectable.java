package game;
/**
 * Authors: Emily Clark
 * Inspectable Object within cells
 */
import java.util.ArrayList;

import items.Item;

public class Inspectable {

	private String inspDescription;
	private String inspName;
	private ArrayList<Item> inspObj;

	public Inspectable() {
		//empty constructor
	}
	
	public Inspectable(String inspName, String inspDescription, ArrayList<Item> inspObj) {
		this.inspName = inspName;
		this.inspDescription = inspDescription;
		this.inspObj = inspObj;
	}

	public String getInspDescription() {
		return inspDescription;
	}

	public String getInspName() {
		return inspName;
	}

	public ArrayList<Item> getInspObj() {
		return inspObj;
	}
	
}
