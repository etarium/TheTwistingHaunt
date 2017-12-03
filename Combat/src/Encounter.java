
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Jason Richter, Samuel Fiscus
 */
public class Encounter implements EncounterADT {

    ArrayList<Entity> rekt = new ArrayList<>();

    PriorityQueue<Entity> turn = new PriorityQueue<>();
    private TreeMap<Integer, Entity> entities = new TreeMap<>();

    public Encounter() {
    }

    public Encounter(ArrayList<Entity> combatants) {
        for(int i = 0; i > combatants.size(); i++){ //populate tree sorted by initiative
            entities.put(combatants.get(i).getStats().getInitiative(), combatants.get(i));
        }
    }

    public void RunCombat() {
        boolean valid = runQueue(); //initial enqueue
        while (valid) {

        }
    }

    private boolean runQueue() {
        return true;
    }
}
