
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jason Richter, Samuel Fiscus
 */
public class Encounter implements EncounterADT {

    private ArrayList<Entity> rekt;
    private ArrayList<Entity> combatants;
    
    private TreeMap<Integer, Entity> combQueue = new TreeMap<>();

    
    //constructors
    public Encounter() {
    }

    public Encounter(ArrayList<Entity> combatants) {
        
        this.rekt = new ArrayList<>();
        this.combatants = combatants;
    }

    //Encounter methods
    public void runCombat() {
        boolean valid = runQueue(); //initial enqueue, never runs combat if failed
        if (valid) {            
            //populate tree sorted by initiative
            for(Entity temp : combatants){
                combQueue.put(0 - temp.getStats().getInitiative(), temp);
            }
            
            //test print
            for(Map.Entry<Integer,Entity> entry: combQueue.entrySet()){
                System.out.println(entry.getValue());
            }
            
            System.out.println("\n\nDefeated:");
            for(Entity dead : rekt){
                System.out.println("\t" + dead.getName());
            }
        }
        else {
            System.out.println("No conflict here.");
        }
       
    }//end RunCombat()

    private boolean runQueue() {
        boolean teamCheck = false; //boolean to check team compositions
        
        if (!combatants.isEmpty()) {
            int firstTeam = combatants.get(0).getTeamId();
            

            for (Entity temp : combatants) {
                if (temp.getStats().isAlive()) {
                    if (temp.getTeamId() != firstTeam && teamCheck == false) {
                        teamCheck = true;
                    }
                } else { //can remove Entity from combat and add to rekt
                    rekt.add(temp);
                }
            }
            for (Entity dead : rekt) {
                if (combatants.contains(dead)) {
                    combatants.remove(dead);
                }
            }
        }
        return teamCheck; //returns boolean representing validity of fight
    }//end runQueue()
}
