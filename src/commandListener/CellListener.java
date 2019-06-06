package commandListener;

import gameplay.commandServices.CellService;
import pojos.entity.PlayerEntity;
import utilities.InputParser;
import utilities.Logs;

public class CellListener {

	public Reply listen(String command, String parameter, PlayerEntity player) {
		CellService system = new CellService(player);

		String output = "";
		boolean isSuccessful = true;

		switch(command) {

		case "/look":

			//look at room
			if (parameter == null) {
				output = system.inspectRoom();
			} //inspect object of command
			else {
				Object looked = InputParser.parseParameter(parameter);
				output = system.inspectItem();
			}
			break;

		case "/inspect":
			output = system.inspectCell();

			break;
			
		default:
			Logs.LOGGER.info("Hit default case in commandListener.CellListener.listen with command " + command);
			isSuccessful = false;
		}	

		return new Reply(isSuccessful, output);
	}
}
