package commandListener;

import gameplay.battle.BattleOrder;
import gameplay.commandServices.BattleService;
import uiView.UIMain;
import utilities.Logs;

public class BattleListener {

	public Reply listen(String command, String parameter) {
		BattleService system = new BattleService();
		BattleOrder order = new BattleOrder();

		String output="";
		String description = UIMain.player.currentCell.getDescription() + "\n"; 
		String upperOutput = description + order.formatBattleOrder(UIMain.battleOrder);
		boolean isSuccessful = true;
		switch (command) {

		case "/phys":
		case "/physical attack":
		case "/attack":
			if (parameter == null) {
				//if no name, attack first enemy in queue
					output = system.physAttack(UIMain.player.getCurrentCell().getEnemies().get(0).getName());
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

		if(UIMain.player.isInEncounter) {
			upperOutput = description + order.initializeBattle();
		} else {
			upperOutput = description;
		}
		return new Reply(isSuccessful, output, upperOutput);
	}
}
