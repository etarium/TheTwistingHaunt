package tests.gameplay.battle.commandServices.utilities;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
	

	@Before
	public void setUp () {
//
//		item.setName("Test Item");
//		item2.setName("Test Item 2");
//		listOfItems.add(item);
//		listOfItems.add(item2);
	}

	@Test
	public void takeAllItemsFromInspectableSuccess() {

		//given that the player and recently opened object are defined
		UIMain.player = SetupStaticValues.setUpPlayer();
		CellService.recentlyOpenedObject = SetupStaticValues.setUpRecentlyInspectedObject();
		
		//then when all items are taken
		String output = utility.takeAllFromInspectable();

		//the recently opend object should be empty
		assert(CellService.recentlyOpenedObject.getItems().isEmpty());

		//and the cell should also reflect this change
		//we know in this test there is only one inspectable item
		assert(UIMain.player.currentCell.getInspectableObjects().get(0).getItems().isEmpty());
	}

	@Test
	public void takeAllItemsInventoryFull() {

	}

	@Test
	public void takeOnlyItemFromInspectableSuccess() {

	}

	@Test
	public void takeOnlyItemFromInspectableInventoryFull() {

	}

	@Test
	public void takeOnlyItemFromInspectableMoreThanOneItem() {

	}

	@Test
	public void takeItemByNameFromInspectableSuccess() {

	}

	@Test
	public void takeItemByNameFromInspectableInventoryFull() {

	}

	@Test
	public void takeItemByNameFromInspectableWrongName() {

	}


}
