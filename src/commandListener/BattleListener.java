package commandListener;

import gameplay.commandServices.BattleService;
import uiView.UIMain;
import utilities.Logs;

public class BattleListener {

	public Reply listen(String command, String parameter) {
		BattleService system = new BattleService();

		String output="";
		boolean isSuccessful = true;
		switch (command) {

		case "/order":
		case "/battle":
			//TODO:
			break;

		case "/phys":
		case "/physical attack":
		case "/attack":
			if (parameter == null) {
				if(UIMain.player.currentCell.getEnemies().size() == 1) {
					output = system.physAttack(UIMain.player.getCurrentCell().getEnemies().get(0).getName());
				} else {
					output = "Your weapon clanks as you drag it along the ground, preparing to strike. Yet you pause and wonder... who? Perhaps you should be more specific.";
				}
			} else {
				output = system.physAttack(parameter);
			}
			break;

		case "/spell":
		case "/magic":
		case "/magic attack":
		case "/spell attack":
		case "/sp attack":
			//TODO
			if (parameter == null) {
				if(UIMain.player.currentCell.getEnemies().size() == 1) {
					output = system.spAttack(UIMain.player.getCurrentCell().getEnemies().get(0).getName());
				}
				output = "The thunderous fury of your spells pound in your ears. The magic begs to be unleashed. Yet you pause and wonder... who? Perhaps you should be more specific.";
			} else {
				output = system.spAttack(parameter);
			}
			break;
		case "/look":
		case "/inspect":
			//TODO
			if (parameter == null) {
				if(UIMain.player.currentCell.getEnemies().size() == 1) {
					output = system.inspectEnemy(UIMain.player.getCurrentCell().getEnemies().get(0).getName());
				}
				output = "Looking out at the enemies before you, you see many worthwhile foes. You would like to focus on one in particular. Yet you pause and wonder... who? Perhaps you should be more specific.";
			} else {
				output = system.inspectEnemy(parameter);
			}
			break;

		default:
			Logs.LOGGER.info("Hit default case in commandListener.BattleListener.listen with command " + command);
			isSuccessful = false;
		}
		return new Reply(isSuccessful, output);
	}
}
