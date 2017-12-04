
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
        StatBlock statBlock4 = new StatBlock(0, 100, 50, 60, 50, 0);
        StatBlock statBlock5 = new StatBlock(0, 100, 50, 60, 50, 30);

        //stats, team#
        Entity player = new Entity(statBlock1, "Player", 1);
        Entity opp1 = new Entity(statBlock2, "Helpless Cripple1", 2);
        Entity opp2 = new Entity(statBlock3, "Helpless Cripple2", 2);
        Entity opp3 = new Entity(statBlock4, "Helpless Cripple3", 2);
        Entity opp4 = new Entity(statBlock5, "Helpless Cripple4", 1);
        
        ArrayList<Entity> fighters = new ArrayList<>();
        fighters.add(opp1);
        fighters.add(player);
        fighters.add(opp2);
        fighters.add(opp3);
        fighters.add(opp4);
        Encounter fight1 = new Encounter(fighters);
        fight1.runCombat();
        /*
        while ( opp.getStats().isAlive() ) {
            int damage = player.attack(opp);
            player.combatDialog(damage);
            System.out.println();
            
        }//end while
    */
    }//end main
}//end class
