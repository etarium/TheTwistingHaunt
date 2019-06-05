package commandListener;

import gameplay.commandServices.BattleService;
import gameplay.commandServices.CellService;
import gameplay.commandServices.GameService;
import gameplay.commandServices.InventoryService;
import gameplay.commandServices.MovementService;
import uiView.classes.PlayWindow;
import utilities.InputParser;

public class Init {

	//declare listeners
	BattleListener battleListener = new BattleListener();
	MovementListener movementListener = new MovementListener();
	InventoryListener inventoryListener = new InventoryListener();
	SystemListener systemListener = new SystemListener();
	CellListener cellListener = new CellListener();
	
	public void initializeListeners(PlayWindow play, GameService system) {
		
        String[] stringArray = InputParser.parse(play.requestInput());
        
        String command = stringArray[0];
        String parameter = stringArray[1];
        
        
        String output = "";
        String upperOutput = "";
        //check the listeners
        
        	Reply systemReply = systemListener.listen(command, system);
        	Reply battleReply = battleListener.listen(command, parameter);
        	Reply movementReply = movementListener.listen(command, parameter);
        	Reply inventoryReply = inventoryListener.listen(command, parameter);
        	Reply cellReply = cellListener.listen(command, parameter);
        	
        	Reply[] replies = {systemReply, battleReply, movementReply, inventoryReply, cellReply};
        	
        	for(Reply reply: replies) {
        		if(reply.isSuccess) {
        			output = reply.output;
        			if(reply.upperOutput != null) {
        				upperOutput = reply.upperOutput;
        			}
        			break;
        		}
        	}
        	
        //sends output generated from user selection to the GUI window
        play.outGUI(output);
        play.outTopGUI(upperOutput);
	}
}
