package tests.commandListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import commandListener.MovementListener;
import commandListener.Reply;
import gameplay.GamePlayConstants;
import gameplay.commandServices.MovementService;
import pojos.environment.Cell;
import pojos.environment.Location;
import tests.SetupStaticValues;
import uiView.UIMain;

public class MovementListenerTest {

	@Mock
	MovementService service = Mockito.mock(MovementService.class);

	@InjectMocks
	MovementListener listener = new MovementListener();
	
	Location originalLocation = new Location(0,1,0);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UIMain.cells = SetupStaticValues.setUpCells();
		UIMain.player = SetupStaticValues.setUpPlayer();

	}

	@Test
	public void moveNorth() {
		Reply reply = listener.listen("/n");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveNorth();

		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveNorthButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);
		Reply reply = listener.listen("/n");

		//the call should fail when in battle
		assertFalse(reply.isSuccess);

		//because the call failed, movement services shouldn't be called
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveNorthHitsEncounter() {
		//given the command is correct, but the player is in battle
		for(Cell cell : UIMain.cells) {
			cell.setEnemies(SetupStaticValues.setUpEnemies());
		}
		Mockito.doCallRealMethod().when(service).moveNorth();

		Reply reply = listener.listen("/n");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//the player should now be engaged in combat
		assertTrue(UIMain.player.isInEncounter);

		//and the cell should be displaying it:
		assertTrue(reply.output.contains(GamePlayConstants.BATTLE_OUTPUT));

		//call succeeded, so movement was a success.
		verify(service, times(1)).moveNorth();

		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveNorthFails() {
		Mockito.when(service.moveNorth()).thenReturn(UIMain.player.currentCell.getDescription());
		Reply reply = listener.listen("/n");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveNorth();

		//and the output should contain the failed movement
		assertTrue(reply.output.contains(GamePlayConstants.FAILED_MOVEMENT));
		verify(service, times(0)).moveWest();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
	}

	@Test
	public void moveSouth() {
		Reply reply = listener.listen("/s");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveSouth();

		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveSouthButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);
		Reply reply = listener.listen("/s");

		//the call should fail when in battle
		assertFalse(reply.isSuccess);

		//because the call failed, movement services shouldn't be called
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveSouthHitsEncounter() {
		//given the command is correct, but the player is in battle
		for(Cell cell : UIMain.cells) {
			cell.setEnemies(SetupStaticValues.setUpEnemies());
		}
		Mockito.doCallRealMethod().when(service).moveSouth();

		Reply reply = listener.listen("/s");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//the player should now be engaged in combat
		assertTrue(UIMain.player.isInEncounter);

		//and the cell should be displaying it:
		assertTrue(reply.output.contains(GamePlayConstants.BATTLE_OUTPUT));

		//call succeeded, so movement was a success.
		verify(service, times(0)).moveNorth();

		verify(service, times(1)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveSouthFails() {
		Mockito.when(service.moveSouth()).thenReturn(UIMain.player.currentCell.getDescription());
		Reply reply = listener.listen("/s");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveSouth();

		//and the output should contain the failed movement
		assertTrue(reply.output.contains(GamePlayConstants.FAILED_MOVEMENT));
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveWest();
		verify(service, times(0)).moveEast();	
	}

	@Test
	public void moveEast() {
		Reply reply = listener.listen("/e");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveEast();

		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveEastButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);
		Reply reply = listener.listen("/e");

		//the call should fail when in battle
		assertFalse(reply.isSuccess);

		//because the call failed, movement services shouldn't be called
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveEastHitsEncounter() {
		//given the command is correct, but the player is in battle
		for(Cell cell : UIMain.cells) {
			cell.setEnemies(SetupStaticValues.setUpEnemies());
		}
		Mockito.doCallRealMethod().when(service).moveEast();

		Reply reply = listener.listen("/e");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//the player should now be engaged in combat
		assertTrue(UIMain.player.isInEncounter);

		//and the cell should be displaying it:
		assertTrue(reply.output.contains(GamePlayConstants.BATTLE_OUTPUT));

		//call succeeded, so movement was a success.
		verify(service, times(0)).moveNorth();

		verify(service, times(0)).moveSouth();
		verify(service, times(1)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveEastFails() {
		Mockito.when(service.moveEast()).thenReturn(UIMain.player.currentCell.getDescription());
		Reply reply = listener.listen("/e");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveEast();

		//and the output should contain the failed movement
		assertTrue(reply.output.contains(GamePlayConstants.FAILED_MOVEMENT));
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveWest();
		verify(service, times(0)).moveSouth();
	}

	@Test
	public void moveWest() {
		Reply reply = listener.listen("/w");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveWest();

		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
	}

	@Test
	public void moveWestButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);

		Reply reply = listener.listen("/w");

		//the call should fail when in battle
		assertFalse(reply.isSuccess);

		//because the call failed, movement services shouldn't be called
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}

	@Test
	public void moveWestHitsEncounter() {
		//given the command is correct, but the player is in battle
		for(Cell cell : UIMain.cells) {
			cell.setEnemies(SetupStaticValues.setUpEnemies());
		}
		Mockito.doCallRealMethod().when(service).moveWest();

		System.out.println(originalLocation);
		Reply reply = listener.listen("/w");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//the player should now be engaged in combat
		assertTrue(UIMain.player.isInEncounter);

		//and the cell should be displaying it:
		assertTrue(reply.output.contains(GamePlayConstants.BATTLE_OUTPUT));

		//call succeeded, so movement was a success.
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(1)).moveWest();
	}

	@Test
	public void moveWestFails() {

		Mockito.when(service.moveWest()).thenReturn(UIMain.player.currentCell.getDescription());
		Reply reply = listener.listen("/w");

		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the service should run the one operation
		verify(service, times(1)).moveWest();

		//and the output should contain the failed movement
		assertTrue(reply.output.contains(GamePlayConstants.FAILED_MOVEMENT));
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
	}

	@Test
	public void moveToRestableCell() {
		for(Cell cell : UIMain.cells) {
			cell.setCanRest(true);
		}
		Mockito.doCallRealMethod().when(service).moveWest();
		Reply reply = listener.listen("/w");
		//the call should succeed
		assertTrue(reply.isSuccess);

		//and the cell's lower output should include the rest blurb
		assertTrue(reply.output.contains("\n\nThis area seems safer than most. It wouldn't be a terrible place to have a short rest. \n"));

	}

	@Test
	public void otherCommand() {
		Reply reply = listener.listen("/something-else");

		//the call should fail
		assertFalse(reply.isSuccess);

		//and no actions on the movementservice should be taken
		verify(service, times(0)).moveNorth();
		verify(service, times(0)).moveSouth();
		verify(service, times(0)).moveEast();
		verify(service, times(0)).moveWest();
	}
}
