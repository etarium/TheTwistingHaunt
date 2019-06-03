package commandListener;

import uiView.classes.PlayWindow;
import utilities.GameCommands;
import utilities.InputParser;

public class Init {

	//declare listeners
	BattleListener battleListener = new BattleListener();
	MovementListener movementListener = new MovementListener();
	InventoryListener inventoryListener = new InventoryListener();
	SystemListener systemListener = new SystemListener();
	
	public void initializeListeners(PlayWindow play, GameCommands system) {
		
        String[] stringArray = InputParser.parse(play.requestInput());
        
        String command = stringArray[0];
        String parameter = stringArray[1];
        
        
        String output = "";
        String upperOutput = "";
        //check the listeners
        
        	Reply systemReply = systemListener.listen(command, system);
        	Reply battleReply;
        	Reply movementReply;
        	
        	
        //sends output generated from user selection to the GUI window
        play.outGUI(output);
        play.outTopGUI(upperOutput);
	}
}
