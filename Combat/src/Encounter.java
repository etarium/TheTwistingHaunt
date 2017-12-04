
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Jason Richter, Samuel Fiscus
 */
public class Encounter implements EncounterADT {

    private ArrayList<Entity> rekt = new ArrayList<>();
    private PriorityQueue<Entity> turn = new PriorityQueue<>();
    
    private TreeMap<Integer, Entity> entities = new TreeMap<>();

    public Encounter() {
    }

    public Encounter(ArrayList<Entity> combatants) {
        //populate tree sorted by initiative
        for(Entity temp : combatants){
            entities.put(temp.getStats().getInitiative(), temp);
        }
        //System.out.println(entities); //test print
    }

    public void RunCombat() {
        boolean valid = runQueue(); //initial enqueue, never runs combat if failed
        if (valid) {
            System.out.println("I got this far!");
        }
        else {
            System.out.println("No conflict here.");
        }
        
        System.out.println(entities);
        //all entries currently removed from entities
    }

    private boolean runQueue() {
        boolean teamCheck = false; //boolean to check team compositions
        
        int firstTeam = entities.lastEntry().getValue().getTeamId();
        System.out.println(firstTeam);
        Entity temp;
        while(!entities.isEmpty()){
            temp = entities.lastEntry().getValue();
            entities.remove(entities.lastKey());
            System.out.println(temp.getName());
            if(temp.getTeamId() != firstTeam && teamCheck == false)
                teamCheck = true;
        }
        return teamCheck; //returns boolean representing validity of fight
    }
}
