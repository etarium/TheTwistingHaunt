package tests.commandListener;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import commandListener.BattleListener;
import commandListener.Reply;
import gameplay.GamePlayConstants;
import gameplay.battle.BattleOrder;
import gameplay.commandServices.BattleService;
import tests.SetupStaticValues;
import uiView.UIMain;

public class BattleListenerTest {

	@Mock
	BattleService service = Mockito.mock(BattleService.class);

	@Mock
	BattleOrder order = Mockito.mock(BattleOrder.class);

	@InjectMocks
	BattleListener listener = new BattleListener();


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UIMain.player = SetupStaticValues.setUpPlayer();
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpOneEnemy());
		UIMain.player.setIsInEncounter(true);
	}

	@Test
	public void attackWithParam() {
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		String specificEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(2).getName();
		
		//given a physical attack where the enemy is specified
		Reply reply = listener.listen("/phys", "Toranga Leela");

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and the specified enemy should be attacked
		verify(service, times(1)).physAttack(specificEnemyInQueue);
	}

	@Test
	public void attackWithoutParam() {
		String firstEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(0).getName();

		//give a physical attack where no enemy is specified
		Reply reply = listener.listen("/phys", null);

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and the first enemy should be attacked
		verify(service, times(1)).physAttack(firstEnemyInQueue);		
	}

	@Test
	public void inspectOneEnemy() {
		String firstEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(0).getName();
		
		//given a look command attack where there is only one enemy
		Reply reply = listener.listen("/look", null);

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and the specified enemy should be inspected
		verify(service, times(1)).inspectEnemy(firstEnemyInQueue);
	}

	@Test
	public void inspectSpecificEnemy() {
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		String specificEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(2).getName();
		
		//given a look command attack where there the enemy is specified
		Reply reply = listener.listen("/look", "Toranga Leela");

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and the specified enemy should be inspected
		verify(service, times(1)).inspectEnemy(specificEnemyInQueue);
	}

	@Test
	public void inspectOneEnemyButMoreThanOne() {
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		String firstEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(0).getName();
		
		//given a look command attack where there is more than one enemy, but it isn't specified
		Reply reply = listener.listen("/look", null);

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and no inspect command should be run
		verify(service, times(0)).inspectEnemy(firstEnemyInQueue);
		
		//and the output should include the relevant message
		assertTrue(reply.output.equals(GamePlayConstants.SPECIFY_AN_ENEMY_TARGET));
	}

	@Test
	public void helpWindow() {

	}

	@Test
	public void useAttackSpellWithoutTarget() {
		String firstEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(0).getName();

		//give a physical attack where no enemy is specified
		Reply reply = listener.listen("/phys", null);

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and the first enemy should be attacked
		verify(service, times(1)).physAttack(firstEnemyInQueue);
	}

	@Test
	public void useSupportSpellWithoutTarget() {

	}

	@Test
	public void useAttackSpellWithTarget() {
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		String specificEnemyInQueue = UIMain.player.getCurrentCell().getEnemies().get(2).getName();

		//give a physical attack where an enemy is specified
		Reply reply = listener.listen("/phys", specificEnemyInQueue);

		//then the command should succeed
		assertTrue(reply.isSuccess);

		//and the specified enemy should be attacked
		verify(service, times(1)).physAttack(specificEnemyInQueue);
	}

	@Test
	public void useSupportSpellWithTarget() {
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());

	}
	
	@Test
	public void otherCommandNotASkill() {
		Reply reply = listener.listen("/other-command", null);
		assertFalse(reply.isSuccess);
	}
}
