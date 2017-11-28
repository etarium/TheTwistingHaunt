
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
        Entity opp = new Entity(statBlock2, "Enemy");

        while ( opp.getStats().isAlive() ) {
            int damage = player.attack(opp);
            
            if(damage < 0){
                System.out.println("Miss!");
            }
            else {
                
                int beforeHealth = opp.getStats().currentHealth;
                opp.defend(damage);
                int afterHealth = opp.getStats().currentHealth;
                
                if(beforeHealth == afterHealth){
                    System.out.println("Armor nullifes.");
                }
                else {
                    int shave = beforeHealth - afterHealth;
                    System.out.println("Hit for " + shave + "!");
                }
            }
            System.out.println(opp);
            System.out.print("\n\n");

        }//end while
    }//end main
}//end class
