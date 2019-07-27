package commandListener;

import gameplay.commandServices.CellService;
import utilities.Logs;

public class CellListener {

	public Reply listen(String command, String parameter) {
		CellService system = new CellService();

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
