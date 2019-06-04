package commandListener;

import commandServices.BattleService;

public class BattleListener {

	BattleService system = new BattleService();
	
	public Reply listen(String command, String parameter) {
		String output="";
		boolean isSuccessful = true;
		switch (command) {
		case "/status":
		case "/stats":

			//xoutput = this.player.getStats().toString();
			break;
		}
		return new Reply(isSuccessful, output);
	}
}
