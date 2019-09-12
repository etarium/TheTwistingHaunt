package tests;

import java.util.ArrayList;
import java.util.List;

import gameplay.commandServices.CellService;
import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import pojos.environment.InspectableObjects;
import pojos.environment.Location;
import pojos.items.Item;
import uiView.UIMain;

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
		List<Cell> cells = new ArrayList<Cell>();
		Cell newCell = new Cell();
		newCell.setLocation(new Location (0,1, 0));
		List<InspectableObjects> listInspectables = new ArrayList<InspectableObjects>();
		listInspectables.add(setUpRecentlyInspectedObject());
		newCell.setInspectableObjects(listInspectables);
		
		return newCell;
	}
	
	public static InspectableObjects setUpRecentlyInspectedObject() {
		InspectableObjects recentlyOpenedObject = new InspectableObjects();
		recentlyOpenedObject = new InspectableObjects();
		recentlyOpenedObject.getItems().add(item);
		recentlyOpenedObject.getItems().add(item2);
		
		return recentlyOpenedObject;
	}
}
