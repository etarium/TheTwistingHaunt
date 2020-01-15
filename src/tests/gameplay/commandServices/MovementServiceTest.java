package tests.gameplay.commandServices;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import gameplay.commandServices.MovementService;
import environment.Cell;
import environment.Location;
import tests.SetupStaticValues;
import uiView.UIMain;

public class MovementServiceTest {

	@InjectMocks
	MovementService service = new MovementService();

	Location originalLocation = new Location(0,1,0);
	List<Cell> ogCellList = new ArrayList<Cell>();
	@Before
	public void setUp() {
		UIMain.player = SetupStaticValues.setUpPlayer();
		UIMain.cells = SetupStaticValues.setUpCells();
	}

	@Test
	public void moveNorthSuccess() {
		//given a player and cells are initialized
		//and the player can move the direction
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveNorth();
		//then the player's location should be X, Y+1, Z
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY() + 1);
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());

		//and the output should update.
		assert(!originalDescription.equals(output));
	}

	@Test
	public void moveNorthFail() {
		//given a player and cells are intialized
		//and the player cannot move in the direction

		UIMain.player.currentCell.setNorth(false);
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveNorth();
		//then the players location should remain unchanged
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY());
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and so should the output.
		assert(originalDescription.equals(output));

	}

	@Test
	public void moveNorthSuccessFindsBattle() {
		//given a player and cells are initialized
		//and the player can move the direction
		//and an encounter is found
		Cell newCell = new Cell();
		newCell.setLocation(new Location(0,2,0));
		newCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		for(Cell cell: UIMain.cells) { ogCellList.add(cell); }
		for(Cell cell : ogCellList) {
			if(cell.getLocation().getX() == newCell.getLocation().getX() &&
					cell.getLocation().getY() == newCell.getLocation().getY() &&
					cell.getLocation().getZ() == newCell.getLocation().getZ()) {
				UIMain.cells.remove(cell);
				UIMain.cells.add(newCell);
			}
		}
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveNorth();
		//then the player's location should be X, Y+1, Z
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY() + 1);
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());

		//and the output should update
		//and player.isinencounter should be true
		assert(!originalDescription.equals(output));
		//cell at 1,2,0 has encounter)
		assertTrue(UIMain.player.isInEncounter);
	}

	@Test
	public void moveSouthSuccess() {
		//given a player and cells are initialized
		//and the player can move the direction
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveSouth();
		//then the player's location should be X, Y-1, Z
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY() - 1);
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and the output should update.
		assert(!originalDescription.equals(output));
	}

	@Test
	public void moveSouthFail() {
		//given a player and cells are intialized
		//and the player cannot move in the direction
		UIMain.player.currentCell.setSouth(false);
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveSouth();
		//then the players location should remain unchanged
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY());
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and so should the output.
		assert(originalDescription.equals(output));

	}

	@Test
	public void moveEastSuccess() {
		//given a player and cells are initialized
		//and the player can move the direction
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveEast();
		//then the player's location should be X+1, Y, Z
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX()+1);
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY());
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and the output should update.
		assert(!originalDescription.equals(output));
	}

	@Test
	public void moveEastFail() {
		//given a player and cells are intialized
		//and the player cannot move in the direction
		UIMain.player.currentCell.setEast(false);
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveEast();
		//then the players location should remain unchanged
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY());
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and so should the output.
		assert(originalDescription.equals(output));
	}

	@Test
	public void moveWestSuccess() {
		//given a player and cells are initialized
		//and the player can move the direction
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveWest();
		//then the player's location should be X-1, Y, Z
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX()-1);
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY());
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and the output should update.
		assert(!originalDescription.equals(output));
	}

	@Test
	public void moveWestFail() {
		//given a player and cells are intialized
		//and the player cannot move in the direction
		UIMain.player.currentCell.setWest(false);
		String originalDescription = UIMain.player.currentCell.getDescription();
		String output = service.moveWest();
		//then the players location should remain unchanged
		assertTrue(UIMain.player.getLocation().getX() == originalLocation.getX());
		assertTrue(UIMain.player.getLocation().getY() == originalLocation.getY());
		assertTrue(UIMain.player.getLocation().getZ() == originalLocation.getZ());
		//and so should the output.
		assert(originalDescription.equals(output));
	}
}
