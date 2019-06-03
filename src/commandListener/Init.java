package commandListener;

import uiView.classes.PlayWindow;
import utilities.InputParser;

public class Init {

	public void initializeListeners(PlayWindow play, boolean run) {
        String[] stringArray = InputParser.parse(play.requestInput());
        
        String command = stringArray[0];
        String parameter = stringArray[1];
        
        
        String output = "";
	}
}
