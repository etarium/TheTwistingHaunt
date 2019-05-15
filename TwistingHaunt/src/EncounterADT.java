
import java.util.ArrayList;



/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface EncounterADT {
    
    /**
     * Method to run the combat using the data contained in the class, using turnSetup() as a helper method.
     */
    public void runCombat();
    
    /**
     * Cleans up and organizes the queue to run the next turn. Will also check validity of the next turn.
     * This method should be automatically called by runCombat()
     * @return a boolean representing whether the combat turn is valid(at least 2 sides are present for combat)
     */
    public boolean turnSetup();
    
    /**
     * Returns ArrayList of all Entities in Encounter
     * @return ArrayList&lt;Entity&gt; containing all Entities in Encounter
     * @ensure this.getCombatants() != null
     */
    public ArrayList<Entity> getCombatants();
    
    /**
     * Returns ArrayList of all defeated Entities from Encounter
     * @return ArrayList&lt;Entity&gt; containing all defeated Entities from Encounter
     * @ensure this.getRekt() != null
     */
    public ArrayList<Entity> getRekt();
    
    
    
}
