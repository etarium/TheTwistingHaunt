

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface EncounterADT {
    
    /**
     * Method to run the combat using the data contained in the class, using runQueue as a helper method.
     */
    public void runCombat();
    
    /**
     * Cleans up and organizes the queue to run the next turn. Will also check validity of the next turn.
     * This method should be automatically called by runCombat()
     * @return a boolean representing whether the combat turn is valid(at least 2 sides are present for combat)
     */
    public boolean runQueue();
    
    
    
}
