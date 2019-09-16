package tests.commandListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import commandListener.SystemListener;
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
	SystemListener listener = new SystemListener();


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UIMain.player = SetupStaticValues.setUpPlayer();
	}
	
	@Test
	public void attackWithParam() {
		
	}
	
	@Test
	public void attackWithoutParam() {
		
	}
	
	@Test
	public void inspectOneEnemy() {
		
	}
	
	@Test
	public void inspectSpecificEnemy() {
		
	}
	
	@Test
	public void inspectOneEnemyButMoreThanOne() {
		
	}
	
	@Test
	public void helpWindow() {
		
	}
	
	@Test
	public void useAttackSpellWithoutTarget() {
		
	}
	
	@Test
	public void useSupportSpellWithoutTarget() {
		
	}
	
	@Test
	public void useAttackSpellWithTarget() {
		
	}
	
	@Test
	public void useSupportSpellWithTarget() {
		
	}
}
