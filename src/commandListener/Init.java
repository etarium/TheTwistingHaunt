package commandListener;

import gameplay.commandServices.BattleService;
import gameplay.commandServices.CellService;
import gameplay.commandServices.GameService;
import gameplay.commandServices.InventoryService;
import gameplay.commandServices.MovementService;
import gameplay.newGame.NewPlayerPayload;
import gameplay.newGame.PlayerInitializer;
import pojos.entity.PlayerEntity;
import uiView.classes.PlayWindow;
import utilities.InputParser;
import utilities.Logs;

public class Init {

	//declare listeners
	BattleListener battleListener = new BattleListener();
	MovementListener movementListener = new MovementListener();
	InventoryListener inventoryListener = new InventoryListener();
	SystemListener systemListener = new SystemListener();
	CellListener cellListener = new CellListener();
	
	//declare initialization services
	//PlayerInitializer playinit = new PlayerInitializer();
	
	public void initializeListeners(PlayWindow play, GameService system, PlayerEntity player) {
		Logs.LOGGER.info("Init.initializeListeners() with player " + player);
		System.out.println(play);
        String[] stringArray = InputParser.parse(play.requestInput());
        
        String command = stringArray[0];
        String parameter = stringArray[1];
        
        
        String output = "";
        String upperOutput = "";
        //check the listeners
        
        	Reply systemReply = systemListener.listen(command, system, player);
        	Reply battleReply = battleListener.listen(command, parameter, player);
        	Reply movementReply = movementListener.listen(command, parameter, player);
        	Reply inventoryReply = inventoryListener.listen(command, parameter, player);
        	Reply cellReply = cellListener.listen(command, parameter, player);
        	
        	Reply[] replies = {systemReply, battleReply, movementReply, inventoryReply, cellReply};
        	
        	for(Reply reply: replies) {
        		if(reply.isSuccess) {
        			output = reply.output;
        			if(reply.upperOutput != null) {
        				upperOutput = reply.upperOutput;
        			} else {
        				upperOutput = player.getCurrentCell().getDescription();
        			}
        		}
        	}
        	
        //sends output generated from user selection to the GUI window
        	System.out.println("play.outGUI " + output);
        play.outGUI(output);
        play.outTopGUI(upperOutput);
	}
	
	public void initializeGame(PlayWindow play, GameService system, PlayerEntity player) {
		Logs.LOGGER.info("Init.initializeGame()");
		
		//PlayerEntity player = playinit.initializePlayer(isNewGame, payload);
		System.out.println("initializeListeners: Player = " + player);
		initializeListeners(play, system, player);
	}
}
