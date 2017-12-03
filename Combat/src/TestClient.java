
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class TestClient {

    public static void main(String[] args) {
        // currentHealth,  maxHealth,  physDef,  evasion,  physAtt,  initiative
        StatBlock statBlock1 = new StatBlock(100, 100, 50, 60, 50, 10);
        StatBlock statBlock2 = new StatBlock(100, 100, 50, 60, 50, 10);

        Entity player = new Entity(statBlock1, "Player");
        Entity opp = new Entity(statBlock2, "Helpless Cripple");

        while ( opp.getStats().isAlive() ) {
            int damage = player.attack(opp);
            player.combatDialog(damage);
            System.out.println();

        }//end while
    }//end main
}//end class
