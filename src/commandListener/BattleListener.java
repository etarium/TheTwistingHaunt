package commandListener;

import gameplay.battle.BattleOrder;
import gameplay.commandServices.BattleService;
import gameplay.commandServices.GameService;
import pojos.Ability;
import pojos.ability.enums.AbilityType;
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
		case "/attack":
			if (parameter == null) {
				//if no name, attack first enemy in queue
				output = system.physAttack(UIMain.player.getCurrentCell().getEnemies().get(0).getName());
			} else {
				output = system.physAttack(parameter);
			}
			break;

		case "/look":
		case "/inspect":
			if (parameter == null) {
				if(UIMain.player.currentCell.getEnemies().size() == 1) {
					output = system.inspectEnemy(UIMain.player.getCurrentCell().getEnemies().get(0).getName());
				}
				output = "Looking out at the enemies before you, you see many worthwhile foes. You would like to focus on one in particular. Yet you pause and wonder... who? Perhaps you should be more specific.";
			} else {
				output = system.inspectEnemy(parameter);
			}
			break;

		case "/help":
			output = "Your cries for help go answered, and text appears before your eyes.";
			GameService.help();
			break;

		default:
			Logs.LOGGER.info("Hit default case in commandListener.BattleListener.listen with command " + command);
			isSuccessful = false;
		}

		//switch cases require final values, therefore dynamically 
		//creating the switch case based on skills would be cumbersome to implement custom classes for
		//this should operate in a similar manner
		for(Ability spell : UIMain.player.getSkills()) {
			if(command.equalsIgnoreCase(spell.getName())) {

				//if target wasn't specific and the ability is damage
				if (parameter == null && ( spell.getType().equals(AbilityType.DAMAGE) 
						|| spell.getType().equals(AbilityType.DEBUFF) 
						|| spell.getType().equals(AbilityType.DRAIN))) {
					//if no name, attack first enemy in queue
					output = system.spAttack(spell, UIMain.player.getCurrentCell().getEnemies().get(0).getName());

					//or if the target wasnt specific and the ability is support
				} else if(parameter == null && ( spell.getType().equals(AbilityType.HEAL) 
						|| spell.getType().equals(AbilityType.BUFF) )) {

					output = system.spSupport(spell, null);

					//or a target was specified
				} else {
					if(spell.getType().equals(AbilityType.DAMAGE) 
							|| spell.getType().equals(AbilityType.DEBUFF) 
							|| spell.getType().equals(AbilityType.DRAIN)) {
						output = system.spAttack(spell, parameter);

					} else {
						output = system.spSupport(spell, parameter);
					}

					Logs.LOGGER.info("Hit spell if statement in commandListener.BattleListener.listen with command " + command);	
					isSuccessful = true;
					break;
				}
			}
		}
		if(UIMain.player.isInEncounter) {
			upperOutput = description + order.initializeBattle();
		} else {
			upperOutput = description;
		}
		return new Reply(isSuccessful, output, upperOutput);
	}
}