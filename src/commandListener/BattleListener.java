package commandListener;

import ability.enums.AbilityType;
import gameplay.GamePlayConstants;
import gameplay.battle.BattleOrder;
import gameplay.commandServices.BattleService;
import gameplay.commandServices.GameService;
import general.Ability;
import uiView.UIMain;
import utilities.Logs;

public class BattleListener {

	BattleService system = new BattleService();
	BattleOrder order = new BattleOrder();

	public Reply listen(String command, String parameter) {
		String output="";
		String description = UIMain.player.currentCell.getDescription() + "\n"; 
		String upperOutput;
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
				output = GamePlayConstants.SPECIFY_AN_ENEMY_TARGET;
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
			//switch cases require final values, therefore dynamically 
			//creating the switch case based on skills would be cumbersome to implement custom classes for
			//this should operate in a similar manner
			for(Ability spell : UIMain.player.getSkills()) {
				if(command.equalsIgnoreCase("/"+spell.getName())) {
					isSuccessful = true;
					//if target wasn't specific and the ability is damage
					if (parameter == null && ( spell.getType().equals(AbilityType.DAMAGE) 
							|| spell.getType().equals(AbilityType.DEBUFF) 
							|| spell.getType().equals(AbilityType.DRAIN))) {
						//if no name, attack first enemy in queue
						output = system.spAttack(spell, UIMain.player.getCurrentCell().getEnemies().get(0).getName());

						//or if the target wasnt specific and the ability is support
					} else if(parameter == null && ( spell.getType().equals(AbilityType.HEAL) 
							|| spell.getType().equals(AbilityType.BUFF) )) {

						output = system.spSupport(spell);

						//or a target was specified
					} else {
						if(spell.getType().equals(AbilityType.DAMAGE) 
								|| spell.getType().equals(AbilityType.DEBUFF) 
								|| spell.getType().equals(AbilityType.DRAIN)) {
							output = system.spAttack(spell, parameter);

						} else {
							output = system.spSupport(spell);
						}

						Logs.LOGGER.info("Hit spell if statement in commandListener.BattleListener.listen with command " + command);	

						break;
					}
				}
			}
		}
		if(UIMain.player.isInEncounter) {
			upperOutput = description + order.updateBattleOrder();
		} else {
			upperOutput = description;
		}
		return new Reply(isSuccessful, output, upperOutput);
	}
}