package commandListener;

import gameplay.commandServices.CellService;
import utilities.InputParser;

public class CellListener {
	
	CellService system = new CellService();
	
	public Reply listen(String command, String parameter) {
		
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
		}
		
		return new Reply(isSuccessful, output);
	}
}
