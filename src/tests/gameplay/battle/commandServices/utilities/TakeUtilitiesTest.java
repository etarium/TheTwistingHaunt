package tests.gameplay.battle.commandServices.utilities;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import gameplay.commandServices.CellService;
import pojos.items.Item;
import uiView.UIMain;

public class TakeUtilitiesTest {

	@Before
	public void setUp () {
		Item item = new Item();
		item.setName("Test Item");
		Item item2 = new Item();
		item2.setName("Test Item 2");
		List<Item> listOfItems = new ArrayList<Item>();
		listOfItems.add(item);
		listOfItems.add(item2);
		
		Mockito.when(CellService.recentlyOpenedObject.getItems()).thenReturn(listOfItems);
	}

	@Test
	public void takeAllItemsFromInspectableSuccess() {

		
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
