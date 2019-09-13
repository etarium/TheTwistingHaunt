package gameplay.commandServices.utilities;

import java.util.ArrayList;
import java.util.List;

import gameplay.GamePlayConstants;
import gameplay.commandServices.CellService;
import pojos.environment.InspectableObjects;
import pojos.items.Item;
import uiView.UIMain;

public class TakeUtilities {

	public String takeAllFromInspectable() {
		StringBuilder outputBuilder = new StringBuilder();
		outputBuilder.append("You take all of the items.\n");
		outputBuilder.append("**********\n");
		outputBuilder.append("Items Received: \n");
		List<Item> itemsToRemove = new ArrayList<Item>();
		for(Item item : CellService.recentlyOpenedObject.getItems()) {
			if(UIMain.player.getInventory().size() >= GamePlayConstants.MAX_INVENTORY_SIZE) {
				outputBuilder.replace(0, outputBuilder.length(), "Your bag is heaving with the volume of items inside. You couldn't possible take anymore!"
						+ "\n [Use /drop to remove items from your inventory.]");
				break;
			} else {
				UIMain.player.getInventory().add(item);
				itemsToRemove.add(item);
				outputBuilder.append(item.getName() + "\n");
			}
		}
		removeItemsFromInspectableObject(itemsToRemove);
		return outputBuilder.toString();
	}

	public String takeOnlyItemFromInspectable() {
		//no parameter but only one item
		StringBuilder outputBuilder = new StringBuilder();
		if(CellService.recentlyOpenedObject.getItems() != null && CellService.recentlyOpenedObject.getItems().size() == 1) {
			if(UIMain.player.getInventory().size() >= GamePlayConstants.MAX_INVENTORY_SIZE) {
				return "Your bag is heaving with the volume of items inside. You couldn't possible take anymore!"
						+ "\n [Use /drop to remove items from your inventory.]";
			} else {
				UIMain.player.getInventory().add(CellService.recentlyOpenedObject.getItems().get(0));
				outputBuilder.append("You take the " + CellService.recentlyOpenedObject.getItems().get(0).getName());
				//then remove the item from the cell / instance
				removeItemFromInspectableObject(CellService.recentlyOpenedObject.getItems().get(0));
			}
		} else {
			outputBuilder.append("I'm not sure what you were expecting to take..."
					+ "\n [Use /take all for every item, or be more specific.]");
		}
		return outputBuilder.toString();
	}

	public String takeItemByNameFromInspectable(String param) {
		StringBuilder outputBuilder = new StringBuilder();
		if(UIMain.player.getInventory().size() >= GamePlayConstants.MAX_INVENTORY_SIZE) {
			return "Your bag is heaving with the volume of items inside. You couldn't possible take anymore!"
					+ "\n [Use /drop to remove items from your inventory.]";
		} else {
			for(Item item : CellService.recentlyOpenedObject.getItems()) {
				if(item.getName().equalsIgnoreCase(param)) {
					UIMain.player.getInventory().add(item);
					outputBuilder.append("You take the " + item.getName());
					removeItemFromInspectableObject(item);
					break;
				} else {
					outputBuilder.append("You look around, but can't find anything worth taking by that name.");
				}
			}
		}
		return outputBuilder.toString();
	}

	public void removeItemFromInspectableObject(Item item) {
		InspectableObjects matchedInspectable = new InspectableObjects();
		for(InspectableObjects object : UIMain.player.currentCell.getInspectableObjects()) {
			for(int i = 0; i < object.getItems().size(); i ++) {
				if(item.getName().equalsIgnoreCase(object.getItems().get(i).getName())) {
					//to avoid concurrency errors, first add any matching items to a new list
					matchedInspectable = object;
					matchedInspectable.getItems().remove(i);
					CellService.recentlyOpenedObject.getItems().remove(i);
				}
			}
		}
		//then replace the current inspectable with the new set
		UIMain.cells.remove(UIMain.player.currentCell);	
		UIMain.player.currentCell.getInspectableObjects().remove(matchedInspectable);
		UIMain.player.currentCell.getInspectableObjects().add(matchedInspectable);
		UIMain.cells.add(UIMain.player.currentCell);
	}

