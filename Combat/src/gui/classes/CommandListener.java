package gui.classes;

public class CommandListener {

	public CommandListener() {
		
	}
	public  void listen(PlayWindow play,  boolean run) {

			
		String[] stringArray = inputParser(play.requestInput());
		String output = "";


		switch(stringArray[0]) {

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


		case "/north": case "/n":
		case "/south": case "/s":
		case "/east": case "/e":
		case "/west": case "/w":

			char direction = stringArray[0].charAt(1);
			output = "You'd like to go that way, wouldn't you?";
			break;


		case "/help":
			output = "Oh, help me!";
			new gui.classes.HelpWindow();
			break;

		case "/quit":
			output = "Next time, hero.";
			run = false;
			new gui.classes.MainMenu();
			play.exitGame();
			play = null;
			break;

		case "/save":

			output = "TEST SAVE";
			break;

		default:
			output = "Your mutterings echo softly, but go unanswered.\n"
					+ "[try again, or type '/help' for assistance]";
			break;





		}//end switch
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
