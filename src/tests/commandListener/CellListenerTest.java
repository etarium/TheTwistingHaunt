package tests.commandListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import commandListener.CellListener;
import commandListener.PlayerListener;
import commandListener.Reply;
import gameplay.commandServices.CellService;
import gameplay.commandServices.PlayerService;
import tests.SetupStaticValues;
import uiView.UIMain;


public class CellListenerTest {

	@Mock
	CellService service = Mockito.mock(CellService.class);

	@InjectMocks
	CellListener listener = new CellListener();


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UIMain.player = SetupStaticValues.setUpPlayer();
	}

	@Test
	public void lookCellSuccess() {
		Reply reply = listener.listen("/look", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).inspectCell();
		
		verify(service, times(0)).inspectItem(null);
		verify(service, times(0)).openItem(null);
	}

	@Test
	public void lookItemSuccess() {
		Reply reply = listener.listen("/look", "item");

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).inspectItem("item");
		
		verify(service, times(0)).inspectCell();
		verify(service, times(0)).openItem(null);
	}

	@Test
	public void openItemSuccess() {
		Reply reply = listener.listen("/open", "item");

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(1)).openItem("item");
		
		verify(service, times(0)).inspectCell();
		verify(service, times(0)).inspectItem("item");
	}

	@Test
	public void openItemSucessfulCommandNoParam() {
		Reply reply = listener.listen("/open", null);

		//should have a successful reply
		assertTrue(reply.isSuccess);
		//and the service should be called once
		verify(service, times(0)).openItem(null);
		
		verify(service, times(0)).inspectCell();
		verify(service, times(0)).inspectItem(null);
	}

	@Test
	public void otherCommand() {
		Reply reply = listener.listen("/something-else", null);

		//the call should fail
		assertFalse(reply.isSuccess);
		
		//and no calls should have been made
		verify(service, times(0)).openItem(null);
		verify(service, times(0)).inspectCell();
		verify(service, times(0)).inspectItem(null);
	}
}
