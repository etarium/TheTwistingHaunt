package commandListener;

import gameplay.commandServices.CellService;
import pojos.entity.PlayerEntity;
import utilities.Logs;

public class CellListener {

	public Reply listen(String command, String parameter, PlayerEntity player) {
		CellService system = new CellService(player);

		String output = "";
		boolean isSuccessful = true;

		switch(command) {

		case "/look":
		case "/inspect":
			//look at room
			if (parameter == null) {
				output = system.inspectCell();
			} //inspect object of command
			else {
				output = system.inspectItem(parameter);
			}
			break;

			
		default:
			Logs.LOGGER.info("Hit default case in commandListener.CellListener.listen with command " + command);
			isSuccessful = false;
		}	

		return new Reply(isSuccessful, output);
	}
}
