
import java.util.ArrayList;


/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class TestClient {

    public static void main(String[] args) {
        // currentHealth,  maxHealth,  physDef,  evasion,  physAtt,  initiative
        //initiative must currently be different
        StatBlock statBlock1 = new StatBlock(100, 100, 50, 60, 50, 15);
        StatBlock statBlock2 = new StatBlock(100, 100, 50, 60, 50, 10);
        StatBlock statBlock3 = new StatBlock(100, 100, 50, 60, 50, 11);

        //stats, team#
        Entity player = new Player(statBlock1, "Player", 1);
        Entity gob1 = new Entity(statBlock2, "Goblin1", 2);
        Entity gob2 = new Entity(statBlock3, "Goblin2", 2);
        
        SingleTargetUsable_HP potion = new SingleTargetUsable_HP(50,"Potion");
        potion.setDescription("This potion heals " + Math.abs(potion.getPotency()) + " HP");
        
        SingleTargetUsable_HP dart = new SingleTargetUsable_HP(-25, "Throwing Dart");
        dart.setDescription("This throwing dart hits for  " + Math.abs(dart.getPotency()) + " HP");
        
        MultiTargetUsable_HP grenade = new MultiTargetUsable_HP(-100, "Grenade");
        
        
        Weapon axe = new Weapon(15, "Axe");
        Armor shield = new Armor(15, "Shield");
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
        boolean combat1Complete;
        fight1.runCombat();
        
        
        
            StatBlock statBlock4 = new StatBlock(100, 100, 50, 60, 50, 10);
            StatBlock statBlock5 = new StatBlock(100, 100, 50, 60, 50, 11);
            Entity gob3 = new Entity(statBlock4, "Goblin3", 2);
            Entity gob4 = new Entity(statBlock5, "Goblin4", 2);
            StatBlock statBlock6 = new StatBlock(400, 400, 60, 30, 70, 7);
            Entity ogre = new Entity(statBlock6, "Shrek", 3);

            ArrayList<Entity> fighters2 = new ArrayList<>();
            fighters2.clear();
            fighters2.add(player);
            fighters2.add(gob3);
            fighters2.add(gob4);
            fighters2.add(ogre);
            Encounter fight2 = new Encounter(fighters2);
            fight2.runCombat();

        
        
        
        
        
    }//end main
}//end class
