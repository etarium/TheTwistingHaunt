package commandListener;

import gameplay.commandServices.CellService;
import pojos.entity.PlayerEntity;
import utilities.InputParser;

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
		}
		
		return new Reply(isSuccessful, output);
	}
}
