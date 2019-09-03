package commandListener;

import gameplay.commandServices.GameService;
import pojos.entity.PlayerEntity;
import uiView.UIMain;
import uiView.classes.PlayWindow;
import utilities.InputParser;
import utilities.Logs;

public class Init {

	//declare listeners
	BattleListener battleListener = new BattleListener();
	MovementListener movementListener = new MovementListener();
	PlayerListener inventoryListener = new PlayerListener();
	SystemListener systemListener = new SystemListener();
	CellListener cellListener = new CellListener();
	
	//declare outputs
	private String output = "";
	private String upperOutput = "";
	private boolean success = false;

	public void initializeListeners(PlayWindow play, GameService system) {
		String[] stringArray = InputParser.parse(play.requestInput());

		String command = stringArray[0];
		String parameter = stringArray[1];

		//check the listeners
		Reply systemReply = systemListener.listen(command, system, parameter);
		Reply battleReply = battleListener.listen(command, parameter);
		Reply movementReply = movementListener.listen(command);
		Reply inventoryReply = inventoryListener.listen(command, parameter);
		Reply cellReply = cellListener.listen(command, parameter);
		
		//player is not engaged in combat
		if(!UIMain.player.isInEncounter) {
			Reply[] replies = {systemReply, battleReply, movementReply, inventoryReply, cellReply};
			processReplies(replies);
		} else { //player is engaged in combat
			Reply[] replies = {battleReply, inventoryReply, movementReply};
			processReplies(replies);
		}
			if(!success) {
				output = "Your mutterings echo softly, but go unanswered.\n"
						+ "[try again, or type '/help' for assistance]";
			}
		//sends output generated from user selection to the GUI window
		play.outGUI(output);
		play.outTopGUI(upperOutput);
	}

	public void initializeGame(PlayWindow play, GameService system, PlayerEntity player) {
		Logs.LOGGER.info("Init.initializeGame()");

		initializeListeners(play, system);
	}
	
	private void processReplies(Reply[] replies) {
		for(Reply reply: replies) {
			if(reply.isSuccess) {
				output = reply.output;
				success = true;
				if(reply.upperOutput != null) {
					upperOutput = reply.upperOutput;
				} else {
					upperOutput = UIMain.player.getCurrentCell().getDescription();
				}
			}
		}
	}
}
