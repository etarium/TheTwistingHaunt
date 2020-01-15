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

import commandListener.PlayerListener;
import commandListener.Reply;
import gameplay.commandServices.PlayerService;
import tests.SetupStaticValues;
import uiView.UIMain;

public class PlayerListenerTest {

	@Mock
	PlayerService service = Mockito.mock(PlayerService.class);

	@InjectMocks
	PlayerListener listener = new PlayerListener();


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UIMain.player = SetupStaticValues.setUpPlayer();
	}

	@Test
	public void takeSuccess() {
		Reply reply = listener.listen("/take", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).takeItem(null);

		verify(service, times(0)).rest();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void takeSuccessfulCommandButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);
		Reply reply = listener.listen("/take", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should not be called
		verify(service, times(0)).takeItem(null);

		verify(service, times(0)).rest();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}
	
	@Test
	public void dropSuccess() {
		Reply reply = listener.listen("/drop", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).dropItem(null);

		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).rest();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void dropSuccessfulCommandButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);
		Reply reply = listener.listen("/drop", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should not be called
		verify(service, times(0)).dropItem(null);

		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).rest();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void restSuccess() {
		//given the cell can be rested in
		UIMain.player.currentCell.setCanRest(true);
		Reply reply = listener.listen("/rest", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).rest();

		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void restSuccessfulCommandWrongPlace() {
		//given the command is correct, but the cell cannot be rested in
		UIMain.player.currentCell.setCanRest(false);
		Reply reply = listener.listen("/rest", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(0)).rest();

		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void restSuccessfulCommandButInEncounter() {
		//given the command is correct, but the player is in battle
		UIMain.player.setIsInEncounter(true);
		Reply reply = listener.listen("/rest", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should not be called
		verify(service, times(0)).rest();

		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void useItemSuccess() {
		Reply reply = listener.listen("/use", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).useItem(null);

		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void equipItemSuccess() {
		Reply reply = listener.listen("/equip", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).equipItem(null);

		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void listInventorySuccess() {
		Reply reply = listener.listen("/inventory", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).inventory();

		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void listEquipmentSuccess() {
		Reply reply = listener.listen("/equipment", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).equipment();

		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void listStatsSuccess() {
		Reply reply = listener.listen("/stats", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).getPlayerStats();

		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).listAbilities();
	}

	@Test
	public void listAbilitiesSuccess() {
		Reply reply = listener.listen("/skills", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).listAbilities();

		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).useItem(null);
	}

	@Test
	public void otherCommand() {
		Reply reply = listener.listen("/something-else", null);

		//the call should fail
		assertFalse(reply.isSuccess);

		//and no actions on the playerservice should be taken
		verify(service, times(0)).rest();
		verify(service, times(0)).takeItem(null);
		verify(service, times(0)).dropItem(null);
		verify(service, times(0)).equipItem(null);
		verify(service, times(0)).inventory();
		verify(service, times(0)).equipment();
		verify(service, times(0)).getPlayerStats();
		verify(service, times(0)).useItem(null);
		verify(service, times(0)).listAbilities();
	}

}
