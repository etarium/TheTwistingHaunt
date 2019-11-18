package tests.gameplay.battle.commandServices.utilities;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import gameplay.GamePlayConstants;
import gameplay.commandServices.CellService;
import gameplay.commandServices.utilities.TakeUtilities;
import environment.InspectableObjects;
import items.Item;
import tests.SetupStaticValues;
import uiView.UIMain;

public class TakeUtilitiesTest {

	@Mock
	CellService cellService = new CellService();

	@Mock
	InspectableObjects recentlyOpenedObject = new InspectableObjects();

	TakeUtilities utility = new TakeUtilities();

	//declare reused variables
	Item item = new Item();
	Item itemAdded = new Item();
	String queryName = "Test Item 1";
	String wrongName = "Wrong Item Name";

	@Before
	public void setUp() {
		UIMain.player = SetupStaticValues.setUpPlayer();
		CellService.recentlyOpenedObject = SetupStaticValues.setUpRecentlyInspectedObject();
	}

	@Test
	public void takeAllItemsFromInspectableSuccess() {

		//given that the player and recently opened object are defined
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();
		//then when all items are taken
		utility.takeAllFromInspectable();

		//the recently opened object should be empty
		assertTrue(CellService.recentlyOpenedObject.getItems().isEmpty());

		//and the cell should also reflect this change
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().isEmpty());

