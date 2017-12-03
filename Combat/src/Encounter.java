
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
        boolean valid = runQueue(); //initial enqueue, never runs combat if failed
        while (valid) {
            System.out.print("I got this far!");
        }
    }

    private boolean runQueue() {
        boolean teamCheck = false; //boolean to check team compositions
        int firstTeam = entities.lastKey();
        Entity temp;
        while(!entities.isEmpty()){
            temp = entities.lastEntry().getValue();
            entities.remove(entities.lastKey());
            System.out.print(temp.getName());
            if(temp.getTeamId() != firstTeam && teamCheck == false)
                teamCheck = true;
        }
        return teamCheck; //returns boolean representing validity of fight
    }
}
