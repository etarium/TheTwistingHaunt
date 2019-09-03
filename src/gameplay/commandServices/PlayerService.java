package gameplay.commandServices;

import gameplay.StatModMethods.PlayerStatMethods;
import pojos.items.enums.ArmorMaterial;
import pojos.items.enums.WeaponType;
import uiView.UIMain;

public class PlayerService {
	
	PlayerStatMethods system = new PlayerStatMethods();
	
	public PlayerService() {
	}
	
	public String rest() {
		return "Your HP and SP have been restored! \n" + system.fullHP() + "\n" + system.fullSP(); 
	}
	
	public String takeItem(String parameter) {
		//TODO
		/*
		if (parameter == null) {
            //TO_DO
            output = "Oh, come one. You've got to give me more info than that!";
        } //inspect object of command
        else {
            Object taken = parseParameter(parameter);

            if(taken == null) {
            		output = "I'm not sure what you were expecting to take...";
            }
            else if(taken instanceof ConsumableItem) {
            	ConsumableItem item = (ConsumableItem)taken;

            		usableList.remove(item);
            		//player.getCurrentCell(cellList).setItem("");

            		//player.getItemList().add(item);


            		output = "You have added " + item.getName() + " to your inventory.";
            }
            else if (taken instanceof Item) {
            	Item item = (Item)taken;
            		keyList.remove(item);
            		//player.getCurrentCell(cellList).setKeyItem("");


            		//player.getKeyItemsList().add(item);

            		output = "Hm. This looks interesting. You add " + item.getName() + " to your pack.";
            }

            else {
            		output = "That looks awkward to just carry around.";
            }

        } */
		return "";
	}

	public String useItem(String parameter) {
		//TODO
		/*
		if (parameter == null) {
            //TO_DO
            output = "Giving more information would be ... USEful.";
        } //inspect object of command
        else {
            //TO_DO
        		Object used = searchInventory(parameter);

        		if (used == null) {
        			output = "I could use my weight in gold. You could use that " + parameter  
        				+    ". Not everyone can get what they want, though, can they, " + player.getName()
        				+    "?";	
        		}
        		else {
        			if (used instanceof Item) {
        				Item item = (Item)used;
        				output = "You twirl " + item.getName() + " around in your fingers."
        						+"While fun, you're not entirely sure how or where to use it..."
        						+"\n\nIt's best to keep looking.";
        			}

        			else if(used instanceof ConsumableItem) {
        				ConsumableItem item = (ConsumableItem)used;
                		//item.useItem_OOC(player);

                		output = "You have used " + item.getName() + ".";
                }

        			else if(used instanceof WeaponItem) {                				

        				output = "You really need to find a better time for sparring.";

        			}

        			else {
                		output = "You can't use that.";
                }

        		}

        } */
		return "";
	}

	public String dropItem(String parameter) {
		//TODO
		/*
		if (parameter == null) {
            //TO_DO
            output = "Stop, drop, and roll is often useful, but not here.";
        } //inspect object of command
        else {
            //TO_DO
        		Object dropped = searchInventory(parameter);

        		if(dropped == null) {
        			output = "You must first HAVE that in order to drop it.";
        		}

        		else {
        			if (dropped instanceof Item) {
        				Item item = (Item)dropped;
        				output = "You have a feeling that you may need " + item.getName() + ". It wouldn't be wise to drop it.";
        			}

        			else if(dropped instanceof ConsumableItem) {
        				ConsumableItem item = (ConsumableItem)dropped;
                		//player.getItemList().remove(item);

                		output = "You have removed " + item.getName() + " from your inventory.";
                }

        			else if(dropped instanceof WeaponItem) {
        				WeaponItem item = (WeaponItem)dropped;
        				/*
        				if(player.hasWornArmor()) {
        					if(item.getName().equals(player.getWornArmor().getName())) {
        						player.setWornArmor(null);
        					}
        				}
        				if(player.hasUsedWeapon()) {
        					if(item.getName().equals(player.getUsedWeapon().getName())) {
        						player.setUsedWeapon(null);
        				}
        				}

        				output = "Well, you've dropped " + item.getName() + ", and it crumbles to dust "
        					   + "when it hits the floor.\n\n Happy now?";

        			}

        			else {
                		output = "However you managed to get your hands on that thing, it's gone now...";
                }

        		} 
        }  */
		return "";
	}

