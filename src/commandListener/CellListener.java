package commandListener;

import commandServices.CellService;
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
				//TO_DO
				system.inspectRoom();
			} //inspect object of command
			else {
				Object looked = InputParser.parseParameter(parameter);
				system.inspectItem();
			}
			break;

		case "/inspect":
			system.inspectCell();

			break;
		}
		
		return new Reply(isSuccessful, output);
	}
}
