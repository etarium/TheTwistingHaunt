package tests.gameplay.battle.commandServices.utilities;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import gameplay.GamePlayConstants;
import gameplay.commandServices.CellService;
import gameplay.commandServices.utilities.TakeUtilities;
import pojos.environment.InspectableObjects;
import pojos.items.Item;
import tests.SetupStaticValues;
import uiView.UIMain;

public class TakeUtilitiesTest {

	@Mock
	CellService cellService = new CellService();

	@Mock
	InspectableObjects recentlyOpenedObject = new InspectableObjects();

	@Mock
	TakeUtilities utility = new TakeUtilities();

	//declare reused variables
	Item item = new Item();

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

		//the recently opend object should be empty
		assert(CellService.recentlyOpenedObject.getItems().isEmpty());

		//and the cell should also reflect this change
		//we know in this test there is only one inspectable item
		assert(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().isEmpty());

		//and the players inventory should be that many items larger.
		assert(UIMain.player.getInventory().size() == (originalInventorySize  + newItemsToAdd));
	}

	@Test
	public void takeAllItemsInventoryFull() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items

		//and the inventory only has one open slot
		for(int i=0; i<GamePlayConstants.MAX_INVENTORY_SIZE -1; i++) { UIMain.player.getInventory().add(item); }

		//then when all items are taken
		utility.takeAllFromInspectable();

		//there should be an error since the inventory is full, only one item can be taken

		//and should have a size of 1
		assert(CellService.recentlyOpenedObject.getItems().size() == 1);

		//and the cell should also reflect this change
		//we know in this test there is only one inspectable item
		assert(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == 1);

		//and the player's inventory is only one larger, and at the max size
		assert(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);

	}

	@Test
	public void takeOnlyItemFromInspectableSuccess() {

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
		//the recently opend object should not have changed
		assert(CellService.recentlyOpenedObject.getItems().size() == 1);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assert(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == 1);

		//and the players inventory should not have changed
		assert(UIMain.player.getInventory().size() == GamePlayConstants.MAX_INVENTORY_SIZE);

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
		//the recently opend object should not have changed
		assert(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assert(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == newItemsToAdd);

		//and the players inventory should not have changed
		assert(UIMain.player.getInventory().size() == (originalInventorySize));
	}

	@Test
	public void takeItemByNameFromInspectableSuccess() {
		//given that the player and recently opened object are defined
		//and given the opened object has two items
		int originalInventorySize = UIMain.player.getInventory().size();
		int newItemsToAdd = CellService.recentlyOpenedObject.getItems().size();

		//then when a specific item is taken
		utility.takeItemByNameFromInspectable("Test Item 1");

		System.out.println("new items - 1 " + (newItemsToAdd - 1));
		System.out.println("recentlyopenedobject " + CellService.recentlyOpenedObject.getItems().size());
		System.out.println("playercurrentcell " + UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size());
		//it should fail and no changes should be made.
		//the recently opend object should not have changed
		assert(CellService.recentlyOpenedObject.getItems().size() == newItemsToAdd - 1);

		//and the cell should also not be changed
		//we know in this test there is only one inspectable item
		assert(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().size() == newItemsToAdd -1);

		//and the players inventory should not have changed
		assert(UIMain.player.getInventory().size() == (originalInventorySize + 1));
	}

	@Test
	public void takeItemByNameFromInspectableInventoryFull() {

	}

	@Test
	public void takeItemByNameFromInspectableWrongName() {

	}


}
