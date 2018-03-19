
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
    /**
     * Empty constructor
     */
    public Encounter() {
    }

    /**
     * Filled Encounter constructor
     * @param combatants ArrayList&lt;Entity&gt; containing list of Entities to participate in Encounter
     */
    public Encounter(ArrayList<Entity> combatants) {
        
        this.rekt = new ArrayList<>();
        this.combatants = combatants;
    }
       

    //getters
    @Override
    public ArrayList<Entity> getCombatants() {
        return combatants;
    }
    @Override
    public ArrayList<Entity> getRekt() {
        return rekt;
    } 

    //Encounter methods
    @Override
    public void runCombat() {
        boolean valid = turnSetup(); //initial enqueue, never runs combat if failed
        if (valid) {
            //populate tree sorted by initiative
            for (Entity temp : combatants) {
                combQueue.put(0 - temp.getStats().getInitiative(), temp);
            }

            for (Map.Entry<Integer, Entity> entry : combQueue.entrySet()) {
                Entity actor = entry.getValue();

                if (actor.getStats().isAlive()) {

                    if (actor instanceof Player) {
                        ((Player) actor).playerRun(this);

                    } else {
                        Entity target = actor.chooseTarget(actor.getTargetList(combatants));
                        if (target != null) {
                            int dialog = actor.attack(target);
                            actor.combatDialog(dialog, target);
                        }
                    }
                }
            }//end for
            combQueue.clear();
            System.out.println("\n");
            runCombat();

        } else {
            for (Entity victor : combatants) {
                System.out.println(victor);
            }
            System.out.println("No conflict here.");
        }
    } //end RunCombat()

    @Override
    public boolean turnSetup() {
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