	public void removeItemsFromInspectableObject(List<Item> items) {
		InspectableObjects matchedInspectable = new InspectableObjects();
		for(Item item : items) {
			for(InspectableObjects object : UIMain.player.currentCell.getInspectableObjects()) {
				for(int i = 0; i < object.getItems().size(); i ++) {
					if(item.getName().equalsIgnoreCase(object.getItems().get(i).getName())) {
						//to avoid concurrency errors, first add any matching items to a new list
						matchedInspectable = object;
						matchedInspectable.getItems().remove(i);
					}
				}
			}
			//then replace the current inspectable with the new set

			UIMain.cells.remove(UIMain.player.currentCell);	
			UIMain.player.currentCell.getInspectableObjects().remove(matchedInspectable);
			UIMain.player.currentCell.getInspectableObjects().add(matchedInspectable);
			CellService.recentlyOpenedObject = matchedInspectable;
			UIMain.cells.add(UIMain.player.currentCell);
		}
	}

	public String takeAllFromCell() {
		StringBuilder outputBuilder = new StringBuilder();
		outputBuilder.append("You take all of the items.\n");
		outputBuilder.append("**********\n");
		outputBuilder.append("Items Received: \n");
		List<Item> itemsToRemove = new ArrayList<Item>();
		for(Item item : UIMain.player.currentCell.getItems()) {
			if(UIMain.player.getInventory().size() >= GamePlayConstants.MAX_INVENTORY_SIZE) {
				outputBuilder.replace(0, outputBuilder.length(), "Your bag is heaving with the volume of items inside. You couldn't possible take anymore!"
						+ "\n [Use /drop to remove items from your inventory.]");
				break;
			} else {
				UIMain.player.getInventory().add(item);
				itemsToRemove.add(item);
				outputBuilder.append(item.getName() + "\n");
			}
		}
		removeItemsFromCell(itemsToRemove);
		return outputBuilder.toString();
	}

	public String takeOnlyItemFromCell() {
		//no parameter but only one item
		StringBuilder outputBuilder = new StringBuilder();
		if(UIMain.player.currentCell.getItems() != null && UIMain.player.currentCell.getItems().size() == 1) {
			if(UIMain.player.getInventory().size() >= GamePlayConstants.MAX_INVENTORY_SIZE) {
				return "Your bag is heaving with the volume of items inside. You couldn't possible take anymore!"
						+ "\n [Use /drop to remove items from your inventory.]";
			} else {
				UIMain.player.getInventory().add(UIMain.player.currentCell.getItems().get(0));
				outputBuilder.append("You take the " + UIMain.player.currentCell.getItems().get(0).getName());
				//then remove the item from the cell / instance
				removeItemFromCell(UIMain.player.currentCell.getItems().get(0));
			}
		} else {
			outputBuilder.append("I'm not sure what you were expecting to take..."
					+ "\n [Use /take all for every item, or be more specific.]");
		}
		return outputBuilder.toString();
	}

	public String takeItemByNameFromCell(String param) {
		StringBuilder outputBuilder = new StringBuilder();
		if(UIMain.player.getInventory().size() >= GamePlayConstants.MAX_INVENTORY_SIZE) {
			return "Your bag is heaving with the volume of items inside. You couldn't possible take anymore!"
					+ "\n [Use /drop to remove items from your inventory.]";
		} else {
			for(Item item : UIMain.player.currentCell.getItems()) {
				if(item.getName().equalsIgnoreCase(param)) {
					UIMain.player.getInventory().add(item);
					outputBuilder.append("You take the " + item.getName());
					removeItemFromCell(item);
					break;
				} else {
					outputBuilder.append("You look around, but can't find anything worth taking by that name.");
				}
			}
		}
		return outputBuilder.toString();
	}

	public void removeItemsFromCell(List<Item> itemsToRemove) {
		List<Item> itemsInCell = UIMain.player.currentCell.getItems();
		for(Item item : itemsToRemove) {
			for(int i = 0; i < itemsInCell.size(); i ++) {
				if(item.getName().equalsIgnoreCase(itemsInCell.get(i).getName())) {
					UIMain.player.currentCell.getItems().remove(item);
				}
			}
		}
	}

	public void removeItemFromCell(Item itemToRemove) {
		List<Item> itemsInCell = UIMain.player.currentCell.getItems();
		for(int i = 0; i < itemsInCell.size(); i ++) {
			if(itemToRemove.getName().equalsIgnoreCase(itemsInCell.get(i).getName())) {
				UIMain.player.currentCell.getItems().remove(itemToRemove);
			}
		}
	}
}
