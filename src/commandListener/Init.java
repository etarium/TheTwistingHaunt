package commandListener;

import gameplay.commandServices.GameService;

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

	public void initializeListeners(PlayWindow play, GameService system) {
		String input = play.requestInput();
		String[] stringArray = InputParser.parse(input);

		String command = stringArray[0];
		String parameter = stringArray[1];
		
		//check the listeners
		//player is not engaged in combat
		if(!UIMain.player.isInEncounter) { 
			Reply systemReply = systemListener.listen(command, system, parameter);
			Reply movementReply = movementListener.listen(command);
			Reply inventoryReply = inventoryListener.listen(command, parameter);
			Reply cellReply = cellListener.listen(command, parameter);
			Reply[] replies = {systemReply, movementReply, inventoryReply, cellReply};
			Reply reply = processReplies(replies);
			if(!reply.isSuccess) {
				output = "Your mutterings echo softly, but go unanswered.\n"
						+ "[try again, or type '/help' for assistance]";
			}
		} else {
			//player is engaged in combat
			Reply battleReply = battleListener.listen(command, parameter);
			Reply battleSpellReply = new Reply(false, "", "");
			if(!battleReply.isSuccess) {
				String [] spellStringArray = InputParser.parseMultiWordSkills(input);
				String spellCommand = spellStringArray[0];
				String spellParameter = spellStringArray[1];
				battleSpellReply = battleListener.listen(spellCommand,  spellParameter);
			}
			Reply movementReply = movementListener.listen(command);
			Reply inventoryReply = inventoryListener.listen(command, parameter);
			Reply[] replies = {(battleReply.isSuccess) ? battleReply : battleSpellReply, movementReply, inventoryReply };
			Reply reply = processReplies(replies);
			if(!reply.isSuccess) {
				output = "This isn't the time or place to do anything other than fight, hero! \n"
						+ "[try again, or type '/help' for battle assistance]";
			}
		}

		//sends output generated from user selection to the GUI window
		play.outGUI(output);
		play.outTopGUI(upperOutput);
	}

	public void initializeGame(PlayWindow play, GameService system ) {
		Logs.LOGGER.info("Init.initializeGame()");

		initializeListeners(play, system);
	}

	private Reply processReplies(Reply[] replies) {
		for(Reply reply: replies) {
			if(reply.isSuccess) {
				output = reply.output;
				if(reply.upperOutput != null) {
					upperOutput = reply.upperOutput;
				} else {
					upperOutput = UIMain.player.getCurrentCell().getDescription();
				}
				return new Reply(true, output, upperOutput);
			}
		}
		return new Reply(false, "", UIMain.player.getCurrentCell().getDescription());
	}
}
