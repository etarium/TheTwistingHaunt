package tests.commandListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import commandListener.Reply;
import commandListener.SystemListener;
import gameplay.commandServices.GameService;
import tests.SetupStaticValues;
import uiView.UIMain;

public class SystemListenerTest {
	
	@Mock
	GameService service = Mockito.mock(GameService.class);

	@InjectMocks
	SystemListener listener = new SystemListener();


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UIMain.player = SetupStaticValues.setUpPlayer();
	}
	
	@Test
	public void helpWindow() {
		
		Reply reply = listener.listen("/help", service,  null);
		
		assertTrue(reply.isSuccess);
		assertEquals(reply.output, "Your cries for help go answered, and text appears before your eyes.");
	}
	
	@Test
	public void quitSuccess() {
		Reply reply = listener.listen("/quit", service, null);
		
		assertTrue(reply.isSuccess);
		
		verify(service, times(1)).quitGame();
	}
	
	@Test
	public void saveSuccess() {
		Reply reply = listener.listen("/save", service,  "some-param");
		
		assertTrue(reply.isSuccess);
		
		verify(service, times(1)).saveGame("some-param");
	}
	
	@Test
	public void saveFailure() {
		Reply reply = listener.listen("/save", service,  null);
		
		assertTrue(reply.isSuccess);
		
		verify(service, times(0)).saveGame(null);
	}
	
	@Test
	public void otherCommand() {
		Reply reply = listener.listen("/something-else", service, null);

		//the call should fail
		assertFalse(reply.isSuccess);
	}
}
