package commandListener;

import gameplay.commandServices.CellService;
import utilities.Logs;

public class CellListener {

	CellService system = new CellService();
	public Reply listen(String command, String parameter) {
		
		String output = "";
		boolean isSuccessful = true;

		switch(command) {

		case "/look":
		case "/inspect":
			//look at room
			if (parameter == null) {
				output = system.inspectCell();
			} //inspect object
			else {
				output = system.inspectItem(parameter);
			}
			break;
			
		case "/open":
			if (parameter == null) {
				output = "You look around aimlessly, unsure of what could possibly be opened. Perhaps you should be more specific.";
			} else {
				output = system.openItem(parameter);
			}
			break;
		default:
			Logs.LOGGER.info("Hit default case in commandListener.CellListener.listen with command " + command);
			isSuccessful = false;
		}	

		return new Reply(isSuccessful, output);
	}
}
