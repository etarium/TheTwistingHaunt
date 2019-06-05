package commandListener;

import gameplay.commandServices.MovementService;
import utilities.Logs;

public class MovementListener {

	MovementService system = new MovementService();
	public Reply listen(String command, String parameter) {
		String output = "";
		String upperOutput = "";
		boolean success = true;
		switch (command) {
		 //determines if movement can be made in the direction sent by the user
        //direction is parsed from /command and streamlined into a single character: n, s, e, or w
        //	so the input for applicable methods should rely on that passed char
        //if player can move that direction, sets new current cell and outputs that cell's description
        //if not, outputs some sort of error to user
        case "/north":
        case "/n":
        case "/south":
        case "/s":
        case "/east":
        case "/e":
        case "/west":
        case "/w":

            char direction = command.charAt(1);

            output = "You'd like to go that way, wouldn't you?";
            switch (direction) {
                case 'n':
                    
                		upperOutput = system.movePlayer(direction);
                

                    break;
                case 's':
                    //check to see of movement possible 
                	/*
            			if(player.getCurrentCell(cellList).isSouth()) {
                        player.getLocation().setY(player.getLocation().getY() - 1);
                        output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                    }  */
                    break;
                case 'e':
                    //check to see of movement possible
            		/*
                		if(player.getCurrentCell(cellList).isEast()) {
                        player.getLocation().setX(player.getLocation().getX() + 1);
                        output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                    } */
                    break;
                case 'w':
                    //check to see of movement possible
                	/*
            			if(player.getCurrentCell(cellList).isWest()) {
                        player.getLocation().setX(player.getLocation().getX() - 1);
                        output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
                    } */
                    break;
                default:
                    output = "This should never happen, please contact your nearest dev.";
                    success = false;
        				Logs.LOGGER.info("Hit default case in commandListener.MovementListener.listen with command " + command);
            }
            break;
    }//end switch
		
		return new Reply(success, output, upperOutput);
	}
}
