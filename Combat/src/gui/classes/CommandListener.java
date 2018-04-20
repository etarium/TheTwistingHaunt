package gui.classes;

public class CommandListener {

	public CommandListener() {
		
	}
	public  void listen(PlayWindow play,  boolean run) {

			
		String[] stringArray = inputParser(play.requestInput());


		switch(stringArray[0]) {

		case "/look":
			if(stringArray[1] == null) {
				//NEED TO INSTANTIATE
				String cellDescription = "";
				play.outGUI(cellDescription);
			}

			break;
		case "/take":

			break;
		case "/drop":

			break;
		case "/use":

			break;
		case "/equip":

			break;
		case "/inventory": case "/inv":

			break;
		case "/equipment":

			break;
		case "/status":

			break;


		case "/north": case "/n":
		case "/south": case "/s":
		case "/east": case "/e":
		case "/west": case "/w":

			char direction = stringArray[0].charAt(1);
			play.outGUI("You'd like to go that way, wouldn't you?");
			break;


		case "/help":
			new gui.classes.HelpWindow();
			play.outGUI("Oh, help me!");
			break;

		case "/quit":
			run = false;
			new gui.classes.MainMenu();
			play.exitGame();
			play = null;
			break;

		case "/save":

			break;

		default:
			String errorMessage = "Your mutterings echo softly, but go answered.\n"
					+ "[try again, or type '/help' for assistance]";
			play.outGUI(errorMessage);
			break;





		}//end switch


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
