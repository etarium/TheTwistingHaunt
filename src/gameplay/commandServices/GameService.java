package gameplay.commandServices;

import pojos.entity.PlayerEntity;
import uiView.classes.HelpWin;
import uiView.classes.PlayWindow;

public class GameService {

	PlayWindow play;
	boolean run;
	
	public GameService(PlayWindow play, boolean run) {
		this.play = play;
		this.run = run;
		
	}
	
	public void quitGame() {
		run = false;
		play.exitGame();
		play = null;
	}
	
	public void help() {
		//this one might not have needed to be factored out, but it gives us a consistent patter to follow
		new HelpWin();
	}
	
	//TODO	
	public void saveGame(PlayerEntity player) {
		
	}
	
	public void options() {
		
	}
}