	public String equipItem(String parameter) {
		//TODO
		/* 
		 * if (parameter == null) {
		 *
            //TO_DO
            output = "Are you sure you're equipped for this task if you can't give me more information?";
        } //inspect object of command
        else {
            //TO_DO
        		Object equipped = parseParameter(parameter);

        		if(equipped == null) {
        			output = "You'll have no such luck equipping that.";
        		}

        		else if (equipped instanceof ArmorItem) {
        			ArmorItem armor = (ArmorItem)equipped;
        				this.equipList.remove(armor);
        				/*player.getCurrentCell(cellList).setItem("");

        				Equipable old = player.getWornArmor();
    					player.setWornArmor(armor);

    					if(old != null) {
    						output = "As soon as you finish donning " + armor.getName() + ", "
    								+old.getName() + " crumbles to dust. How convenient.";
    					}
    					else { 
    						output = "You don " + armor.getName() + ". You feel much more protected.";
    					//}
    			}
        		else if (equipped instanceof WeaponItem) {
        			WeaponItem weapon = (WeaponItem)equipped;
        				this.equipList.remove(weapon);
        				/* player.getCurrentCell(cellList).setItem("");
        				Equipable old = player.getUsedWeapon();
    					player.setUsedWeapon(weapon);

    					if(old != null) {
    						output = "As soon as you pick up " + weapon.getName() + ", "
    								+ old.getName() + " crumbles to dust. How convenient.";
    					}
    					else { 
    						output = "You equip " + weapon.getName() + ". This will work so much better "
    								+ "than your fists, huh?.";
    					//}

    			}

        		else {
        			output = "Yeah, good luck fighting with that.";
        		}


        } */
		return "";
	}

	public String inventory() {
		//TODO
		/*
		if(this.player.getItemList() == null) {
			output = "Nothing to see here.";
		}
		else if(this.player.getItemList().isEmpty()) {
			output = "You don't have anything in your backpack. Poor you.";
		}
		else {
			for(Usable item : player.getItemList()) {
				output += item +  "\n";
			}
		} 
		output = "Nothing to see here.";
		 */
		return "";
	}

	public String equipment() {
		//TODO
		/*
		 *     		List<ArmorItem> armor = this.player.getEquippedArmor();
    		List<WeaponItem> weapon = this.player.getEquippedWeapons();

        	if(armor == null && weapon == null) {
    			output = "You might as well be naked! Maybe that's why the villagers ushered you into this cave...\n\nHmmmm.....";
    		}
    		else {
    			if(armor != null) {
    				output += "You are wearing " + armor.get(0).getName() + ".\n";
    			}
    			if(weapon != null) {
    				output += "You are wielding " + weapon.get(0).getName() + ".\n";
    			}
    		}
		 */
		return"";
	}
	
	public String getPlayerStats() {
		StringBuilder output = new StringBuilder();
		System.out.println("get player stats \n" + UIMain.player.toString());
		output.append(String.format("%-25s", "Name: " + UIMain.player.getName()));
		output.append(String.format("%10s", "Class: " + UIMain.player.getEntityClass().getName()));
		output.append(String.format("%20s", "Level: " + UIMain.player.getLevel()));
		output.append(String.format("%30s",  "Species: " + UIMain.player.getSpeciesObject().getName()));
		output.append("\n\n\n");
		output.append(String.format("%-5s",  "HP: "));
		output.append(String.format("%5s",  UIMain.player.getStats().getHp()));
		output.append(String.format("%13s",  "SP: "));
		output.append(String.format("%6s", UIMain.player.getStats().getSp()));
		output.append(String.format("%14s",  "EVA: " + UIMain.player.getStats().getEva()));
		output.append(String.format("%14s",  "STA: " + UIMain.player.getStats().getSta()));
		output.append("\n\n\n");
		output.append(String.format("%-5s",  "ATK: "));
		output.append(String.format("%5s", UIMain.player.getStats().getAtk()));
		output.append(String.format("%14s",  "DEF: "));
		output.append(String.format("%5s",  + UIMain.player.getStats().getDef()));
		output.append(String.format("%14s",  "INT: " + UIMain.player.getStats().getIntel()));
		output.append(String.format("%15s",  "AGI: " + UIMain.player.getStats().getAgi()));
		output.append("\n\n\n");
		output.append(String.format("%-5s",  "SP ATK: " + UIMain.player.getStats().getSpatk()));
		output.append(String.format("%19s",  "SP DEF: " + UIMain.player.getStats().getSpdef()));
		output.append(String.format("%13s",  "CHA: " + UIMain.player.getStats().getCha()));
		output.append(String.format("%15s",  "ACC: " + UIMain.player.getStats().getAcc()));
		output.append("\n**********\n");
		output.append("Available Weapon Types: ");
		for(WeaponType weapon : UIMain.player.getWeaponType()) {
			output.append(weapon.toString() + ", ");
		}
		output.deleteCharAt(output.length()-2);
		output.append("\n**********\n");
		output.append("Available Armor Types: ");
		for(ArmorMaterial armor : UIMain.player.getArmorType()) {
			output.append(armor.toString() + ", ");
		}
		output.deleteCharAt(output.length()-2);
		output.append("\n**********\n");
		output.append(String.format("%-25s", "XP: " + UIMain.player.getXp()));
		output.append(String.format("%10s", "XP to Next Level: " + UIMain.player.getXpToNextLevel()));
		
		return output.toString();
	}
}
