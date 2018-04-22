package game;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gui.classes.CommandListener;
import gui.classes.GUI_Client;
import gui.classes.PlayWindow;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

//import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class TestClient {

	//static JTextArea output;
	//static JTextField input;
	static PlayWindow play;


    public static void main(String[] args) {
        
        Client client = new Client();
        
        try {
        		GUI_Client.main(null);
        		//output = GUI_Client.getPlayWindow().getOutputBox();
        		//input = GUI_Client.getPlayWindow().getInputBox();
        		
        		play = GUI_Client.getPlayWindow();
        		CommandListener ear = new CommandListener();
        		
        		
        		
               		
        		boolean run = true;
        		int count = 0;
        		
        		while(run) {
        			
        			System.out.println("Iteration " + ++count);        			
        			ear.listen(play , run);
        		}
        		
        		
        		
        } catch(Exception e) {
        	
        }
        // <editor-fold defaultstate="collapsed" desc=" Old code to test the combat project. Pending removal... ">
        
        /*
        // currentHealth,  maxHealth,  physDef,  evasion,  physAtt,  initiative
        //initiative must currently be different
        StatBlock statBlock1 = new StatBlock(100, 100, 3, 50, 60, 50, 15);
        StatBlock statBlock2 = new StatBlock(100, 100, 1, 50, 60, 50, 10);
        StatBlock statBlock3 = new StatBlock(100, 100, 1, 50, 60, 50, 11);

        //stats, team#
        Entity player = new Player(statBlock1, "Player", 1);
        Entity gob1 = new Entity(statBlock2, "Goblin1", 2);
        Entity gob2 = new Entity(statBlock3, "Goblin2", 2);

        Usable_SingleTarget_HP potion = new Usable_SingleTarget_HP(50, "Potion");
        potion.setDescription("This potion heals " + Math.abs(potion.getPotency()) + " HP");

        Usable_SingleTarget_HP dart = new Usable_SingleTarget_HP(-25, "Throwing Dart");
        dart.setDescription("This throwing dart hits for  " + Math.abs(dart.getPotency()) + " HP");

        Usable_MultiTarget_HP grenade = new Usable_MultiTarget_HP(-75, "Grenade");

        SpecAttack_SingleTarget_HP heal = new SpecAttack_SingleTarget_HP(75, "Heal");
        SpecAttack_MultiTarget_HP fireball = new SpecAttack_MultiTarget_HP(-75, "Fireball");
        
        player.getSpecAttackList().add(fireball);

        Equipable_Weapon axe = new Equipable_Weapon(15, "Axe");
        Equipable_Armor shield = new Equipable_Armor(15, "Shield");
        player.setUsedWeapon(axe);
        player.setWornArmor(shield);

        player.getItemList().add(potion);
        player.getItemList().add(potion);
        player.getItemList().add(dart);
        player.getItemList().add(potion);
        player.getItemList().add(potion);
        player.getItemList().add(dart);
        player.getItemList().add(grenade);
        player.getItemList().add(grenade);

        ArrayList<Entity> fighters1 = new ArrayList<>();
        fighters1.add(gob1);
        fighters1.add(player);
        fighters1.add(gob2);
        Encounter fight1 = new Encounter(fighters1);
        fight1.getCombatants().forEach((selected) -> {
            selected.printEntityInfo();
        });
        boolean combat1Complete;
        fight1.runCombat();

        StatBlock statBlock4 = new StatBlock(100, 100, 1, 50, 60, 50, 10);
        StatBlock statBlock5 = new StatBlock(100, 100, 1, 50, 60, 50, 11);
        Entity gob3 = new Entity(statBlock4, "Goblin3", 2);
        Entity gob4 = new Entity(statBlock5, "Goblin4", 2);
        StatBlock statBlock6 = new StatBlock(400, 400, 1, 60, 30, 70, 7);
        Entity ogre = new Entity(statBlock6, "Shrek", 3);

        ArrayList<Entity> fighters2 = new ArrayList<>();
        fighters2.clear();
        fighters2.add(player);
        fighters2.add(gob3);
        fighters2.add(gob4);
        fighters2.add(ogre);
        Encounter fight2 = new Encounter(fighters2);
        fight2.runCombat();

         */
// </editor-fold>

    }//end main
    
    
    
}//end class
