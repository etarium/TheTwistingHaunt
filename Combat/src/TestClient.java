
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

        //stats, team#
        Entity player = new Entity(statBlock1, "Player", 1);
        Entity opp = new Entity(statBlock2, "Helpless Cripple", 2);
        
        ArrayList<Entity> fighters = new ArrayList<>();
        fighters.add(opp);
        fighters.add(player);
        Encounter fight1 = new Encounter(fighters);
        fight1.RunCombat();
        /*
        while ( opp.getStats().isAlive() ) {
            int damage = player.attack(opp);
            player.combatDialog(damage);
            System.out.println();
            
        }//end while
    */
    }//end main
}//end class
