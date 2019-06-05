package commandListener;

import gameplay.commandServices.BattleService;
import pojos.entity.PlayerEntity;

public class BattleListener {
	
	public Reply listen(String command, String parameter, PlayerEntity player) {
		BattleService system = new BattleService(player);
		
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
