package tests;

import java.util.ArrayList;
import java.util.List;

import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import pojos.environment.InspectableObjects;
import pojos.environment.Location;
import pojos.items.Item;

public class SetupStaticValues {

	//this file is used to instantiate the player, cell, and other static values that are persisted throughout the game.
	static Item item = new Item();
	static Item item2 = new Item();
	
	public static PlayerEntity setUpPlayer() {
		PlayerEntity player = new PlayerEntity();
		player.setCurrentCell(setUpActiveCell());
		
		return player;
	}
	
	public static Cell setUpActiveCell() {
		Cell newCell = new Cell();
		newCell.setLocation(new Location (0,1, 0));
		List<InspectableObjects> listInspectables = new ArrayList<InspectableObjects>();
		listInspectables.add(setUpRecentlyInspectedObject());
		newCell.setInspectableObjects(listInspectables);
		
		return newCell;
	}
	
	public static InspectableObjects setUpRecentlyInspectedObject() {
		item.setName("Test Item 1");
		item2.setName("Test Item 2");
		InspectableObjects recentlyOpenedObject = new InspectableObjects();
		recentlyOpenedObject = new InspectableObjects();
		recentlyOpenedObject.setName("Inspectable Object Test");
		recentlyOpenedObject.getItems().add(item);
		recentlyOpenedObject.getItems().add(item2);
		
		return recentlyOpenedObject;
	}
}
