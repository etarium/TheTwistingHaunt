package gui.classes;

public class CommandListener {

	public CommandListener() {
		
	}
	
	
	/**
	 * Uses parsed input in a {command}{parameter} format in order to filter user input based on help file commands
	 * Input comes from JTextField and output goes to JTextArea, both in PlayWindow class.
	 * 
	 * Every /command should generate some sort of output for the user to see the effect of their actions.
	 * If no command is recognized, then output warns user of an invalid input, referencing the help file
	 * 	for more instructions.
	 * 
	 * Case-switch determines which methods or blocks of code are run, and which output is to be sent to the
	 * 	JTextArea for the user to see.
	 * 
	 * 
	 * 
	 * @param play Instance of play window in which the input/output can be found
	 * @param run Boolean representing whether or not the listener loop should still run after current iteration
	 */
	public  void listen(PlayWindow play,  boolean run) {

			
		String[] stringArray = inputParser(play.requestInput());
		String output = "";


		switch(stringArray[0]) {
		
		
		//if no parameter is present in the {command}{parameter} structure, then output is set
		//	to current room's description
		//otherwise, parameter may fall into entity, item, equipment, etc., and should be output
		//	based upon that
		case "/look":
			//inspect room
			if(stringArray[1] == null) {
				//TO_DO
				output = "TEST CELL DESC";
			}
			//inspect object of command
			else {
				//TO_DO
				output = "TEST ITEM/ENTITY/ETC";
				
			}
			break;
			
		case "/take":
			output = "TEST TAKE";
			break;
			
		case "/drop":
			output = "TEST DROP";
			break;
			
		case "/use":
			output = "TEST USE";
			break;
			
		case "/equip":
			output = "TEST EQUIP";
			break;
			
		case "/inventory": case "/inv":
			output = "TEST INVENTORY";
			break;
			
		case "/equipment":
			output = "TEST EQUIPMENT";
			break;
			
		case "/status":
			output = "TEST STATUS";
			break;


		//determines if movement can be made in the direction sent by the user
		//direction is parsed from /command and streamlined into a single character: n, s, e, or w
		//	so the input for applicable methods should rely on that passed char
		//if player can move that direction, sets new current cell and outputs that cell's description
		//if not, outputs some sort of error to user
		case "/north": case "/n":
		case "/south": case "/s":
		case "/east": case "/e":
		case "/west": case "/w":

			char direction = stringArray[0].charAt(1);
			output = "You'd like to go that way, wouldn't you?";
			break;

			
		
		case "/help":
			output = "\"Oh, help me!\"";
			new HelpWindow();
			break;

		case "/quit":
			output = "Next time, hero.";
			run = false;
			new MainMenu();
			play.exitGame();
			play = null;
			break;

		case "/save":

			output = "TEST SAVE";
			break;

			
		//if command is not recognized, outputs a flavorful error and references the /help command for assistance
		default:
			output = "Your mutterings echo softly, but go unanswered.\n"
					+ "[try again, or type '/help' for assistance]";
			break;





		}//end switch
		
		//sends output generated from user selection to the GUI window
		play.outGUI(output);


	}//end commandListener()
	
	
	/**
	 * Parses input into an array with the format {verb},{object}. If no parameter is present, that
	 * field will be null.
	 * 
	 * @param input
	 * @return String array with command and parameter.
	 */
	public String[] inputParser(String input) {
		
		String[] stringArray = new String[2];
		
		input = input.trim().toLowerCase();
		
		boolean containsSpace = input.contains(" ");
		
		//will be -1 if no space present
		int indexOfSpace = input.indexOf(" ");
		
		stringArray[0] = (containsSpace) ? input.substring(0, input.indexOf(" ")) : input;
		stringArray[1] = (containsSpace) ? input.substring(indexOfSpace + 1) : null;
		
		return stringArray;
		
			
		
	}

}
