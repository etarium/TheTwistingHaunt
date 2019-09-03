package commandListener;

import gameplay.commandServices.BattleService;
import utilities.Logs;

public class BattleListener {
	
	public Reply listen(String command, String parameter) {
		BattleService system = new BattleService();
		
		String output="";
		boolean isSuccessful = true;
		switch (command) {
		case "/order":
		case "/battle":
			//TODO:
			break;

		default:
			Logs.LOGGER.info("Hit default case in commandListener.BattleListener.listen with command " + command);
			isSuccessful = false;
		}
		return new Reply(isSuccessful, output);
	}
}
