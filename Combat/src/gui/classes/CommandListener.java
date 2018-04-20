package gui.classes;

public class CommandListener {

	public static void listen(PlayWindow play,  boolean run) {

		String selection = play.requestInput();
		
		
		selection = selection.toLowerCase().trim();
		String firstParse = selection;

		if (selection.contains(" ")){
			firstParse = selection.substring(0, selection.indexOf(' '));
		}


		switch(firstParse) {

		case "/look":

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

			break;
		case "/south": case "/s":

			break;
		case "/east": case "/e":

			break;
		case "/west": case "/w":

			break;


		case "/help":
			new gui.classes.HelpWindow();
			play.outGUI("Oh, help me!");
			break;

		case "/quit":
			run = false;
			play.exitGame();
			new gui.classes.MainMenu();
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

}