		//and the players inventory should be that many items larger.
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize  + newItemsToAdd));
	}

	@Test
	public void takeAllItemsInventoryFull() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();
		//and the inventory only has one open slot
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE -1; i++) { UIMain.player.getInventory().add(item); }

		//then when all items are taken
		utility.takeAllFromInspectable();

		//there should be an error since the inventory is full, only one item can be taken

		//and should have a size of 1
		assertTrue(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd - 1);

		//and the cell should also reflect this change
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == 1);

		//and the player's inventory is only one larger, and at the max size
		assertTrue(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);

	}

	@Test
	public void takeOnlyItemFromInspectableSuccess() {

		//removing the second item from the original init
		CellService.recentlyOpenedObject.getItems().remove(1);
		UIMain.player.currentCell.getInspectableObjects().get(0).getItems().remove(1);
		for(Item item : UIMain.player.currentCell.getInspectableObjects().get(0).getItems()) {
			if(item.getName() == queryName) {
				itemAdded = item;
				break;
			}
		}

		//given that the player and recently opened object are defined
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();

		//then when all items are taken
		utility.takeOnlyItemFromInspectable();

		//the recently opened object should be empty
		assertTrue(CellService.recentlyOpenedObject.getItems().isEmpty());

		//and the cell should also reflect this change
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().isEmpty());

		//and the players inventory should be that many items larger.
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize  + newItemsToAdd));

		//and the inventory should contain the item queried for
		assertTrue(UIMain.player.getInventory().contains(itemAdded));
	}


	@Test
	public void takeOnlyItemFromInspectableInventoryFull() {
		//given that the player and recently opened object are defined
		//and given the opened object has only one item

		//removing the second item from the original init
		CellService.recentlyOpenedObject.getItems().remove(1);
		UIMain.player.currentCell.getInspectableObjects().get(0).getItems().remove(1);

		//and the inventory is full
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE; i++) { UIMain.player.getInventory().add(item); }

		//then when the only item is taken
		utility.takeOnlyItemFromInspectable();

		//it should fail and no changes should be made.
		//the recently opened object should not have changed
		assertTrue(CellService.recentlyOpenedObject.getItems().size() == 1);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == 1);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);

	}


	@Test
	public void takeOnlyItemFromInspectableMoreThanOneItem() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();

		//then when the only item is taken
		utility.takeOnlyItemFromInspectable();

		//it should fail and no changes should be made.
		//the recently opened object should not have changed
		assertTrue(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize));
	}

	@Test
	public void takeItemByNameFromInspectableSuccess() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();

		for(Item item : UIMain.player.currentCell.getItems()) {
			if(item.getName() == queryName) {
				itemAdded = item;
				break;
			}
		}
		//then when a specific item is taken
		utility.takeItemByNameFromInspectable(queryName);

		//it should succeed and one item should be taken;
		//the recently opened object should also have this change;
		assertTrue(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd - 1);

		//and the cell should also be changed
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == newItemsToAdd -1);

		//and the players inventory should have increased by 1
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize + 1));

		//and the inventory should contain the item queried for
		assertTrue(UIMain.player.getInventory().contains(itemAdded));
	}

	@Test
	public void takeItemByNameFromInspectableInventoryFull() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();

		//and the inventory is full
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE; i++) { UIMain.player.getInventory().add(item); }

		//then when a specific item is taken
		utility.takeItemByNameFromInspectable(queryName);

		//it should fail and no changes should be made.
		//the recently opened object should not have changed
		assertTrue(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);
	}


	@Test
	public void takeItemByNameFromInspectableWrongName() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();

		//then when a specific item is taken, but there is no item by that name
		utility.takeItemByNameFromInspectable(wrongName);

		//it should fail and no changes should be made.
		//the recently opened object should not have changed
		assertTrue(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == originalInventorySize);
	}

	@Test
	public void takeAllItemsFromCellSucces() {
		//given that the player and cell items are defined
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();
		//then when all items are taken
		utility.takeAllFromCell();

		// cell should also reflect this change
		//we know in this test there is only one inspectable item
		assertTrue(UIMain.player.currentCell.getItems().isEmpty());

		//and the players inventory should be that many items larger.
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize  + newItemsToAdd));
	}

	@Test
	public void takeAllItemsFromCelInventoryFull() {
		//given that the player and cell items are defined
		//and given the opened object has two items
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();

		//and the inventory only has one open slot
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE -1; i++) { UIMain.player.getInventory().add(item); }

		//then when all items are taken
		utility.takeAllFromCell();

		//there should be an error since the inventory is full, only one item can be taken
		//and the cell should also reflect this change
		assertTrue(UIMain.player.currentCell.getItems().size() == newItemsToAdd - 1);

		//and the player's inventory is only one larger, and at the max size
		assertTrue(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);
	}

	@Test
	public void takeOnlyItemFromCellSuccess() {
		//removing the second item from the original init
		UIMain.player.currentCell.getItems().remove(1);

		//given that the player and cell items are defined
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();

		//then when the only item from the cell is taken
		utility.takeOnlyItemFromCell();

		//and the cell should be empty
		assertTrue(UIMain.player.currentCell.getItems().isEmpty());

		//and the players inventory should be that many items larger.
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize  + newItemsToAdd));

	}

	@Test
	public void takeOnlyItemFromCellInventoryFull() {
		//removing the second item from the original init
		UIMain.player.currentCell.getItems().remove(1);

		//given that the player and recently cell items are defined
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();

		//and the inventory is full
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE; i++) { UIMain.player.getInventory().add(item); }

		//then when the only item from the cell is taken
		utility.takeOnlyItemFromCell();

		//it should fail and no changes should be made.
		//and the cell should not have changed
		assertTrue(UIMain.player.currentCell.getItems().size() == newItemsToAdd);

		//and the players inventory should be at max size
		assertTrue(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);
	}

	@Test
	public void takeOnlyItemFromCellMorethanOneItem() {
		//given that the player and cell items are defined
		//and given the opened object has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();

		//then when the only item from the cell is taken
		utility.takeOnlyItemFromCell();

		//it should fail and no changes should be made.
		//and the cell should not have changed
		assertTrue(UIMain.player.currentCell.getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize));

	}

	@Test
	public void takeItemByNameFromCellSuccess() {
		//given that the player and cell are defined
		//and given the cell has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();
		for(Item item : UIMain.player.currentCell.getItems()) {
			if(item.getName() == queryName) {
				itemAdded = item;
				break;
			}
		}

		//then when a specific item is taken
		utility.takeItemByNameFromCell(queryName);

		//it should succeed and one item should be taken;
		//the cell should have this change;
		assertTrue(UIMain.player.currentCell.getItems().size() == newItemsToAdd - 1);

		//and the players inventory should have increased by 1
		assertTrue(UIMain.player.getInventory().size() == (originalInventorySize + 1));

		//and the inventory should contain the item queried for
		assertTrue(UIMain.player.getInventory().contains(itemAdded));
	}

	@Test
	public void takeItemByNameFromCellInventoryFull() {
		//given that the player and cell are defined
		//and given the cell has two items
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();
		for(Item item : UIMain.player.currentCell.getItems()) {
			if(item.getName() == queryName) {
				itemAdded = item;
				break;
			}
		}

		//and the inventory is full
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE; i++) { UIMain.player.getInventory().add(item); }

		//then when the specific item from the cell is taken
		utility.takeItemByNameFromCell(queryName);

		//it should fail and no changes should be made.
		//and the cell should not have changed
		assertTrue(UIMain.player.currentCell.getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);

		//and the inventory should not contain the item queried for
		assertTrue(!UIMain.player.getInventory().contains(itemAdded));
	}

	@Test
	public void takeItemByNameFromCellWrongName() {
		//given that the player and cell are defined
		//and given the cell has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = UIMain.player.currentCell.getItems().size();

		//then when a specific item is taken, but there is no item by that name
		utility.takeItemByNameFromCell(wrongName);

		//it should fail and no changes should be made.
		//the cell should not have changed
		assertTrue(UIMain.player.currentCell.getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assertTrue(UIMain.player.getInventory().size() == originalInventorySize);
	}
}
